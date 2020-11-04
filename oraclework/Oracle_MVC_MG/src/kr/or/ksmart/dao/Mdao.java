package kr.or.ksmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.ksmart.dto.Member;

public class Mdao {
	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	Member m = null;
	ArrayList<Member> alm = null;

	public Mdao() {
		System.out.println("05 Mdao ������ �޼ҵ� ����");
		// 01 ����̹� �ε��� 02 DB���� ���� ������ �д´�.
		// META_INF ������ context.xml
		try {
			Context init = new InitialContext();
			System.out.println(init + "<-- init BoardDAO() ");
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");

		} catch (Exception ex) {
			System.out.println("DB ���� ���� : " + ex);
			return;
		}
	}
	//insert
	public void mInsert(Member m) throws ClassNotFoundException, SQLException {
		System.out.println("test system");

		conn = ds.getConnection();
		System.out.println(conn + "<- conn");
		pstmt = conn.prepareStatement("insert into oracle_member values(?, ?, ?, ?, ?)");
		System.out.println(pstmt + "<-- pstmt 1");
		pstmt.setString(1, m.getOra_id());
		pstmt.setString(2, m.getOra_pw());
		pstmt.setString(3, m.getOra_level());
		pstmt.setString(4, m.getOra_name());
		pstmt.setString(5, m.getOra_email());
		System.out.println(pstmt + "<-- pstmt 2");
		int result = pstmt.executeUpdate();
		System.out.println(result + "<-- result");
		pstmt.close();
		conn.close();
	}
	//list
	public ArrayList<Member> mAllSelect() throws SQLException {
		System.out.println("05��üȸ����ȸ �޼ҵ�");
		alm = new ArrayList<Member>();
		System.out.println(alm + "<-- alm mAllSelect Mdao.java");

		conn = ds.getConnection();
		System.out.println(conn);

		pstmt = conn.prepareStatement("select * from oracle_member");
		System.out.println(pstmt);
		rs = pstmt.executeQuery();

		while (rs.next()) {
			m = new Member();
			m.setOra_id(rs.getString("ora_id"));
			m.setOra_pw(rs.getString("ora_pw"));
			m.setOra_level(rs.getString("ora_level"));
			m.setOra_name(rs.getString("ora_name"));
			m.setOra_email(rs.getString("ora_email"));
			alm.add(m);
			System.out.println(alm + " : alm mAllSelect Mdao.java");
		}
		pstmt.close();
		conn.close();
		return alm;

	}
	//update for each person
	public Member mSelectforUpdate(String ora_id) throws SQLException {
		System.out.println("05 Mdao ������ �޼ҵ� ����");
		conn = ds.getConnection();
		pstmt = conn.prepareStatement("SELECT * FROM oracle_member WHERE ora_id=?");
		System.out.println(pstmt);

		pstmt.setString(1, ora_id);

		rs = pstmt.executeQuery();

		if (rs.next()) {
			m = new Member();
			m.setOra_id(rs.getString("ora_id"));
			m.setOra_pw(rs.getString("ora_pw"));
			m.setOra_level(rs.getString("ora_level"));
			m.setOra_name(rs.getString("ora_name"));
			m.setOra_email(rs.getString("ora_email"));
		}
		pstmt.close();
		rs.close();
		conn.close();

		return m;
	}
	//update all
	public void mUpdate(Member m) throws SQLException {
		System.out.println("05 Mdao ������ �޼ҵ� ����");
		conn = ds.getConnection();
		pstmt = conn.prepareStatement(
				"update ORACLE_MEMBER set ORA_PW=?, ORA_LEVEL=?, ORA_NAME=?, ORA_EMAIL=? where ORA_ID=?");
		System.out.println(pstmt);

		pstmt.setString(1, m.getOra_pw());
		pstmt.setString(2, m.getOra_level());
		pstmt.setString(3, m.getOra_name());
		pstmt.setString(4, m.getOra_email());
		pstmt.setString(5, m.getOra_id());

		System.out.println(pstmt + " : pstmt 2");

		int result = pstmt.executeUpdate();
		System.out.println(result + " : result");
		pstmt.close();
		conn.close();
	}
	//update delete
	public void mDelete(String ora_id) throws SQLException {
		System.out.println("05 Mdao ������ �޼ҵ� ����");
		conn = ds.getConnection();
		pstmt = conn.prepareStatement("delete from ORACLE_MEMBER where ora_id=?");
		System.out.println(pstmt + " : pstmt1");
		pstmt.setString(1, ora_id);

		int result = pstmt.executeUpdate();
		System.out.println(result + " : result");
		pstmt.close();
		conn.close();

	}
	//update search
	public ArrayList<Member> mSearch(String a, String b) throws SQLException {
		System.out.println("05 Mdao ������ �޼ҵ� ����");
		conn = ds.getConnection();
		String selectQuery = "select * from oracle_member ";
		
		if (a == null && b == null) {
			System.out.println("01 Both of values are null");
			pstmt = conn.prepareStatement(selectQuery);
		} 
		else if (a != null && b.equals("")) {
			System.out.println("02 Not null as sk and sv is empty");
			pstmt = conn.prepareStatement(selectQuery);
		}
		else if(a != null && b != null) {
			System.out.println("03 Both of values are not null");
			pstmt = conn.prepareStatement(selectQuery+" WHERE "+a+"=?");
			pstmt.setString(1, b);
		}
		System.out.println(pstmt + " : Checking pstmt");
		rs=pstmt.executeQuery();
		alm = new ArrayList<Member>();
		
		while(rs.next()) {
			m= new Member();
			
			m.setOra_id(rs.getString("ora_id"));
			m.setOra_pw(rs.getString("ora_pw"));
			m.setOra_level(rs.getString("ora_level"));
			m.setOra_name(rs.getString("ora_name"));
			m.setOra_email(rs.getString("ora_email"));
			alm.add(m);
			System.out.println("Checking alm : "+alm);
		}
		pstmt.close();
		rs.close();
		conn.close();

		return alm;

	}
	//login
	public String mLoginCheck(String ora_id, String ora_pw) throws SQLException {
		System.out.println("05 Mdao ������ �޼ҵ� ����");
		String re = null;
		String result1 ="LoginSuccess";
		String result2  = "WrongPassord";
		String result3 = "WrongId";
		String result4 = "Rightid";
		
		conn = ds.getConnection();
		pstmt = conn.prepareStatement("SELECT ora_pw FROM ORACLE_MEMBER WHERE ORA_ID = ?");
		System.out.println(pstmt);
		
		pstmt.setString(1, ora_id);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			System.out.println("Login Success Mdao.java");
			re = result4;
			if(ora_pw.equals(rs.getString("ora_pw"))) {
				re =result1;
			}else {
				re = result2;
			}
			
		}else {
			System.out.println("Wrong Id Mdao.java");
			re = result3;
		}
	
		pstmt.close();
		rs.close();
		conn.close();
		
		return re;
	}
}
