import java.net.Socket;
import java.net.ServerSocket;
import java.io.ObjectOutputStream; // cause sending msg out to the server
import java.net.InetAddress;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.io.ObjectInputStream;

public class TCPClient {
  
  private Socket socket;
  private ServerSocket serverSocket;
  private ObjectOutputStream output;
   private ObjectInputStream input;

  public TCPClient () {
    System.out.println ("Client is running!!!");
    Scanner keyboard = new Scanner (System.in);
    
    try {
      serverSocket = new ServerSocket (1097,500);
      while (true) {
    socket = new Socket (InetAddress.getByName("localhost"), 1098);
    String message = keyboard.nextLine ();
    output = new ObjectOutputStream(socket.getOutputStream());
    output.writeObject (message);
    output.flush ();
    
    socket = serverSocket.accept ();
      input = new ObjectInputStream (socket.getInputStream ()); //Casting: changing double into int 
     message = (String) input.readObject (); // bigger data into small
    System.out.println ("Client Says:" + message);
    }
    }
    
     catch (UnknownHostException uhe) {
      uhe.printStackTrace ();    
    }
     
    catch (IOException ioe) {
      ioe.printStackTrace ();
    }
    catch (ClassNotFoundException cnfe){
      cnfe.printStackTrace ();
    }
    
     
  }
  public static void main (String [] args) {
    new TCPClient ();
  }
}