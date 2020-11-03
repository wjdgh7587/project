package com.test.Abstract;

public class BB01 extends CC01 {
	@Override
	public void c_abstarct() {
		// TODO Auto-generated method stub
		System.out.println("02 c_abstarct 실행 BB01.java");
	}

	// public void c_a() {
	// System.out.println("03 c_a() from BB01.java");
	// }
	@Override
	public void c_a() {
		// TODO Auto-generated method stub
		super.c_a();
		System.out.println("test c_a form CC01");
	}
}
