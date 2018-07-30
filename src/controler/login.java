package controler;
import model.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String user =new String(request.getParameter("username"));
        String password =new String(request.getParameter("password"));
        manager.user=user;
        manager.password=password;
        
	 try{     
		      Getconnection g=new Getconnection();
			  ResultSet rs=g.stmt.executeQuery("select * from manager");  
			  while(rs.next()){
				    if(user.equals(rs.getString("id"))){
					 if(password.equals(rs.getString("password"))){
						    manager.rank=Integer.parseInt("3");
						    System.out.println(manager.rank);
							request.getRequestDispatcher("welcome.jsp").forward(request, response); 
					 }
				        else 
				        	 response.sendRedirect("login.jsp?error=yes"); 
				    }
				   
			  }			 
			  rs.close();			   
	          g.close();
	}catch(java.lang.NullPointerException s){
		 response.sendRedirect("login.jsp?error=yes"); 
	}
	 catch(SQLException se){
	   // 处理 JDBC 错误
	   se.printStackTrace();
	}catch(Exception e){
	   // 处理 Class.forName 错误
	   e.printStackTrace();  
	}
      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
