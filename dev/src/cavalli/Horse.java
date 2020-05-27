/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cavalli;

import java.util.Random;


/**
 *
 * @author aa
 */
public class Horse {
    
    private String name;
    private int code;
    Random rand;
    
    public Horse(String name, int code)
    {
        this.name=name;
        this.code=rand.nextInt(10);
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public int getCode()
    {
        return this.code;
    }
}
