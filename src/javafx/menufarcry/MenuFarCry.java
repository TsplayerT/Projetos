package javafx.menufarcry;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuFarCry extends Application {

    private Parent criarContainer() {
        Pane painel = new Pane();
        painel.setPrefSize(860, 600);

        ImageView background = new ImageView(new Image(getClass().getResource("/javafx/menufarcry/FarCry4.jpg").toString()));
        background.setFitWidth(860);
        background.setFitHeight(600);
        painel.getChildren().add(background);

        Titulo titulo = new Titulo("C A M P A N H A");
        titulo.setTranslateX(25);
        titulo.setTranslateY(150);

        MenuItem itemExit = new MenuItem("SAIR");
        itemExit.setOnMouseClicked(event -> System.exit(0));

        MenuBox menu = new MenuBox(
                new MenuItem("CONTINUAR"),
                new MenuItem("NOVO JOGO"),
                new MenuItem("COPERATIVO"),
                itemExit);
        menu.setTranslateX(100);
        menu.setTranslateY(300);

        painel.getChildren().addAll(titulo, menu);
        return painel;
    }

    @Override
    public void start(Stage janela) throws Exception {
        Scene cena = new Scene(criarContainer());
        janela.setScene(cena);
        janela.show();
    }

    private static class Titulo extends StackPane {

        public Titulo(String name) {
            Rectangle bg = new Rectangle(380, 50);

            bg.setStroke(Color.WHITE);
            bg.setStrokeWidth(2);
            bg.setFill(null);

            Text texto = new Text(name);
            texto.setFill(Color.WHITE);
            texto.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 50));

            setAlignment(Pos.CENTER);
            getChildren().addAll(bg, texto);
        }

    }

    private static class MenuBox extends VBox {

        public MenuBox(MenuItem... items) {
            getChildren().add(criarSeparador());

            for (MenuItem item : items) {
                getChildren().addAll(item, criarSeparador());
            }
        }

        public Line criarSeparador() {
            Line separador = new Line();
            separador.setEndX(200);
            separador.setStroke(Color.DARKGREY);
            return separador;
        }
    }

    private static class MenuItem extends StackPane {

        public MenuItem(String nome) {
            LinearGradient gradiente = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, new Stop[]{
                new Stop(0, Color.DARKVIOLET),
                new Stop(0.1, Color.BLACK),
                new Stop(0.9, Color.BLACK),
                new Stop(1, Color.DARKVIOLET)
            });
            Rectangle bg = new Rectangle(200, 30);
            bg.setOpacity(0.4);

            Text texto = new Text(nome);
            texto.setFill(Color.DARKGREY);
            texto.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 22));

            setAlignment(Pos.CENTER);
            getChildren().addAll(bg, texto);

            setOnMouseEntered(event -> {
                bg.setFill(gradiente);
                texto.setFill(Color.WHITE);
            });
            setOnMouseExited(event -> {
                bg.setFill(Color.BLACK);
                texto.setFill(Color.DARKGREY);
            });
            setOnMousePressed(event -> {
                bg.setFill(Color.DARKVIOLET);
            });
            setOnMouseReleased(event -> {
                bg.setFill(gradiente);
            });

        }
    }

    public static void main(String[] args) {
        launch();
    }
}
