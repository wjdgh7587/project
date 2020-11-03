package com.test.Constructor;

public class BB01 {
	private String mid;
	private String mpw;
	private String mlevel;
	public static int account_num = 10;

	public BB01(String mid, String mpw, String mlevel) {
		super();
		this.mid = mid;
		this.mpw = mpw;
		this.mlevel = mlevel;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	public void setMlevel(String mlevel) {
		this.mlevel = mlevel;
	}

	public String getMid() {
		return mid;
	}

	public String getMpw() {
		return mpw;
	}

	public String getMlevel() {
		return mlevel;
	}

	public BB01() {
		account_num = 100;
		System.out.println(account_num);
	}

}
