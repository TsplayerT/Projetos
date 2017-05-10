package javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ImagemLink extends Application {

    private final String IMG_URL = "http://www.oracle.com/ocom/groups/public/@otn/documents/digitalasset/402460.gif";
    StackPane pane = new StackPane();
    Scene cena = new Scene(pane, 360, 150);
    Image imagem = new Image(IMG_URL);
    ImageView view = new ImageView(imagem);
    Text text = new Text("Imagem desenhada com JavaFX");

    @Override
    public void start(Stage window) {
        view.setTranslateX(80);
        view.setTranslateY(5);

        text.setTranslateX(70);
        text.setTranslateY(75);

        pane.getChildren().add(view);
        pane.getChildren().add(text);
        window.setScene(cena);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
