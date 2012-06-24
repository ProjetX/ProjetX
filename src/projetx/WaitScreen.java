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
    Image img;

    WaitScreen(int stateID) {
        this.stateID = stateID;
        
    }

    @Override
    public int getID() {

        return stateID;
        

    }
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        newOne = true;
        time=0;
        img = new Image("ressources/sprites/Fond/Fond2.jpg");
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics gr) throws SlickException {
       img.draw(0,0);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        if(newOne)
        {
            time=0;
            newOne=false;
        }
        time+=(double)delta/1000.0;
        if(time>=1)
        {
            sbg.enterState(2);
            newOne=true;
        }

    }
}