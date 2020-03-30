/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import javafx.application.Application;
import javafx.stage.Stage;
import shamai.audio.Audio;

/**
 *
 * @author wagne
 */
public class TesteAudio extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        Audio.getAudio().tocar();
    }
    
}
