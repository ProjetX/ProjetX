/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetx;

/**
 *
 * @author anisbenyoub
 */
import java.awt.geom.Point2D;
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
    
    int elapsedTimeSinceLastNewField;

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
        manageField(delta);
        manageInput(gc,sbg,delta);
        managePhysics();
    }

    private void manageField(int elapsedTime) 
    {
        Point2D coords;
        int tailleEcranY=600;
        
        int nbMiniBlocs=3;
        int nbMaxBlocs=10;
        
        int nbBlocRandom; = (int)(Math.random() * (nbMaxBlocs-nbMiniBlocs)) + nbMiniBlocs;
        
        int deplacement=10*elapsedTime;
        
        for(Obstacle o:obstacles){
            coords=o.getCoords();
            if(coords.getY()>tailleEcranY)
                obstacles.remove(o);
            else {
                coords.setLocation(coords.getX(), coords.getY()+deplacement);
                o.setCoords(coords);
            }
        }
        
        
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
