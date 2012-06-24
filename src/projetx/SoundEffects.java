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

    /**
    * Initialise resources
    */
    public void init() throws SlickException {
	    explosionEffect = new Sound("ressources/audio/ExplosionAudio/PUNCH3.WAV");
    }

    public void explode(){
        explosionEffect.play(0.5f, 10f);// playAsSoundEffect(1.0f, 1.0f, false);
    }

}