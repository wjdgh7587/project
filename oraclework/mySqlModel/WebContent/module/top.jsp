<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String S_ID = (String)session.getAttribute("S_ID");
String S_NAME = (String)session.getAttribute("S_NAME");
String S_LEVEL = (String)session.getAttribute("S_LEVEL");
System.out.println(S_ID + "<-- S_ID top.jsp ");
System.out.println(S_NAME + "<-- S_NAME top.jsp ");
System.out.println(S_LEVEL + "<-- S_LEVEL top.jsp ");
%>
   <!-- Begin Wrapper -->
   <div id="wrapper">
         <!-- Begin Header -->
         <div id="header">
/module/top.jsp     <br/>     
		       ��ܸ޴� <br/><br/>	 
<%
if(S_LEVEL == null){
%>
<!-- 01 �α��� �� ȭ�� ���� -->
<a href="<%= request.getContextPath() %>/minsert/m_insert_form.jsp">01ȸ�����</a><br/>
<form action="<%= request.getContextPath() %>/login/login_action.jsp" method="post">
	���̵� : <input type="text" name="id"> 
	��   �� : <input type="text" name="pw"> 
	<input type="submit" value="�α���">
</form>
<!-- 01 �α��� �� ȭ�� End -->
<%
}else{
%>	
	<!-- 02 �α��� �� ȭ�� ���� -->
	<%= S_ID %> / <%= S_NAME %> �� / <%= S_LEVEL %> �α��� �� 
	<a href="<%= request.getContextPath() %>/login/logout.jsp">�α׾ƿ�</a><br/>
	<!-- 02 �α��� �� ȭ�� End -->
<%		
	if(S_LEVEL.equals("������")){
%>
<a href="<%= request.getContextPath() %>/minsert/m_insert_form.jsp">01ȸ�����</a>
<a href="<%= request.getContextPath() %>/msearch/m_search_list.jsp">02ȸ������Ʈ</a>
<a href="<%= request.getContextPath() %>/goods/goods_insert_form.jsp">03��ǰ���</a>
<a href="#">04��ǰ����Ʈ</a>	<br/>
<%
	}else if(S_LEVEL.equals("�Ǹ���")){
%>
<a href="<%= request.getContextPath() %>/minsert/m_insert_form.jsp">01ȸ�����</a>
<a href="<%= request.getContextPath() %>/goods/goods_insert_form.jsp">03��ǰ���</a>
<a href="#">04��ǰ����Ʈ</a>	<br/>
<%
	}else if(S_LEVEL.equals("������")){
%>
<a href="<%= request.getContextPath() %>/minsert/m_insert_form.jsp">01ȸ�����</a>
<a href="#">04��ǰ����Ʈ</a>	<br/>
<%
	}
}
%>
		 </div>
		 <!-- End Header -->
		 
		 
		 
		 
		 
		 
		 
		 
		 