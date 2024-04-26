package eventticketssystem;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;

public class Concerts extends JFrame {
    //panels
    private JPanel ConcertLabel;
    private JPanel radioPanel;
    private JPanel datePanel;
    private JPanel combination;
    private JPanel ticketsNumPanel;
    private JPanel categoryPanel;
    private JPanel payment;
    
    //label
    private JLabel selectConcert;
    private JLabel dateLabel;
    private JLabel ticketsNum;
    private JLabel categoryLabel;
    private JLabel error_Label;
    
    //textfield
    private JTextField tickets;
    //radiobutton
    private JRadioButton concert1;
    private JRadioButton concert2;
    private JRadioButton concert3;
    //combobox
    private JComboBox dateBox;
    private JComboBox category;
    //button 
    private JButton pay;
    //window's width and hight
    private final int LABEL_WIDTH = 600;
    private final int LABEL_HEIGHT = 270;
    //date array for the date combobox
    private String [] Date = {"February 1 " ,"February 2 ", "February 15" ,"February 16"};
    //tickets type array for the category combobox
    private String [] ticketsType = {"VIP" ,"Platinum", "Silver" ,"Standard"};
    
    String name;
    String email;
    String number;
 
    public Concerts(String name,String number,String email) {
        
        this.email=email;
        this.number=number;
        this.name=name;
        //set Window
        setTitle("Concert Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(LABEL_WIDTH, LABEL_HEIGHT);
        
        //build methods 
        buildRadio();
        buildDate_category_Panel();
        buildTicketsNumPanel();
        buildPaymentPanel();
        //content pane layout
        setLayout(new BorderLayout(10,10));
        //add the panels to the content pane
        add(ConcertLabel, BorderLayout.NORTH);
        add(radioPanel, BorderLayout.WEST);
        add(combination,BorderLayout.CENTER);
        add(ticketsNumPanel,BorderLayout.EAST);
        add(payment,BorderLayout.SOUTH);
        //set the content pane background color
        getContentPane().setBackground(Color.CYAN);
       
        //to make the window at the center
        setLocationRelativeTo(null);
    }
    /**
     * The buildRadio method build the panel that contain the radio buttons
     */
    private void buildRadio() {
        //ConcertLabel panel hold the select concert label
        ConcertLabel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        selectConcert = new JLabel("Select Concerts:");
        selectConcert.setForeground(Color.WHITE);
        selectConcert.setFont(new Font("Serif", Font.BOLD, 18));
        ConcertLabel.add(selectConcert);
        ConcertLabel.setBackground(Color.CYAN);
        
        
        concert1 = new JRadioButton("Rabeh Sager");
        concert1.setMnemonic(KeyEvent.VK_R);
        concert1.setBackground(Color.CYAN);
        concert1.setFont(new Font("Serif", Font.BOLD+Font.ITALIC, 12));
        
        concert2 = new JRadioButton("Majed Al-Mohandis");
        concert2.setMnemonic(KeyEvent.VK_M);
        concert2.setBackground(Color.CYAN);
        concert2.setFont(new Font("Serif", Font.BOLD+Font.ITALIC, 12));
        
        concert3 = new JRadioButton("Abdulmajeed Abdullah");
        concert3.setMnemonic(KeyEvent.VK_A);
        concert3.setBackground(Color.CYAN);
        concert3.setFont(new Font("Serif", Font.BOLD+Font.ITALIC, 12));

        ButtonGroup group = new ButtonGroup();
        group.add(concert1);
        group.add(concert2);
        group.add(concert3);
        //radioPanel panel hold the three radio buttons 
        radioPanel=new JPanel(new GridLayout(3,1));
        radioPanel.add(concert1);
        radioPanel.add(concert2);
        radioPanel.add(concert3);
        radioPanel.setBackground(Color.CYAN);
        radioPanel.setBorder(BorderFactory.createLineBorder( Color.BLUE,2));
    }
    /**
     * The buildDate_category_Panel method build the panel that contain the date and category combobox
     */
    private void buildDate_category_Panel() {
        //datePanel panel hold the dateLabel and the dateBox combobox
        datePanel=new JPanel();
        dateLabel=new JLabel("Date: ");
        dateLabel.setForeground(Color.WHITE);
        dateLabel.setFont(new Font("Serif", Font.BOLD, 18));
        dateBox=new JComboBox(Date);
        
        
        datePanel.add(dateLabel);
        datePanel.add(dateBox);
        datePanel.setBackground(Color.CYAN);
        
        //categoryPanel panel hold the categoryLabel and the category combobox
        categoryPanel=new JPanel();
        categoryLabel=new JLabel("Category: ");
        categoryLabel.setForeground(Color.WHITE);
        categoryLabel.setFont(new Font("Serif", Font.BOLD, 18));
        category=new JComboBox(ticketsType);
        
        categoryPanel.add(categoryLabel);
        categoryPanel.add(category);
        categoryPanel.setBackground(Color.CYAN);
        
        //combination panel hold the datePanel and the categoryPanel panels
        combination=new JPanel();
        combination.add(datePanel);
        combination.add(categoryPanel);
        combination.setBackground(Color.CYAN);
        combination.setBorder(BorderFactory.createLineBorder( Color.BLUE,2));
    }
    /**
     * The buildTicketsNumPanel method build the panel that contain the ticketsNum label and the tickets textfeild
     */
    private void buildTicketsNumPanel() {
        //ticketsNumPanel panel hold the ticketsNum label and the tickets textfeild
        ticketsNumPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        ticketsNum=new JLabel("Tickets Number: ");
        ticketsNum.setForeground(Color.WHITE);
        ticketsNum.setFont(new Font("Serif", Font.BOLD, 18));
        tickets = new JTextField(5);
        
        ticketsNumPanel.add(ticketsNum);
        ticketsNumPanel.add(tickets);
        ticketsNumPanel.setBackground(Color.CYAN);
        ticketsNumPanel.setBorder(BorderFactory.createLineBorder( Color.BLUE,2));
    }
    /**
     * The buildPaymentPanel method build the panel that contain the pay button and the error_Label   
     */
    private void buildPaymentPanel() {
      //payment panel hold the pay button and the error_Label   
      payment=new JPanel();
      
      pay = new JButton("Payment");
      pay.addActionListener(new paymentListener(name,number,email) );
      error_Label=new JLabel();
      error_Label.setForeground(Color.red);
      payment.add(pay);
      payment.add(error_Label);
      payment.setBackground(Color.CYAN);
    }
    //**************************************************************************
    //ActionListener class
    private  class paymentListener implements ActionListener {
        
        String name;
         String email;
         String number;
        
        public paymentListener(String name , String number , String email) {
            this.name=name;
            this.number=number;
            this.email=email;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            //get the customer requirment 
            String selected_date = (String)dateBox.getSelectedItem();
            String selected_type = (String)category.getSelectedItem();
            String ticketNum = tickets.getText();
            String festival_1=concert1.getActionCommand();
            String festival_2=concert2.getActionCommand();
            String festival_3=concert3.getActionCommand();
            String concertName="";
            double price=0.0,total_price=0.0;
            int gate=0;
            String Stadium="";
            boolean flag = false;
            
            //VALIDATION
            if( festival_1==null && festival_2==null && festival_3==null ){
                error_Label.setText("PLEASE FILL ALL THE REQUIREMENT!");
            
            }else if(ticketNum.isEmpty()){
                 error_Label.setText("PLEASE FILL ALL THE REQUIREMENT!"); 
            }
            
            else{  
            
                if(concert1.isSelected()){
                    concertName="Rabeh Sager";
                        if(selected_type.equals("VIP")){
                           price=1000.00;
                           total_price=CalculateTotal(price,ticketNum);
                           gate=1;
                           Stadium="Super Dome";

                        }
                        else if (selected_type.equals("Platinum")){
                            price=800.00;
                            total_price=CalculateTotal(price,ticketNum);
                            gate=2;
                            Stadium="Super Dome";
                        }
                        else if (selected_type.equals("Silver")){
                            price=500.00;
                            total_price=CalculateTotal(price,ticketNum);
                            gate=3;
                            Stadium="Super Dome";
                        }
                        else if (selected_type.equals("Standard")){
                            price=300.00;
                            total_price=CalculateTotal(price,ticketNum);
                            gate=4;
                            Stadium="Super Dome";
                        }

                       try{
                          //file for the receipt
                          PrintWriter outfile = new PrintWriter("Receipt.txt");
                            outfile.println("-----------THE RECEIPT------------------ ");
                            outfile.println("---The Customer Information---");
                            outfile.println("Customer Name : "+name );
                            outfile.println("Phone Number : "+number );
                            outfile.println("Email : "+email );
                            outfile.println("-----------------------------------------");
                            outfile.println("Concert Information :");
                            outfile.println("-----------------------------------------");
                            outfile.println("\t\tTHE TAX WILL BE 10%" );
                            outfile.println("Concert Name: "+concertName );
                            outfile.println("The place : "+Stadium );
                            outfile.println("Category : "+selected_type );
                            outfile.println("Gate : "+gate );
                            outfile.println("Number of tickets : "+ticketNum );
                            outfile.println("Date : "+selected_date );
                            outfile.println("Total price: "+total_price );
                            outfile.println("\nHAVE FUN! ");
                            outfile.close();
                            flag = true;
                     }catch(FileNotFoundException x){

                       JOptionPane.showMessageDialog(null, "Error !" + x.getMessage());
                    }
                }
                if(concert2.isSelected()){
                    concertName="Majed Al-Mohandis";
                        if(selected_type.equals("VIP")){
                           price=1000.00;
                           total_price=CalculateTotal(price,ticketNum);
                           gate=1;
                           Stadium="Super Dome";

                        }
                        else if (selected_type.equals("Platinum")){
                            price=800.00;
                            total_price=CalculateTotal(price,ticketNum);
                            gate=2;
                            Stadium="Super Dome";
                        }
                        else if (selected_type.equals("Silver")){
                            price=500.00;
                            total_price=CalculateTotal(price,ticketNum);
                            gate=3;
                            Stadium="Super Dome";
                        }
                        else if (selected_type.equals("Standard")){
                            price=300.00;
                            total_price=CalculateTotal(price,ticketNum);
                            gate=4;
                            Stadium="Super Dome";
                        }

                       try{
                          PrintWriter outfile = new PrintWriter("Receipt.txt");
                            outfile.println("-----------THE RECEIPT------------------ ");
                            outfile.println("---The Customer Information---");
                            outfile.println("Customer Name : "+name );
                            outfile.println("Phone Number : "+number );
                            outfile.println("Email : "+email );
                            outfile.println("-----------------------------------------");
                            outfile.println("Concert Information :");
                            outfile.println("-----------------------------------------");
                            outfile.println("\t\tTHE TAX WILL BE 10%" );
                            outfile.println("Concert Name: "+concertName );
                            outfile.println("The place : "+Stadium );
                            outfile.println("Category : "+selected_type );
                            outfile.println("Gate : "+gate );
                            outfile.println("Number of tickets : "+ticketNum );
                            outfile.println("Date : "+selected_date );
                            outfile.println("Total price: "+total_price );
                            outfile.println("\nHAVE FUN! ");
                            outfile.close();
                            flag = true;
                     }catch(FileNotFoundException x){

                       JOptionPane.showMessageDialog(null, "Error !" + x.getMessage());
                    }
                }
                if(concert3.isSelected()){
                    concertName="Abdulmajeed Abdullah";
                        if(selected_type.equals("VIP")){
                           price=1000.00;
                           total_price=CalculateTotal(price,ticketNum);
                           gate=1;
                           Stadium="Super Dome";

                        }
                        else if (selected_type.equals("Platinum")){
                            price=800.00;
                            total_price=CalculateTotal(price,ticketNum);
                            gate=2;
                            Stadium="Super Dome";
                        }
                        else if (selected_type.equals("Silver")){
                            price=500.00;
                            total_price=CalculateTotal(price,ticketNum);
                            gate=3;
                            Stadium="Super Dome";
                        }
                        else if (selected_type.equals("Standard")){
                            price=300.00;
                            total_price=CalculateTotal(price,ticketNum);
                            gate=4;
                            Stadium="Super Dome";
                        }

                       try{
                          PrintWriter outfile = new PrintWriter("Receipt.txt");
                            outfile.println("-----------THE RECEIPT------------------ ");
                            outfile.println("---The Customer Information---");
                            outfile.println("Customer Name : "+name );
                            outfile.println("Phone Number : "+number );
                            outfile.println("Email : "+email );
                            outfile.println("-----------------------------------------");
                            outfile.println("Concert Information :");
                            outfile.println("-----------------------------------------");
                            outfile.println("\t\tTHE TAX WILL BE 10%" );
                            outfile.println("Concert Name: "+concertName );
                            outfile.println("The place : "+Stadium );
                            outfile.println("Category : "+selected_type );
                            outfile.println("Gate : "+gate );
                            outfile.println("Number of tickets : "+ticketNum );
                            outfile.println("Date : "+selected_date );
                            outfile.println("Total price: "+total_price );
                            outfile.println("\nHAVE FUN! ");
                            outfile.close();
                            flag = true;
                     }catch(FileNotFoundException x){

                       JOptionPane.showMessageDialog(null, "Error !" + x.getMessage());
                    }
                }
       }
        
        if(flag ){
        //connect to the payment class
        Payment pay = new Payment();
            pay.setVisible( true );
            dispose();
        }            
        
    }
     /**
     * The CalculateTotal method returns total price
     * @return The value in the total
     */
      public double CalculateTotal(double price,String ticketNum){
          int numberOfTickets = Integer.parseInt(ticketNum);
           double total,tax,subTotal;
           subTotal=price *numberOfTickets ;
           tax=subTotal*0.10;
           total=subTotal+tax;
           return total ;  
        } 
    }

    
    

    
    
    
}