/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cavalli;

import java.awt.*;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

/**
 *
 * @author Majid Alessio
 */
public class RaceFrame extends JFrame{
    
       private int pos;
       private Horse[] h;          //horse array
       private ThreadHorse[] threads;      //thread array
       private HorseLane lane;         //lane JPanel
       private Graphics gr;
       private Image bf;
       private int n=0;        //number of horses to generate
 /**
 *constructor method
 */   
    public RaceFrame(Graphic g) 
    {
	n=g.getInput();         
	setSize(600, 600);
	setLocation(10, 30);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	lane = new HorseLane();
	h = new Horse[n];
	threads = new ThreadHorse[n];
	pos = 1;
	int start = 15;                 //starting X coordinate
	for (int x=0; x<n; x++) 
        {
            h[x] = new Horse(start,  x*50);         //lanes have 50 Y distance between them that's why i need to *50
            threads[x] = new ThreadHorse(h[x], this);
            start = start+50;		//moving the starting point and repainting the img moves all over the lane	
	}
	//lanes are now visible
	this.add(lane);
	setVisible(true);
        this.setSize(600, 550);
    }
    
 /**
 *synchronized method to get the position of the Horses
 */
    public synchronized int getPos()
    {
	return pos++;
    }
    
 /**
 *synchronized method to check the position of the horses
 */
    public synchronized void check() 
    {
	boolean arrived=true;
	for (int x=0; x<n; x++) 
        {
            if (threads[x].pos==0) 
            {
              arrived=false;            //if the position is = to 0 the horse is not arrived yet
            }
	}
	if(arrived) 
        {
            ranking();
	}
    }
  
 /**
 *method used to print the ranking of the race
 */
    public void ranking() 
    {
	JLabel[] arrivals;
	arrivals = new JLabel[n];
	JFrame ranking = new JFrame("Horse Ranking");
	ranking.setSize(600, 600);
	ranking.setDefaultCloseOperation(EXIT_ON_CLOSE);
	ranking.getContentPane().setLayout(new GridLayout(5,1 ));
        ranking.getContentPane().setBackground(Color.black);
	for(int x=0; x<11; x++) 
        {
            for (int y=0; y<n; y++) 
            {
		if (threads[y].pos==x)
                {
                    arrivals[y]=new JLabel(x+"' ranked " + (y+1)+"' lane");
                    arrivals[y].setFont(new Font("Tahoma", Font.BOLD, 15));
                    arrivals[y].setForeground(Color.white);
                    ranking.getContentPane().add(arrivals[y]);
		}
            }
	}
	ranking.setVisible(true);
    }
    
 /**
 *paint method
 */
    public void update(Graphics g) 
    {
        paint(g);
    }
    
 /**
 *method used to paint the horses
 */
    public void paint(Graphics g) 
    {
	if (h != null) 
        {
	Graphics2D screen = (Graphics2D) g;
	bf= createImage(600, 600);
	gr = bf.getGraphics();
	Dimension d=getSize();
	lane.paint(gr);
	for (int x=0; x<n; x++) 
        {
            h[x].paint(gr);
        }
	screen.drawImage(bf, 0, 30, this);
	gr.dispose();
	}
    }
}
