package controler;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Getconnection;

/**
 * Servlet implementation class userinsert
 */
@WebServlet("/userinsert")
public class userinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userinsert() {
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
				String name =new String(request.getParameter("name"));
				String sex =new String(request.getParameter("sex"));
				String papertype =new String(request.getParameter("papertype"));
				String papernumber =new String(request.getParameter("papernumber"));
				String phonenumber =new String(request.getParameter("phonenumber"));
                String sql="insert customer(name,sex,papertype,papernumber,phonenumber) values(?,?,?,?,?)";
                PreparedStatement pst=g.conn.prepareStatement(sql);
                pst.setString(1, name);
                pst.setString(2, sex);
                pst.setString(3, papertype);
                pst.setString(4, papernumber);
                pst.setString(5,phonenumber);
                pst.executeUpdate();
	            g.close();
	            response.sendRedirect("usershow.jsp"); 
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
