package kr.or.ksmart.Static;
public class AA01 {
	public static void main(String[] args) {
		BB01.test();
		
		BB01 b01 = new BB01();
		BB01 b02 = new BB01();
		System.out.println(b01.total + "<-- b01.total");
		b01.total = 20;
		b01.a = 20;
		System.out.println(b01.a+" : b01");
		System.out.println(b02.a+" : b02");
		System.out.println(b02.total + "<-- b02.total");
		BB01.total = 30;
		System.out.println(b01.total + "<-- b01.total");
		System.out.println(b02.total + "<-- b02.total");
		System.out.println(BB01.total + "<-- BB01.total");
	}

}
