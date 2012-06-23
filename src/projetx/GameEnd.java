/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetx;

/**
 *
 * @author anisbenyoub
 */
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameEnd extends BasicGameState  {

    int stateID = -1;
    boolean newEnding;
    GameEnd(int stateID) {
        this.stateID = stateID;
    }

    @Override
    public int getID() {
        newEnding=true;
        return stateID;
        
    }
    
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException 
    {

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics gr) throws SlickException 
    {
        if(newEnding)
        {
            newEnding=false;
        }


    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {


    }
}
