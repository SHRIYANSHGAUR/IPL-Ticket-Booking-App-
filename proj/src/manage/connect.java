package manage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class connect {

static	Connection con;

//connection is static so that we dont need object!
	
	public  static Connection createC() throws ClassNotFoundException, SQLException {
		//load the driver;
		
		//JDBC DATABASE LINKAGE !
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//create the connection
		String user= "root";
		String password= "password";
		String url= "jdbc:mysql://localhost:3306/ipl?characterEncoding=latin1";
		
		con= DriverManager.getConnection(url,user,password);
		return con;
	}
	
}
