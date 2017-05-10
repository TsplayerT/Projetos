package javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MediaLink extends Application {

    private final String url = "https://youtu.be/pUXvoFrsuok";
    StackPane pane = new StackPane();
    Scene cena = new Scene(pane, 1000, 600);

    WebView view = new WebView();

    @Override
    public void start(Stage window) {
        pane.getChildren().add(view);
        view.getEngine().load(url);
        window.setScene(cena);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
