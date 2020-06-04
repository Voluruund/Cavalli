/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cavalli;

import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


/**
 *
 * @author aa
 */
public class Horse extends JPanel{
    
    private int x;          //x coordinate
    private int y;          //y coordinate
    private ImageIcon doom;
    
    public Horse(int x, int y)
    {
        super();
        this.x=x;
        this.y=y;
        setSize(40,40);
        doom= new ImageIcon(getClass().getResource("doom.png"));
        setVisible(true);     
    }
    
    public int getX()
    {
        return this.x;
    }
    
    public int getY()
    {
        return this.y;
    }
    
    public void setX(int x)
    {
        this.x=x;
    }
    
    public void setY(int y)
    {
        this.y=y;
    }
}
