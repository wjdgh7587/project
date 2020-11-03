package kr.or.ksmart.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import kr.or.ksmart.driverdb.DriverDB;
import kr.or.ksmart.dto.Member;

public class Mdao {
	PreparedStatement pstmt = null;
	Connection conn = null;
	Member m = null;
	ResultSet rs = null;
	ArrayList<Member> alm = null;
	
	//08 �Ѹ� ȸ����ȸ �޼���(���ǵ�ϸ���)
	public Member mGetForSession(String in_id) throws ClassNotFoundException, SQLException {
		System.out.println("08 mGetForSession �Ѹ� ȸ����ȸ �޼���(���ǵ�ϸ���) Mdao.java");
		System.out.println(in_id + "<-- in_id mGetForSession Mdao.java");
		DriverDB db = new DriverDB();
		conn = db.driverDbcon();
		pstmt = conn.prepareStatement("SELECT m_id,m_level,m_name FROM tb_member WHERE m_id=?");
		System.out.println(pstmt + "<-- pstmt01");
		pstmt.setString(1, in_id);
		System.out.println(pstmt + "<-- pstmt02");
		rs = pstmt.executeQuery();
		//System.out.println(rs.next() + "<-- rs.next() m_update_form.jsp");
		//05���� ���� ��� : Member��ü�� ����
		if(rs.next()) {
			System.out.println("if���ǹ� mGetForSession Mdao.java");
			m = new Member();
			m.setM_id(rs.getString("m_id"));
			m.setM_level(rs.getString("m_level"));
			m.setM_name(rs.getString("m_name"));
		}
		pstmt.close();
		rs.close();
		conn.close();
		return m;
	}
	
	//07 mLoginCheck �α��� üũ �޼��� 
	public String mLoginCheck(String in_id,String in_pw) throws ClassNotFoundException, SQLException{
		System.out.println("07 mLoginCheck �α��� üũ �޼��� Mdao.java");
		System.out.println(in_id + "<-- in_id mLoginCheck Mdao.java");
		System.out.println(in_pw + "<-- in_pw mLoginCheck Mdao.java");
		String re = null;
		DriverDB db = new DriverDB();
		conn = db.driverDbcon();
		pstmt = conn.prepareStatement("SELECT m_pw FROM tb_member WHERE m_id=?");
		System.out.println(pstmt + "<-- pstmt01");
		pstmt.setString(1, in_id);
		System.out.println(pstmt + "<-- pstmt02");
		rs = pstmt.executeQuery();
		//System.out.println(rs.next() + "<-- rs.next() mLoginCheck Mdao.java");
		if(rs.next()) {
			System.out.println("1-1 ���̵� ��ġ mLoginCheck Mdao.java");
			if(in_pw.equals(rs.getString("m_pw"))){
				System.out.println("2-1 �α��� ���� mLoginCheck Mdao.java");
				re = "01�α��μ���";
			}else {
				System.out.println("2-2 ��� ����ġ mLoginCheck Mdao.java");
				re = "02�������ġ";
			}
		}else {
			System.out.println("1-2 ���̵� ����ġ mLoginCheck Mdao.java");
			re = "03���̵����ġ";
		}
		pstmt.close();
		rs.close();
		conn.close();
		return re;
	}

		
	
