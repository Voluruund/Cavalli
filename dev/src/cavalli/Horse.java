
package cavalli;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Majid Alessio
 */
public class Horse extends JPanel
{
    
    private int x;          //x coordinate
    private int y;          //y coordinate
    private Image doom;
    
 /**
 *constructor method
 * @param x
 * @param y
 */
 public Horse(int x, int y) 
    {
	this.x = 0;
	this.y = y;
	Toolkit tk = Toolkit.getDefaultToolkit();

            try 
            {
                doom=ImageIO.read(getClass().getResource("../img/doom.png"));
            } 
            catch (IOException e) 
            {
                Logger.getLogger(Horse.class.getName()).log(Level.SEVERE, null, e);
            }
		MediaTracker mt = new MediaTracker(this);
		mt.addImage(doom, 1);
		try 
                {
                    mt.waitForID(1);
		} 
                catch (Exception e) 
                {
			//unreported exception
		}
    }
	
	public void setX(int x) 
        {
		this.x = x;
	}
	
	public int getX() {
		return this.x;
	}
	/**
         * method used to create the img
         * @param g 
         */
	
	public void paint(Graphics g) 
        {
		g.drawImage(doom,  x,  y, null);
	}
}
