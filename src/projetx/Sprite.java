/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetx;

import java.awt.geom.Point2D;
import java.util.Map;
import java.util.TreeMap;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author jonas
 */
public class Sprite {

    private static Map<String, Image> sprites = new TreeMap<String, Image>();

    protected Image image;
    protected Point2D coords= new Point2D.Double();

    public Sprite(String img) throws SlickException {
        if(sprites.containsKey(img)){
            this.image = sprites.get(img);
        } else {
            this.image = new Image(img);
            sprites.put(img, this.image);
        }
    }

    public Sprite(){
        
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
