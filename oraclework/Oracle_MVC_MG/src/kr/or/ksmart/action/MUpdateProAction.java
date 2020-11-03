package kr.or.ksmart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.Inter.MActionInterFace;
import kr.or.ksmart.dao.Mdao;
import kr.or.ksmart.dto.Member;
import kr.or.ksmart.forward.MActionForward;

public class MUpdateProAction implements MActionInterFace {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse resoibse) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("04-02 execute MUpdateProAction.java");
		
		String ora_id = request.getParameter("ora_id");
		String ora_pw = request.getParameter("ora_pw");
		String ora_level = request.getParameter("ora_level");
		String ora_name = request.getParameter("ora_name");
		String ora_email = request.getParameter("ora_email");
		
		System.out.println(ora_id);
		System.out.println(ora_pw);
		System.out.println(ora_level);
		System.out.println(ora_name);
		System.out.println(ora_email);
		
		
		Mdao mdao = new Mdao();
		Member m = new Member();
		
		m.setOra_id(ora_id);
		m.setOra_pw(ora_pw);
		m.setOra_level(ora_level);
		m.setOra_name(ora_name);
		m.setOra_email(ora_email);
		
		mdao.mUpdate(m);
		
		MActionForward mf = new MActionForward();
		mf.setRedirect(true);
		mf.setPath(request.getContextPath()+"/Mlist/m_list.ksmart_m");
		
		return mf;
	}

}
