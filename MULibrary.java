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



public class MULibrary extends JFrame implements ActionListener {
  
  private JButton AddButton, MUsearchButton, ArlingtonSearch;
  private JLabel ISBNLabel, TitleLabel;
  private JTextField isbnTF, titleTF;
  private JPanel southPanel, northPanel, centerPanel;
  
   public MULibrary () {
    super ("MU Library");
    
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
           output = "ISBN: "+isbn+" is not available at MU Library";
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
   }
   
     public static void main (String [] args){
   MULibrary app =new MULibrary ();
    
  }
}
   // no loop in MU LIB and loop in Arlington County LIB because it doesn't have GUI