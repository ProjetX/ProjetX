/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetx;

import java.awt.geom.Point2D;
import org.newdawn.slick.Image;

/**
 *
 * @author jonas
 */
public class Player extends Sprite{

    protected Point2D speed;

    public Point2D getSpeed() {
        return speed;
    }

    public void setSpeed(Point2D speed) {
        this.speed = speed;
    }


}
