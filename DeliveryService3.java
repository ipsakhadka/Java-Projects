
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DeliveryService3 extends JFrame implements ActionListener {
  
  private JButton GoButton, ResetButton;
  private JLabel WeightLabel,DeliveryTypeLabel;
  private JTextField WeightTF;
  private JPanel southPanel,northPanel, westPanel, westPanel2;
  private JCheckBox InsuranceBox;
  private JRadioButton LocalOption,GlobalOption;
  private ButtonGroup deliveryGroup;
 

  
  public DeliveryService3 () {
    super ("Delivery Service");
    
   
    WeightLabel = new JLabel ("Enter weight in pounds:");
    WeightTF = new JTextField (5);
    northPanel= new JPanel ();
    northPanel.add (WeightLabel);
    northPanel.add (WeightTF);
    add (northPanel,BorderLayout.NORTH);
    
    
    GoButton = new JButton ("Go"); 
    ResetButton = new JButton ("Reset");
    GoButton.addActionListener(this);
    ResetButton.addActionListener(this);
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
  
  public void actionPerformed(ActionEvent event) {
    
    if(event.getSource() == GoButton) {
          
       String Weight = WeightTF.getText();
       double weight = Double.parseDouble (Weight);
       double fee = 0;
       
       String DeliveryType = "";
       if(LocalOption.isSelected()) {
         DeliveryType = "Local";
         
         if (weight < 5){
         fee = 5.75;
         }
         
         else if (weight >= 5 && weight <= 20){
         fee = 10.75;
         }
         
         else if (weight > 20) {
         fee= 20.75;
         }
         
       }
       else if(GlobalOption.isSelected()) {
         DeliveryType = "Long Distance";
         
         if (weight <5){
         fee= 35.75;
         }
         else if (weight >= 5){
         fee = 47.75;
         }
       }
       String Insurance = "";
       if(InsuranceBox.isSelected()) {
         Insurance = "Yes";
         fee += 4;
       }
       else if (!InsuranceBox.isSelected()) {
         Insurance = "No";
       }
       
       String output = "Delivery Information" +
         "\nWeight: " + Weight + 
         "\nType of Delievery: " + DeliveryType + 
         "\nInsurance: " + Insurance +
         "\nPrice: $" + fee ;
         
       JOptionPane.showMessageDialog(null, output);
    }
    else if(event.getSource() == ResetButton) {
      WeightTF.setText("");
      deliveryGroup.clearSelection();
      InsuranceBox.setSelected(false);
    }
  }
 
  
  public static void main (String [] args){
   DeliveryService3 app =new DeliveryService3 ();
    
  }
}