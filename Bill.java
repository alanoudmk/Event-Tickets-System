package eventticketssystem;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class Bill extends  JFrame {
    
    private JPanel receipt_panel;
    private JPanel bill_details;
    private JPanel done_panel;
    
    private JLabel receipt;
    
    //private JTextField bill_txt;
    private JTextArea bill_txt;
    
    private JButton Done;
    
    private final int LABEL_WIDTH = 500;
    private final int LABEL_HEIGHT = 500;
    
    //constructor
    public Bill()  {
        

        
        setTitle("Receipt Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        setSize(LABEL_WIDTH, LABEL_HEIGHT);
        
        buildReceiptPage();
        
        add(receipt_panel,BorderLayout.NORTH);
        add(bill_details,BorderLayout.CENTER);
        add(done_panel,BorderLayout.SOUTH);
        
        setLocationRelativeTo(null);  
        
        
    }
    
    private void buildReceiptPage()  {
        
        
        //panels
        receipt_panel=new JPanel();
        bill_details=new JPanel();
        done_panel=new JPanel();
        
       receipt=new JLabel("Receipt") ; 
       receipt.setFont(new Font("Serif", Font.BOLD, 24));
       
       
       bill_txt = new JTextArea(100, 50);
       bill_txt.setEditable(false);
       try{
           //create file object that represent a file named Receipt 
           File file = new File("Receipt.txt");
           //create fileReader object used to read characters from specified file
           //it eastablishes a connection between the java program and the file 
           FileReader reader = new FileReader(file);
           //wraps around the fileReader object. it provides buffering functionality
           //allowing more efficient reading of characters from the file
           BufferedReader br = new BufferedReader(reader);
           //pass br as source from which to read the file's content
           bill_txt.read(br, null);
           br.close();
           
           //bill_txt.requestFocus();
            
       }catch(Exception x){
            JOptionPane.showMessageDialog(null, "Error !" + x.getMessage());
       }
       
       Done=new JButton("Done");
       Done.addActionListener(new ButtonListener() );
       
       receipt_panel.add(receipt);
       bill_details.add(bill_txt);
       done_panel.add(Done);
       
        
    }
    private  class ButtonListener implements ActionListener {

        
        @Override
        public void actionPerformed(ActionEvent e) {
           System.exit(0);
        }
    }
  
}
