/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetx;

/**
 *
 * @author mica
 */
import org.newdawn.slick.*;
import projetx.Gameplay;
import projetx.MainMenu;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.BasicGameState;
public class Game extends BasicGame
{
     static int height = 480;
     static int width = 640;

     static boolean fullscreen = false;

     static boolean showFPS = true;

     static String title = "ProjetX";

     static int fpslimit = 60;
     
     
    public static final int MAINMENU          = 0;
    public static final int GAMEPLAY          = 1;
    public static final int END          = 1;

     public Game(String title)
     {
          super(title);
     }

     public void init(GameContainer gc) throws SlickException
     {
        this.addState(new MainMenu(MAINMENU));
        this.addState(new Gameplay(GAMEPLAY));
        this.addState(new Gameplay(END));
     }

     public void update(GameContainer gc, int delta) throws SlickException
     {

     }

     public void render(GameContainer gc, Graphics g) throws SlickException
     {

     }

     public  void addState(BasicGameState  aState) throws SlickException
     {
         
     }
     
}