package web.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import web.dao.face.BoardDao;
import web.dao.face.BoardFileDao;
import web.dao.impl.BoardDaoImpl;
import web.dao.impl.BoardFileDaoImpl;
import web.dto.Board;
import web.dto.BoardFile;
import web.service.face.BoardService;
import web.util.Paging;

public class BoardServiceImpl implements BoardService {

	private BoardDao boardDao = new BoardDaoImpl();
	private BoardFileDao boardFileDao = new BoardFileDaoImpl();
	
	
	@Override
	public List<Board> list() {
		
		List<Board> list = boardDao.selectAll();
		
		return list;
	}


	@Override
	public Board getBoardno(HttpServletRequest req) {
		
		Board b = new Board();
		
		String param = req.getParameter("boardno");
		System.out.println(param);
		
		// boardno  전달 파라미터 검증 null, ""
		if( param!=null && !"".equals(param)) {
			b.setBoardno(Integer.parseInt(param));
		}
		
		return b;
	}


	@Override
	public Board view(Board b) {
		
		Board res = b;
		
		boardDao.updateHit(b);

		res = boardDao.selectBoardByBoardno(b);
		
		
		return res;
	}


	@Override
	public Paging getPaging(HttpServletRequest req) {
		
		// 전달 파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		
		if( param!=null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		
		// Board 테이블의 총 게시글 수를 조회한다
		int totalCount = boardDao.selectCntAll();
		
		// Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		// 계산된 paging 객체 반환
		return paging;
	}


	@Override
	public List<Board> list(Paging paging) {
		return boardDao.selectAll(paging);
	}


	@Override
	public void write(Board b) {
		
		boardDao.insert(b);
		
	}


	@Override
	public void write(HttpServletRequest req, HttpServletResponse resp) {
		
		// 전달파라미터 저장할 DTO 객체
		Board board = null;
		BoardFile boardFile = null;
		
		// 1. 파일 업로드 형태가 데이터가 맞는지 검사
		// 요청 메시지 Content-Type 이 multipart/form-data가 맞는지 확인한다
		boolean isMultipart = false;
		isMultipart = ServletFileUpload.isMultipartContent(req);
		
		// 1-1. multipart/form-data 인코딩으로 전송되지 않았을 경우 처리 중단하기
		if( !isMultipart ) {
//			out.println("<script type='text/javascript'> console.log('enctype이 multipart/form-data가 아닙니다')</script>");
			return; // write() 메소드 중단
		}
		
		board = new Board();

		// 세션 객체.. 아이디
		HttpSession session = req.getSession();
		
		// board 객체에 저장
		board.setId((String) session.getAttribute("userid"));

		int boardno = boardDao.selectBoardno();
		board.setBoardno(boardno);
		
		// 1-2. 여기부터는 multipart/form-data 정상적 흐름
		
		// 2. 업로드된 파일을 처리하는 아이템 팩토리 객체 생성
		// ItemFactory: 업로드된 데이터(FileItem)를 처리하는 방식을 설정하는 클래스
		// FileItem : 클라이언트로부터 전송된 데이터를 객체화 시킨 것
		
		// DiskFileitemFactory class
		// -> 디스크(HDD) 기반의 파일 아이템 처리 API
		// -> 업로드된 파일을 디스크(HDD)에 임시저장하고 나중에 처리
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		// 3. 업로드된 파일 아이템의 용량이 적당히 작으면 메모리에서 처리하도록 설정
		int maxMem = 1 * 1024 * 1024; // 1MB
		factory.setSizeThreshold(maxMem);
		
		// 4. 용량이 적당히 크면 임시파일(HDD)를 만들어서 처리하도록 설정
		// -> 임시파일 폴더 설정
		ServletContext context = req.getServletContext();
		String path = context.getRealPath("tmp");
		
		File repository = new File(path); // 임시 저장 파일
		
		factory.setRepository(repository);
		
		// 5. 업로드 허용 용량 기준을 넘지 않을 경우에만 파일 업로드 처리되도록 설정
		// -> 업로드 기준 넘으면 차단
		int maxFile = 10 * 1024 * 1024; // 10MB
		
		// 파일 업로드 수행 객체 생성
		// DiskFileItemFactory 객체 이용
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		// 파일 하나 업로드 용량 제한 설정
		upload.setFileSizeMax(maxFile);
		
		// -------------파일 업로드 준비 완료 --------------
		
		// 7. 업로드된 데이터 추출(파싱)
		// 임시파일 업로드도 같이 수행
		List<FileItem> items = null;
		
		try {
			items = upload.parseRequest(req);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		// 8. 파싱될 요청정보 데이터 처리
		// item 리스트에 요청정보 파라미터(파일 포함)이 파싱되어 들어있다
		
		// 요청정보의 3가지 형태
		//	1. 빈 파일(용량 0)
		//	2. form-data (전달 파라미터)
		//	3. 파일
		
		// 파일 아이템 반복자
		Iterator<FileItem> iter = items.iterator();
		
		// 모든 요청정보를 처리하는 반복문
		while( iter.hasNext() ) {
			
			// 요청정보객체
			FileItem item = iter.next();
			
			// 1) 빈파일에 대한 처리
			if(item.getSize() <= 0 ) continue;
			
			// 2) 기본 전달 파라미터에 대한 처리
			// isFormField : 폼에 들어있는 태그들일 때
			if( item.isFormField() ) {
				
				//----파라미터 처리 개요 ------
				// form-data (form field)는 key-value 쌍으로 전달됨
				
				// key는 item.getFieldName() 으로 얻어옴
				// value는 item.getString()으로 얻어옴
				
				// ** 전달값이 한글일 경우 인코딩 설정 방법
				// item.getString("UTF-8")
				
				// ** multipart로 바꾸면 req.setCharacterEncoding("UTF-8")이 적용되지 않는다.
				
				//---- 키 값에 따라 처리----------
				String key = item.getFieldName();
				
				if("title".equals(key)) {
					try {
						board.setTitle(item.getString("UTF-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}else if("content".equals(key)) {
					try {
						board.setContent(item.getString("UTF-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
				
			}// if(item.isFormField) End
			
			// 3) 파일에 대한 처리
			if( !item.isFormField()) {
				
				/// 업로드된 파일을 처리하는 방식
				//	1) 파일을 웹서버의 로컬 디스크에 저장
				//	파일의 정보를 DB에 기록해야 한다
				
				// 2) 테이블의 컬럼으로 파일의 내용을 저장
				//	 BLOB 타입 사용.. 그러나 성능 저하
				
				// 1번 방식 사용!
				
				//----------------------
				
				// 파일에 저장되는 파일명을 "년월일시분초밀리초.확장자"로 변경하기
				
				// 파일명 - 년월일시분초밀리초
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssS");
				String rename = sdf.format(new Date());
				
				// 확장자
				String origin = item.getName(); // 원본 파일명
				String ext = origin.substring(origin.lastIndexOf(".") + 1);
				
				// 저장될 이름
				String stored = rename + "." + ext;
				
				//-----------------------
				
				
				//---DB에 업로드된 파일에 대한 정보 기록하기
				boardFile = new BoardFile();
				
				boardFile.setBoardno(boardno);
				boardFile.setOriginname(origin);
				boardFile.setStoredname(stored);
				boardFile.setFilesize((int)item.getSize());
				
				// 실제 업로드 파일
				File up = new File(context.getRealPath("upload"), stored); //업로드될 폴더
				
				try {
					item.write(up); // 실제 업로드
					item.delete(); // 임시파일 삭제
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			}
		} // while(iter.hasNext()) End
		
		// 게시글 DB에 등록하기
		boardDao.insert(board);
		
		// 파일 정보 DB에 기록하기
		if( boardFile != null ) {
			boardDao.insertFile(boardFile);
		}
	}


	@Override
	public BoardFile viewFile(int boardno) {
		
		BoardFile res = boardDao.selectFile(boardno);
		
		return res;
	}


	@Override
	public void delete(Board board) {
		
		BoardFile bFile = boardDao.selectFile(board.getBoardno());
		
		if(bFile != null) {
			boardFileDao.delete(bFile);
		}
		
		boardDao.delete(board);
		
	}


	@Override
	public Board getBoard(Board board) {
		
		Board res = board;
		
		res = boardDao.selectBoardByBoardno(board);
		
		return res;
	}


	@Override
	public void update(HttpServletRequest req, HttpServletResponse resp,Board board) {
		
		// 수정 전 객체
		Board b = boardDao.selectBoardByBoardno(board);
		BoardFile bf = boardDao.selectFile(b.getBoardno());


		// 1-2. 여기부터는 multipart/form-data 정상적 흐름
		
		// 2. 업로드된 파일을 처리하는 아이템 팩토리 객체 생성
		// ItemFactory: 업로드된 데이터(FileItem)를 처리하는 방식을 설정하는 클래스
		// FileItem : 클라이언트로부터 전송된 데이터를 객체화 시킨 것
		
		// DiskFileitemFactory class
		// -> 디스크(HDD) 기반의 파일 아이템 처리 API
		// -> 업로드된 파일을 디스크(HDD)에 임시저장하고 나중에 처리
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		// 3. 업로드된 파일 아이템의 용량이 적당히 작으면 메모리에서 처리하도록 설정
		int maxMem = 1 * 1024 * 1024; // 1MB
		factory.setSizeThreshold(maxMem);
		
		// 4. 용량이 적당히 크면 임시파일(HDD)를 만들어서 처리하도록 설정
		// -> 임시파일 폴더 설정
		ServletContext context = req.getServletContext();
		String path = context.getRealPath("tmp");
		
		File repository = new File(path); // 임시 저장 파일
		
		factory.setRepository(repository);
		
		// 5. 업로드 허용 용량 기준을 넘지 않을 경우에만 파일 업로드 처리되도록 설정
		// -> 업로드 기준 넘으면 차단
		int maxFile = 10 * 1024 * 1024; // 10MB
		
		// 파일 업로드 수행 객체 생성
		// DiskFileItemFactory 객체 이용
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		// 파일 하나 업로드 용량 제한 설정
		upload.setFileSizeMax(maxFile);
		
		// -------------파일 업로드 준비 완료 --------------
		
		// 7. 업로드된 데이터 추출(파싱)
		// 임시파일 업로드도 같이 수행
		List<FileItem> items = null;
		
		try {
			items = upload.parseRequest(req);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		// 8. 파싱될 요청정보 데이터 처리
		// item 리스트에 요청정보 파라미터(파일 포함)이 파싱되어 들어있다
		
		// 요청정보의 3가지 형태
		//	1. 빈 파일(용량 0)
		//	2. form-data (전달 파라미터)
		//	3. 파일
		
		// 파일 아이템 반복자
		Iterator<FileItem> iter = items.iterator();
		
		// 모든 요청정보를 처리하는 반복문
		while( iter.hasNext() ) {
			
			// 요청정보객체
			FileItem item = iter.next();
			
			// 1) 빈파일에 대한 처리
			if(item.getSize() <= 0 ) continue;
			
			// 2) 기본 전달 파라미터에 대한 처리
			// isFormField : 폼에 들어있는 태그들일 때
			if( item.isFormField() ) {
				
				//----파라미터 처리 개요 ------
				// form-data (form field)는 key-value 쌍으로 전달됨
				
				// key는 item.getFieldName() 으로 얻어옴
				// value는 item.getString()으로 얻어옴
				
				// ** 전달값이 한글일 경우 인코딩 설정 방법
				// item.getString("UTF-8")
				
				// ** multipart로 바꾸면 req.setCharacterEncoding("UTF-8")이 적용되지 않는다.
				
				//---- 키 값에 따라 처리----------
				String key = item.getFieldName();
				
				if("title".equals(key)) {
					try {
						board.setTitle(item.getString("UTF-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}else if("content".equals(key)) {
					try {
						board.setContent(item.getString("UTF-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
				
			}// if(item.isFormField) End
			
			// 3) 파일에 대한 처리
			if( !item.isFormField()) {
				
				/// 업로드된 파일을 처리하는 방식
				//	1) 파일을 웹서버의 로컬 디스크에 저장
				//	파일의 정보를 DB에 기록해야 한다
				
				// 2) 테이블의 컬럼으로 파일의 내용을 저장
				//	 BLOB 타입 사용.. 그러나 성능 저하
				
				// 1번 방식 사용!
				
				//----------------------
				
				// 파일에 저장되는 파일명을 "년월일시분초밀리초.확장자"로 변경하기
				
				// 파일명 - 년월일시분초밀리초
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssS");
				String rename = sdf.format(new Date());
				
				// 확장자
				String origin = item.getName(); // 원본 파일명
				String ext = origin.substring(origin.lastIndexOf(".") + 1);
				
				// 저장될 이름
				String stored = rename + "." + ext;
				
				//-----------------------
				
				//---DB에 업로드된 파일에 대한 정보 기록하기
				if( bf != null) {
					boardFileDao.delete(bf);
				}
				
				bf.setOriginname(origin);
				bf.setStoredname(stored);
				bf.setFilesize((int)item.getSize());
				
				// 실제 업로드 파일
				File up = new File(context.getRealPath("upload"), stored); //업로드될 폴더
				
				try {
					item.write(up); // 실제 업로드
					item.delete(); // 임시파일 삭제
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			}
		} // while(iter.hasNext()) End
		
		// 게시글 DB에 등록하기
		boardDao.update(board);
		
		// 파일 정보 DB에 기록하기
		if( bf != null ) {
			boardDao.insertFile(bf);
		}
	}



}
