package web.service.impl;

import javax.servlet.http.HttpServletRequest;

import web.dao.face.MemberDao;
import web.dao.impl.MemberDaoImpl;
import web.dto.Member;
import web.service.face.MemberService;

public class MemberServiceImpl implements MemberService {
	
	private MemberDao memberDao = new MemberDaoImpl();
	@Override
	public Member getLoginMember(HttpServletRequest req) {
		
		Member m = new Member();
		
		m.setUserid(req.getParameter("uid"));
		m.setUserpw(req.getParameter("upw"));
		
		return m;
	}

	@Override
	public boolean login(Member m) {
		
		int res = memberDao.selectCntMemberByUseridpw(m);
		
		if( res > 0 ) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public Member getMemberByUserid(Member m) {
		
		Member user = memberDao.selectMemberByUserid(m);
		
		return user;
	}

	@Override
	public Member getJoinMember(HttpServletRequest req) {
		
		Member m = new Member();
		
		m.setUserid(req.getParameter("uid"));
		m.setUserpw(req.getParameter("upw"));
		m.setUsernick(req.getParameter("unick"));
		
		return m;
	}

	@Override
	public void join(Member m) {
		
		memberDao.insert(m);
		
	}

}
