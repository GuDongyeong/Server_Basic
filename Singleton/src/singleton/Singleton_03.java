package singleton;

// 단점
// 1. 인스턴스를 생성할 때 추가작업을 할 수 없다 -> 예외 처리 불가
// 2. 인스턴스(객체)를 사용하지 않아도 생성해놓는다

public class Singleton_03 {
	
	public String data = "Apple"; // 데이터
	
	//private 생성자 - 클래스 외부에서 객체를 생성하지 못하게 막는다
	private Singleton_03() {}
	
	//자신 클래스에 대한 객체 생성
	// 정적 메소드로 만들어주면 클래스 외부에서 클래스 명으로 접근할 수 있다
	private static Singleton_03 instance = new Singleton_03();
	
	// 싱글톤 객체 반환 메소드 - lazy : 객체 생성을 최대한 늦춘다
	public static Singleton_03 getInstance() {
		
		if( instance == null ) {
			try {
				instance = new Singleton_03();// 객체 생성
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return instance;
	}

}
