<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "java.sql.DriverManager" %>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "java.sql.PreparedStatement" %>
<%@ page import = "java.sql.SQLException" %>
<%@ page import = "kr.or.ksmart.driverdb.DriverDB" %>

<%
	request.setCharacterEncoding("euc-kr");
	Connection conn = null;
	PreparedStatement pstmt = null;
//화면에서 입력자료 받아서 콘솔창에 출력 시작
	String m_id = request.getParameter("m_id");
	String m_pw = request.getParameter("m_pw");
	String m_level = request.getParameter("m_level");
	String m_name = request.getParameter("m_name");
	String m_email = request.getParameter("m_email");
	System.out.println(m_id + "<-- m_id /minsert/m_insert_pro.jsp");
	System.out.println(m_pw + "<-- m_pw /minsert/m_insert_pro.jsp");
	System.out.println(m_level + "<-- m_level /minsert/m_insert_pro.jsp");
	System.out.println(m_name + "<-- m_name /minsert/m_insert_pro.jsp");
	System.out.println(m_email + "<-- m_email /minsert/m_insert_pro.jsp");

	try{
		DriverDB db = new DriverDB();
		conn = db.driverDbcon();

		pstmt = conn.prepareStatement(
				"INSERT INTO tb_member VALUES (?, ?, ?, ?, ?)");
		System.out.println(pstmt + "<-- pstmt 1");
		System.out.println(pstmt.getClass() + "<-- pstmt.getClass() 1");
//insert into tb_member values('id001','pw001','관리자','홍01','email01');
		pstmt.setString(1, m_id);
		pstmt.setString(2, m_pw);
		pstmt.setString(3, m_level);
		pstmt.setString(4, m_name);
		pstmt.setString(5, m_email);

		System.out.println(pstmt + "<-- pstmt 2");
		
//03단계 :Query실행을 위한 statement 또는 prepareStatement객체생성 끝
//04단계 :Query실행 시작
		int result = pstmt.executeUpdate();
		System.out.println(result + "<-- result");
//04단계 :Query실행 끝
//05단계 :Query실행결과 사용 (insert의 경우 생략 가능단계)
response.sendRedirect(request.getContextPath() + "/msearch/m_search_list.jsp");
//response.sendRedirect(request.getContextPath() + "/mlist/m_list.jsp");

	}finally{
		//06단계 :statement 또는 prepareStatement객체 종료(close())
		if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
		//07단계 :Connection 객체 종료(close())
		if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	}

%>








