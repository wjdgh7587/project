<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="/msearch/m_search_form.jsp" %>
<%
request.setCharacterEncoding("euc-kr");
String sk = request.getParameter("sk");
String sv = request.getParameter("sv");
System.out.println(sk + "<-- sk ");
System.out.println(sv + "<-- sv ");
if(sk == null & sv == null){
	System.out.println("01 sk,sv �Ѵ� null ����");
	//SELECT * FROM tb_member ���� ���� �غ�
}else if(sk != null & sv.equals("")){
	System.out.println("02 sk null �ƴϰ� sv ���� ����");
	//SELECT * FROM tb_member ���� ���� �غ�
}else if(sk != null & sv != null){
	System.out.println("03 sk,sv �Ѵ� null �ƴ� ����");
//���Ǻ��� �Ʒ� select ���� ���� �غ� �ϸ� �ȴ�
//SELECT * FROM tb_member WHERE m_id='id001'; 		���� ���� �غ�
//SELECT * FROM tb_member WHERE m_level='�Ǹ���'; 	���� ���� �غ�
//SELECT * FROM tb_member WHERE m_name='ȫ03';		���� ���� �غ�
//SELECT * FROM tb_member WHERE m_email='test05';	���� ���� �غ�
}
%>


