<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.sql.*"%> 
<%@ page import="java.io.*" %>
<%@ page import="java.net.URLEncoder" %>


<%
    // �ٿ�ε� �� ���� ��
    String fullPath = request.getParameter("filename");
	System.out.println(fullPath + "<-- fullPath filedown.jsp");
    // ���� ���ϸ�
    //String fileName = request.getParameter("ofilename");
     
    // �������� ���� ��ġ
   // String path = "D:/kangeunji/orderproject15/orderproject/WebContent/admin/admin_menu/uploadimage";
   // String path = "D:/leehyoungyeol/OracleWork15/OraJspJavaFileUp03/WebContent/admin/admin_menu/uploadimage";
	String root = request.getSession().getServletContext().getRealPath("/");
	String path = root + "boardupload";
	System.out.println(path + "<-- saveFolder");
   
   
   
    // ����ƮŸ���� �ٿ�ε�� ����, �ȵ� ��� ������ ���� ���� �غ��ϴ�.
    // application/octet-stream, application
     
    
    String downName = null;
    String browser = request.getHeader("User-Agent");
    //���� ���ڵ�
    if(browser.contains("MSIE") || browser.contains("Trident") || browser.contains("Chrome")){             
        downName = URLEncoder.encode(fullPath,"UTF-8").replaceAll("\\+", "%20");
    } else {               
        downName = new String(fullPath.getBytes("UTF-8"), "ISO-8859-1");
    }
    response.setHeader("Content-Disposition","attachment;filename=\"" + downName+"\"");             
    response.setContentType("application/octer-stream");
    response.setHeader("Content-Transfer-Encoding", "binary;");

    
    System.out.println(downName + "<-- downName");
    //System.out.println((path+"/"+fullPath).getBytes("utf-8"));  
    
 
    // ���ϸ��� ���ڵ� �մϴ�.
    //String filename2 = java.net.URLEncoder.encode(new String(fullPath.getBytes("iso-8859-1"), "euc-kr"), "UTF-8");
    //String ofilename2 = java.net.URLEncoder.encode(new String(fullPath.getBytes("iso-8859-1"), "euc-kr"), "UTF-8");
    
    //System.out.println(filename2 + "<-- filename2  filedown.jsp");
    
    // �ٿ�ε�� ���ϸ��� �����մϴ�.
    //response.setHeader("Content-Disposition","attachment; filename="+fullPath+";");
     
    
    
    
    // ������ �а� �� ��Ʈ��
    BufferedInputStream in = null;
    BufferedOutputStream os = null;
     
    // ���� ����
    

    
   // File file = new File (new String((path+"/"+fullPath).getBytes("utf-8"), "euc-kr"));
     File file = new File (path+"/"+fullPath);
     
    // �̰��� �ݵ�� ���־�� �մϴ�.
    // �ֳ��ϸ� jsp �⺻��ü�� �ϳ��� out�� response�� ���ؼ� �̹� stream�� ���� �ֱ� �����Դϴ�. 
    out.clear();
    out = pageContext.pushBody();
     
    // ������ ��Ʈ������ �ѷ� ���ϴ�.
    try {
        // ��ǲ �ƿ�ǲ ��Ʈ�� ����
        in = new BufferedInputStream(new FileInputStream(file));
        os = new BufferedOutputStream(response.getOutputStream());
         
        // ����
        byte[] buf = new byte[(int)file.length()]; 
        int count = 0;
         
        // �ų��� ���鼭 ���ۿ� �ִ� ���� �Ѹ��ϴ�.
        while ((count = in.read(buf)) != -1) {
            os.write(buf,0,count);
        }
    }
    catch(Exception e) {
        // �������� ������ �ֿܼ� �Ѹ��ϴ�.
        e.printStackTrace();    
    }
    finally
    {
        // �����ִ� ��Ʈ���� �ʽ� �ݾ��ݴϴ�.
        if(in != null) try{in.close();}catch(Exception e){}
        if(os != null) try{os.close();}catch(Exception e){}
    }
%>

