package projetx;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import org.newdawn.slick.Image;


/**
 *
 * @author mica
 */
public class Object{
    public int width;
    public int height;
    public Point2D Position;
    public Point2D vitesse;
}

public class Physics implements Runnable{
    private int gravity;
    ArrayList<Object> movables;
    ArrayList<Object> platforms;

    public int getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    Physics(int _gravity){
        gravity = _gravity;
    }

    public updateMovable(ArrayList<Object> _players){
        players = _players;
    }

    public updatePlatforms(ArrayList<Object> _platforms){
        platforms = _platforms;
    }

    public computePhysics(double TimeSinceLastFrame){

        boolean canFall = true;
        Point2D nextPoint = 0;


       for(Object movable : players){

        //
        nextPoint = movable.Position + movable.vitesse * TimeSinceLastFrame;

        //On teste si le movable peut tomber
        for(Object plateform: _platforms){
            //nextPoint
        }
        for(Object movable : movables){

        }
       }
    }



}
