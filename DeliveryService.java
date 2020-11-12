import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;


public class DeliveryService extends JFrame {
  
  private JButton GoButton, ResetButton;
  private JLabel WeightLabel,DeliveryTypeLabel;
  private JTextField WeightTF;
  private JPanel southPanel,northPanel, westPanel, westPanel2;
  private JCheckBox InsuranceBox;//box
  private JRadioButton LocalOption,GlobalOption;// circle
  private ButtonGroup deliveryGroup;
 

  
  public DeliveryService () {
    super ("Delivery Service");
    
   
    WeightLabel = new JLabel ("Enter weight in pounds:");
    WeightTF = new JTextField (5);
    northPanel= new JPanel ();
    northPanel.add (WeightLabel);
    northPanel.add (WeightTF);
    add (northPanel,BorderLayout.NORTH);
    
    
    GoButton = new JButton ("Go"); 
    ResetButton = new JButton ("Reset");
    southPanel = new JPanel ();
    southPanel.add (GoButton);
    southPanel.add (ResetButton);
    add (southPanel,BorderLayout.SOUTH);
    
    
   

   DeliveryTypeLabel =new JLabel ("Type of Delivery:");
   LocalOption =new JRadioButton ("Local");
   GlobalOption = new JRadioButton ("Long Distance");
 
    
    
      
   westPanel = new JPanel ();
   westPanel.add (DeliveryTypeLabel);
   westPanel.add(LocalOption);
   westPanel.add (GlobalOption);
   add (westPanel, BorderLayout.WEST);
   
   deliveryGroup = new ButtonGroup ();
   deliveryGroup.add(LocalOption);
    deliveryGroup.add(GlobalOption);
   
   
    InsuranceBox =new JCheckBox ("Insurance");
   westPanel2 =new JPanel ();
   westPanel2.add (westPanel);
    westPanel2.add (InsuranceBox);
   add (westPanel2, BorderLayout.WEST);
   
    
    setSize (500,300);
    setVisible(true);
    setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        
  }
 
  
  public static void main (String [] args){
   DeliveryService app =new DeliveryService ();
    
  }
}