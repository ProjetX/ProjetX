/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetx;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author anisbenyoub
 */
public class WaitScreen extends BasicGameState {

    int stateID = -1;
    StateBasedGame sbg;
    double time;
    boolean newOne;

    WaitScreen(int stateID) {
        this.stateID = stateID;
        time=0;
    }

    @Override
    public int getID() {
        newOne = true;
        return stateID;

    }
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        time=0;
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics gr) throws SlickException {
       
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        if(newOne)
        {
            time=0;
            newOne=false;
        }
        time+=(double)delta;
        if(time>=3000)
        {
            sbg.enterState(3);
            newOne=true;
        }

    }
}