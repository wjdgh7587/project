<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form action="<%=request.getContextPath()%>/Msearch/m_search_list.ksmart_m" method="post">
	<select name="sk">
	    <option value="ora_id">���̵�</option>
	    <option value="ora_level">����</option>
	    <option value="ora_name">�̸�</option>
	    <option value="ora_email">�̸���</option>
	</select>
	<input type="text" name="sv">
	<input type="submit" value="�˻���ư">
</form>