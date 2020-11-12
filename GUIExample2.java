import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class GUIExample2 extends JFrame implements ActionListener {
  
  private JButton submitButton, cancelButton;
  private JLabel fullnameLabel,hobbyLabel,maleLabel, femaleLabel;
  private JTextField fullnameTF;
  private JPanel southPanel,northPanel, westPanel, westPanel2;
  private JCheckBox movieBox,musicBox;
  private JPanel centerPanel;
  private JComboBox stateBox;
  private JRadioButton maleOption,femaleOption;
  private ButtonGroup genderGroup;
  private JTextArea commentArea;
  private ImageIcon maleIcon, femaleIcon;
  
  public GUIExample2 () {
    super ("My First Java Interface");
//JFrame mainframe = new JFrame (); REMOVING MAINFRAME TO MAKE THE WHOLE GUI EXAMPLE A MAINFRAME. 
    
    commentArea = new JTextArea (10, 5);
    add (commentArea,BorderLayout.EAST);
    
    maleIcon =new ImageIcon ("male.gif");
    maleLabel = new JLabel (maleIcon);
    maleOption =new JRadioButton ();
    femaleIcon = new ImageIcon ("female.gif");
    femaleLabel =new JLabel (femaleIcon);
    femaleOption =new JRadioButton ();
    genderGroup =new ButtonGroup ();
    genderGroup.add(maleOption);
    genderGroup.add(femaleOption);
    centerPanel = new JPanel ();
    centerPanel.add(maleOption);
    centerPanel.add(maleLabel); //never maleIcon
    centerPanel.add (femaleOption);
    centerPanel.add (femaleLabel);
    add (centerPanel, BorderLayout.CENTER);
    
    fullnameLabel = new JLabel ("Enter Full Name:");
    fullnameLabel.setForeground (Color.PINK);
    fullnameLabel.setFont (new Font ("Times New Roman", Font.PLAIN, 25));
    fullnameLabel.setToolTipText ("Enter only alphabets.");
    fullnameTF = new JTextField (10);
    northPanel= new JPanel ();
    northPanel.add (fullnameLabel);
    northPanel.add (fullnameTF);
    Color myColor = new Color (230,255,70);
    northPanel.setBackground (myColor);
    add (northPanel,BorderLayout.NORTH);
    
    
    submitButton = new JButton ("Submit"); //(Don't write JButton infront)
    
    submitButton.setBackground (Color.GREEN);
    submitButton.addActionListener (this);
    cancelButton = new JButton ("Cancel");
    cancelButton.setBackground (Color.RED);
    cancelButton.addActionListener (this);
    southPanel = new JPanel ();
    southPanel.setBackground (Color.YELLOW);
    southPanel.add (submitButton);
    southPanel.add (cancelButton);
    add (southPanel,BorderLayout.SOUTH);
    
    
   
   movieBox =new JCheckBox ("Movie");
   musicBox = new JCheckBox ("Music");
   hobbyLabel =new JLabel ("Select your hobby:");
   String stateName []= {"--select a state", "DC","MD","VA"};
   stateBox = new JComboBox (stateName);
   
   
   westPanel = new JPanel ();
   westPanel.setLayout (new GridLayout (4,1));
   westPanel.add (hobbyLabel);
   westPanel.add (movieBox);
   westPanel.add (musicBox);
   westPanel.add (stateBox);
   
   westPanel2 =new JPanel ();
   westPanel2.add (westPanel);
   add (westPanel2, BorderLayout.WEST);
   
    
    setSize (600,400);
    setVisible(true);
    setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        
  }
  
  public void actionPerformed (ActionEvent event) {
    if (event.getSource() == submitButton) {
   //System.out.println("Submit Button is clicked!!!");
      String fullname =fullnameTF.getText ();
     // double dollars =  Double.parseDouble (fullname);
      //int dol = Integer.parseInt (fullname);
     // double pounds = dollars * 0.78;
      
      String state = stateBox.getSelectedItem().toString ();
      String movie = "No";
          
      if (movieBox.isSelected ()){
       movie= "Yes";
      }
       String music = "No";
      
      if (musicBox.isSelected ()){
       music = "Yes";
      }
      
      String gender = "Not selected";
      if (maleOption.isSelected ()){
       gender = "Male"; 
      }
      
      else if (femaleOption.isSelected ()) {
      gender = "female";
      }
      
      String output = "Confirmation:\nFull Name:" + fullname +
        "\nMovie:" + movie +
        "\nMusic:" + music +
        "\nState:" + state +
        "\nGender:" + gender;
      JOptionPane.showMessageDialog (null,output);
      System.out.println (output);
      //System.out.println (fullname + "" + state);
      //System.out.println (fullname);
    }// end submitButton
    
    else if (event.getSource ()== cancelButton){
    //System.out.println ("Cancel Button is Clicked!!");
      fullnameTF.setText("");
      stateBox.setSelectedIndex (0);
      movieBox.setSelected (false);
      musicBox.setSelected (false);
      genderGroup.clearSelection ();
      
    }
  }
  
  public static void main (String [] args){
   GUIExample2 app =new GUIExample2 ();
    
  }
}