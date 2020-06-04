
package cavalli;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Majid Alessio
 */

public class HorseLane extends JPanel{
    
 /**
 *constructor used to generate the lanes
 */
	public void paint(java.awt.Graphics g) {
		
                //lanes
                g.setColor(Color.black);
		g.fillRect(0, 0, 600, 600);
		
                //white lines between the lanes     (x,y,width,height)
		g.setColor(Color.white);
		g.fillRect(0, 0, 600, 10);
		g.fillRect(0, 50, 600, 10);
		g.fillRect(0, 100, 600, 10);
		g.fillRect(0, 150, 600, 10);
		g.fillRect(0, 200, 600, 10);
		g.fillRect(0, 250, 600, 10);
		g.fillRect(0, 300, 600, 10);
                g.fillRect(0, 350, 600, 10);
                g.fillRect(0, 400, 600, 10);
                g.fillRect(0, 450, 600, 10);
                g.fillRect(0, 500, 600, 10);
                
		//finish lines
		g.fillRect(560, 0, 5, 600);
		g.fillRect(570, 0, 5, 600);
		g.fillRect(580, 0, 5, 600);
                this.setSize(600, 600);         //panel size
	}
}
