<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	/minsert/m_insert_form.jsp
	<br>
	<form
		action="<%=request.getContextPath()%>
		/Min/m_insert_pro.ksmart_m"
		method="post">
		<table border="1">
			<tr>
				<td>���̵�</td>
				<td><input type="text" name="ora_id" size="20"></td>
			<tr>
			<tr>
				<td>��ȣ</td>
				<td><input type="text" name="ora_pw" size="20"></td>
			<tr>
			<tr>
				<td>����</td>
				<td><input type="text" name="ora_level" size="20"></td>
			<tr>
			<tr>
				<td>�̸�</td>
				<td><input type="text" name="ora_name" size="20"></td>
			<tr>
			<tr>
				<td>�̸���</td>
				<td><input type="text" name="ora_email" size="20"></td>
			<tr>
			<tr>
				<td colspan="4"><input type="submit" value="ȸ�����Թ�ư"></td>
			</tr>
		</table>
	</form>
</body>
</html>