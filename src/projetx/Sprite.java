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
public class Sprite {

    protected Image image;
    protected Point2D coords;

    public Sprite(){
        this.coords = new Point2D.Double();
    }

    public Point2D getCoords() {
        return coords;
    }

    public void setCoords(Point2D coords) {
        this.coords = coords;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    

}
