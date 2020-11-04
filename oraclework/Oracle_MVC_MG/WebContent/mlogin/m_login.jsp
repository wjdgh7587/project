<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Login Form</title>
</head>
<body>
<!-- 로그인폼에 입력된 데이터들이 post방식으로 m_login_pro.ksmart_m로 이동 -->    
    <form action = "<%=request.getContextPath()%>/MLogin/m_login_pro.ksmart_m" method="post">
        아이디 : <input type ="text" name="ora_id"> <br>
        비밀번호 : <input type = "password" name="ora_pw">
        <input type = "submit" value="로그인">
        
    </form>
    <button><a href = "<%=request.getContextPath() %>/Min/m_insert_pro.ksmart_m">회원가입</a></button>
</body>
</html>