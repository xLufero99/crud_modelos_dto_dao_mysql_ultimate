package controlador;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Controlador {
	public static void main(String[] args) {
        try {
            // Verificar si Desktop está soportado en el sistema
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                // Comprobar si se puede abrir un navegador
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    // Especificar la URL que quieres abrir
                    URI uri = new URI("http://localhost:8080/crud_modelos_dto_dao_mysql_ultimate/index.jsp");
                    desktop.browse(uri);
                }
            } else {
                System.out.println("El uso de Desktop no está soportado en este sistema.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

