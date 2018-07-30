package controler;
import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

/**
 * Servlet implementation class reservationdelete
 */
@WebServlet("/reservationdelete")
public class reservationdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reservationdelete() {
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
			g.stmt.executeUpdate("delete from Reservation where customerid="+id);
	    g.close();
	}catch(SQLException se){
	   // 处理 JDBC 错误
	   se.printStackTrace();
	}catch(Exception e){
	   // 处理 Class.forName 错误
	   e.printStackTrace();  
	}
	String msg="ok";	 
	response.getWriter().write(msg);	 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
