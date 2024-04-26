//greeting 
package eventticketssystem;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;


public class GreetingWindow extends JFrame {
    //fields
    private final int LABEL_WIDTH = 500;
    private final int LABEL_HIGHT = 350;    
    private JLabel greeting_Label;      //text display to user
    
    private JLabel image_Label;
    private ImageIcon image;
    
    private JButton logIn_button;
    private JButton exit_button;
    
    
   
    private JPanel logIn_Panel;
    private JPanel exit_Panel;
    
    //constructor
    public GreetingWindow(){
        //set Window
        setTitle("Greeting Window");
        setLocationRelativeTo(null); 
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setSize(LABEL_WIDTH,LABEL_HIGHT);
        
        image = new ImageIcon( "systemLogo.gif" );
        
        //creat label & set size & color
      
        greeting_Label = new JLabel("Welcome To Event Tickets System", image , SwingConstants.LEFT);
        greeting_Label.setFont(new Font("SansSerif", Font.BOLD, 24));
        greeting_Label.setPreferredSize( new Dimension( LABEL_WIDTH , LABEL_HIGHT ) );
        greeting_Label.setForeground( Color.BLACK );
        greeting_Label.setBorder(BorderFactory.createLineBorder( Color.BLUE,2));
        
        
        
        //setLayout
        setLayout( new GridLayout(3,1));
        
        //method call to creat panels and add buttons in it
        buildLogInButtonPanel();
        buildExitButtonPanel();
        
        //add paneles to content pane
        //add paneles to content pane
        add( greeting_Label , BorderLayout.NORTH);
        add( logIn_Panel ,BorderLayout.CENTER);
        add( exit_Panel ,BorderLayout.SOUTH);
        
        setLocationRelativeTo(null);  
        //display 
        setVisible( true );
    }
    
    
        
//******************************************************************************
    //method for building panaels
    
    
    //*********************************
    public void buildLogInButtonPanel(){
        //creat  
        logIn_Panel = new JPanel();
        logIn_button = new JButton( "Login" );
        logIn_button.setForeground(Color.WHITE);
        logIn_button.setBackground(Color.BLUE);
        logIn_button.setFont(new Font("Serif", Font.PLAIN, 24));
        //rigster ActionListener
        logIn_button.addActionListener( new LogInButtonActionListener());
        
        //add buttons to panel
        logIn_Panel.add(logIn_button);
        logIn_Panel.setBackground(Color.CYAN);
    }
    
    //*********************************
    public void buildExitButtonPanel(){
        //creat  
        exit_Panel = new JPanel();
        exit_button = new JButton( "Exit" );
        exit_button.setForeground(Color.WHITE);
        exit_button.setBackground(Color.BLACK);
        exit_button.setFont(new Font("Serif", Font.PLAIN, 24));
        //rigster ActionListener
        exit_button.addActionListener( new ExitButtonListener() );
        
        //add buttons to panel
        exit_Panel.add(exit_button);
        exit_Panel.setBackground(Color.CYAN);
    }
    
    
        
    //**************************************************************************
    //ActionListener class
    private class ExitButtonListener implements ActionListener{
        @Override
        public void actionPerformed( ActionEvent e ){
            System.exit(0);
        }
    }
    private class LogInButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed( ActionEvent e ){
            LoginWindow login = new LoginWindow();
            login.setVisible( true );
            dispose();
        }
    }
    
//******************************************************************************
    public static void main(String[] args) {
        new GreetingWindow();
    }
    
}