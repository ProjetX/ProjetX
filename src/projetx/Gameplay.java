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

        players = new ArrayList<Player>(4);
        obstacles = new ArrayList<Obstacle>();

        players.add(new Player());
    }
 
    public void render(GameContainer gc, StateBasedGame sbg, Graphics gr) throws SlickException {

        img.draw(0, 0);
    }
 
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        manageField();
        manageInput(gc,sbg,delta);
        managePhysics();
    }

    private void manageField() 
    {
        
    }

    private void manageInput(GameContainer gc, StateBasedGame sbg, int delta) 
    {
        // Input managing du personnage 1
        Input input = gc.getInput();
        if(input.isKeyPressed(Input.KEY_Z))
        {
            players.get(0).iWouldLikeToJump();
        }
        
        if(input.isKeyPressed(Input.KEY_Q))
        {
            players.get(0).iWouldLikeToGoRight();
        }
                
        if(input.isKeyPressed(Input.KEY_D))
        {
            players.get(0).iWouldLikeToGoLeft();
        }
        
        if(players.size()>1)
        {
            // Input managing du personnage 2
            if(input.isKeyPressed(Input.KEY_UP))
            {
                players.get(1).iWouldLikeToJump();
            }

            if(input.isKeyPressed(Input.KEY_LEFT))
            {
                players.get(1).iWouldLikeToGoRight();
            }

            if(input.isKeyPressed(Input.KEY_RIGHT))
            {
                players.get(1).iWouldLikeToGoLeft();
            }
        }
    }

    private void managePhysics() {
    }

    private void initField(){
        
    }

    private void initPlayers(){
        
    }

}
