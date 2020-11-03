<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "java.sql.DriverManager" %>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "java.sql.PreparedStatement" %>
<%@ page import = "java.sql.ResultSet" %>
<%@ page import = "java.sql.SQLException" %>

<!-- 아이디와 비번 입력받아 콘솔창에 출력 할 수 있다 -->
<%
String id = request.getParameter("id");
String pw = request.getParameter("pw");
System.out.println(id + "<-- id login_action.jsp");
System.out.println(pw + "<-- pw login_action.jsp");
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
Class.forName("com.mysql.jdbc.Driver");
String dbid = null;
String dbpw = null;
String dblevel = null;
String dbname = null;
String dbemail = null;
String alert = null;

try{
	String jdbcDriver = "jdbc:mysql://localhost:3306/dev37db?" +
			"useUnicode=true&characterEncoding=euckr";
	String dbUser = "dev37id";
	String dbPass = "dev37pw";
	conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
	System.out.println(conn + "<-- conn login_action.jsp");
	pstmt = conn.prepareStatement("SELECT * FROM tb_member WHERE m_id=?");
	System.out.println(pstmt + "<-- pstmt01");
	pstmt.setString(1, id);
	System.out.println(pstmt + "<-- pstmt02");
	rs = pstmt.executeQuery();
	//System.out.println(rs.next() + "<-- rs.next() login_action.jsp");
	if(rs.next()){
		System.out.println("1-1 아이디 일치");
		dbid = rs.getString("m_id");
		dbpw = rs.getString("m_pw");
		dblevel = rs.getString("m_level");
		dbname = rs.getString("m_name");
		dbemail = rs.getString("m_email");
		System.out.println(dbid + "<-- dbid ");
		System.out.println(dbpw + "<-- dbpw ");
		System.out.println(dblevel + "<-- dblevel ");
		System.out.println(dbname + "<-- dbname ");
		System.out.println(dbemail + "<-- dbemail ");
		if(pw.equals(dbpw)){
			System.out.println("2-1 로그인 성공");
			session.setAttribute("S_ID", dbid);
			session.setAttribute("S_NAME", dbname);
			session.setAttribute("S_LEVEL", dblevel);
			alert = "로그인 성공";
		}else{
			System.out.println("2-2 비번 불일치");
			alert = "비번 불일치";
		}
	}else{
		System.out.println("1-2 아이디 불일치");
		alert = "아이디 불일치";
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
<script type="text/javascript">
	alert('<%= alert %>');
	location.href='<%= request.getContextPath()%>/index.jsp';
</script>




