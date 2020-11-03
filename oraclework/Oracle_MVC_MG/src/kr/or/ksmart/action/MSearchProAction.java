package kr.or.ksmart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.Inter.MActionInterFace;
import kr.or.ksmart.dao.Mdao;
import kr.or.ksmart.dto.Member;
import kr.or.ksmart.forward.MActionForward;

public class MSearchProAction implements MActionInterFace {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse resoibse) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("04_01 execute MSearchProAction.java");
		request.setCharacterEncoding("euc-kr");
		String sk = request.getParameter("sk");
		String sv = request.getParameter("sv");
		System.out.println(sk + "<-- sk ");
		System.out.println(sv + "<-- sv ");
		Member m = new Member();
		Mdao mdao = new Mdao();
		mdao.mSearch(sk, sv);
		
		
		return null;
	}

}
