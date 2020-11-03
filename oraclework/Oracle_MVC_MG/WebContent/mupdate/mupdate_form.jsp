<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="kr.or.ksmart.dao.Mdao"%>
<%@ page import="kr.or.ksmart.dto.Member"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<%
	String send_id = request.getParameter("ora_id");
	System.out.println(send_id);

	Mdao mdao = new Mdao();
	Member m = mdao.mSelectforUpdate(send_id);
	String ora_id = m.getOra_id();
	String ora_pw = m.getOra_pw();
	String ora_level = m.getOra_level();
	String ora_name = m.getOra_name();
	String ora_email = m.getOra_email();
%>

<body>
	<form action="<%=request.getContextPath()%>/MUpdate/m_update.ksmart_m"
		method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="ora_id" value="<%=ora_id%>"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="ora_pw" value="<%=ora_pw%>"></td>
			</tr>
			<tr>
				<td>권한</td>
				<td><input type="text" name="ora_level" value="<%=ora_level%>"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="ora_name"  value="<%=ora_name%>"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="ora_email"  value="<%=ora_email%>"></td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" value="회원수정버튼"></td>
			</tr>
			

	</table>

</form>
</body>
</html>