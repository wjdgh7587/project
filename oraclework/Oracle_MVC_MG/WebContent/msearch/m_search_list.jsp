<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import = "kr.or.ksmart.dao.Mdao" %>
<%@ page import = "kr.or.ksmart.dto.Member" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
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
		Mdao mdao = new Mdao();
		ArrayList<Member> alm = null;
		alm = (ArrayList<Member>)request.getAttribute("member");
		
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