	//06 mSearch �˻�ó�� �޼���
	public ArrayList<Member> mSearch(String sk,String sv) throws ClassNotFoundException, SQLException{
		System.out.println("06 mSearch �˻�ó�� �޼��� Mdao.java");
		//03�ܰ� : ���� ���� �غ�ܰ踸 �� �ۼ��ϸ� ��!
		alm = new ArrayList<Member>();
		DriverDB db = new DriverDB();
		conn = db.driverDbcon();
		String selectQuery = "select * from tb_member ";
		if(sk == null & sv == null){
			System.out.println("01 sk,sv �Ѵ� null ����");
			pstmt = conn.prepareStatement(selectQuery);
			//SELECT * FROM tb_member ���� ���� �غ�
		}else if(sk != null & sv.equals("")){
			System.out.println("02 sk null �ƴϰ� sv ���� ����");
			pstmt = conn.prepareStatement(selectQuery);
			//SELECT * FROM tb_member ���� ���� �غ�
		}else if(sk != null & sv != null){
			System.out.println("03 sk,sv �Ѵ� null �ƴ� ����");
			pstmt = conn.prepareStatement(selectQuery+" WHERE "+sk+"=?");
			pstmt.setString(1, sv);
			//���Ǻ��� �Ʒ� select ���� ���� �غ� �ϸ� �ȴ�
			//SELECT * FROM tb_member WHERE m_id='id001'; 		���� ���� �غ�
			//SELECT * FROM tb_member WHERE m_level='�Ǹ���'; 	���� ���� �غ�
			//SELECT * FROM tb_member WHERE m_name='ȫ03';		���� ���� �غ�
			//SELECT * FROM tb_member WHERE m_email='test05';	���� ���� �غ�
		}
		System.out.println(pstmt + "<-- pstmt");
		rs = pstmt.executeQuery();

		while(rs.next()) {
			//System.out.println("while �ݺ��� mAllSelect Mdao.java");
			m = new Member();
			//System.out.println(m + "<-- m mAllSelect Mdao.java");
			m.setM_id(rs.getString("m_id"));
			m.setM_pw(rs.getString("m_pw"));
			m.setM_level(rs.getString("m_level"));
			m.setM_name(rs.getString("m_name"));
			m.setM_email(rs.getString("m_email"));
			alm.add(m);
			System.out.println(alm + "<-- alm mSearch Mdao.java");
		}
		pstmt.close();
		rs.close();
		conn.close();
		return alm;
	}
	
	//05 mAllSelect ��üȸ�� ��ȸ �޼���
	public ArrayList<Member> mAllSelect() throws ClassNotFoundException, SQLException{
		System.out.println("05 mAllSelect ��üȸ�� ��ȸ �޼��� Mdao.java");
		alm = new ArrayList<Member>();
		System.out.println(alm + "<-- alm mAllSelect Mdao.java"); 
		DriverDB db = new DriverDB();
		conn = db.driverDbcon();
		pstmt = conn.prepareStatement("select * from tb_member");
		rs = pstmt.executeQuery();
		//System.out.println(rs.next() + "<-- rs.next() mAllSelect Mdao.java");
		while(rs.next()) {
			//System.out.println("while �ݺ��� mAllSelect Mdao.java");
			m = new Member();
			//System.out.println(m + "<-- m mAllSelect Mdao.java");
			m.setM_id(rs.getString("m_id"));
			m.setM_pw(rs.getString("m_pw"));
			m.setM_level(rs.getString("m_level"));
			m.setM_name(rs.getString("m_name"));
			m.setM_email(rs.getString("m_email"));
			alm.add(m);
			System.out.println(alm + "<-- alm mAllSelect Mdao.java");
		}
		pstmt.close();
		rs.close();
		conn.close();
		return alm;
	}
	
	//04 mSelectforUpdate �Ѹ���ȸ �޼��� ����
	public Member mSelectforUpdate(String mid) throws ClassNotFoundException, SQLException{
		System.out.println("04 mSelectforUpdate �Ѹ���ȸ �޼��� ���� Mdao.java");
		DriverDB db = new DriverDB();
		conn = db.driverDbcon();
		pstmt = conn.prepareStatement("SELECT * FROM tb_member WHERE m_id=?");
		System.out.println(pstmt + "<-- pstmt01");
		pstmt.setString(1, mid);
		System.out.println(pstmt + "<-- pstmt02");
		rs = pstmt.executeQuery();
		//System.out.println(rs.next() + "<-- rs.next() m_update_form.jsp");
		//05���� ���� ��� : Member��ü�� ����
		if(rs.next()) {
			System.out.println("if���ǹ� mSelectforUpdate Mdao.java");
			m = new Member();
			m.setM_id(rs.getString("m_id"));
			m.setM_pw(rs.getString("m_pw"));
			m.setM_level(rs.getString("m_level"));
			m.setM_name(rs.getString("m_name"));
			m.setM_email(rs.getString("m_email"));
		}
		pstmt.close();
		rs.close();
		conn.close();
		return m;
	}

