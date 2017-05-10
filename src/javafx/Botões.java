package javafx;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Botões extends Application implements EventHandler {

    VBox pane = new VBox(10);
    Scene cena = new Scene(pane, 200, 240);

    ArrayList<Button> botoes = new ArrayList<>();
    Text pressione = new Text("Pressione os Botões");
    Text sumiu = new Text("Sumiu!");

    @Override
    public void start(Stage window) {
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(pressione, sumiu);
        sumiu.setTranslateY(113);
        for (int s = 0; botoes.size() < 5; s++) {
            botoes.add(new Button("Botão " + (s + 1)));
            botoes.get(s).setTranslateY(-20);
            botoes.get(s).setPrefSize(100, 25);
            botoes.get(s).setOnMouseClicked(this);
            pane.getChildren().add(botoes.get(s));
        }

        window.getIcons().add(new Image(getClass().getResource("/javafx/java_icone.png").toString()));
        window.setResizable(false);
        window.setScene(cena);
        window.show();
    }

    @Override
    public void handle(Event event) {
        botoes.get(0).setDisable(false);
        botoes.get(1).setText("Botão 2");
        botoes.get(3).setVisible(true);
        botoes.get(4).setTranslateX(0);
        botoes.get(4).setTranslateY(-20);
        
        if (event.getSource() == botoes.get(0)) {
            botoes.get(0).setDisable(true);
        } else if (event.getSource() == botoes.get(1)) {
            botoes.get(1).setText("Pressionado!");
        } else if (event.getSource() == botoes.get(2)) {
            pane.setBackground(new Background(new BackgroundFill(Color.color(Math.random(), Math.random(), Math.random()), CornerRadii.EMPTY, Insets.EMPTY)));
        } else if (event.getSource() == botoes.get(3)) {
            botoes.get(3).setVisible(false);
        } else if (event.getSource() == botoes.get(4)) {
            botoes.get(4).setTranslateX(55);
            botoes.get(4).setTranslateY(16);
        }
    }

    public static void main(String[] args) {
        launch();
    }

}
