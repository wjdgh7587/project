package kr.or.ksmart.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.Inter.MActionInterFace;
import kr.or.ksmart.dao.Mdao;
import kr.or.ksmart.dto.Member;
import kr.or.ksmart.forward.MActionForward;


public class MListProAction implements MActionInterFace {
@Override
public MActionForward execute(HttpServletRequest request, HttpServletResponse resoibse) throws Exception {
	// TODO Auto-generated method stub
	System.out.println("04-02 execute MlistProAction.java");

	
	//Phase 1 : Are their have input values??
	//01 : �Է��ڷᰡ �ִ°�?
	
	
	
	//Phase 2 : need VO or DTO Object ?
	//02 : VO �Ǵ� DTO ��ü�� �ʿ��Ѱ�? ������ (����)
	
	//Phase 3 : Call the all_member_list method in the Mdao object and return
	//03 :  Mdao ��ü�� ��ü ȸ������ �޼ҵ� ȣ�� �� ���Ϲ޴´�.
	Mdao mdao = new Mdao();
	ArrayList<Member> alm = mdao.mAllSelect();	//Phase 4 : setting in the request Object
	//04 : request ��ü�� ����
	request.setAttribute("alm", alm);
	//request.setAttribute("ora_pw", 2);
	
	//Phase 5 : Make a object from the MActionForward and set the path you made
	//05 : MActionForward ���� ��ü�� �����ϰ� ������ ��� ����
	
	//Phase 6 : Return the address value of Object  which is made from the MActionForward
	//06 : MActionForward ���� ������ ��ü�� �ּҰ��� ����
	MActionForward mf = new MActionForward();
	mf.setRedirect(false);
	mf.setPath("/mlist/m_list.jsp");
	
	return mf;
}
}
