package controler;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Getconnection;

/**
 * Servlet implementation class nowlistinsert
 */
@WebServlet("/nowlistinsert")
public class nowlistinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public nowlistinsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id =new String(request.getParameter("id"));
	    Getconnection g=new  Getconnection();
	 try{ 
			  ResultSet rs=g.stmt.executeQuery("select * from customer where id="+id);  
			  while(rs.next()){
					 String name=rs.getString("name");
					 String papernumber=rs.getString("papernumber");
					 response.setCharacterEncoding("UTF-8"); 
                     response.getWriter().write("{\"name\":"+"\""+name+"\""+",\"papernumber\":"+"\""+papernumber+"\""+"}");
			  }			 
			  rs.close();
	          g.close();
	}catch(SQLException se){
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
