<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "java.sql.DriverManager" %>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "java.sql.PreparedStatement" %>
<%@ page import = "java.sql.ResultSet" %>
<%@ page import = "java.sql.SQLException" %>

<%@ include file="/msearch/m_search_form.jsp" %>

ȸ�� ����Ʈ <br>
<table width="100%" border="1">
<tr>
	<td>���̵�</td><td>���</td><td>����</td><td>�̸�</td><td>�̸���</td><td>����</td><td>����</td>
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
			out.println("01 DB���� ����");
		}else{
			out.println("02 DB���� ����");
		}
		if(sk == null & sv == null){
			System.out.println("01 sk,sv �Ѵ� null ����");
			pstmt = conn.prepareStatement("select * from tb_member");
			//SELECT * FROM tb_member ���� ���� �غ�
		}else if(sk != null & sv.equals("")){
			System.out.println("02 sk null �ƴϰ� sv ���� ����");
			pstmt = conn.prepareStatement("select * from tb_member");
			//SELECT * FROM tb_member ���� ���� �غ�
		}else if(sk != null & sv != null){
			System.out.println("03 sk,sv �Ѵ� null �ƴ� ����");
			pstmt = conn.prepareStatement("SELECT * FROM tb_member WHERE "+sk+"=?");
			pstmt.setString(1, sv);

			//���Ǻ��� �Ʒ� select ���� ���� �غ� �ϸ� �ȴ�
			//SELECT * FROM tb_member WHERE m_id='id001'; 		���� ���� �غ�
			//SELECT * FROM tb_member WHERE m_level='�Ǹ���'; 	���� ���� �غ�
			//SELECT * FROM tb_member WHERE m_name='ȫ03';		���� ���� �غ�
			//SELECT * FROM tb_member WHERE m_email='test05';	���� ���� �غ�
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
<!-- get������� ���̵� ���� �ѱ�� -->
<a href="<%= request.getContextPath() %>/mupdate/m_update_form.jsp?send_id=<%= rs.getString("m_id")%>">������ư</a>
			</td>
			<td>
<!-- get������� ���̵� ���� �ѱ�� -->
<a href="<%= request.getContextPath() %>/mdelete/m_delete_action.jsp?send_id=<%= rs.getString("m_id")%>">������ư</a>
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

