package javafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FigurasGeometricas extends Application {

    Group componentes = new Group();
    Scene cena = new Scene(componentes, 360, 110);

    Text textoInformativo = new Text("Algumas figuras Geométricas desenhadas com JavaFX");
    Rectangle retangulo = new Rectangle(100, 40);
    Circle circulo = new Circle(30);
    Circle circuloBranco = new Circle(30);
    Ellipse elipse = new Ellipse(30, 10);

    @Override
    public void start(Stage window) {
        textoInformativo.setTranslateX(30);
        textoInformativo.setTranslateY(20);

        retangulo.setTranslateX(5);
        retangulo.setTranslateY(40);
        retangulo.setFill(Color.GREEN);

        circulo.setTranslateX(160);
        circulo.setTranslateY(60);
        circulo.setFill(Color.YELLOW);

        circuloBranco.setTranslateX(240);
        circuloBranco.setTranslateY(60);
        circuloBranco.setStroke(Color.BLACK);
        circuloBranco.setStrokeWidth(3.0);
        circuloBranco.setFill(Color.WHITE);

        elipse.setTranslateX(320);
        elipse.setTranslateY(60);
        elipse.setFill(Color.BLUE);

        componentes.getChildren().addAll(textoInformativo, retangulo, circulo, circuloBranco, elipse);
        window.setScene(cena);
        window.setResizable(false);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
