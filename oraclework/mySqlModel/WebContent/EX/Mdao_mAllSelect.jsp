<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "kr.or.ksmart.dao.Mdao" %>
<%@ page import = "kr.or.ksmart.dto.Member" %>
<%@ page import = "java.util.ArrayList" %>
<%
Mdao mdao = new Mdao();
ArrayList<Member> alm = mdao.mAllSelect();
System.out.println(alm.size() + "<-- alm.size()");
for(int i=0 ; i < alm.size() ; i++){
	Member m = alm.get(i);
	out.println(m.getM_id() + "<-- m.getM_id() <br/>");
	out.println(m.getM_pw() + "<-- m.getM_pw() <br/>");
	out.println(m.getM_level() + "<-- m.getM_level() <br/>");
	out.println(m.getM_name() + "<-- m.getM_name() <br/>");
	out.println(m.getM_email() + "<-- m.getM_email() <br/><br/>");
}
%>