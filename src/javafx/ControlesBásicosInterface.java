package javafx;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ControlesBásicosInterface extends Application {

    VBox vbox = new VBox(10);
    Scene cena = new Scene(vbox, 300, 400);

    Label label = new Label("Sou um rótulo de texto!");
    TextField campoTexto = new TextField("Digite algo");
    TextArea areaTexto = new TextArea("Digite algo com várias linhas");
    Separator separadorHorizontal = new Separator();
    Separator separadorVertical = new Separator(Orientation.VERTICAL);
    Slider deslizante = new Slider();

    @Override
    public void start(Stage window) {
        label.setTooltip(new Tooltip("Esse é um rótulo para mostrar textos de forma simples"));
        
        campoTexto.setTooltip(new Tooltip("Campo de texto para entrada de uma só linha "));
        
        areaTexto.setWrapText(true);
        areaTexto.setTooltip(new Tooltip("Campo de texto para entrada de múltiplas linhas"));

        deslizante.setShowTickLabels(true);
        deslizante.setShowTickMarks(true);
        deslizante.setTooltip(new Tooltip("O controle deslizante tem um valor numérico de acordo com sua posição"));

        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(label, campoTexto, areaTexto, separadorVertical, separadorHorizontal, deslizante);

        window.setTitle("Controles Básicos I");
        window.setScene(cena);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
