package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.face.MemberDao;
import dbutil.DBConn;
import dto.Member;

public class MemberDaoImpl implements MemberDao{

	//
	private Connection conn = null; // DB연결 객체
	private PreparedStatement ps = null;// SQL수행객체
	private ResultSet rs = null;// 결과집합
	
	
	@Override
	public int selectNextUserno() {
		
		conn = DBConn.getConnection();// DB연결
		
		String sql = "";
		sql +="SELECT member_seq.nextval FROM dual";
		
		int nextval = 0; // 조회된 시퀀스 값(nextval)
		
		try {
			ps = conn.prepareStatement(sql);//SQL수행객체 생성
			rs = ps.executeQuery();//SQL쿼리 수행 및 결과 반환
			
			rs.next();
			
//			nextval = rs.getInt(1);
			nextval = rs.getInt("nextval");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return nextval;
	}


	@Override
	public void insert(Member member) {
		
		conn = DBConn.getConnection();
		
		String sql = "";
		sql+="INSERT INTO member (userno , userid , nick , email)";
		sql+=" VALUES(?,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, member.getUserno());
			ps.setString(2, member.getUserid());
			ps.setString(3, member.getNick());
			ps.setString(4, member.getEmail());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
