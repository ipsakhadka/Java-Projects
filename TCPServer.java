import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class TCPServer {
  
  private Socket socket, socket2;
  private ServerSocket serverSocket;
  private ObjectInputStream input;
  private ObjectOutputStream output;
  
  public TCPServer () {
    System.out.println ("Server is running!!!");
    Scanner keyboard = new Scanner (System.in);
    try {
    serverSocket = new ServerSocket (1098,500);
    
    while (true){
      socket = serverSocket.accept ();
      input = new ObjectInputStream (socket.getInputStream ()); //Casting: changing double into int 
      String message = (String) input.readObject (); // bigger data into small
      System.out.println ("Client Says:" + message);
    
      socket = new Socket (InetAddress.getByName("localhost"), 1097);
      message = keyboard.nextLine ();
      output = new ObjectOutputStream(socket.getOutputStream());
      output.writeObject (message);
      output.flush ();
      
    }
    }
   
    catch (IOException ioe) {
      ioe.printStackTrace ();
    }
    catch (ClassNotFoundException cnfe){
      cnfe.printStackTrace ();
    }
    
  }
  public static void main (String [] args){
   new TCPServer ();
  }
}