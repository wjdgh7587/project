<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "kr.or.ksmart.dto.Member" %>
<%
	Member m = new Member();
	m.setM_id("id001");
	m.setM_pw("pw001");
	m.setM_level("������");
	m.setM_name("��浿");
	m.setM_email("email01");
	
	out.println(m.getM_id() + "<-- m.getM_id()	<br/>");
	out.println(m.getM_pw() + "<-- m.getM_pw()	<br/>");
	out.println(m.getM_level() + "<-- m.getM_level()	<br/>");
	out.println(m.getM_name() + "<-- m.getM_name()	<br/>");
	out.println(m.getM_email() + "<-- m.getM_email()	<br/>");
%>
���̵� : <%= m.getM_id() %>	<br/>
��   �� : <%= m.getM_pw() %>	<br/>
��   �� : <%= m.getM_level() %>	<br/>
��   �� : <%= m.getM_name() %>	<br/>
�̸��� : <%= m.getM_email() %>	<br/>
<!-- MemberŬ���� ���� ������ ��ü���� set�޼���5���� ȣ���ؼ� setting�ϰ�
getting�ؼ� 1)�ܼ�â ��� 2) out��ü Ȱ�� �ؼ� ȭ�� ��� 3) ǥ�������� ȭ�� ��� ����! -->