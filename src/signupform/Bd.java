package signupform;
import java.sql.Connection;
import java.sql.DriverManager;
public class Bd {
 Connection con= null;
 java.sql.PreparedStatement pst;
 public static Connection dbconnection () // dc method to calling in our signup class
 {
	 
	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");// load the driver class
		 Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/userform","root","");// create connection 
		 return conn;  // return conn object
	 }catch (Exception e) {
		 System.out.println(e);
		 return null;
	 }
 }
 
 
}
