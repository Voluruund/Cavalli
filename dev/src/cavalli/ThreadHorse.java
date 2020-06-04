/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cavalli;

import java.util.Random;

/**
 *
 * @author Majid Alessio
 */
public class ThreadHorse implements Runnable{
    
  private Horse h;
  private RaceFrame lane;
  private int speed;
  private Thread t;
  private int count;
  int pos;
	/**
         * constructor
         * @param h
         * @param g 
         */
	public ThreadHorse(Horse h, RaceFrame g) 
        {
	this.h=h;
	lane=g;
	count=0;
        speed=2;
        t = new Thread(this);
        t.start();
	pos=0;
	}
	
        /**
         * run method used to move the img randomly
         */
	@Override
	public void run() 
        {
		int imglenght=60;
		int lanelenght=600;
		while((h.getX()+imglenght)<lanelenght) 
                {
			if ((count%10)==0)
				speed=(int)(Math.random()*4+1);
		h.setX(h.getX()+speed);
		count++;
		try {Thread.sleep(100);}
		catch (Exception e) {}
		lane.repaint();
		}
		pos=lane.getPos();
		lane.check();
	}
	
}
