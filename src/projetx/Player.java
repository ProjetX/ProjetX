/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetx;

import java.awt.geom.Point2D;
import java.util.Date;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.Renderable;
import org.newdawn.slick.SlickException;

/**
 *
 * @author jonas
 */
public class Player extends Sprite implements Comparable<Player> {

    public enum Type {

        COSTARD, BAGNARD;
    }
    protected Point2D speed = new Point2D.Double(0, 0);
    protected Point2D AcutalPosition;
    protected boolean isOnAPlatform;
    protected boolean wantsToGoRight = false;
    protected boolean wantsToGoLeft = false;
    protected boolean wantsToJump = false;
    protected double lateralSpeed = 0.7;
    protected double verticalSpeed = 1.2;
    protected int timeSinceDeath = -1;
    int numberOfKills = 0;
    int numberOfDeaths = 0;
    int lastPower = 0;
    boolean rightOrientation = true;
    Animation walkLeft = null;
    Animation jumpLeft = null;
    Animation walkRigth = null;
    Animation jumpRigth = null;
    boolean walkNext = false;
    boolean jumpNext = false;
    boolean hasUsedGravityBoom = false;
    protected Player angryPlayer = null;

    Date lastRespawn = null;

    public Player(Type type) throws SlickException {
        super();
        setType(type);
    }

    public Player(String type) throws SlickException {
        if (type.toLowerCase().equals("bagnard") || type.equals("ressources/sprites/Bagnard/BagnardStatique.png")) {
            setType(Type.BAGNARD);
        } else if (type.toLowerCase().equals("costard") || type.equals("ressources/sprites/Costard/CostardStatique.png")) {
            setType(Type.COSTARD);
        }
    }

    private void setType(Type type) throws SlickException {

        int speedWalk = 75;
        int speedJump = 150;

        switch (type) {
            case BAGNARD:
                this.image = new Image("ressources/sprites/Bagnard/BagnardStatique.png"); {
                Image walkA[] = new Image[6];
                walkA[0] = new Image("ressources/sprites/Bagnard/Animations/Marche/BagnardMarche1.png");
                walkA[1] = new Image("ressources/sprites/Bagnard/Animations/Marche/BagnardMarche2.png");
                walkA[2] = new Image("ressources/sprites/Bagnard/Animations/Marche/BagnardMarche3.png");
                walkA[3] = new Image("ressources/sprites/Bagnard/Animations/Marche/BagnardMarche4.png");
                walkA[4] = new Image("ressources/sprites/Bagnard/Animations/Marche/BagnardMarche5.png");
                walkA[5] = new Image("ressources/sprites/Bagnard/Animations/Marche/BagnardMarche6.png");
                this.walkRigth = new Animation(walkA, speedWalk);

                Image jumpA[] = new Image[6];
                jumpA[0] = new Image("ressources/sprites/Bagnard/Animations/Saute/BagnardSaute1.png");
                jumpA[1] = new Image("ressources/sprites/Bagnard/Animations/Saute/BagnardSaute2.png");
                jumpA[2] = new Image("ressources/sprites/Bagnard/Animations/Saute/BagnardSaute3.png");
                jumpA[3] = new Image("ressources/sprites/Bagnard/Animations/Saute/BagnardSaute4.png");
                jumpA[4] = new Image("ressources/sprites/Bagnard/Animations/Saute/BagnardSaute5.png");
                jumpA[5] = new Image("ressources/sprites/Bagnard/Animations/Saute/BagnardSaute6.png");
                this.jumpRigth = new Animation(jumpA, speedJump);

                Image walkAL[] = new Image[6];
                Image jumpAL[] = new Image[6];
                for (int i = 0; i < 6; i++) {
                    walkAL[i] = walkA[i].getFlippedCopy(true, false);
                    jumpAL[i] = jumpA[i].getFlippedCopy(true, false);
                }

                this.walkLeft = new Animation(walkAL, speedWalk);
                this.jumpLeft = new Animation(jumpAL, speedJump);
            }
            break;

            case COSTARD:
                this.image = new Image("ressources/sprites/Costard/CostardStatique.png"); {

                Image walkA[] = new Image[6];
                walkA[0] = new Image("ressources/sprites/Costard/Animations/Marche/CostardMarche1.png");
                walkA[1] = new Image("ressources/sprites/Costard/Animations/Marche/CostardMarche2.png");
                walkA[2] = new Image("ressources/sprites/Costard/Animations/Marche/CostardMarche3.png");
                walkA[3] = new Image("ressources/sprites/Costard/Animations/Marche/CostardMarche4.png");
                walkA[4] = new Image("ressources/sprites/Costard/Animations/Marche/CostardMarche5.png");
                walkA[5] = new Image("ressources/sprites/Costard/Animations/Marche/CostardMarche6.png");
                this.walkRigth = new Animation(walkA, speedWalk);

                Image jumpA[] = new Image[6];
                jumpA[0] = new Image("ressources/sprites/Costard/Animations/Saute/CostardSaute1.png");
                jumpA[1] = new Image("ressources/sprites/Costard/Animations/Saute/CostardSaute2.png");
                jumpA[2] = new Image("ressources/sprites/Costard/Animations/Saute/CostardSaute3.png");
                jumpA[3] = new Image("ressources/sprites/Costard/Animations/Saute/CostardSaute4.png");
                jumpA[4] = new Image("ressources/sprites/Costard/Animations/Saute/CostardSaute5.png");
                jumpA[5] = new Image("ressources/sprites/Costard/Animations/Saute/CostardSaute6.png");
                this.jumpRigth = new Animation(jumpA, speedJump);

                Image walkAL[] = new Image[6];
                Image jumpAL[] = new Image[6];
                for (int i = 0; i < 6; i++) {
                    walkAL[i] = walkA[i].getFlippedCopy(true, false);
                    jumpAL[i] = jumpA[i].getFlippedCopy(true, false);
                }

                this.walkLeft = new Animation(walkAL, speedWalk);
                this.jumpLeft = new Animation(jumpAL, speedJump);
            }
            break;
        }

        super.image = this.image;
    }

