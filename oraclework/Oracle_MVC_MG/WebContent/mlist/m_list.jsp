<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="kr.or.ksmart.dto.Member"%>
<%@page import="kr.or.ksmart.dao.Mdao"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>list</title>
</head>
<body>
	<%
		ArrayList<Member> alm = (ArrayList<Member>) request.getAttribute("alm");
		out.println(alm.size() + "<-- alm.size() <br/><br/>");
	%>
	<table width="100%"  border="1" >
	<tr>
		<td>���̵�</td>
		<td>���</td>
		<td>����</td>
		<td>�̸�</td>
		<td>�̸���</td>
		<td>����</td>
		<td>����</td>
	</tr>
		<%
			for (int i = 0; i < alm.size(); i++) {
				Member m = alm.get(i);
		%>
		<tr>
			<td><%=m.getOra_id()%></td>
			<td><%=m.getOra_pw()%></td>
			<td><%=m.getOra_level()%></td>
			<td><%=m.getOra_name()%></td>
			<td><%=m.getOra_email()%></td>
			<td><a
				href="<%=request.getContextPath()%>/mupdate/mupdate_form.jsp?ora_id=<%=m.getOra_id()%>">������ư</a>
			</td>
			<td><a
				href="<%=request.getContextPath()%>/mdelete/m_delete_pro.jsp?ora_id=<%=m.getOra_id()%>">������ư</a>
			</td>
		</tr>
		<%
			}
		%>
	</table>
</body>







</html>