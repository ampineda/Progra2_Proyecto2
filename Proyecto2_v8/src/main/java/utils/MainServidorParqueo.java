package utils;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * programa principal que lanza la aplicacion del parqueo para el servidor
 * @author: Pedro Luis de Jesus Hernandez, Angel Magdiel Pineda Cruz
 * @version: 2021/10/06/E
 */

public class MainServidorParqueo extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        try {

            Pane root = FXMLLoader.load(getClass().getResource("/views/Menu.fxml"));
            primaryStage.setTitle("*** MENU PRINCIPAL DEL PARQUEO ***");

            //primaryStage.initStyle(StageStyle.UNIFIED);
            // primaryStage.initStyle(StageStyle.UNDECORATED);

            primaryStage.initStyle(StageStyle.UTILITY);

            Scene scene = new Scene(root,705,532);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e){

            System.out.println("Error: "+e.getMessage());

        }

    }

    public static void main(String[] args) {

        // Thread abrirServidor = new TareaIniciarServidor();
        // abrirServidor.start();

        launch(args);

    }

}
