package dao.face;

import java.util.List;

import dto.User;

public interface UserDao {
	
	// 전체 조회
	public List<User> selectAll();
	
	// 유저 삽입
	public void insertUser(User u);
	
	// 유저 조회
	public User selectByIdx(int idx);
	
	// 유저 삭제
	public void deleteByIdx(int idx);
	

}
