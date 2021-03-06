<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "java.sql.DriverManager" %>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "java.sql.PreparedStatement" %>
<%@ page import = "java.sql.ResultSet" %>
<%@ page import = "java.sql.SQLException" %>

<%@ include file="/msearch/m_search_form.jsp" %>

회원 리스트 <br>
<table width="100%" border="1">
<tr>
	<td>아이디</td><td>비번</td><td>권한</td><td>이름</td><td>이메일</td><td>수정</td><td>삭제</td>
</tr>

<%
	request.setCharacterEncoding("euc-kr");
	String sk = request.getParameter("sk");
	String sv = request.getParameter("sv");
	System.out.println(sk + "<-- sk ");
	System.out.println(sv + "<-- sv ");

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Class.forName("com.mysql.jdbc.Driver");
	try{
		String jdbcDriver = "jdbc:mysql://localhost:3306/dev37db?" +
				"useUnicode=true&characterEncoding=euckr";
		String dbUser = "dev37id";
		String dbPass = "dev37pw";
		conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		System.out.println(conn + "<-- conn m_list.jsp");
		if(conn != null){
			out.println("01 DB연결 성공");
		}else{
			out.println("02 DB연결 실패");
		}
		if(sk == null & sv == null){
			System.out.println("01 sk,sv 둘다 null 조건");
			pstmt = conn.prepareStatement("select * from tb_member");
			//SELECT * FROM tb_member 쿼리 문장 준비
		}else if(sk != null & sv.equals("")){
			System.out.println("02 sk null 아니고 sv 공백 조건");
			pstmt = conn.prepareStatement("select * from tb_member");
			//SELECT * FROM tb_member 쿼리 문장 준비
		}else if(sk != null & sv != null){
			System.out.println("03 sk,sv 둘다 null 아닌 조건");
			if(sk.equals("m_id")){
				System.out.println("03_01 m_id 조건");	
				pstmt = conn.prepareStatement("SELECT * FROM tb_member WHERE m_id=?");
			}else if(sk.equals("m_level")){
				System.out.println("03_02 m_level 조건");	
				pstmt = conn.prepareStatement("SELECT * FROM tb_member WHERE m_level=?");
			}else if(sk.equals("m_name")){
				System.out.println("03_03 m_name 조건");	
				pstmt = conn.prepareStatement("SELECT * FROM tb_member WHERE m_name=?");
			}else if(sk.equals("m_email")){
				System.out.println("03_04 m_email 조건");	
				pstmt = conn.prepareStatement("SELECT * FROM tb_member WHERE m_email=?");
			}
			pstmt.setString(1, sv);

			//조건별로 아래 select 쿼리 문장 준비 하면 된다
			//SELECT * FROM tb_member WHERE m_id='id001'; 		쿼리 문장 준비
			//SELECT * FROM tb_member WHERE m_level='판매자'; 	쿼리 문장 준비
			//SELECT * FROM tb_member WHERE m_name='홍03';		쿼리 문장 준비
			//SELECT * FROM tb_member WHERE m_email='test05';	쿼리 문장 준비
		}
		
		System.out.println(pstmt + "<-- pstmt");
		out.println(pstmt + "<-- pstmt");
		
		rs = pstmt.executeQuery();
		System.out.println(rs + "<-- rs m_list.jsp");
		//System.out.println(rs.next() + "<-- rs.next() m_list.jsp");
		while(rs.next()){
%>
		<tr>
			<td><%= rs.getString("m_id")%></td>
			<td><%= rs.getString("m_pw")%></td>
			<td><%= rs.getString("m_level")%></td>
			<td><%= rs.getString("m_name")%></td>
			<td><%= rs.getString("m_email")%></td>
			<td>
<!-- get방식으로 아이디 값을 넘긴다 -->
<a href="<%= request.getContextPath() %>/mupdate/m_update_form.jsp?send_id=<%= rs.getString("m_id")%>">수정버튼</a>
			</td>
			<td>
<!-- get방식으로 아이디 값을 넘긴다 -->
<a href="<%= request.getContextPath() %>/mdelete/m_delete_action.jsp?send_id=<%= rs.getString("m_id")%>">삭제버튼</a>
			</td>			
		</tr>
<%		
		}
	} catch(SQLException ex) {
		out.println(ex.getMessage());
		ex.printStackTrace();
	} finally {
		if (rs != null) try { rs.close(); } catch(SQLException ex) {}
		if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
		if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	}
%>	
</table>

