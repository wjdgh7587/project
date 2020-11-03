package com.test.Constructor;

public class AA01 {
	public static void main(String[] args) {

		BB01 bb01 = new BB01("id001", "pw001", "°ü¸®ÀÚ");
		BB01 bb02 = new BB01();

		System.out.println(bb01.getMid() + " : bb01.getMid()");
		System.out.println(bb01.getMpw() + " : bb01.getMpw()");
		System.out.println(bb01.getMlevel() + " : bb01.getMlevel");
		System.out.println(bb01.account_num);
	}
}
