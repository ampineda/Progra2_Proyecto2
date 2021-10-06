package utils;

import javafx.scene.control.Alert;

/**
 * Clase que muestra un mensaje de tipo Alert en pantalla
 * @author: Pedro Luis de Jesus Hernandez, Angel Magdiel Pineda Cruz
 * @version: 2021/10/06/E
 */

public class MiMensaje {

    /**
     * esta funcion crea y muestra en pantalla un Alert con la siguiente informcaion
     * @param titulo    titulo que se muestra en el alert
     * @param texto     texto que se muestra en el alert
     */
    public static void MuestraMensaje(String titulo, String texto){

        // cargamos los datos en el tipo que se halla seleccionado
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(titulo);
        alert.setContentText(texto);
        alert.showAndWait();

    }

}
