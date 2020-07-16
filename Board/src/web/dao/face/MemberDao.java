package web.dao.face;

import web.dto.Member;

public interface MemberDao {

	/**
	 * 로그인 검증
	 * @param m - 로그인 정보
	 * @return - cnt 로그인 정보와 일치하는 DB 개수
	 */
	public int selectCntMemberByUseridpw(Member m);

	/**
	 * user 객체 얻어오기
	 * @param m - 로그인 정보
	 * @return - user 객체
	 */
	public Member selectMemberByUserid(Member m);

	/*
	 * 회원가입 정보 객체 DB에 insert
	 */
	public void insert(Member m);

}
