/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetx;

import java.io.IOException;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

public class SoundEffects {
    private Sound explosionEffect;
    private Sound painEffect;
    private Sound burnEffect;

    /**
    * Initialise resources
    */
    public void init() throws SlickException {
	    explosionEffect = new Sound("ressources/audio/ExplosionAudio/PUNCH3.WAV");
            painEffect = new Sound("ressources/audio/ExplosionAudio/Pain.wav");
            burnEffect = new Sound("ressources/audio/LargeFireball.wav");

    }

    public void explode(){
        explosionEffect.play(1f, 10f);// playAsSoundEffect(1.0f, 1.0f, false);
    }
    
     public void pain(){
        painEffect.play(1f, 0.19f);// playAsSoundEffect(1.0f, 1.0f, false);
    }

     public void burnEffect(){
        burnEffect.play(1.6f, 0.6f);
     }

}