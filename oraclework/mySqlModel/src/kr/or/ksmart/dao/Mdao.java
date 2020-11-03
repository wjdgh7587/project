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
	
	//08 한명 회원조회 메서드(세션등록목적)
	public Member mGetForSession(String in_id) throws ClassNotFoundException, SQLException {
		System.out.println("08 mGetForSession 한명 회원조회 메서드(세션등록목적) Mdao.java");
		System.out.println(in_id + "<-- in_id mGetForSession Mdao.java");
		DriverDB db = new DriverDB();
		conn = db.driverDbcon();
		pstmt = conn.prepareStatement("SELECT m_id,m_level,m_name FROM tb_member WHERE m_id=?");
		System.out.println(pstmt + "<-- pstmt01");
		pstmt.setString(1, in_id);
		System.out.println(pstmt + "<-- pstmt02");
		rs = pstmt.executeQuery();
		//System.out.println(rs.next() + "<-- rs.next() m_update_form.jsp");
		//05쿼리 실행 결과 : Member객체에 셋팅
		if(rs.next()) {
			System.out.println("if조건문 mGetForSession Mdao.java");
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
	
	//07 mLoginCheck 로그인 체크 메서드 
	public String mLoginCheck(String in_id,String in_pw) throws ClassNotFoundException, SQLException{
		System.out.println("07 mLoginCheck 로그인 체크 메서드 Mdao.java");
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
			System.out.println("1-1 아이디 일치 mLoginCheck Mdao.java");
			if(in_pw.equals(rs.getString("m_pw"))){
				System.out.println("2-1 로그인 성공 mLoginCheck Mdao.java");
				re = "01로그인성공";
			}else {
				System.out.println("2-2 비번 불일치 mLoginCheck Mdao.java");
				re = "02비번불일치";
			}
		}else {
			System.out.println("1-2 아이디 불일치 mLoginCheck Mdao.java");
			re = "03아이디불일치";
		}
		pstmt.close();
		rs.close();
		conn.close();
		return re;
	}

		
	
	//06 mSearch 검색처리 메서드
	public ArrayList<Member> mSearch(String sk,String sv) throws ClassNotFoundException, SQLException{
		System.out.println("06 mSearch 검색처리 메서드 Mdao.java");
		//03단계 : 쿼리 실행 준비단계만 잘 작성하면 끝!
		alm = new ArrayList<Member>();
		DriverDB db = new DriverDB();
		conn = db.driverDbcon();
		String selectQuery = "select * from tb_member ";
		if(sk == null & sv == null){
			System.out.println("01 sk,sv 둘다 null 조건");
			pstmt = conn.prepareStatement(selectQuery);
			//SELECT * FROM tb_member 쿼리 문장 준비
		}else if(sk != null & sv.equals("")){
			System.out.println("02 sk null 아니고 sv 공백 조건");
			pstmt = conn.prepareStatement(selectQuery);
			//SELECT * FROM tb_member 쿼리 문장 준비
		}else if(sk != null & sv != null){
			System.out.println("03 sk,sv 둘다 null 아닌 조건");
			pstmt = conn.prepareStatement(selectQuery+" WHERE "+sk+"=?");
			pstmt.setString(1, sv);
			//조건별로 아래 select 쿼리 문장 준비 하면 된다
			//SELECT * FROM tb_member WHERE m_id='id001'; 		쿼리 문장 준비
			//SELECT * FROM tb_member WHERE m_level='판매자'; 	쿼리 문장 준비
			//SELECT * FROM tb_member WHERE m_name='홍03';		쿼리 문장 준비
			//SELECT * FROM tb_member WHERE m_email='test05';	쿼리 문장 준비
		}
		System.out.println(pstmt + "<-- pstmt");
		rs = pstmt.executeQuery();

		while(rs.next()) {
			//System.out.println("while 반복문 mAllSelect Mdao.java");
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
	
	//05 mAllSelect 전체회원 조회 메서드
	public ArrayList<Member> mAllSelect() throws ClassNotFoundException, SQLException{
		System.out.println("05 mAllSelect 전체회원 조회 메서드 Mdao.java");
		alm = new ArrayList<Member>();
		System.out.println(alm + "<-- alm mAllSelect Mdao.java"); 
		DriverDB db = new DriverDB();
		conn = db.driverDbcon();
		pstmt = conn.prepareStatement("select * from tb_member");
		rs = pstmt.executeQuery();
		//System.out.println(rs.next() + "<-- rs.next() mAllSelect Mdao.java");
		while(rs.next()) {
			//System.out.println("while 반복문 mAllSelect Mdao.java");
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
	
	//04 mSelectforUpdate 한명조회 메서드 선언
	public Member mSelectforUpdate(String mid) throws ClassNotFoundException, SQLException{
		System.out.println("04 mSelectforUpdate 한명조회 메서드 선언 Mdao.java");
		DriverDB db = new DriverDB();
		conn = db.driverDbcon();
		pstmt = conn.prepareStatement("SELECT * FROM tb_member WHERE m_id=?");
		System.out.println(pstmt + "<-- pstmt01");
		pstmt.setString(1, mid);
		System.out.println(pstmt + "<-- pstmt02");
		rs = pstmt.executeQuery();
		//System.out.println(rs.next() + "<-- rs.next() m_update_form.jsp");
		//05쿼리 실행 결과 : Member객체에 셋팅
		if(rs.next()) {
			System.out.println("if조건문 mSelectforUpdate Mdao.java");
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

	//03 mDelete 삭제처리 메서드
	public void mDelete(String mid) throws ClassNotFoundException, SQLException {
		System.out.println("03 mDelete 삭제처리 메서드 Mdao.java");
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
	
	//02 mUpdate 입력처리 메서드
	public void mUpdate(Member m) throws ClassNotFoundException, SQLException {
		System.out.println("02 mUpdate 수정처리 메서드 Mdao.java");
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
	
	//01_02 mInsert 입력처리 메서드 (입력 1개)
	public void mInsert(Member m) throws ClassNotFoundException, SQLException {
		//01단계) 드라이버로딩 ~ 07) 객체종료
		System.out.println("01_02 mInsert 입력처리 메서드 (입력 1개) Mdao.java");
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
	
	//01_01 mInsert 입력처리 메서드 (입력 2개)
	public void mInsert(Member m,Connection conn) throws SQLException {
		//03단계) 쿼리 실행 준비 ~ 07) 객체종료
		System.out.println("01_01 mInsert 입력처리 메서드 (입력 2개) Mdao.java");
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
