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
		//BB01Ŭ������ static ���� ������ test �޼ҵ�� �������� �����Ǿ� �ִ�.
		//�� static ������ ���� �ּҿ� �η� �ִ°� �ƴϰ�, ����?? �� �������� �����ϵ��� ����.
		
	}
}
