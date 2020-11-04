package kr.or.ksmart.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.or.ksmart.forward.MActionForward;
import kr.or.ksmart.Inter.MActionInterFace;
import kr.or.ksmart.action.MDeleteProAction;
import kr.or.ksmart.action.MInsertProAction;
import kr.or.ksmart.action.MListProAction;
import kr.or.ksmart.action.MLoginProAction;
import kr.or.ksmart.action.MSearchProAction;
import kr.or.ksmart.action.MUpdateProAction;

/*
 * 	컨테이너에서는 service 메소드를 호출하기 전에 HttpServletRequest 객체와 HttpServletResponse 객체를 생성하여 service 메소드에 파라미터로 전송한다.
 * //	String uri = request.getRequestURI();
//
//	String conPath = request.getContextPath();
//
//	String com = uri.substring(conPath.length());

 * */

//@WebServlet("/Mcontroller")
public class Mcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Mcontroller() {
		// super();
		System.out.println("00 MControllerMController.java");
	}

	protected void doPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");

		System.out.println("02 doPro MController.java");
		System.out.println(request + " :  request doPro Mcontroller.java");
		System.out.println(response + " :  response doPro Mcontroller.java");

		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());

		System.out.println(RequestURI + "<-- RequestURI Mcontroller.java");
		System.out.println(contextPath + "<-- contextPath Mcontroller.java");
		System.out.println(contextPath.length() + "<-- contextPath.length() Mcontroller.java");
		System.out.println(command + "<-- command Mcontroller.java");
		System.out.println("----------Mcontroller.java----------------");
		System.out.println();

		MActionForward forward = null;
		MActionInterFace action = null;

		if (command.equals("/Min/m_insert_form.ksmart_m")) {
			System.out.println("03_1 조건문 /Min/m_insert_form.ksmart_m");
			// forward 또는 redirect 세팅
			// 경로 세팅
			forward = new MActionForward();
			forward.setRedirect(false); // 의미 없는 코드다. 이미 초기값이 false 이기 때문
			forward.setPath("/minsert/m_insert_form.jsp");
			
		}else if(command.equals("/Min/m_insert_pro.ksmart_m")) {
			System.out.println("03_02 조건문 /Min/m_insert_pro.ksmart_m MController.java");
			
			//execute 메소드 호출
			action  = new MInsertProAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		//login
		else if(command.equals("/MLogin/m_login_pro.ksmart_m")) {
			System.out.println("03_03 조건문 /MLogin/m_login_pro.ksmart_m");
			action  = new MLoginProAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
			//llsit
		}
		else if(command.equals("/Mlist/m_list.ksmart_m")) {
			System.out.println("03_03 조건문 /Mlist/m_list.ksmart_m");
			
			action  = new MListProAction();
			
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//update
		else if(command.equals("/MUpdate/m_update.ksmart_m")) {
			System.out.println("03_04 조건문 /Mupdate/m_update.ksmart_m");
			
			action = new MUpdateProAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		//delete
		else if(command.equals("/Mdelete/m_delete.ksmart_m")) {
			System.out.println("03_04 조건문 /Mdelete/m_delete.ksmart_m");
			
			action = new MDeleteProAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//search
		else if(command.equals("/Msearch/m_search_list.ksmart_m")) {
			System.out.println("03_04 조건문 /Msearch/m_search_list.ksmart_m");
			
			action = new MSearchProAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		// --- 만약에 forward 객체참조변수 담겨있는 값이 null이 아니면
		// --- 포워드 할 것인가? 리다이렉트 할것인가?
		if (forward != null) {
			if (forward.isRedirect()) {

				response.sendRedirect(forward.getPath());
			} else {

				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				System.out.println(forward.getPath() + "<--- forward.getPath()  Mcontroller.java");
				System.out.println();
				dispatcher.forward(request, response);
			}
		}

		// 요청 경로를 기준으로
		// get방식이든 post 방식으든 전체 경로를 기준으로 /프로젝트 하위 경로를 추출 하려고 한다.
		// e.g) http://localhost:8807/Oracle_MVC/MG/Min/m_insert_form.ksmart_m

	}

	public void parseCommand(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String cmd = uri.substring(path.length() + 1);

		System.out.println(uri);
		System.out.println(path);
		System.out.println(cmd);


		// return cmd;
	}

	// redirect가 아니고 forward 하는 상황
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("01_01 doGet MController.java");
		doPro(request, response);
		// parseCommand(request);
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("01_01 doPost MController.java");
		 doPro(request, response);
		// doGet(request, response);
	}

}
// get방식으로 요청하면 doGet 메소드 실행
// Post 방식으로 요청하면 doPost 메소드 실행
