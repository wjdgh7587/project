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
	System.out.println("01 sk,sv 둘다 null 조건");
	//SELECT * FROM tb_member 쿼리 문장 준비
}else if(sk != null & sv.equals("")){
	System.out.println("02 sk null 아니고 sv 공백 조건");
	//SELECT * FROM tb_member 쿼리 문장 준비
}else if(sk != null & sv != null){
	System.out.println("03 sk,sv 둘다 null 아닌 조건");
//조건별로 아래 select 쿼리 문장 준비 하면 된다
//SELECT * FROM tb_member WHERE m_id='id001'; 		쿼리 문장 준비
//SELECT * FROM tb_member WHERE m_level='판매자'; 	쿼리 문장 준비
//SELECT * FROM tb_member WHERE m_name='홍03';		쿼리 문장 준비
//SELECT * FROM tb_member WHERE m_email='test05';	쿼리 문장 준비
}
%>


