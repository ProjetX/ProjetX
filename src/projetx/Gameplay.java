/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetx;

/**
 *
 * @author anisbenyoub
 */
import java.util.List;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
 
public class Gameplay extends BasicGameState {
 
    int stateID = -1;

    Image img;

    List<Player> players;

    List<Obstacle> obstacles;

    Gameplay( int stateID ) 
    {
       this.stateID = stateID;
    }
 
    @Override
    public int getID() {
        return stateID;
    }
 
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

        img = new Image("ressources/index.jpeg");
    }
 
    public void render(GameContainer gc, StateBasedGame sbg, Graphics gr) throws SlickException {

        img.draw(0, 0);
    }
 
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        manageField();
        manageInput();
        managePhysics();
    }

    private void manageField() {
    }

    private void manageInput() {
    }

    private void managePhysics() {
    }
 
}
