<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "kr.or.ksmart.dao.Mdao" %>
<%@ page import = "kr.or.ksmart.dto.Member" %>
<%
String id = request.getParameter("id");
String pw = request.getParameter("pw");
System.out.println(id + "<-- id login_action.jsp");
System.out.println(pw + "<-- pw login_action.jsp");
Mdao mdao = new Mdao();
String result = mdao.mLoginCheck(id, pw);
System.out.println(result + "<-- result login_action.jsp");
String alert = null;
if(result.equals("01로그인성공")){
	System.out.println("01로그인성공 조건문 login_action.jsp");
	//mGetForSession 메서드 호출 후 리턴받을 수 있다
	Member m = mdao.mGetForSession(id);
	session.setAttribute("S_ID", m.getM_id());
	session.setAttribute("S_NAME", m.getM_name());
	session.setAttribute("S_LEVEL", m.getM_level());
	alert = "로그인 성공";
}else if(result.equals("02비번불일치")){
	System.out.println("02비번불일치 조건문 login_action.jsp");
	alert = "비번 불일치";
}else if(result.equals("03아이디불일치")){
	System.out.println("03아이디불일치 조건문 login_action.jsp");
	alert = "아이디 불일치";
}
%>
<script type="text/javascript">
	alert('<%= alert %>');
	location.href='<%= request.getContextPath()%>/index.jsp';
</script>










