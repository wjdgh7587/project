<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 아이디와 비번 입력받아 콘솔창에 출력 할 수 있다 -->
<%
String id = request.getParameter("id");
String pw = request.getParameter("pw");
System.out.println(id + "<-- id login_action.jsp");
System.out.println(pw + "<-- pw login_action.jsp");
String dbid = "id001";
String dbpw = "pw001";
String dbname = "홍길동";
String dblevel = "관리자"; //관리자 또는 판매자 또는 구매자 등으로 변경해서 테스트
if(id.equals(dbid)){
	System.out.println("1-1 아이디 일치");
	if(pw.equals(dbpw)){
		System.out.println("2-1 로그인 성공");
		//S_LEVEL = "관리자" session에 셋팅
		session.setAttribute("S_ID", dbid);
		session.setAttribute("S_NAME", dbname);
		session.setAttribute("S_LEVEL", dblevel);
		//response.sendRedirect(request.getContextPath() + "/index.jsp");
%>
<script type="text/javascript">
	alert('로그인 성공');
	location.href='<%= request.getContextPath()%>/index.jsp';
</script>
<%
	}else{
		System.out.println("2-2 비번 불일치");
%>
<script type="text/javascript">
	alert('비번 불일치');
	location.href='<%= request.getContextPath()%>/index.jsp';
</script>
<%	
	}
}else{
	System.out.println("1-2 아이디 불일치");
%>
<script type="text/javascript">
	alert('아이디 불일치');
	location.href='<%= request.getContextPath()%>/index.jsp';
</script>
<%
}
%>







