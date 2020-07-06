package service.impl;

import javax.servlet.http.HttpServletRequest;

import dao.face.MemberDao;
import dao.impl.MemberDaoImpl;
import dto.Member;
import service.face.MemberService;

public class MemberServiceImpl implements MemberService {

	//MemberDao객체 생성
	private MemberDao memberDao = new MemberDaoImpl();

	@Override
	public Member getParam(HttpServletRequest req) {
		
		//요청 정보를 저장할 객체 생성
		Member member = new Member();
		
		//userno
		//  사용자가 전달하는 값이 아님 - 여기에서 처리할 필요 없음
		//  DB에서 member_seq를 이용하여 생성되는 값
		
		//userid - VARCHAR2
		member.setUserid(req.getParameter("userid"));
		
		//nick - VARCHAR2
		member.setNick(req.getParameter("nick"));
		
		//email - VARCHAR2
		member.setEmail(req.getParameter("email"));
		
		return member;
	}

	@Override
	public Member join(Member member) {
		
		//1. member_seq 의 다음 nextval 값을 조회하기
		//  MemberDao 이용
		//  SELECT member_seq.nextval FROM dual
		int next = memberDao.selectNextUserno();
		System.out.println("MemberService nextval - "+ next);
		// 2. 얻어온 시퀀스 값을 member객체에 대입
		member.setUserno(next);
		System.out.println("MemberService member with userno - "+ member);
		
		// 3. member객체를 DB에 insert
		memberDao.insert(member);
		
		// 4. member객체 반환
		return member;
	}
	
	
	
	
}
