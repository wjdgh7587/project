<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- ���̵�� ��� �Է¹޾� �ܼ�â�� ��� �� �� �ִ� -->
<%
String id = request.getParameter("id");
String pw = request.getParameter("pw");
System.out.println(id + "<-- id login_action.jsp");
System.out.println(pw + "<-- pw login_action.jsp");
String dbid = "id001";
String dbpw = "pw001";
String dbname = "ȫ�浿";
String dblevel = "������"; //������ �Ǵ� �Ǹ��� �Ǵ� ������ ������ �����ؼ� �׽�Ʈ
if(id.equals(dbid)){
	System.out.println("1-1 ���̵� ��ġ");
	if(pw.equals(dbpw)){
		System.out.println("2-1 �α��� ����");
		//S_LEVEL = "������" session�� ����
		session.setAttribute("S_ID", dbid);
		session.setAttribute("S_NAME", dbname);
		session.setAttribute("S_LEVEL", dblevel);
		//response.sendRedirect(request.getContextPath() + "/index.jsp");
%>
<script type="text/javascript">
	alert('�α��� ����');
	location.href='<%= request.getContextPath()%>/index.jsp';
</script>
<%
	}else{
		System.out.println("2-2 ��� ����ġ");
%>
<script type="text/javascript">
	alert('��� ����ġ');
	location.href='<%= request.getContextPath()%>/index.jsp';
</script>
<%	
	}
}else{
	System.out.println("1-2 ���̵� ����ġ");
%>
<script type="text/javascript">
	alert('���̵� ����ġ');
	location.href='<%= request.getContextPath()%>/index.jsp';
</script>
<%
}
%>







