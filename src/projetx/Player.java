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

    protected double speed;
    protected Point2D AcutalPosition;
    protected boolean isOnAPlatform;
    protected boolean wantsToGoRight;

    protected boolean wantsToGoLeft;
    protected boolean wantsToJump;

    public void setWantsToJump(boolean wantsToJump) {
        this.wantsToJump = wantsToJump;
    }

    protected double lateralSpeed = 10;
    protected double verticalSpeed = 30;

    public double getVerticalSpeed() {
        return verticalSpeed;
    }

    public void setVerticalSpeed(double verticalSpeed) {
        this.verticalSpeed = verticalSpeed;
    }

    public Player(String img) throws SlickException {
        super(img);
        this.image = new Image(img);
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
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

    public boolean isOnAPlatform() {
        return isOnAPlatform;
    }

    public boolean isWantsToGoLeft() {
        return wantsToGoLeft;
    }

    public boolean isWantsToGoRight() {
        return wantsToGoRight;
    }

    public boolean isWantsToJump() {
        return wantsToJump;
    }

    public void setIsOnAPlatform(boolean isOnAPlatform) {
        this.isOnAPlatform = isOnAPlatform;
    }

    public double getLateralSpeed() {
        return lateralSpeed;
    }

    public void setLateralSpeed(double lateralSpeed) {
        this.lateralSpeed = lateralSpeed;
    }
    
    public void iWouldLikeToGoLeft() {
        wantsToGoLeft = true;
    }

    public void iWouldLikeToGoRight() {

        wantsToGoRight = true;
    }
}
