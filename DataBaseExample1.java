import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement; 
import java.sql.ResultSet;

public class DataBaseExample1 {
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
     String query= "select * from student";
     ResultSet result = stmt.executeQuery(query);
     
     while (result.next ()){
       
       String studentID = result.getString (1);
       System.out.println (StudentID);//these 1/2/3 refers to column
       System.out.println (result.getString(2));
       System.out.println (result.getString(3));
     }
    }
    catch (ClassNotFoundException cnfe){
      cnfe.printStackTrace ();
    }
    catch (SQLException sqle){
    sqle.printStackTrace();
    }
  }
}