package projetx;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import org.newdawn.slick.Image;


/**
 *
 * @author mica
 */

public class Physics {
    private int gravity;
    ArrayList<Player> movables;
    ArrayList<Sprite> platforms;

    public int getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    Physics(int _gravity){
        gravity = _gravity;
    }

    public void updateMovable(ArrayList<Player> _players){
        movables = _players;
    }

    public void updatePlatforms(ArrayList<Sprite> _platforms){
        platforms = _platforms;
    }
/*
    public void computePhysics(double TimeSinceLastFrame){

        boolean canFall = true;
        Point2D nextPoint;


       for(Player movable : movables){

        //
        nextPoint = movable.Position + movable.vitesse * TimeSinceLastFrame;

        //On teste si le movable peut tomber
        for(Sprite plateform: platforms){
            
        }
        for(Object movable : movables){

        }
       }
    }

    private boolean IsColliding(){
        boolean isColliding = false;

        //nextPoint
            //if( plateform.getCoords().getX() < nextPoint.x)

        return isColliding;
    }

*/

}
