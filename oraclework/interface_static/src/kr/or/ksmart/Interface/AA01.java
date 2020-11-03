package kr.or.ksmart.Interface;
public class AA01 {
	public static void main(String[] args) {
		Testable01 t = null;
		t = new BB01();
		t.test01();
		t = new CC01();
		t.test01();
		
		
		
		
		
		BB01 b = new BB01();
		b.test01();
		//b.A = 20;//상수는 값 변경 불가
	}

}
