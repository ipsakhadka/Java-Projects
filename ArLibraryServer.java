import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ArLibraryServer {
  private Socket socket, socket2;
  private ServerSocket serverSocket;
  private ObjectInputStream input;
  private ObjectOutputStream output;
  
  public ArLibraryServer () {
    System.out.println ("Arlington Library Server is Running!!");
        
    try {
    serverSocket = new ServerSocket (1098,500);
    
    while (true){
      socket = serverSocket.accept ();
      input = new ObjectInputStream (socket.getInputStream ()); 
      String isbn = (String) input.readObject (); 
      String command = "Select title from book where isbn = '"+ isbn +"';";
      System.out.println (command);
      
      String URL= "jdbc:mysql://localhost/arlibrary?user=root&password=";
      String Title= "";
      
       try {
         Class.forName("com.mysql.jdbc.Driver");
         System.out.println("Connected to JDBC!!!");
          
          Connection con = DriverManager.getConnection(URL);
          System.out.println("Connected to MySQL!!!");          
          Statement stmt = con.createStatement();
          ResultSet results = stmt.executeQuery(command); 
          
          while(results.next()) {
           Title = results.getString(1);
         }
          
          System.out.println(Title);          
        }     
        catch(SQLException sqle) {
         System.out.println(sqle.toString());
        }
         
         catch (ClassNotFoundException cnfe){
      cnfe.printStackTrace ();
    }
         
        socket = new Socket(InetAddress.getByName("localhost"), 1097);
        output = new ObjectOutputStream(socket.getOutputStream());
        output.writeObject(Title);
        output.flush();
        
      } //close loop
    }
    
    
    
    catch (IOException ioe) {
      ioe.printStackTrace ();
    }
    catch (ClassNotFoundException cnfe){
      cnfe.printStackTrace ();
    }
    
  }
  public static void main (String [] args){
   new ArLibraryServer ();
    
  }
}
