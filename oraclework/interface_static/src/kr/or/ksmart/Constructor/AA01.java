package kr.or.ksmart.Constructor;
public class AA01 {
	public static void main(String[] args) {
		BB01 b = new BB01("id001","pw001","ÆÇ¸ÅÀÚ");
		System.out.println(b.getMid() + "<-- b.getMid()");
		System.out.println(b.getMpw() + "<-- b.getMpw()");
		System.out.println(b.getMlevel() + "<-- b.getMlevel()");
		
	}

}
