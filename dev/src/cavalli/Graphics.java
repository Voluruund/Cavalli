/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cavalli;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import javax.swing.*;

public class Graphics  implements ActionListener{
    
    //Initialize components
    private JFrame frame;       //init frame       
    private JPanel pb;          //button panel
    private JButton start;      //start button
    private JButton quit;       //quit button (ends the program)
    
    //inputGUI components
    private JFrame horseFrame;  //horse frame for the HorseGUI method
    private JPanel horsePanel;
    private JLabel alert;       //label used for input errors
    private JLabel info;        //info about the input
    private JTextField hi;      //horse input field
    private JButton confirm;    //confirm button for the horse input
    private JButton quit2;      //quit button (ends the program)
    
    public void Initialize()
    {
        //frame creation
        frame=new JFrame();                                     //frame created
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //if you close the frame, the program ends.
        frame.setVisible(true);                                 //the frame interface is visible
        frame.setTitle(" Corse clandestine di cavalli ");       //title
        frame.setBounds(600, 600, 600, 600);                    
        frame.setResizable(false);                              //the user cannot resize the frame
        
       //buttons 
       start=new JButton("Start");
       start.addActionListener(this);
       start.setFont(new Font("Tahoma", Font.BOLD, 15));
       start.setBounds(250,250,100,30);                         //set the position of the button
       
       quit=new JButton("Quit");
       quit.addActionListener(this);
       quit.setFont(new Font("Tahoma", Font.BOLD, 15));
       quit.setBounds(250,300,100,30);                         //set the position of the button
       
       //Button panel
       pb=new JPanel();
       pb.setBackground(Color.black);
       pb.setPreferredSize(new Dimension(600,600));
       pb.setLayout(null);
       
       //graphic hierarchy  
       frame.add(pb);
        pb.add(start);
        pb.add(quit);  
    }
    
    public void inputGUI()
    {
        frame.dispose();                                             //init frame disposed
        
        //frame creation
        horseFrame=new JFrame();                                     //frame created
        horseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //if you close the frame, the program ends.
        horseFrame.setVisible(true);                                 //the frame interface is visible
        horseFrame.setTitle(" Corse clandestine di cavalli ");       //title
        horseFrame.setBounds(600, 600, 600, 600);                    
        horseFrame.setResizable(false);                              //the user cannot resize the frame
        
        //button
        quit2=new JButton("Quit");
        quit2.addActionListener(this);
        quit2.setFont(new Font("Tahoma", Font.BOLD, 15));
        quit2.setBounds(250,450,100,30);                         //set the position of the button
        
        confirm=new JButton("Confirm");
        confirm.addActionListener(this);
        confirm.setFont(new Font("Tahoma", Font.BOLD, 15));
        confirm.setBounds(250,400,100,30);                         //set the position of the button
         
        //panel
        horsePanel=new JPanel();
        horsePanel.setBackground(Color.black);
        horsePanel.setPreferredSize(new Dimension(600,600));
        horsePanel.setLayout(null);
        
         //label
        info=new JLabel("Insert a number between 2 and 10 in order to create the race.");
        info.setFont(new Font("Tahoma", Font.BOLD, 15));
        info.setBounds(75,300,600,30);
        
        alert=new JLabel("");
        alert.setFont(new Font("Tahoma", Font.BOLD, 15));
        alert.setBounds(200, 250, 600, 30);
        alert.setForeground(Color.red);
        
        //text input
        hi=new JTextField();
        hi.setBounds(200,350,200,30);
        
        //graphic hierarchy  
        horseFrame.add(horsePanel);
        horsePanel.add(alert);
        horsePanel.add(info);
        horsePanel.add(hi);
        horsePanel.add(quit2);
        horsePanel.add(confirm);
    }
    
    public void horseGUI()
    {
        //setting all the object i don't need to non visible
        alert.setVisible(false);
        hi.setVisible(false);
        info.setVisible(false);
        confirm.setVisible(false);
    }
    
    public int getInput()
    {
        int appo=parseInt(hi.getText());
        if(appo<2||appo>10)
        {
            alert.setText("numero di cavalli non valido");
        }
        return appo;
    }
    
    public Graphics()
    {
       Initialize();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==quit)
        {
            frame.dispose();                //the program ends when clicking the quit button
        }
        if(e.getSource()==start)
        {
            inputGUI();                     //initialize the input frame closing the first one
        }
        if(e.getSource()==confirm)
        {
            if(getInput()>=2&&getInput()<=10)
            {  
                horseGUI();
            }
        }
        if(e.getSource()==quit2)
        {
            horseFrame.dispose();           //the program ends when clicking the quit button
        }
    }

}
