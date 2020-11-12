import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement; 

public class DataBaseExample {
  public static void main (String [] args){
    //http: database requires this format or in link
      //client is JAVA and server is database.
    String URL = "jdbc:mysql://localhost/IT230?user=root&password=";// password=saints"
    
    try {
     Class.forName("com.mysql.jdbc.Driver"); //the class we're in
     System.out.println ("JDBC is connected!!");
     
     Connection conn = DriverManager.getConnection(URL);
     System.out.println ("MYSql is connected!!");
     
     Statement stmt = conn.createStatement ();
     int id= 103;
     String insertCommand = "insert into student values('"+ id +", 'Jane','Smith' ')";
     //stmt.execute ("insert into student values ('102','Jane', 'Smith')");
     //System.out.println ("Command Successfully Executed!!");
    }
    catch (ClassNotFoundException cnfe){
      cnfe.printStackTrace ();
    }
    catch (SQLException sqle){
    sqle.printStackTrace();
    }
  }
}