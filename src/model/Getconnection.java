package model;
import java.sql.*;
public class Getconnection {
  private String jdbc="com.mysql.jdbc.Driver"; 
  private String url="jdbc:mysql://localhost:3306/hotel";
  private String user="root";
  private String password="1234";
  public Connection conn=null;
  public Statement stmt=null;
  public Getconnection() {
	  this.user=manager.user;
	  this.password=manager.password;
	  try{
		  Class.forName(jdbc);
          conn = DriverManager.getConnection(url,user,password);
          stmt = conn.createStatement();
	  }catch(SQLException se){
		   // 处理 JDBC 错误
		   se.printStackTrace();
		}
	  catch(Exception e){
          // 处理 Class.forName 错误
          e.printStackTrace();  
  }
	    }
  
 public void close(){
	try{ 
		stmt.close();
	    conn.close();
	}catch(SQLException se){
        // 处理 JDBC 错误
        se.printStackTrace();
    }catch(Exception e){
        // 处理 Class.forName 错误
        e.printStackTrace();  
}
		 
 } 
}