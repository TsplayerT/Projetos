package testes;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class AbrirLink {

    public static void main(String[] args) throws URISyntaxException, IOException {

        URI link = new URI("www.youtube.com/teta");
        Desktop.getDesktop().browse(link);

    }
}
