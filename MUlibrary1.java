import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.net.Socket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;



public class MUlibrary1 extends JFrame implements ActionListener {
  
  private JButton AddButton, MUsearchButton, ArlingtonSearch;
  private JLabel ISBNLabel, TitleLabel;
  private JTextField isbnTF, titleTF;
  private JPanel southPanel, northPanel, centerPanel;
  private Socket socket, socket2;
  private ServerSocket serverSocket;
  private ObjectInputStream input;
  private ObjectOutputStream output;
  
   public MUlibrary1 () {
    super ("MU Library");
    try {
      serverSocket  = new ServerSocket(1097, 500);
    }
    catch(IOException exception) {
      exception.printStackTrace();
    }
    
    ISBNLabel = new JLabel ("ISBN:");
    isbnTF = new JTextField (20);
    TitleLabel = new JLabel ("Title:");
    titleTF = new JTextField (20);
    northPanel = new JPanel ();
    northPanel.add (ISBNLabel);
    northPanel.add (isbnTF);
    add (northPanel, BorderLayout.NORTH);
    centerPanel = new JPanel ();
    centerPanel.add (TitleLabel);
    centerPanel.add (titleTF);
    add (centerPanel, BorderLayout.CENTER);
    
    
    
    AddButton = new JButton ("Add New Book");
    AddButton.addActionListener (this);
    MUsearchButton = new JButton ("Search ISBN - MU Library");
    MUsearchButton.addActionListener (this);
    ArlingtonSearch = new JButton ("Search ISBN - Arlington Library");
    ArlingtonSearch.addActionListener (this);
    southPanel = new JPanel ();
    southPanel.add (AddButton);
    southPanel.add (MUsearchButton);
    southPanel.add (ArlingtonSearch);
    add (southPanel, BorderLayout.SOUTH);
    
    
    
     setSize (600,200);
    setVisible(true);
    setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    
   }
   
   public void actionPerformed (ActionEvent event) {
     if (event.getSource () == AddButton) {
     String isbn = isbnTF.getText ();
     String title = titleTF.getText ();
     String insert = "insert into book (isbn, title) values ('"+isbn+"', '"+title+"')";
     System.out.println (insert);
     
     String URL = "jdbc:mysql://localhost/mulibrary?user=root&password=";
     
     try {
       Class.forName("com.mysql.jdbc.Driver"); //the class we're in
       System.out.println ("JDBC is connected!!");
     
       Connection conn = DriverManager.getConnection(URL);
       System.out.println ("MYSql is connected!!");
     
     Statement stmt = conn.createStatement ();
     stmt.execute (insert);
     System.out.println ("Command is running!!!");
     String output = "The following book is SuccessFully added to the MU Library.\nISBN: "+isbn+" \nTitle: "+title;
     JOptionPane.showMessageDialog (null,output); 
     }
     catch(ClassNotFoundException exception) {
      System.out.println(exception.toString());
    }
    catch(SQLException exception) {
      System.out.println(exception.toString());
    }
     }
     else if (event.getSource() == MUsearchButton) {
       String isbn = isbnTF.getText ();
       String select = "Select title from book where isbn = '"+isbn+"';";
         System.out.println (select);
         
       String URL = "jdbc:mysql://localhost/mulibrary?user=root&password=";
       try {
         Class.forName("com.mysql.jdbc.Driver"); 
         System.out.println ("JDBC is connected!!");
     
         Connection conn = DriverManager.getConnection(URL);
         System.out.println ("MYSql is connected!!");
     
         Statement stmt = conn.createStatement ();
         ResultSet result = stmt.executeQuery (select);
         
         String title = "";
         while(result.next()) {
           title = result.getString(1);
         }
         String output = "";
         if(!title.equals("")) {
           output = "ISBN: "+isbn+" \nTitle: "+title+" \nAvailable at MU Library";
         }
         else {
           output = "ISBN: "+isbn+" is not available at MU Library!";
         }
         JOptionPane.showMessageDialog(null, output);
       }
       catch(ClassNotFoundException exception) {
         System.out.println(exception.toString());
       }
       catch(SQLException exception) {
         System.out.println(exception.toString());
       }      
     }
      else if (event.getSource() == ArlingtonSearch) {
    try {
      socket = new Socket(InetAddress.getByName("localhost"), 1098);
      output = new ObjectOutputStream(socket.getOutputStream());
      String isbn = isbnTF.getText();
      output.writeObject(isbn);
      output.flush();
      
      socket = serverSocket.accept();
      input = new ObjectInputStream(socket.getInputStream());
      String title = (String) input.readObject();
      String command = "";
      if(!title.equals("")) {
      command = "ISBN: "+isbn+" \nTitle "+title+" \nAvailable at Arlington Library";
      }
      else {
      command = "ISBN: "+isbn+" is not available at Arlington Library!";
      }
      JOptionPane.showMessageDialog(null, command);
  }
    catch(IOException exception) {
      System.out.println(exception.toString());
    }
   catch (ClassNotFoundException exception) {
     exception.printStackTrace();
    }
  }
     
   }
   
     public static void main (String [] args){
   MUlibrary1 app =new MUlibrary1 ();
    
  }
}
   // no loop in MU LIB and loop in Arlington County LIB because it doesn't have GUI