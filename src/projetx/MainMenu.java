/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetx;

/**
 *
 * @author anisbenyoub
 */

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class MainMenu extends BasicGameState {
 
    int stateID = -1;
    
    Image img;
 
    MainMenu( int stateID ) 
    {
       this.stateID = stateID;
    }
 
    @Override
    public int getID() {
        return stateID;
    }
 
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
            img = new Image("ressources/chew.gif");
    }
 
    public void render(GameContainer gc, StateBasedGame sbg, Graphics gr) throws SlickException 
    {
        img.draw(0,0);
        
            
    }
 
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException 
    {
        Input input = gc.getInput();
        if(input.isMousePressed(0))
        {
        sbg.enterState(1);
        }
    }
 
}