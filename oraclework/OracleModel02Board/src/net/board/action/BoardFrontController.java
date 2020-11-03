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
	 //Servlet ����������Ŭ ���ظ� Ȯ�� ���� �����ڸ޼��� ����
   public BoardFrontController() {
        super();
		System.out.println("01 BoardFrontController ������ �޼���  ");
		System.out.println();
   }
	 //Servlet ����������Ŭ ���ظ� Ȯ�� ����  init �޼��� ����
	 public void init(){
		 System.out.println("02 init()�޼��� !!!!!!! ");
		 System.out.println();
	 }
	 //Servlet ����������Ŭ ���ظ� Ȯ�� ����  init �޼��� ����
	public void init(ServletConfig config) throws ServletException {
		System.out.println("03 init�޼��� config : "+config);
		System.out.println("03 init�޼��� config.config.getServletName() : "+config.getServletName());
		System.out.println("03 init�޼��� config.config.getInitParameterNames() : "+config.getInitParameterNames());
		System.out.println("03 init�޼��� config.config.getServletContext() : "+config.getServletContext());
		System.out.println("03 init�޼��� config.getServletContext().getContextPath() : "+config.getServletContext().getContextPath());
		//System.out.println("03 init�޼��� config.getInitParameter(getServletInfo()) : "+config.getInitParameter(getServletInfo()));
		//System.out.println("03 init�޼��� config.getInitParameter(getServletName()) : "+config.getInitParameter(getServletName()));
		System.out.println();
	}
	 //Servlet ����������Ŭ ���ظ� Ȯ�� ����  service �޼��� ����
/*	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("04444--- service �޼���  ");
		doProcess(request,response);

	}*/
	 //Servlet ����������Ŭ ���ظ� Ȯ�� ����  destroy �޼��� ����
	 public void destroy(){
		 System.out.println("09 destroy()�޼���  !!!!!!!");
		 System.out.println();

	 }
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		 	System.out.println("04 doGet()�޼��� request  => "+ request);
		 	System.out.println("04 doGet()�޼��� response  => "+ response);
		 	System.out.println(request.getParameter("page") + "<-- page ��ȣ doGet BoardFrontController.java");
		 	System.out.println();
			doProcess(request,response);
	}  	
			
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
	 	System.out.println("05 doPost()�޼��� request  => "+ request);
	 	System.out.println("05 doPost()�޼��� response  => "+ response);
	 	System.out.println();
		doProcess(request,response);
	}
			
			
	 protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
	 	throws ServletException, IOException {
		 System.out.println("06 doProcess ȣ�� BoardFrontController.java");
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
		
//--- ���࿡ forward ��ü�������� ����ִ� ���� null�� �ƴϸ�
//--- ������ �� ���ΰ�? �����̷�Ʈ �Ұ��ΰ�?
		if(forward != null){
			if(forward.isRedirect()){
				
				response.sendRedirect(forward.getPath());
			}else{
				
				RequestDispatcher dispatcher=
					request.getRequestDispatcher(forward.getPath());
				System.out.println(forward.getPath() + "<--- forward.getPath()[jsp �̵����]  BoardFrontController.java");
				System.out.println();
				dispatcher.forward(request, response);
			}
		}
	 }
	  	 
}