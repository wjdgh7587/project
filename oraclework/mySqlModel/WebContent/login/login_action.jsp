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
if(result.equals("01�α��μ���")){
	System.out.println("01�α��μ��� ���ǹ� login_action.jsp");
	//mGetForSession �޼��� ȣ�� �� ���Ϲ��� �� �ִ�
	Member m = mdao.mGetForSession(id);
	session.setAttribute("S_ID", m.getM_id());
	session.setAttribute("S_NAME", m.getM_name());
	session.setAttribute("S_LEVEL", m.getM_level());
	alert = "�α��� ����";
}else if(result.equals("02�������ġ")){
	System.out.println("02�������ġ ���ǹ� login_action.jsp");
	alert = "��� ����ġ";
}else if(result.equals("03���̵����ġ")){
	System.out.println("03���̵����ġ ���ǹ� login_action.jsp");
	alert = "���̵� ����ġ";
}
%>
<script type="text/javascript">
	alert('<%= alert %>');
	location.href='<%= request.getContextPath()%>/index.jsp';
</script>










