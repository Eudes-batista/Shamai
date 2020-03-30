/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shamai.audio;

import javafx.scene.media.AudioClip;

/**
 *
 * @author wagne
 */
public class Audio {

    private static Audio audio;

    public static Audio getAudio() {
        if (audio == null) {
            audio = new Audio();
        }
        return audio;
    }

    public static void setAudio(Audio audio) {
        Audio.audio = audio;
    }
    
    public void tocar() {
        String buscarCaminho = this.buscarCaminho();
        AudioClip audioClip = new AudioClip(buscarCaminho);
        audioClip.play();
    }

    private String buscarCaminho() {
        return getClass().getResource("/shamai/audio/chama.wav").toString();
    }
}
