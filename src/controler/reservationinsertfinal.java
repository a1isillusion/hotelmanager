package controler;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Getconnection;

/**
 * Servlet implementation class reservationinsertfinal
 */
@WebServlet("/reservationinsertfinal")
public class reservationinsertfinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reservationinsertfinal() {
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
				String sex =new String(request.getParameter("sex"));
				String type =new String(request.getParameter("type"));
				int id =Integer.parseInt(new String(request.getParameter("id")));
				int price =Integer.parseInt(new String(request.getParameter("price")));
				String papertype =new String(request.getParameter("papertype"));
				String papernumber =new String(request.getParameter("papernumber"));
				String phonenumber =new String(request.getParameter("phonenumber"));
				Date arrivedate =Date.valueOf(request.getParameter("arrivedate"));
				Date leavedate =Date.valueOf(request.getParameter("leavedate"));
				
                String sql="insert reservation values(?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pst=g.conn.prepareStatement(sql);
                pst.setInt(1, customerid);
                pst.setString(2, name);
                pst.setString(3, sex);
                pst.setString(4, type);
                pst.setInt(5, id);
                pst.setInt(6, price);
                pst.setString(7, papertype);
                pst.setString(8, papernumber);
                pst.setString(9, phonenumber);
                pst.setDate(10, arrivedate);
                pst.setDate(11, leavedate);
                pst.executeUpdate();
	            g.close();
	            response.sendRedirect("reservationshow.jsp"); 
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