    public Renderable getRenderable() {
        if (jumpNext && rightOrientation && this.jumpRigth != null) {
            if (this.jumpRigth.getFrame() == this.jumpRigth.getFrameCount() - 1) {
                jumpNext = false;
            }
            return this.jumpRigth;
        } else if (jumpNext && !rightOrientation && this.jumpLeft != null) {
            if (this.jumpLeft.getFrame() == this.jumpLeft.getFrameCount() - 1) {
                jumpNext = false;
            }
            return this.jumpLeft;
        } else if (walkNext && rightOrientation && this.walkRigth != null) {
            if (this.walkRigth.getFrame() == this.walkRigth.getFrameCount() - 1) {
                walkNext = false;
            }
            return this.walkRigth;
        } else if (walkNext && !rightOrientation && this.walkLeft != null) {
            if (this.walkLeft.getFrame() == this.walkLeft.getFrameCount() - 1) {
                walkNext = false;
            }
            return this.walkLeft;
        } else {
            return this.image;
        }
    }

    public float getAlpha(){
        float i = getInvincibilityRemainingTime();
        if(i > 0){
            float m = (float) (i % 1000);
            m = m < 500 ? 1000 - m : m;
            return m / 1000;
        }
        return 1;
    }

    //ca s'ecrit surement pas comme ça. OSEF
    public float getInvincibilityRemainingTime(){
        if(lastRespawn == null){
            return 0;
        }
        Date d = new Date();
        float r = 3000 - (d.getTime() - lastRespawn.getTime());
        return r > 0 ? r : 0;
    }

    public void SetTimeSinceDeath(int time) {
        if(timeSinceDeath != -1 && time == -1){
            lastRespawn = new Date();
        }
        timeSinceDeath = time;
    }

    public int GetTimeSinceDeath() {
        return timeSinceDeath;
    }

    public void iWouldLikeToJump() {
        if (isOnAPlatform) {
            wantsToJump = true;
            jumpNext = true;
        }
    }

    public void iWouldLikeToGoLeft() {
        wantsToGoLeft = true;
        walkNext = true;
        if (rightOrientation) {
            this.image = this.image.getFlippedCopy(true, false);
            rightOrientation = false;
        }
    }

    public void iWouldLikeToGoRight() {
        wantsToGoRight = true;
        walkNext = true;
        if (!rightOrientation) {
            this.image = this.image.getFlippedCopy(true, false);
            rightOrientation = true;
        }
    }

    public void Die() {
        numberOfDeaths++;
        lastPower = 0;
    }

    public void Kill() {
        numberOfKills++;
    }

    public int compareTo(Player o) {
        if (this.getNumberOfKills() > o.getNumberOfKills()) {
            return -1;
        } else if (this.getNumberOfKills() < o.getNumberOfKills()) {
            return 1;
        } else {
            if (this.getNumberOfDeaths() < o.getNumberOfDeaths()) {
                return -1;
            } else if (this.getNumberOfDeaths() > o.getNumberOfDeaths()) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public void setWantsToGoLeft(boolean wantsToGoLeft) {
        this.wantsToGoLeft = wantsToGoLeft;
    }

    public void setWantsToGoRight(boolean wantsToGoRight) {
        this.wantsToGoRight = wantsToGoRight;
    }

    public void setWantsToJump(boolean wantsToJump) {
        this.wantsToJump = wantsToJump;
    }

    public double getVerticalSpeed() {
        return verticalSpeed;
    }

    public void setVerticalSpeed(double verticalSpeed) {
        this.verticalSpeed = verticalSpeed;
    }

    public Point2D getSpeed() {
        return speed;
    }

    public void setSpeed(Point2D speed) {
        this.speed = speed;
    }

    public void setSpeed(double x, double y) {
        this.speed.setLocation(x, y);
    }

    public Point2D getActualPosition() {
        return this.AcutalPosition;
    }

    public void setActualPosition(Point2D pos) {
        this.AcutalPosition = pos;
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

    public int GetTimeSinceLastPower() {
        return lastPower;
    }

    public void SetTimeSinceLastPower(int time) {
        lastPower = time;
    }

    public float GetTailleBarre() {
        if (lastPower > 5000) {
            return 80.f;
        } else {
            return (float) ((80.f * (float) lastPower) / 5000.f);
        }
    }

    public int getNumberOfDeaths() {
        return numberOfDeaths;
    }

    public int getNumberOfKills() {
        return numberOfKills;
    }

    public boolean isHasUsedGravityBoom() {
        return hasUsedGravityBoom;
    }

    public void setHasUsedGravityBoom(boolean hasUsedGravityBoom) {
        this.hasUsedGravityBoom = hasUsedGravityBoom;
    }

    public Player getAngryPlayer() {
        return angryPlayer;
    }

    public void setAngryPlayer(Player angryPlayer) {
        this.angryPlayer = angryPlayer;
    }
}
