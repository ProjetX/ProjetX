package projetx;

import java.awt.Point;
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

    public void computePhysics(double TimeSinceLastFrame){

        boolean canMove = true;
        Point2D nextPoint;
        Point2D oldPoint;
        Sprite plateform;
        Player otherMovable;


       for(Player currentMovable : movables){
         oldPoint = currentMovable.getCoords();

        nextPoint = scalarCross(addVectors(currentMovable.getCoords(), currentMovable.getSpeed()), TimeSinceLastFrame);
        currentMovable.setCoords(nextPoint);
         
        //On teste si le movable collide dans sa prochaine position
        for(int i = 0; i < platforms.size() && canMove == true; i++){
            plateform = platforms.get(i);
            canMove = !IsColliding(currentMovable, plateform);
        }
        for(int i = 0; i < movables.size() && canMove == true; i++){
            otherMovable = movables.get(i);
            if(otherMovable != currentMovable){
                canMove = !IsColliding(currentMovable, otherMovable);
            }
        }

        //Si on ne peut pas bouger
        if(canMove == false){
            currentMovable.setCoords(oldPoint);
        }
       }
    }

    private boolean IsColliding(Sprite obj1, Sprite obj2){
        boolean isColliding = false;

        //nextPoint
        if( (obj1.getCoords().getX() + obj1.getImage().getWidth() > obj2.getCoords().getX() && obj1.getCoords().getX() + obj1.getImage().getWidth() < obj2.getCoords().getX() + obj2.getImage().getWidth()) || (obj1.getCoords().getX() > obj2.getCoords().getX() && obj1.getCoords().getX() < obj2.getCoords().getX() + obj2.getImage().getWidth() ) ){ //Aligné suivant y
            if( (obj1.getCoords().getY() + obj1.getImage().getHeight() > obj2.getCoords().getY() && obj1.getCoords().getY() + obj1.getImage().getHeight() < obj2.getCoords().getY() + obj2.getImage().getHeight()) || (obj1.getCoords().getY() > obj2.getCoords().getY() && obj1.getCoords().getY() < obj2.getCoords().getY() + obj2.getImage().getHeight() )){ //Aligné suivant x
                isColliding = true;
            }
        }

        return isColliding;
    }

    private Point2D addVectors(Point2D a, Point2D b){
        Point2D c = new Point2D.Double();// a.getX() + b.getX(), a.getY() + b.getY());
        c.setLocation(a.getX() + b.getX(), a.getY() + b.getY());
        return c;
    }

    private Point2D scalarCross(Point2D a, double l){
        Point2D b= new Point2D.Double(a.getX()*l,a.getY()*l);
        return b;
    }


}
