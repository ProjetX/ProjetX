/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetx;

import java.awt.geom.Point2D;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author jonas
 */
public class Player extends Sprite {

    protected Point2D speed;
    protected Point2D AcutalPosition;
    protected boolean isOnAPlatform;
    protected boolean wantsToGoRight;
    protected boolean wantsToGoLeft;
    protected boolean wantsToJump;

    public Player(String img) throws SlickException {
        this.image = new Image(img);
    }

    public Point2D getSpeed() {
        return speed;
    }

    public void setSpeed(Point2D speed) {
        this.speed = speed;
    }

    public Point2D getActualPosition() {
        return this.AcutalPosition;
    }

    public void setActualPosition(Point2D pos) {
        this.AcutalPosition = pos;
    }

    public void iWouldLikeToJump() {
        if (isOnAPlatform) {
            wantsToJump = true;
        }
    }

    public void iWouldLikeToGoLeft() {
        wantsToGoLeft = true;
    }

    public void iWouldLikeToGoRight() {

        wantsToGoRight = true;
    }
}
