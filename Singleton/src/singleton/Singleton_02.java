package singleton;

// 단점 qhdhks
// 1. 인스턴스를 생성할 때 추가작업을 할 수 없다 -> 예외 처리 불가

public class Singleton_02 {
	
	public String data = "Apple"; // 데이터
	
	//private 생성자 - 클래스 외부에서 객체를 생성하지 못하게 막는다
	private Singleton_02() {}
	
	//자신 클래스에 대한 객체 생성
	// 정적 메소드로 만들어주면 클래스 외부에서 클래스 명으로 접근할 수 있다
	private static Singleton_02 instance;
	
	// static 초기화 블록
	// 클래스 변수(정적 변수)를 초기화하는 블록
	static {
		
		// 블록 내에서 예외 처리 가능
		try {
		instance = new Singleton_02();// 객체 생성
		} catch( Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	// 싱글톤 객체 반환 메소드
	public static Singleton_02 getInstance() {
		return instance;
	}

}
