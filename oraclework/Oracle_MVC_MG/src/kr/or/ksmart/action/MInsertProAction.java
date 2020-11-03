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
		
		//01단계 : 화면에서 입력한 값들을 받아서 콘솔창에 확인한다.
		
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
		
		
		
		//02단계 : VO DTO (Member 클래스를 통해 생성된 객체  세팅
		Member m = new Member();
		
		m.setOra_id(ora_id);
		m.setOra_pw(ora_pw);
		m.setOra_level(ora_level);
		m.setOra_name(ora_name);
		m.setOra_email(ora_email);
		
		//03단계 : Mdao 객체내의 입력처리 메소드 호출 후 리턴이 필요시 받고 아닐경우 받지 않는다.
		
		Mdao mdao = new Mdao();
		mdao.mInsert(m);
		
		
		
		//04단계 : MActionForward 통해 객체를 생성하고 리다이렉트로 경로를 세팅
		
		return null;
	}

}
