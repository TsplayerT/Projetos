package javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class Audio extends Application {

    String url = getClass().getResource("/javafx/JaQT6No5AGIj.128.mp3").toString();
    StackPane pane = new StackPane();
    Scene cena = new Scene(pane, 400, 400);

    AudioClip view = new AudioClip(url);

    @Override
    public void start(Stage window) {
        window.setScene(cena);
        window.show();
        
        //view.setVolume(0.1);
        view.play();
    }

    public static void main(String[] args) {
        launch();
    }

}
