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
 * Servlet implementation class roominsert
 */
@WebServlet("/roominsert")
public class roominsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public roominsert() {
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
				int id =Integer.parseInt(new String(request.getParameter("id")));
				String type =new String(request.getParameter("type"));
				int price =Integer.parseInt(new String(request.getParameter("price")));
				int deposit =Integer.parseInt(new String(request.getParameter("deposit")));
                String sql="insert room values(?,?,?,?,?)";
                PreparedStatement pst=g.conn.prepareStatement(sql);
                pst.setInt(1, id);
                pst.setString(2, type);
                pst.setInt(3, price);
                pst.setInt(4, deposit);
                pst.setString(5,"空闲");
                pst.executeUpdate();
	            g.close();
	            response.sendRedirect("roomshow.jsp"); 
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
