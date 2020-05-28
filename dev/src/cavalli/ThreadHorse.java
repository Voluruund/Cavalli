/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cavalli;

import java.util.Random;

public class ThreadHorse implements Runnable{
    
    Horse h;
    int pos;
    Random rand;
    int appo;
    
    public ThreadHorse(Horse h)
    {
       this.h=h;
    }
    
    @Override
    public void run()
    {
        int imgDimension= 40;
        int raceDimension= 500;
        while((h.getX()+imgDimension)<raceDimension)
        {
          appo= rand.nextInt(10);
          h.setX(h.getX()+appo);
          try
          {Thread.sleep(100);}
          catch(Exception e){}
        }
    }
    
    
}
