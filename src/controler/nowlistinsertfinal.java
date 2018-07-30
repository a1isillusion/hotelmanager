package controler;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Getconnection;

/**
 * Servlet implementation class nowlistinsertfinal
 */
@WebServlet("/nowlistinsertfinal")
public class nowlistinsertfinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public nowlistinsertfinal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    Getconnection g=new  Getconnection();
		 try{ 
				int customerid =Integer.parseInt(new String(request.getParameter("customerid")));
				String name =new String(request.getParameter("name"));
				String papernumber =new String(request.getParameter("papernumber"));
				int id =Integer.parseInt(new String(request.getParameter("id")));
				Date arrivedate =Date.valueOf(request.getParameter("arrivedate"));
				Date leavedate =Date.valueOf(request.getParameter("leavedate"));
				int price =Integer.parseInt(new String(request.getParameter("price")));
                String sql="insert nowlist values(?,?,?,?,?,?,?)";
                PreparedStatement pst=g.conn.prepareStatement(sql);
                pst.setInt(1, customerid);
                pst.setString(2, name);
                pst.setString(3, papernumber);
                pst.setInt(4, id);
                pst.setDate(5, arrivedate);
                pst.setDate(6, leavedate);
                pst.setInt(7, price);
                pst.executeUpdate();
                g.stmt.executeUpdate("update room set status='已满' where id="+id);
	            g.close();
	            response.sendRedirect("nowlistshow.jsp"); 
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
