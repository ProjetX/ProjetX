/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetx;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author jonas
 */
public class Obstacle extends Sprite {

    public Obstacle(String img) throws SlickException {
        super();

        this.image = new Image(img);
    }

    public Obstacle() throws SlickException {
        super();

        this.image = new Image("ressources/initPlateforme.png");
    }
}
