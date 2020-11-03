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
		System.out.println("05 Mdao 생성자 메소드 실행");
		// 01 드라이버 로딩과 02 DB연결 설정 정보를 읽는다.
		// META_INF 하위에 context.xml
		try {
			Context init = new InitialContext();
			System.out.println(init + "<-- init BoardDAO() ");
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");

		} catch (Exception ex) {
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}

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

	public ArrayList<Member> mAllSelect() throws SQLException {
		System.out.println("05전체회원조회 메소드");
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

	public Member mSelectforUpdate(String ora_id) throws SQLException {
		System.out.println("05 Mdao 생성자 메소드 실행");
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

	public void mUpdate(Member m) throws SQLException {
		System.out.println("05 Mdao 생성자 메소드 실행");
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

	public void mDelete(String ora_id) throws SQLException {
		System.out.println("05 Mdao 생성자 메소드 실행");
		conn = ds.getConnection();
		pstmt = conn.prepareStatement("delete from ORACLE_MEMBER where ora_id=?");
		System.out.println(pstmt + " : pstmt1");
		pstmt.setString(1, ora_id);

		int result = pstmt.executeUpdate();
		System.out.println(result + " : result");
		pstmt.close();
		conn.close();

	}

	public void mSearch(String a, String b) throws SQLException {
		System.out.println("05 Mdao 생성자 메소드 실행");
		conn = ds.getConnection();
		String selectQuery = "select * from oracle_member ";
		if (a == null & b == null) {
			System.out.println("");
			pstmt = conn.prepareStatement(selectQuery);
		}

	}
}
