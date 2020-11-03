<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String send_id = request.getParameter("ora_id");
	System.out.println(send_id + " : delete id value");
	response.sendRedirect(request.getContextPath() + "/Mdelete/m_delete.ksmart_m?ora_id="+send_id);
%>

</body>
</html>