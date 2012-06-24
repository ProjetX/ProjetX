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
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenu extends BasicGameState implements ComponentListener {

    int stateID = -1;
    Image img;
    List<List<CustomMouseOverArea>> personnages;
    MouseOverArea startButton;
    StateBasedGame sbg;
    List<String> playersSelected = new ArrayList<String>();
    boolean players[] = new boolean[4];
    Image controlesJoueur1;
    Image controlesJoueur2;
    Image controlesJoueur3;
    Image controlesJoueur4;
   

    MainMenu(int stateID) {
        this.stateID = stateID;
    }

    @Override
    public int getID() {
        return stateID;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        img = new Image("ressources/sprites/Title/EcranTitre/EcranTitre.png");
        
        for(int i=0;i<4;i++) {
            players[i]=false;
        }

        Image p1 = new Image("ressources/sprites/Bagnard/BagnardStatique.png");
        Image p2 = new Image("ressources/sprites/Costard/CostardStatique.png");
        Image start = new Image("ressources/sprites/Title/EcranTitre/Go.png");
        
        controlesJoueur1 = new Image("ressources/sprites/Title/EcranTitre/Player1.png");
        controlesJoueur2 = new Image("ressources/sprites/Title/EcranTitre/Player2.png");
        controlesJoueur3 = new Image("ressources/sprites/Title/EcranTitre/Player3.png");
        controlesJoueur4 = new Image("ressources/sprites/Title/EcranTitre/Player4.png");

        startButton = new MouseOverArea(gc, start, 925, 500, this);

        personnages = new ArrayList<List<CustomMouseOverArea>>(2);

        /*
        for (int i = 0; i < 4; i++) {
            List<CustomMouseOverArea> l = new ArrayList<CustomMouseOverArea>(2);
            l.add(new CustomMouseOverArea(gc, p1, 500 + (p1.getWidth() + 20) * 1, 175 + (i * 125), this));
            l.add(new CustomMouseOverArea(gc, p2, 500 + (p2.getWidth() + 20) * 2, 175 + (i * 125), this));
            personnages.add(l);
        }*/
                
 
            List<CustomMouseOverArea> p1l = new ArrayList<CustomMouseOverArea>(2);
            p1l.add(new CustomMouseOverArea(gc, p1, 10 + (p1.getWidth() + 20) * 1, 300, this));
            p1l.add(new CustomMouseOverArea(gc, p2, 10 + (p2.getWidth() + 20) * 2, 300, this));
            personnages.add(p1l);
            
            List<CustomMouseOverArea> p2l = new ArrayList<CustomMouseOverArea>(2);
            p2l.add(new CustomMouseOverArea(gc, p1, 430 + (p1.getWidth() + 20) * 1, 300, this));
            p2l.add(new CustomMouseOverArea(gc, p2, 430 + (p2.getWidth() + 20) * 2, 300, this));
            personnages.add(p2l);
            
            
            List<CustomMouseOverArea> p3l = new ArrayList<CustomMouseOverArea>(2);
            p3l.add(new CustomMouseOverArea(gc, p1, 10 + (p1.getWidth() + 20) * 1, 500, this));
            p3l.add(new CustomMouseOverArea(gc, p2, 10 + (p2.getWidth() + 20) * 2, 500, this));
            personnages.add(p3l);
            
            List<CustomMouseOverArea> p4l = new ArrayList<CustomMouseOverArea>(2);
            p4l.add(new CustomMouseOverArea(gc, p1, 430 + (p1.getWidth() + 20) * 1, 500, this));
            p4l.add(new CustomMouseOverArea(gc, p2, 430 + (p2.getWidth() + 20) * 2, 500, this));
            personnages.add(p4l);

        
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics gr) throws SlickException {
        img.draw(0, 0);

        gr.setColor(Color.white);
        boolean oneSelected = false;

        for (List<CustomMouseOverArea> l : this.personnages) {
            for (CustomMouseOverArea m : l) {
                m.render(gc, gr);
                if (m.isSelected()) {
                    m.setNormalColor(Color.yellow);
                    m.setMouseOverColor(Color.yellow);
                    m.setMouseOverColor(Color.yellow);

                    oneSelected = true;
                } else {
                    m.setNormalColor(Color.white);
                    m.setMouseOverColor(Color.white);
                    m.setMouseOverColor(Color.white);
                }
            }
        }

        if (oneSelected) {
            startButton.render(gc, gr);
        }
        controlesJoueur1.draw(230, 275);
        controlesJoueur2.draw(650, 275);
        controlesJoueur3.draw(230, 275+200);
        controlesJoueur4.draw(650, 275+200);
        
        
        gr.drawString("#1",40,350);
        gr.drawString("#2",460,350);
        gr.drawString("#3",40,550);
        gr.drawString("#4",460,550);

    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        this.sbg = sbg;
    }

    @Override
    public void componentActivated(AbstractComponent source) { //methode de l'interface ComponentListener

        if (source == startButton) {
            List<String> p = new ArrayList<String>();
            int j=0;
            for (List<CustomMouseOverArea> l : this.personnages) {
                for (int i = 0; i < l.size(); i++) {
                    if (l.get(i).isSelected()) {
                        p.add(l.get(i).getPerso());
                        players[(int)Math.floor(j/2)]=true;
                    }
                    j++;
                }
            }
            Game.players = p;
            Game.selectedPlayers = players;

            sbg.enterState(1);
        } else {
            if (((CustomMouseOverArea) source).isSelected()) {
                ((CustomMouseOverArea) source).setSelected(false);
            } else {
                ((CustomMouseOverArea) source).setSelected(true);
                for (List<CustomMouseOverArea> l : this.personnages) {
                    boolean thisLine = false;
                    for (CustomMouseOverArea m : l) {
                        if (m == source) {
                            thisLine = true;
                            break;
                        }
                    }
                    if (thisLine) {
                        for (CustomMouseOverArea m : l) {
                            if (m != source) {
                                ((CustomMouseOverArea) m).setSelected(false);
                            }
                        }
                        break;
                    }

                }
            }
        }
    }
}

class CustomMouseOverArea extends MouseOverArea {

    private String perso;
    private boolean selected = false;

    public CustomMouseOverArea(GUIContext container, Image image, int x, int y, ComponentListener listener) {
        super(container, image, x, y, listener);

        perso = image.getResourceReference();
    }

    public String getPerso() {
        return perso;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
