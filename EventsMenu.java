package eventticketssystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EventsMenu extends JFrame {

    
    private JLabel imageLabel;
    private final int LABEL_WIDTH = 560;
    private final int LABEL_HEIGHT = 420;
    
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu Events;
    private JMenuItem Concerts;
    private JMenuItem matches;
    private JMenuItem exitItem;
    private JMenuItem AboutUsItem;
    private JMenuItem HelpItem;
    
    String name;
    String email;
    String number;

    
    public EventsMenu(String name,String number,String email) {
        this.email=email;
        this.number=number;
        this.name=name;
        
        setTitle("Events tickets application" + " ( Welcome "+name+" )");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(LABEL_WIDTH,LABEL_HEIGHT);
        
        
        
        ImageIcon image = new ImageIcon ("events.jpg");
        imageLabel = new JLabel(image);
        
        add(imageLabel);
        builMenuBar();
        
        
       
        setLocationRelativeTo(null);
        
        
    }
    
    private void builMenuBar() {
        menuBar=new JMenuBar();
        
        buildFileMenu();
        buildEventsMenu();
        
        menuBar.add(fileMenu);

        menuBar.add(Events);
        setJMenuBar(menuBar);
    }
    
    
    private void buildFileMenu() {
       exitItem=new JMenuItem("Exit");
       exitItem.setMnemonic(KeyEvent.VK_X);
       exitItem.addActionListener(new ExitListener());
       
       AboutUsItem=new JMenuItem("About Us");
       AboutUsItem.setMnemonic(KeyEvent.VK_U);
       AboutUsItem.addActionListener(new AboutUsIListener());
       
       HelpItem=new JMenuItem("Help");
       HelpItem.setMnemonic(KeyEvent.VK_P);
       HelpItem.addActionListener(new HelpIListener());
       
       fileMenu = new JMenu("File");
       fileMenu.setMnemonic(KeyEvent.VK_F);
       fileMenu.add(exitItem);
       fileMenu.add(AboutUsItem);
       fileMenu.add(HelpItem);
       
    }
    
    private void buildEventsMenu() {
        Concerts = new JMenuItem("Concerts");
        Concerts.setMnemonic(KeyEvent.VK_C);
       Concerts.addActionListener(new ConcertsListener());

        matches = new JMenuItem("Matches");
        matches.setMnemonic(KeyEvent.VK_M);
       matches.addActionListener(new matchesListener());

        Events = new JMenu("Events");
        Events.setMnemonic(KeyEvent.VK_E);

        Events.add(Concerts);
        Events.add(matches);
       
        
    }

    private  class HelpIListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "If you want to see what events are currently available,"
                    + "\nplease click on an events in the menu and choose what you want to reserve");
        }

        
    }

    private  class AboutUsIListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           JOptionPane.showMessageDialog(null, "Our event ticket system is designed\n to make your ticket purchasing experience easy and convenient."
                   + " \nWe understand the excitement and anticipation that comes with attending events, \nwhether it's a concert, or sports match."
                   + " \nThat's why we've created a platform that allows you to\n browse and purchase tickets for a wide variety of events, all in one place.");
        }

        
    }

    
    
    private  class ExitListener implements ActionListener {

       
        @Override
        public void actionPerformed(ActionEvent e) {
           System.exit(0);
        }
    }
    
    private class ConcertsListener implements ActionListener {

        
        @Override
        public void actionPerformed(ActionEvent e) {
           Concerts concert = new Concerts(name,number,email);
           concert.setVisible(true);
           dispose();
        }
    }
    
    private  class matchesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Matches match = new Matches(name,number,email);
           match.setVisible(true);
           dispose();
        }

        
    }
    
    
    
}
