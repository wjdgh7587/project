package net.board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 public class BoardFrontController 
 	extends javax.servlet.http.HttpServlet 
 	implements javax.servlet.Servlet {
	 //Servlet 라이프사이클 이해를 확인 위한 생성자메서드 선언
   public BoardFrontController() {
        super();
		System.out.println("01 BoardFrontController 생성자 메서드  ");
		System.out.println();
   }
	 //Servlet 라이프사이클 이해를 확인 위한  init 메서드 선언
	 public void init(){
		 System.out.println("02 init()메서드 !!!!!!! ");
		 System.out.println();
	 }
	 //Servlet 라이프사이클 이해를 확인 위한  init 메서드 선언
	public void init(ServletConfig config) throws ServletException {
		System.out.println("03 init메서드 config : "+config);
		System.out.println("03 init메서드 config.config.getServletName() : "+config.getServletName());
		System.out.println("03 init메서드 config.config.getInitParameterNames() : "+config.getInitParameterNames());
		System.out.println("03 init메서드 config.config.getServletContext() : "+config.getServletContext());
		System.out.println("03 init메서드 config.getServletContext().getContextPath() : "+config.getServletContext().getContextPath());
		//System.out.println("03 init메서드 config.getInitParameter(getServletInfo()) : "+config.getInitParameter(getServletInfo()));
		//System.out.println("03 init메서드 config.getInitParameter(getServletName()) : "+config.getInitParameter(getServletName()));
		System.out.println();
	}
	 //Servlet 라이프사이클 이해를 확인 위한  service 메서드 선언
/*	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("04444--- service 메서드  ");
		doProcess(request,response);

	}*/
	 //Servlet 라이프사이클 이해를 확인 위한  destroy 메서드 선언
	 public void destroy(){
		 System.out.println("09 destroy()메서드  !!!!!!!");
		 System.out.println();

	 }
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		 	System.out.println("04 doGet()메서드 request  => "+ request);
		 	System.out.println("04 doGet()메서드 response  => "+ response);
		 	System.out.println(request.getParameter("page") + "<-- page 번호 doGet BoardFrontController.java");
		 	System.out.println();
			doProcess(request,response);
	}  	
			
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
	 	System.out.println("05 doPost()메서드 request  => "+ request);
	 	System.out.println("05 doPost()메서드 response  => "+ response);
	 	System.out.println();
		doProcess(request,response);
	}
			
			
	 protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
	 	throws ServletException, IOException {
		 System.out.println("06 doProcess 호출 BoardFrontController.java");
		 String RequestURI=request.getRequestURI();
		 String contextPath=request.getContextPath();
		 String command=RequestURI.substring(contextPath.length());
		 System.out.println(RequestURI + "<-- RequestURI BoardFrontController.java");
		 System.out.println(contextPath + "<-- contextPath BoardFrontController.java");
		 System.out.println(contextPath.length() + "<-- contextPath.length() BoardFrontController.java");
		 System.out.println(command + "<-- command BoardFrontController.java");
		 System.out.println("----------BoardFrontController.java----------------");
		 System.out.println();
		 ActionForward forward=null;
		 Action action=null;
		
		if(command.equals("/board/BoardWrite.bo")){
			
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./qna_board_write.jsp");
		}else if(command.equals("/board/BoardReplyAction.bo")){
			action = new BoardReplyAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/board/BoardDelete.bo")){
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./qna_board_delete.jsp");
		}else if(command.equals("/board/BoardModify.bo")){
			action = new BoardModifyView();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
	 	}else if(command.equals("/board/BoardAddAction.bo")){
			action  = new BoardAddAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/board/BoardReplyView.bo")){
			action = new BoardReplyView();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/board/BoardModifyAction.bo")){
			action = new BoardModifyAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/board/BoardDeleteAction.bo")){
			action = new BoardDeleteAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/board/BoardList.bo")){
			
			action = new BoardListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/board/BoardDetailAction.bo")){
			action = new BoardDetailAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
//--- 만약에 forward 객체참조변수 담겨있는 값이 null이 아니면
//--- 포워드 할 것인가? 리다이렉트 할것인가?
		if(forward != null){
			if(forward.isRedirect()){
				
				response.sendRedirect(forward.getPath());
			}else{
				
				RequestDispatcher dispatcher=
					request.getRequestDispatcher(forward.getPath());
				System.out.println(forward.getPath() + "<--- forward.getPath()[jsp 이동경로]  BoardFrontController.java");
				System.out.println();
				dispatcher.forward(request, response);
			}
		}
	 }
	  	 
}