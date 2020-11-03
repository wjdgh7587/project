package com.test.Static;

public class AA01 {
	public static void main(String[] args) {
		BB01.test();
		
		BB01 bb01 = new BB01();
		BB01 bb02 = new BB01();
		System.out.println(bb01.total + " : bb01.total");
		bb01.total = 20;
		
		System.out.println(bb02.total + " : bb02.total");
		bb02.total = 100;
		
		System.out.println(bb01.total + " : bb01.total");
		System.out.println(bb02.total + " : bb02.total");
		System.out.println(BB01.total + " BB01.total");
		
		//as you see all values will be same cause of the 'static'
		//BB01클래스에 static 으로 선언한 test 메소드는 정적으로 고정되어 있다.
		//즉 static 변수는 여러 주소에 널려 있는게 아니고, 공유?? 의 개념으로 이해하도록 하자.
		
	}
}
