package javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class MediaArquivo extends Application {

    private final String url = getClass().getResource("/javafx/fbmedia.mp4").toString();
    StackPane pane = new StackPane();
    Scene cena = new Scene(pane, 400, 400);

    Media media = new Media(url);
    MediaPlayer player = new MediaPlayer(media);
    MediaView view = new MediaView(player);

    @Override
    public void start(Stage window) {
        pane.getChildren().add(view);

        window.setScene(cena);
        window.setResizable(false);
        window.show();

        player.play();
    }

    public static void main(String[] args) {
        launch();
    }

}
