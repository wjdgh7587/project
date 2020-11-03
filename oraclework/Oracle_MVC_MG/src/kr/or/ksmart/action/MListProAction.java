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
	//01 : 입력자료가 있는가?
	
	
	
	//Phase 2 : need VO or DTO Object ?
	//02 : VO 또는 DTO 객체가 필요한가? 없으면 (생략)
	
	//Phase 3 : Call the all_member_list method in the Mdao object and return
	//03 :  Mdao 객체내 전체 회원조희 메소드 호출 후 리턴받는다.
	Mdao mdao = new Mdao();
	ArrayList<Member> alm = mdao.mAllSelect();	//Phase 4 : setting in the request Object
	//04 : request 객체네 세팅
	request.setAttribute("alm", alm);
	//request.setAttribute("ora_pw", 2);
	
	//Phase 5 : Make a object from the MActionForward and set the path you made
	//05 : MActionForward 통해 객체를 생성하고 포워드 경로 세팅
	
	//Phase 6 : Return the address value of Object  which is made from the MActionForward
	//06 : MActionForward 통해 생성된 객체의 주소값을 리턴
	MActionForward mf = new MActionForward();
	mf.setRedirect(false);
	mf.setPath("/mlist/m_list.jsp");
	
	return mf;
}
}
