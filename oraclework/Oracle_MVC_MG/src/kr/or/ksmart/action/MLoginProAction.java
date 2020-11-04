package kr.or.ksmart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.Inter.MActionInterFace;
import kr.or.ksmart.dao.Mdao;
import kr.or.ksmart.dto.Member;
import kr.or.ksmart.forward.MActionForward;

public class MLoginProAction implements MActionInterFace {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse resoibse) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("04-02 execute MLoginProAction.java");
		
		String ora_id = request.getParameter("ora_id");
		String ora_pw = request.getParameter("ora_pw");
		String result = null;
		
		System.out.println(ora_id);
		System.out.println(ora_pw);
		
		Mdao mdao = new Mdao();
		mdao.mLoginCheck(ora_id, ora_pw);
		
		//04단계 : MActionForward 통해 객체를 생성하고 리다이렉트로 경로를 세팅
		MActionForward mf = new MActionForward();
		mf.setRedirect(true);
		mf.setPath(request.getContextPath()+"/Mlist/m_list.ksmart_m");
		
		return mf;
	}

}
