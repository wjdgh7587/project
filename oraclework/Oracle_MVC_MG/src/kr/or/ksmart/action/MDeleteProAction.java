package kr.or.ksmart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.Inter.MActionInterFace;
import kr.or.ksmart.dao.Mdao;
import kr.or.ksmart.dto.Member;
import kr.or.ksmart.forward.MActionForward;

public class MDeleteProAction implements MActionInterFace {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse resoibse) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("04-02 execute MDeleteProAction.java");
		
		String ora_id = request.getParameter("ora_id");
		System.out.println(ora_id);
		
		Mdao mdao = new Mdao();
		Member m = new Member();
		
		mdao.mDelete(ora_id);
		
		MActionForward mf = new MActionForward();
		mf.setRedirect(true);
		mf.setPath(request.getContextPath()+"/Mlist/m_list.ksmart_m");
		
		return mf;
	}

}
