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

    Image background;
    static double partyDuration = 20 ;
    double actualTime;
    int stateID = -1;
    
    Sound Music;
    
    List<Player> players;
    List<Obstacle> obstacles;
    List<String> ficObs;
    
    int elapsedTimeSinceLastNewFieldG;
    int elapsedTimeSinceLastNewFieldD;
    int elapsedTimeSinceLastNewFieldM;
    int randApparitionD;
    int randApparitionG;
    int randApparitionM;
    boolean newGame = true;

    Gameplay(int stateID) {
        this.stateID = stateID;
    }

    @Override
    public int getID() {
        return stateID;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        players = new ArrayList<Player>(4);
        obstacles = new ArrayList<Obstacle>();
        ficObs = new ArrayList<String>();

        initField();
        
        actualTime=1;
        background= new Image("./ressources/sprites/Fond/Fond.jpg");
        Music = new Sound("ressources/audio/musicGame.wav");
        Music.play();
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics gr) throws SlickException 
    {
        int Decalage=(int)(( 650-background.getHeight())*((partyDuration -actualTime)/(double)partyDuration));

        
        System.out.println(Decalage);
        System.out.println(actualTime);
        background.draw(0,Decalage);
        
        for (Obstacle o : obstacles) {
            o.getImage().draw((int) o.getCoords().getX(), (int) o.getCoords().getY());
        }

        for (Player o : players) {
            o.getImage().draw((int) o.getCoords().getX(), (int) o.getCoords().getY());
        }
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        if (newGame) {
            newGame = false;
            initPlayers();
        }

        manageField(delta);
        manageInput(gc, sbg, delta);
        managePhysics();
        manageDeath();
        actualTime+=(double)delta/1000.0;
        
        
        // Fin de partie
        if(actualTime>partyDuration)
        {

            sbg.enterState(0);
            actualTime=0;
            newGame = true;
//            initPlayers();
            initField();
        }

    }

    private void manageField(int elapsedTime) throws SlickException {
        Point2D coords;
        int tailleEcranY = 700;

        double deplacement = 0.2f * elapsedTime;


        for (int i = 0; i < obstacles.size(); i++) {
            Obstacle o = obstacles.get(i);
            coords = o.getCoords();
            if (coords.getY() > tailleEcranY) {
                obstacles.remove(o);
                i--;
            } else {
                coords.setLocation(coords.getX(), coords.getY() + deplacement);
                o.setCoords(coords);
            }
        }

        for (Player p : players) {
            coords = p.getCoords();
            coords.setLocation(coords.getX(), coords.getY() + deplacement);
            p.setCoords(coords);
        }

        int lower = 500;
        int higher = 2500;

        if (elapsedTimeSinceLastNewFieldG > randApparitionG) {
            Obstacle o = new Obstacle(ficObs.get((int) (Math.random() * 2)));
            obstacles.add(o);
            int randX = (int) (Math.random() * (250 + 350 - 120 + 1 - 250)) + 250;
            o.setCoords(new Point2D.Double(randX, 0));
            elapsedTimeSinceLastNewFieldG = 0;

            randApparitionG = (int) (Math.random() * (higher + 1 - lower)) + lower;

        }
        if (elapsedTimeSinceLastNewFieldD > randApparitionD) {
            Obstacle o = new Obstacle(ficObs.get((int) (Math.random() * 2)));
            obstacles.add(o);
            int randX = (int) (Math.random() * (250 + 350 - 120 + 1 - 250)) + 250;
            o.setCoords(new Point2D.Double(randX + 193, 0));
            elapsedTimeSinceLastNewFieldD = 0;

            randApparitionD = (int) (Math.random() * (higher + 1 - lower)) + lower;
        }

        if (elapsedTimeSinceLastNewFieldM > randApparitionM) {
            Obstacle o = new Obstacle(ficObs.get((int) (Math.random() * 2)));
            obstacles.add(o);
            int randX = (int) (Math.random() * (250 + 350 - 120 + 1 - 250)) + 250;
            o.setCoords(new Point2D.Double(randX + 387, 0));
            elapsedTimeSinceLastNewFieldM = 0;

            randApparitionM = (int) (Math.random() * (higher + 1 - lower)) + lower;
        }

        elapsedTimeSinceLastNewFieldD += elapsedTime;
        elapsedTimeSinceLastNewFieldG += elapsedTime;
        elapsedTimeSinceLastNewFieldM += elapsedTime;


    }

    private void manageInput(GameContainer gc, StateBasedGame sbg, int delta) {
        // Input managing du personnage 1
        Input input = gc.getInput();
        if (input.isKeyPressed(Input.KEY_Z)) {
            players.get(0).iWouldLikeToJump();
        }

        if (input.isKeyPressed(Input.KEY_D)) {
            players.get(0).iWouldLikeToGoRight();
        }

        if (input.isKeyPressed(Input.KEY_Q)) {
            players.get(0).iWouldLikeToGoLeft();
        }

        if (players.size() > 1) {
            // Input managing du personnage 2
            if (input.isKeyPressed(Input.KEY_UP)) {
                players.get(1).iWouldLikeToJump();
            }

            if (input.isKeyPressed(Input.KEY_RIGHT)) {
                players.get(1).iWouldLikeToGoRight();
            }

            if (input.isKeyPressed(Input.KEY_LEFT)) {
                players.get(1).iWouldLikeToGoLeft();
            }
        }
    }

    private void managePhysics() {
    }

    
    private void manageDeath() 
    {
        int p =players.size();
           System.out.println(p);
        for(int i=0;i<p;i++)
        {
            Point2D a=players.get(i).getCoords();
            if(a!=null)
            {
               if (a.getY()>700)
               {
                   players.get(i).Die();
               }
            }
        }
    }
    private void initField() throws SlickException {
        obstacles.clear();
        ficObs.clear();
        ficObs.add("ressources/sprites/Plateforme/plateformeNuage1.png");
        ficObs.add("ressources/sprites/Plateforme/plateformeNuage1.png");
        Obstacle platInit = new Obstacle("ressources/initPlateforme.png");
        obstacles.add(platInit);

        platInit.setCoords(new Point2D.Double(250, 200));

        /*randApparitionD=0;
        randApparitionG=0;*/
    }

    private void initPlayers() throws SlickException {
        int decalage = 0;

        players.clear();

        for (String s : Game.players) {
            Player p = new Player(s);
            p.setCoords(new Point2D.Double(300 + decalage, 200 - p.getImage().getHeight()));
            decalage += 200;
            players.add(p);
        }
    }
}
