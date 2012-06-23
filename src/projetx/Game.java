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
public class Game extends StateBasedGame
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

    public Game()
    {
        super("SlickBlocks");
    }
 
    public static void main(String[] args) throws SlickException
    {
          AppGameContainer app = new AppGameContainer(new Game());
          app.setDisplayMode(Game.width, Game.height, Game.fullscreen);
          app.setSmoothDeltas(true);
          app.setTargetFrameRate( Game.fpslimit);
          app.setShowFPS( Game.showFPS);
          app.start();
    }
 
    
    
    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        this.addState(new MainMenu(MAINMENU));
        this.addState(new Gameplay(GAMEPLAY));
    }
     
}