	//03 mDelete ����ó�� �޼���
	public void mDelete(String mid) throws ClassNotFoundException, SQLException {
		System.out.println("03 mDelete ����ó�� �޼��� Mdao.java");
		DriverDB db = new DriverDB();
		conn = db.driverDbcon();
		pstmt = conn.prepareStatement(
				"DELETE FROM tb_member WHERE m_id=?");
		System.out.println(pstmt + "<-- pstmt 1");
		pstmt.setString(1, mid);
		System.out.println(pstmt + "<-- pstmt02");

		int result = pstmt.executeUpdate();
		System.out.println(result + "<-- result");
		pstmt.close();
		conn.close();
	}
	
	//02 mUpdate �Է�ó�� �޼���
	public void mUpdate(Member m) throws ClassNotFoundException, SQLException {
		System.out.println("02 mUpdate ����ó�� �޼��� Mdao.java");
		DriverDB db = new DriverDB();
		conn = db.driverDbcon();
		pstmt = conn.prepareStatement(
				"UPDATE tb_member SET m_pw=?,m_level=?,m_name=?,m_email=? WHERE m_id=?");
		System.out.println(pstmt + "<-- pstmt 1");
		pstmt.setString(1, m.getM_pw());
		pstmt.setString(2, m.getM_level());
		pstmt.setString(3, m.getM_name());
		pstmt.setString(4, m.getM_email());
		pstmt.setString(5, m.getM_id());
		System.out.println(pstmt + "<-- pstmt 2");

		int result = pstmt.executeUpdate();
		System.out.println(result + "<-- result");
		pstmt.close();
		conn.close();
	}
	
	//01_02 mInsert �Է�ó�� �޼��� (�Է� 1��)
	public void mInsert(Member m) throws ClassNotFoundException, SQLException {
		//01�ܰ�) ����̹��ε� ~ 07) ��ü����
		System.out.println("01_02 mInsert �Է�ó�� �޼��� (�Է� 1��) Mdao.java");
		DriverDB db = new DriverDB();
		conn = db.driverDbcon();
		pstmt = conn.prepareStatement(
				"INSERT INTO tb_member VALUES (?, ?, ?, ?, ?)");
		System.out.println(pstmt + "<-- pstmt 1");
		pstmt.setString(1, m.getM_id());
		pstmt.setString(2, m.getM_pw());
		pstmt.setString(3, m.getM_level());
		pstmt.setString(4, m.getM_name());
		pstmt.setString(5, m.getM_email());
		System.out.println(pstmt + "<-- pstmt 2");
		int result = pstmt.executeUpdate();
		System.out.println(result + "<-- result");
		pstmt.close();
		conn.close();
	}
	
	//01_01 mInsert �Է�ó�� �޼��� (�Է� 2��)
	public void mInsert(Member m,Connection conn) throws SQLException {
		//03�ܰ�) ���� ���� �غ� ~ 07) ��ü����
		System.out.println("01_01 mInsert �Է�ó�� �޼��� (�Է� 2��) Mdao.java");
		System.out.println(m + "<-- m mInsert Mdao.java");
		System.out.println(conn + "<-- conn mInsert Mdao.java");
		pstmt = conn.prepareStatement(
				"INSERT INTO tb_member VALUES (?, ?, ?, ?, ?)");
		System.out.println(pstmt + "<-- pstmt 1");
		pstmt.setString(1, m.getM_id());
		pstmt.setString(2, m.getM_pw());
		pstmt.setString(3, m.getM_level());
		pstmt.setString(4, m.getM_name());
		pstmt.setString(5, m.getM_email());
		System.out.println(pstmt + "<-- pstmt 2");
		int result = pstmt.executeUpdate();
		System.out.println(result + "<-- result");
		pstmt.close();
		conn.close();
	}
}
