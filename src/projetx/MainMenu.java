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
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenu extends BasicGameState implements ComponentListener {

    int stateID = -1;
    Image img;
    List<List<MouseOverArea>> personnages;
    MouseOverArea startButton;

    StateBasedGame sbg;

    MainMenu(int stateID) {
        this.stateID = stateID;
    }

    @Override
    public int getID() {
        return stateID;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        img = new Image("ressources/Narwhals_breach.jpg");

        Image p1 = new Image("ressources/sprites/Bagnard/BagnardStatique.png");
        Image p2 = new Image("ressources/sprites/Costard/CostardStatique.png");

        startButton = new MouseOverArea(gc, p1, 800, 550, this);

        personnages = new ArrayList<List<MouseOverArea>>(2);

        for (int i = 0; i < 2; i++) {
            List<MouseOverArea> l = new ArrayList<MouseOverArea>(2);
            l.add(new MouseOverArea(gc, p1, 300 + (p1.getWidth() + 20) * 1, 300 + (i * 90), this));
            l.add(new MouseOverArea(gc, p2, 300 + (p2.getWidth() + 20) * 2, 300 + (i * 90), this));
            personnages.add(l);
        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics gr) throws SlickException {
        img.draw(0, 0);

        for (List<MouseOverArea> l : this.personnages) {
            for (MouseOverArea m : l) {
                m.render(gc, gr);
            }
        }

        startButton.render(gc, gr);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        this.sbg = sbg;
    }

    @Override
    public void componentActivated(AbstractComponent source) { //methode de l'interface ComponentListener

        if (source == startButton) {
            sbg.enterState(1);
        } else {
            source.setFocus(true);
        }
    }
}
