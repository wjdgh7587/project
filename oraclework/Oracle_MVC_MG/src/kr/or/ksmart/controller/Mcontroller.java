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
import kr.or.ksmart.action.MInsertProAction;

/*
 * 	�����̳ʿ����� service �޼ҵ带 ȣ���ϱ� ���� HttpServletRequest ��ü�� HttpServletResponse ��ü�� �����Ͽ� service �޼ҵ忡 �Ķ���ͷ� �����Ѵ�.
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
			System.out.println("03_1 ���ǹ� /Min/m_insert_form.ksmart_m");
			// forward �Ǵ� redirect ����
			// ��� ����
			forward = new MActionForward();
			forward.setRedirect(false); // �ǹ� ���� �ڵ��. �̹� �ʱⰪ�� false �̱� ����
			forward.setPath("/minsert/m_insert_form.jsp");
			
		}else if(command.equals("/Min/m_insert_pro.ksmart_m")) {
			System.out.println("03_02 ���ǹ� /Min/m_insert_pro.ksmart_m MController.java");
			
			//execute �޼ҵ� ȣ��
			action  = new MInsertProAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		// --- ���࿡ forward ��ü�������� ����ִ� ���� null�� �ƴϸ�
		// --- ������ �� ���ΰ�? �����̷�Ʈ �Ұ��ΰ�?
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

		// ��û ��θ� ��������
		// get����̵� post ������� ��ü ��θ� �������� /������Ʈ ���� ��θ� ���� �Ϸ��� �Ѵ�.
		// e.g) http://localhost:8807/Oracle_MVC/MG/Min/m_insert_form.ksmart_m

	}

	public void parseCommand(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String cmd = uri.substring(path.length() + 1);
		String cmd2 = uri.substring(path.length() + 2);
		String cmd3 = uri.substring(path.length() + 3);
		String cmd4 = uri.substring(path.length() - 1);
		String cmd5 = uri.substring(path.length() - 2);
		String cmd6 = uri.substring(path.length() - 3);

		System.out.println(uri);
		System.out.println(path);
		System.out.println(cmd);
		System.out.println(cmd2);
		System.out.println(cmd3);
		System.out.println(cmd4);
		System.out.println(cmd5);
		System.out.println(cmd6);

		// return cmd;
	}

	// redirect�� �ƴϰ� forward �ϴ� ��Ȳ
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
// get������� ��û�ϸ� doGet �޼ҵ� ����
// Post ������� ��û�ϸ� doPost �޼ҵ� ����
