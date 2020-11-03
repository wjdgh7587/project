<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "kr.or.ksmart.driverdb.DriverDB" %>
<%@ page import = "java.sql.Connection" %>
<%
Connection conn = null;

DriverDB db = new DriverDB();
conn = db.driverDbcon();
System.out.println(conn + "<-- conn");


out.println(conn + "<-- conn <br/>");
/* driverDbcon 메서드 호출 후 리턴값을 받아 새로운 변수에 값을 담고 변수에 담겨있는 값을 화면에 출력하세요! */
%>
표현식으로 conn변수 : <%= conn %>

