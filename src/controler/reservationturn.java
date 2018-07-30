package controler;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Getconnection;

/**
 * Servlet implementation class reservationturn
 */
@WebServlet("/reservationturn")
public class reservationturn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reservationturn() {
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
			  ResultSet rs=g.stmt.executeQuery("select * from reservation where customerid="+id);  
			  while(rs.next()){
				     int customerid=rs.getInt("customerid");
					 String name=rs.getString("name");
					 String papernumber=rs.getString("papernumber");
					 int id1=rs.getInt("id");
					 Date arrivedate=rs.getDate("arrivedate");
					 Date leavedate=rs.getDate("leavedate");
					 int price=rs.getInt("price");
                     String sql="insert nowlist values(?,?,?,?,?,?,?)";
                     PreparedStatement pst=g.conn.prepareStatement(sql);
                     pst.setInt(1, customerid);
                     pst.setString(2, name);
                     pst.setString(3, papernumber);
                     pst.setInt(4, id1);
                     pst.setDate(5, arrivedate);
                     pst.setDate(6, leavedate);
                     pst.setInt(7, price);
                     pst.executeUpdate();
                     g.stmt.executeUpdate("update room set status='已满' where id="+id1); 
                     g.stmt.executeUpdate("delete from reservation where customerid="+id);
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
