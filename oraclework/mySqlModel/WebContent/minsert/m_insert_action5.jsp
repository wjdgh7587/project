<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "java.sql.DriverManager" %>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "java.sql.PreparedStatement" %>
<%@ page import = "java.sql.SQLException" %>
<%@ page import = "kr.or.ksmart.driverdb.DriverDB" %>
<%-- <%@ page import = "kr.or.ksmart.dto.Member" %> --%>
<% request.setCharacterEncoding("euc-kr"); %>
<jsp:useBean id="m" class="kr.or.ksmart.dto.Member"/>
<jsp:setProperty name="m" property="*"/>

<%
	Connection conn = null;
	PreparedStatement pstmt = null;

	try{
		DriverDB db = new DriverDB();
		conn = db.driverDbcon();

		pstmt = conn.prepareStatement(
				"INSERT INTO tb_member VALUES (?, ?, ?, ?, ?)");
		System.out.println(pstmt + "<-- pstmt 1");
		System.out.println(pstmt.getClass() + "<-- pstmt.getClass() 1");
//insert into tb_member values('id001','pw001','������','ȫ01','email01');
		pstmt.setString(1, m.getM_id());
		pstmt.setString(2, m.getM_pw());
		pstmt.setString(3, m.getM_level());
		pstmt.setString(4, m.getM_name());
		pstmt.setString(5, m.getM_email());

		System.out.println(pstmt + "<-- pstmt 2");
		
//03�ܰ� :Query������ ���� statement �Ǵ� prepareStatement��ü���� ��
//04�ܰ� :Query���� ����
		int result = pstmt.executeUpdate();
		System.out.println(result + "<-- result");
//04�ܰ� :Query���� ��
//05�ܰ� :Query������ ��� (insert�� ��� ���� ���ɴܰ�)
response.sendRedirect(request.getContextPath() + "/msearch/m_search_list.jsp");
//response.sendRedirect(request.getContextPath() + "/mlist/m_list.jsp");

	}finally{
		//06�ܰ� :statement �Ǵ� prepareStatement��ü ����(close())
		if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
		//07�ܰ� :Connection ��ü ����(close())
		if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	}

%>








