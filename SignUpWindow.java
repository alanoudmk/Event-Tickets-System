//Sign up window
package eventticketssystem;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class SignUpWindow extends JFrame{
    //fields
    private final int WIDTH =320;
    private final int HIGHT =590;
    private JLabel name_Label,email_Label,password_Label,confirmPassword_Label,
                   image_Label,error_Label,city_Label,phoneNumber_Label ;
    private JTextField name_txt,email_txt, phoneNumber_txt;
    private JPasswordField password_txt, confirmPassword_txt;
    private JComboBox city_comboBox;
    private String[] cities = new String[]{"Jeddah" , "Mecca" , "Riyadh", 
                                            "Taif", "Abha"};
    private ImageIcon image;
    private JButton reset_Button , signup_Button; 
    private JPanel image_Panel, signup_Panel ,Button_Panel ,error_Panel,Panel1;
    //constructor
    public SignUpWindow(){
        //set Window
        setTitle("SignUp");
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setSize(WIDTH,HIGHT);
        
        //build 
        buildSignupPage();
        
        //add paneles to content pane
        add( image_Panel , BorderLayout.NORTH);
        add( signup_Panel ,BorderLayout.CENTER);
        add( Panel1 ,BorderLayout.SOUTH);
        
        //pack
        setLocationRelativeTo(null);  
    }
    
    
    
    //***********************************************method for building panaels
    public void buildSignupPage(){
        //crerat panels
        signup_Panel = new JPanel();
        image_Panel = new JPanel();
        Button_Panel = new JPanel();
        error_Panel = new JPanel();
        Panel1 = new JPanel();
        Panel1.setLayout( new BorderLayout() );
        
        //image
        image = new ImageIcon( "signup.gif" );
        image_Label = new JLabel();
        image_Label.setIcon( image );
        image_Label.setBorder(BorderFactory.createLineBorder( Color.black,3));
        
        //creat components
        name_Label = new JLabel("Full Name: ");
        name_Label.setFont(new Font("Serif", Font.BOLD, 15));
        phoneNumber_Label = new JLabel("Phone Number: ");
        phoneNumber_Label.setFont(new Font("Serif", Font.BOLD, 15));
        email_Label = new JLabel("E-Mail: ");
        email_Label.setFont(new Font("Serif", Font.BOLD, 15));
        password_Label = new JLabel("Password: ");
        password_Label.setFont(new Font("Serif", Font.BOLD, 15));
        confirmPassword_Label = new JLabel("Confirm Password: ");
        confirmPassword_Label.setFont(new Font("Serif",Font.BOLD , 15));
        city_Label = new JLabel("Choose City: ");
        city_Label.setFont(new Font("Serif", Font.BOLD, 15));
                
        name_txt = new JTextField(25);
        phoneNumber_txt = new JTextField(25);
        email_txt = new JTextField(25);
        password_txt = new JPasswordField(25); 
        confirmPassword_txt = new JPasswordField(25);
        
        //cobo box
        city_comboBox = new JComboBox( cities );
        
        //error message
        error_Label = new JLabel("*");
        error_Label.setForeground(Color.red);
        error_Label.setFont(new Font("DialogInput", Font.ITALIC + Font.BOLD, 14));
        
        //sign up Button
        signup_Button=new JButton("SignUp");
        signup_Button.setForeground(Color.WHITE);
        signup_Button.setBackground(Color.BLACK);
        signup_Button.setFont(new Font("Serif", Font.PLAIN, 17));
        signup_Button.addActionListener(new SignupButtonListener() );
        
        //reset Button
        reset_Button=new JButton("Reset");
        reset_Button.setForeground(Color.WHITE);
        reset_Button.setBackground(Color.MAGENTA);
        reset_Button.setFont(new Font("Serif", Font.PLAIN, 17));
        reset_Button.addActionListener(new ResetButtonListener() );
        
        //add to panels
        signup_Panel.add( name_Label );
        signup_Panel.add( name_txt );
        signup_Panel.add( phoneNumber_Label );
        signup_Panel.add( phoneNumber_txt );
        signup_Panel.add( email_Label );
        signup_Panel.add( email_txt );   
        signup_Panel.add( password_Label ); 
        signup_Panel.add( password_txt ); 
        signup_Panel.add( confirmPassword_Label ); 
        signup_Panel.add( confirmPassword_txt );
        signup_Panel.add( city_Label );
        signup_Panel.add( city_comboBox );
        
        Button_Panel.add( signup_Button );
        Button_Panel.add( reset_Button );
        
        error_Panel.add( error_Label);
        
        Panel1.add( Button_Panel , BorderLayout.NORTH );
        Panel1.add( error_Panel , BorderLayout.CENTER );
        
        image_Panel.add( image_Label );//1
    }
    
    
    
    
    //******************************************************ActionListener class 
    private class SignupButtonListener implements ActionListener{
        @Override
        public void actionPerformed( ActionEvent e ){
            String customer_name = name_txt.getText();
            String customer_phoneNumber = phoneNumber_txt.getText();
            String customer_email = email_txt.getText();
            String customer_password = password_txt.getText();
            String customer_confirmPassword = confirmPassword_txt.getText();
            String customer_city = (String) city_comboBox.getSelectedItem();
            
            //check 
            if( customer_name.isEmpty() ){
                error_Label.setText("* Please enter your name *");
                
            }else if( customer_phoneNumber.isEmpty() ){
                error_Label.setText("* Please enter your phone number *");
            
            }else if( customer_email.isEmpty() ){
                error_Label.setText("* Please enter your E-mail *");
            
            }else if( customer_password.isEmpty() ){
                error_Label.setText("* Please enter your password *");
            
            }else if( customer_confirmPassword.isEmpty() ){
                error_Label.setText("* Please confirm your password *");
            
            }else if( ! customer_password.equals( customer_confirmPassword ) ){
                error_Label.setText("* password doesn't match the confirmed password *");
            
            }else if( customer_password.length() < 8 ){
                error_Label.setText( "Password must be at least 8 charachtes !");
                
            }else{
                try{
                    File file = new File("customer.txt");
                    Scanner scan = new Scanner( file );
                    ArrayList<String> emails = new ArrayList<>();
                    ArrayList<String> phoneNumbers = new ArrayList<>();
                    
                    while( scan.hasNext() ){
                       scan.next();
                       String phoneNumber = scan.next();
                       phoneNumbers.add( phoneNumber );
                       
                       scan.next();
                       String email = scan.next();
                       emails.add(email);
                       
                       scan.nextLine();
                    }
                    scan.close();
                    
                    if( emails.contains( customer_email ) ){
                        error_Label.setText("* this email is alredy registered *");
                    
                    }else if( phoneNumbers.contains( customer_phoneNumber ) ){
                        error_Label.setText("* this phone number is alredy registered *"); 
                        
                    }else{
                        FileWriter file_writer = new FileWriter("customer.txt", true);
                        PrintWriter write = new PrintWriter( file_writer );
                        write.println(customer_name + " " + customer_phoneNumber + " " 
                                + customer_email + " " + customer_password + " " 
                                + customer_city );
                        
                        write.close();
                        LoginWindow login = new LoginWindow();
                        login.setVisible(true);
                        dispose();
                    }
                    
                }catch( IOException x ){
                    JOptionPane.showMessageDialog(null, "Error !" + x.getMessage());
                }
            } 
        }
    }
    
    
    private class ResetButtonListener implements ActionListener{
        @Override
        public void actionPerformed( ActionEvent e ){
            name_txt.setText("");
            phoneNumber_txt.setText("");
            email_txt.setText("");
            password_txt.setText("");
            confirmPassword_txt.setText("");
            city_comboBox.setSelectedIndex(0); 
        }
    }
    
    
    
    //**********************************************************************main 
    
    
}
