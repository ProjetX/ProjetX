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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameEnd extends BasicGameState {

    int stateID = -1;
    boolean newEnding;

    GameEnd(int stateID) {
        this.stateID = stateID;
    }

    @Override
    public int getID() {
        newEnding = true;
        return stateID;

    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics gr) throws SlickException {

        showInformation(gr);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
    }

    private void showInformation(Graphics gr) {
        int step = 120;
        int p = Game.playerScores.size();

        Collections.sort(Game.playerScores);

        gr.drawString("General ranking", 500, 50);
        
        for (int i = 0; i < p; i++) {
            Player a = Game.playerScores.get(i);
            if (a != null) {
                gr.drawString("Player " + (i + 1), 20 + 500, 80 + 20 + i * step);
                a.getImage().draw(20 + 500, 80 + 40 + i * step);
                gr.drawString("Deaths :" + a.getNumberOfDeaths(), 80 + 500, 80 + 50 + i * step);
                gr.drawString("Kills :" + a.getNumberOfKills(), 80 + 500, 80 + 70 + i * step);

            }


        }

    }
}
