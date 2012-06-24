/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetx;

/**
 *
 * @author mica
 */
import java.lang.reflect.Field;
import java.util.List;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame {

    static int height = 650;
    static int width = 1200;
    static boolean fullscreen = false;
    static boolean showFPS = true;
    static String title = "ProjetX";
    static int fpslimit = 60;
    public static final int MAINMENU = 0;
    public static final int GAMEPLAY = 1;
    public static final int GAMEEND = 2;
    public static final int WAIT = 3;

    public static List<String> players;
    public static List<Player> playerScores;

    
    public static boolean selectedPlayers[];


    public Game(String title) {
        super(title);
    }

    public Game() {
        super("Ascendant");
    }

    public static void main(String[] args) throws SlickException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {

        //Hack for set the library path
        System.setProperty( "java.library.path", "./slick/lib" );
        Field fieldSysPath = ClassLoader.class.getDeclaredField( "sys_paths" );
        fieldSysPath.setAccessible( true );
        fieldSysPath.set( null, null );

        AppGameContainer app = new AppGameContainer(new Game());
        app.setDisplayMode(Game.width, Game.height, Game.fullscreen);
        app.setSmoothDeltas(true);
        app.setTargetFrameRate(Game.fpslimit);
        app.setShowFPS(false);
        app.start();

    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        this.addState(new MainMenu(MAINMENU));
        this.addState(new Gameplay(GAMEPLAY));
        this.addState(new GameEnd(GAMEEND));
        this.addState(new WaitScreen(WAIT));
    }
}
