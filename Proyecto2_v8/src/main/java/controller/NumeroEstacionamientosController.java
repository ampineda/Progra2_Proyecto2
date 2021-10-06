package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.MiMensaje;
import utils.Parqueo;
import utils.TarifasVehiculos;
import utils.Utilidades;

/**
 * Clase para controlar la interactivada de la pantalla de configuracion de numero de estacionamientos
 * @author: Pedro Luis de Jesus Hernandez, Angel Magdiel Pineda Cruz
 * @version: 2021/10/06/E
 */

public class NumeroEstacionamientosController {

    public ComboBox comboTipoVehiculo;
    public TextField txtNumeroParqueos;

    String tipoVehiculoPrecio = "";
    int numeroParqueos = 0;

    public NumeroEstacionamientosController(){

    }

    /**
     * se carga el combobox con los tipos de vehiculos
     */
    public void initialize() {
        ObservableList<String> items = FXCollections.observableArrayList();
        items.addAll("MOTOCICLETA", "VEHICULO", "CAMION");
        comboTipoVehiculo.setItems(items);
    }

    /**
     * se asigna el valor de numero de estacionameiento con el valor ingresado por el usuario
     * @param actionEvent
     */
    public void GrabaDatos(ActionEvent actionEvent) {
        // antes de grabar validamos que los campos esten llenos

        if(comboTipoVehiculo.getValue()==null){
            MiMensaje.MuestraMensaje("Atencion","Por favor ingrese el Tipo de Vehiculo");

        } else if(txtNumeroParqueos.getText().isEmpty()){
            MiMensaje.MuestraMensaje("Atencion","Por favor ingrese la Cantidad de Parqueos");

        } else {

            tipoVehiculoPrecio = comboTipoVehiculo.getValue().toString();

            numeroParqueos = Integer.parseInt(txtNumeroParqueos.getText()) ;


            if(numeroParqueos<0){
                MiMensaje.MuestraMensaje("Atencion","Por favor ingrese una cantidad de parqueos mayor 0");

            } else {

                System.out.println("tipo de vehiculo: "+tipoVehiculoPrecio);
                System.out.println("parqueos: "+numeroParqueos);

                // guardamos la informacion
                switch (tipoVehiculoPrecio){
                    case "MOTOCICLETA":
                        Parqueo.setMaxParqueoMoto(numeroParqueos);
                        break;
                    case "VEHICULO":
                        Parqueo.setMaxParqueoAuto(numeroParqueos);
                        break;
                    case "CAMION":
                        Parqueo.setMaxParqueoCamion(numeroParqueos);
                        break;
                    default:
                        break;
                }

                MiMensaje.MuestraMensaje("Atencion","La informacion se guardo correctamente");

                System.out.println("MOSTRANDO LOS PARQUEOS DISPONIBLES");
                System.out.println("De Motocicletas hay: " + Parqueo.getMaxParqueoMoto() +" habilitados");
                System.out.println("De Automoviles hay: " + Parqueo.getMaxParqueoAuto() +" habilitados");
                System.out.println("De Camiones hay: " + Parqueo.getMaxParqueoCamion() +" habilitados");

            }

        }

    }

    public void CerrarPantalla(ActionEvent actionEvent) {

        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();


    }

}
