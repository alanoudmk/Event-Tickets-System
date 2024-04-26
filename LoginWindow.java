//login window
package eventticketssystem;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;


public class LoginWindow extends JFrame {
    //fields
    private final int WIDTH =280;
    private final int HIGHT =440;
    private JLabel email_Label,password_Label,image_Label,error_Label,signup_Label,phoneNumber_Label;
    private JTextField email_txt ,phoneNumber_txt;
    private JPasswordField password_txt;  
    private ImageIcon image;
    private JButton Login_Button , signup_Button;
    private JPanel Login_Panel , error_Panel,signup_Panel,Panel1 ,image_Panel;
       
    //constructor
    public LoginWindow(){
        //set Window
        setTitle("Login Page");
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setSize(WIDTH,HIGHT);
        
        //build 
        buildLoginPage();
        
        //add paneles to content pane
        add( image_Panel , BorderLayout.NORTH);
        
        add( Login_Panel ,BorderLayout.CENTER);
        
        //display & pack
        setLocationRelativeTo(null); 
         
    }  
    
    
    
    //***********************************************method for building panaels
    public void buildLoginPage(){
        //crerat panels
        Login_Panel = new JPanel(); //1
        image_Panel = new JPanel();//2
        signup_Panel= new JPanel(); //4
        error_Panel = new JPanel(); //5
        Panel1= new JPanel(); //3
        Panel1.setLayout(new BorderLayout());
        
        //image
        image_Label = new JLabel();
        image = new ImageIcon( "Login.gif" );
        image_Label.setIcon( image );
        image_Label.setBorder(BorderFactory.createLineBorder( Color.black,3));//**
        
        //Login
        email_Label = new JLabel("E-mail: ");
        email_Label.setFont(new Font("Serif", Font.BOLD, 15));
        password_Label = new JLabel("Password: ");
        password_Label.setFont(new Font("Serif", Font.BOLD, 15));
        phoneNumber_Label= new JLabel("Phone Number: ");
        phoneNumber_Label.setFont(new Font("Serif", Font.BOLD, 15));
        email_txt = new JTextField(25);
        phoneNumber_txt = new JTextField(25);
        password_txt = new JPasswordField(25); 
        Login_Button = new JButton( "Login " );
        Login_Button.setFont(new Font("Serif", Font.PLAIN, 17));
        Login_Button.addActionListener( new LoginButtonListener() );
        Login_Button.setForeground(Color.white);
        Login_Button.setBackground(Color.black);
        
        //sgin up
        signup_Label = new JLabel("if you don't have account?");
        signup_Label.setFont(new Font("Serif", Font.ITALIC, 14));
        signup_Label.setForeground(Color.blue);
        signup_Button = new JButton("Sign Up");
        signup_Button.addActionListener( new SignupButtonListener() );
        signup_Button.setForeground(Color.CYAN);
        signup_Button.setBackground(Color.BLUE);
        signup_Button.setFont(new Font("Serif", Font.PLAIN, 17));
        
        //error message
        error_Label = new JLabel();
        error_Label.setFont(new Font("DialogInput", Font.ITALIC + Font.BOLD, 14));
        error_Label.setForeground(Color.red);
        error_Panel.add( error_Label );
        
        //add components to paneles
        Login_Panel.add( email_Label );
        Login_Panel.add( email_txt );
        Login_Panel.add( phoneNumber_Label );
        Login_Panel.add( phoneNumber_txt );
        Login_Panel.add( password_Label );
        Login_Panel.add( password_txt );
        signup_Panel.add( signup_Label );
        signup_Panel.add( signup_Button );
        
        Panel1.add( Login_Button , BorderLayout.NORTH );
        Panel1.add( signup_Panel , BorderLayout.CENTER );
        Panel1.add( error_Panel , BorderLayout.SOUTH );
        
        Login_Panel.add( Panel1);
        
        image_Panel.add( image_Label );
        
    }

    
    
    
    
    //******************************************************ActionListener class 
    private class LoginButtonListener implements ActionListener{
        @Override
        public void actionPerformed( ActionEvent e ){
            String customer_phoneNumber = phoneNumber_txt.getText();
            String customer_email = email_txt.getText();
            String customer_password = password_txt.getText();
            
            
            if( customer_email.isEmpty() ){
                error_Label.setText("*Please enter your E-mail*");
            
            }else if( customer_password.isEmpty() ){
                error_Label.setText("*Plese enter your password*");
            
            }else if( customer_phoneNumber.isEmpty() ){
                error_Label.setText("*Plese enter your phone number*"); 
                
            }else{
                String name_file ="";
                try{
                    File file = new File("customer.txt");
                    Scanner scan = new Scanner( file );
                    boolean flag = false;
                    
                    while( scan.hasNext() ){
                        name_file = scan.next();
                        name_file+=" ";
                        name_file+=scan.next();
                        String phoneNumber_file = scan.next();
                        
                        if( phoneNumber_file.equals( customer_phoneNumber ) ){
                            String email_file = scan.next();
                            
                            if( email_file.equals( customer_email ) ){
                                String password_file = scan.next();
                                
                                if( password_file.equals( customer_password ) ){
                                    flag = true;
                                    break;
                                }
                            }
                        }
                        scan.nextLine();
                    }
                    
                    if( flag ){
                       
                        EventsMenu homepage = new EventsMenu(name_file,customer_phoneNumber,customer_email);
                        homepage.setVisible(true);
                        dispose();

                    
                    }else{
                       error_Label.setText("*Wrong E-mail or Passworde*"); 
                       
                    }
                    
                }catch( FileNotFoundException x ){
                    JOptionPane.showMessageDialog(null, "Error !" + x.getMessage());
                    
                }        
            }
        }
    }

    private class SignupButtonListener implements ActionListener{
        @Override
        public void actionPerformed( ActionEvent e ){
            SignUpWindow signup = new SignUpWindow();
            signup.setVisible( true );
            dispose();
        }
    }
    
    
    
    
    
    
    
}
