package web.service.face;

import javax.servlet.http.HttpServletRequest;

import web.dto.Member;

public interface MemberService {

	/**
	 * 로그인 폼에서 로그인 정보 얻어오기
	 * @param req - 요청 객체
	 * @return - 로그인 멤버
	 */
	public Member getLoginMember(HttpServletRequest req);

	/**
	 * 로그인 정보 DB와 비교
	 * @param m - 로그인 정보
	 * @return - DB 비교 결과
	 */
	public boolean login(Member m);

	/**
	 * id로 user 정보 얻어오기
	 * @param m - 로그인 정보 객체
	 * @return - 멤버 정보
	 */
	public Member getMemberByUserid(Member m);

	/**
	 * 회원가입 폼 전달 파라미터 처리
	 * @param req - 전달 파라미터 요청 객체
	 * @return Member - 파라미터 멤버 객체
	 */
	public Member getJoinMember(HttpServletRequest req);

	/*
	 * 회원가입 정보 DB에 입력
	 * @param m - 회원가입 정보 객체
	 */
	public void join(Member m);

}
