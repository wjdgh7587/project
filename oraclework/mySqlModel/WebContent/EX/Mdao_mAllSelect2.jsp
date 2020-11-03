<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "kr.or.ksmart.dao.Mdao" %>
<%@ page import = "kr.or.ksmart.dto.Member" %>
<%@ page import = "java.util.ArrayList" %>
<%
Mdao mdao = new Mdao();
ArrayList<Member> alm = mdao.mAllSelect();
Member m = alm.get(0);
//m.getM_id();
out.println(m.getM_id() + "<-- m.getM_id() <br/><br/>");
out.println(alm.get(1).getM_pw() + "<-- alm.get(1).getM_pw() <br/><br/>");

%>