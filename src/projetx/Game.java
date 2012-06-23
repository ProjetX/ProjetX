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

public class Game extends BasicGame
{
     static int height = 480;
     static int width = 640;

     static boolean fullscreen = false;

     static boolean showFPS = true;

     static String title = "Slick Basic Game Template";

     static int fpslimit = 60;

     Image img;

     public Game(String title)
     {
          super(title);
     }

     public void init(GameContainer gc) throws SlickException
     {
        img = new Image("ressources/index.jpeg");
     }

     public void update(GameContainer gc, int delta) throws SlickException
     {
        
     }

     public void render(GameContainer gc, Graphics g) throws SlickException
     {
        img.draw(-200, 0);

     }

    
}