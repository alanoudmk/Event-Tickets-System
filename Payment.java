package eventticketssystem;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;


public class Payment extends  JFrame{
    private final int WIDTH =320;
    private final int HIGHT =440;
    private JLabel topic,card_number,holder_name,cvv_label,image_label,error_Label;
    private JTextField number_txt ,holder_txt,cvv_txt;
    private ImageIcon image;
    private JButton proceed_Button ;
    private JPanel topic_Panel , error_Panel,button_Panel,image_Panel,details_Panel,panel1,panel2;
    
    public Payment() {
       
        //set Window
        setTitle("payment page");
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setSize(WIDTH,HIGHT);
        
        buildPaymentPage();
        
        //add paneles to content pane
        add( topic_Panel , BorderLayout.NORTH);
        
        add( panel1 ,BorderLayout.CENTER);
        
        add(panel2,BorderLayout.SOUTH);
        
        setLocationRelativeTo(null);  
        
        
    }
    private void buildPaymentPage() {
        //crerat panels
        details_Panel = new JPanel(); 
        image_Panel = new JPanel();
        error_Panel = new JPanel(); 
        button_Panel=new JPanel();
        topic_Panel=new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        panel1= new JPanel(); 
        panel1.setLayout(new BorderLayout());
        panel2= new JPanel();
        panel2.setLayout(new BorderLayout());
        
        
        
        
        //image
        image_label = new JLabel();
        image = new ImageIcon( "payment.png" );
        image_label.setIcon( image );
        image_label.setBorder(BorderFactory.createLineBorder( Color.black,3));
        image_Panel.add( image_label );
        
        topic = new JLabel("Card Details:");
        topic.setFont(new Font("Serif", Font.BOLD+Font.ITALIC, 18));
        topic_Panel.add(topic);
        

        //label details
        card_number = new JLabel("Card Number:");
        holder_name = new JLabel("Card Holder Name:");
        cvv_label = new JLabel("CVV:");
        
        //textFeild
        number_txt=new JTextField(20);
        holder_txt=new JTextField(20);
        cvv_txt=new JTextField(5);
        
        
        details_Panel.add(card_number);
        details_Panel.add(number_txt);
        details_Panel.add(holder_name);
        details_Panel.add(holder_txt);
        details_Panel.add(cvv_label);
        details_Panel.add(cvv_txt);
        
        panel1.add(image_Panel,BorderLayout.NORTH );
        panel1.add(details_Panel,BorderLayout.CENTER);
        
        //button
        proceed_Button=new JButton("Proceed");
        proceed_Button.addActionListener(new ButtonListener() );
        proceed_Button.setForeground(Color.white);
        proceed_Button.setBackground(Color.black);
        button_Panel.add(proceed_Button);
        
        //error
        error_Label = new JLabel();
        error_Label.setForeground(Color.red);
        error_Panel.add( error_Label );
        
        panel2.add(button_Panel,BorderLayout.NORTH);
        panel2.add(error_Panel,BorderLayout.CENTER);
        
        
      
    }
    
    private  class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //get customer's card details
            String card_number = number_txt.getText();
            String card_holder = holder_txt.getText();
            String card_cvv = cvv_txt.getText();
            //validation
            if( card_number.isEmpty() ){
                error_Label.setText("Please enter your card number !");
            
            }else if( card_holder.isEmpty() ){
                error_Label.setText("Plese enter the card holder name !");
            
            }else if( card_cvv.isEmpty() ){
                error_Label.setText("Plese enter the card CVV !");
            }else if(card_number.length()<16 || card_number.length()>16){
                error_Label.setText("card number length must be 16,please try again");
            }else if(card_cvv.length()<3 || card_cvv.length()>3 ){
                error_Label.setText(" CVV length must be 3,please try again");
            }
            
            else{
              //connect to the Bill class
              Bill bill = new Bill();
              bill.setVisible( true );
              dispose();
            }
        }

        
    }
    
   

    
    
    
}
