<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Login Form</title>
</head>
<body>
<!-- �α������� �Էµ� �����͵��� post������� m_login_pro.ksmart_m�� �̵� -->    
    <form action = "<%=request.getContextPath()%>/MLogin/m_login_pro.ksmart_m" method="post">
        ���̵� : <input type ="text" name="ora_id"> <br>
        ��й�ȣ : <input type = "password" name="ora_pw">
        <input type = "submit" value="�α���">
        
    </form>
    <button><a href = "<%=request.getContextPath() %>/Min/m_insert_pro.ksmart_m">ȸ������</a></button>
</body>
</html>