package kr.or.ksmart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.Inter.MActionInterFace;
import kr.or.ksmart.dao.Mdao;
import kr.or.ksmart.dto.Member;
import kr.or.ksmart.forward.MActionForward;;

public class MInsertProAction implements MActionInterFace {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse resoibse) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("04_01 execute MInsertProAction.java");
		
		//01�ܰ� : ȭ�鿡�� �Է��� ������ �޾Ƽ� �ܼ�â�� Ȯ���Ѵ�.
		
		String ora_id = request.getParameter("ora_id");
		String ora_pw = request.getParameter("ora_pw");
		String ora_level = request.getParameter("ora_level");
		String ora_name = request.getParameter("ora_name");
		String ora_email = request.getParameter("ora_email");
		
		System.out.println(ora_id+" : ora_id execute from MInsertProAction.java");
		System.out.println(ora_pw+" : ora_pw execute from MInsertProAction.java");
		System.out.println(ora_level+" : ora_level execute from MInsertProAction.java");
		System.out.println(ora_name+" : ora_name execute from MInsertProAction.java");
		System.out.println(ora_email +" : ora_email execute from MInsertProAction.java");
		
		
		
		//02�ܰ� : VO DTO (Member Ŭ������ ���� ������ ��ü  ����
		Member m = new Member();
		
		m.setOra_id(ora_id);
		m.setOra_pw(ora_pw);
		m.setOra_level(ora_level);
		m.setOra_name(ora_name);
		m.setOra_email(ora_email);
		
		//03�ܰ� : Mdao ��ü���� �Է�ó�� �޼ҵ� ȣ�� �� ������ �ʿ�� �ް� �ƴҰ�� ���� �ʴ´�.
		
		Mdao mdao = new Mdao();
		mdao.mInsert(m);
		
		
		
		//04�ܰ� : MActionForward ���� ��ü�� �����ϰ� �����̷�Ʈ�� ��θ� ����
		
		return null;
	}

}
