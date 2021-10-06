package controller;

import javafx.collections.transformation.TransformationList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import utils.TarifasVehiculos;
import utils.*;

import java.net.InetAddress;

/**
 * Clase para controlar la interactividad de la pantalla principal de la pantalla del servidor del parqueo
 * @author: Pedro Luis de Jesus Hernandez, Angel Magdiel Pineda Cruz
 * @version: 2021/10/06/E
 */

public class MenuController {

    public TextField txtDireccionIp;

    // private static ServidorParqueo servidor = new ServidorParqueo();

    Thread abrirServidor = new TareaIniciarServidor();


    public MenuController(){
        //servidor.iniciar();

    }

    // se carga el numero de ip de la maquina local
    public void initialize() {

        InetAddress address = null;

        //InetAddress address1 = null;

        try {

            abrirServidor.start();

            //address = InetAddress.getByName("localhost");

            address = InetAddress.getLocalHost();
            txtDireccionIp.setText(address.getHostAddress());

        }
        catch (Exception e) {
            // System.out.print("Error: "+e.getMessage());



            //MiMensaje.MuestraMensaje("Error: ",e.getMessage());

        }
            //MiMensaje.MuestraMensaje("Atencion",address.getHostAddress());

            //System.out.println(address.getHostAddress());

    }


    /**
     * se detiene el servidor del parqueo y se cierra el sistema
     * @param actionEvent
     */
    public void SalirSistema(ActionEvent actionEvent) {

        abrirServidor.interrupt();

        abrirServidor = null;

        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

    }

    /**
     * se abrea la pantalla de para configurar los precios de los estacionamientos
     * @param actionEvent
     * @throws Exception
     */
    public void AbrirPrecioEstacionamientos(ActionEvent actionEvent) throws Exception{

        try{

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/PrecioEstacionamientos.fxml"));
            Pane root = (Pane) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Precios de Estacionamientos");

            stage.initStyle(StageStyle.UTILITY);

            // stage.initStyle(StageStyle.UNDECORATED);

            stage.setScene(new Scene(root, 590, 400));

            stage.show();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * se abre la pantalla para configurar el numero de estacionamientos
     * @param actionEvent
     */
    public void AbrirNumeroEstacionamientos(ActionEvent actionEvent) {

        try{

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/NumeroEstacionamientos.fxml"));
            Pane root = (Pane) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Numero de Estacionamientos");

            //stage.initStyle(StageStyle.UNDECORATED);

            stage.initStyle(StageStyle.UTILITY);
            stage.setScene(new Scene(root, 653, 621));

            stage.show();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * se muestran en pantalla (solo para pruebas en consola) los datos del parqueo
      * @param actionEvent
     */
    public void MuestraParqueo(ActionEvent actionEvent) {

        System.out.println("MOSTRANDO LOS PARQUEOS DISPONIBLES");
        System.out.println("De Motocicletas hay: " + Parqueo.getMaxParqueoMoto() +" habilitados");
        System.out.println("De Automoviles hay: " + Parqueo.getMaxParqueoAuto() +" habilitados");
        System.out.println("De Camiones hay: " + Parqueo.getMaxParqueoCamion() +" habilitados");

        System.out.println("");
        System.out.println("MOSTRANDO LAS TARIFAS DE LOS PARQUEOS");
        System.out.println("Para las motos: "+ TarifasVehiculos.getSegundosMoto()+" segundos, con precio de: "+TarifasVehiculos.getTarifaMoto());
        System.out.println("Para las aumotomoviles: "+TarifasVehiculos.getSegundosAutomovil()+" segundos, con precio de: "+TarifasVehiculos.getTarifaAutomovil());
        System.out.println("Para las camiones: "+TarifasVehiculos.getSegundosCamion()+" segundos, con precio de: "+TarifasVehiculos.getTarifaCamion());

        System.out.println();
        System.out.println("MOSTRANDO LOS VEHICULOS EN EL PARQUEO");
        Parqueo.MostrarParqueo();


    }

    /**
     * se abre la pantalla para ingresar vehiculos al parqueo
     * @param actionEvent
     */
    public void AbrirIngresoVehiculos(ActionEvent actionEvent) {

        try{

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/IngresoVehiculos.fxml"));
            Pane root = (Pane) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Ingreso de Vehiculos");

            //stage.initStyle(StageStyle.UNDECORATED);
            stage.initStyle(StageStyle.UTILITY);

            stage.setScene(new Scene(root, 606, 381));

            stage.show();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * se abre la pantalla para sacar vehiculos del parqueo
     * @param actionEvent
     */
    public void AbrirEgresoVehiculos(ActionEvent actionEvent) {

        try{

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/EgresoVehiculos.fxml"));
            Pane root = (Pane) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Egreso de Vehiculos");

            //stage.initStyle(StageStyle.UNDECORATED);

            stage.initStyle(StageStyle.UTILITY);
            stage.setScene(new Scene(root, 600, 500));

            stage.show();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
