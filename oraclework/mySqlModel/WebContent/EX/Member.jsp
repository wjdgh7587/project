<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "kr.or.ksmart.dto.Member" %>
<%
	Member m = new Member();
	m.setM_id("id001");
	m.setM_pw("pw001");
	m.setM_level("관리자");
	m.setM_name("김길동");
	m.setM_email("email01");
	
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
<!-- Member클래스 통해 생성된 객체내의 set메서드5개를 호출해서 setting하고
getting해서 1)콘솔창 출력 2) out객체 활용 해서 화면 출력 3) 표현식으로 화면 출력 하자! -->