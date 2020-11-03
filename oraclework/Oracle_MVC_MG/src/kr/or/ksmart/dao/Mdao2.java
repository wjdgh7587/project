package kr.or.ksmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import kr.or.ksmart.dto.Member;

public class Mdao2 {
	DataSource ds;
	Connection conn = null;
	PreparedStatement pstmt = null;


		public Mdao2() {
			try{
				Context init = new InitialContext();
				System.out.println(init + " :  init Mdao() ");
		  	    ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			}catch(Exception ex){
				System.out.println("DB  연결실패 : " + ex);
				return;
			}
		}
		
		public void mInsert(Member m) throws ClassNotFoundException, SQLException {
			System.out.println("test system");
			conn=ds.getConnection();
			System.out.println(conn + "<- conn");
			pstmt = conn.prepareStatement(
					"insert into oracle_member values(?, ?, ?, ?, ?)");
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

}
