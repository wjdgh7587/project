<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "kr.or.ksmart.dao.Mdao" %>
<%@ page import = "kr.or.ksmart.dto.Member" %>
<%
Mdao mdao = new Mdao();
Member m = mdao.mSelectforUpdate("id003");
out.println(m.getM_id() + "<-- m.getM_id()	<br/>");
out.println(m.getM_pw() + "<-- m.getM_pw()	<br/>");
out.println(m.getM_level() + "<-- m.getM_level()	<br/>");
out.println(m.getM_name() + "<-- m.getM_name()	<br/>");
out.println(m.getM_email() + "<-- m.getM_email()	<br/>");
%>
아이디 : <%= m.getM_id() %>	<br/>
비   번 : <%= m.getM_pw() %>	<br/>
권   한 : <%= m.getM_level() %>	<br/>
이   름 : <%= m.getM_name() %>	<br/>
이메일 : <%= m.getM_email() %>	<br/>