package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.*;

/**
 * Clase para controlar la interactividad de la pantalla de precios de estacionamieintos del servidor de parqueo
 * @author: Pedro Luis de Jesus Hernandez, Angel Magdiel Pineda Cruz
 * @version: 2021/10/06/E
 */

public class PrecioEstacionamientosController {

    public ComboBox comboTipoVehiculo;
    public TextField txtSegundos;
    public TextField txtPrecio;
    String tipoVehiculoPrecio = "";
    int segundosPrecio = 0;
    double precioTiempo = 0.00;

    public PrecioEstacionamientosController(){

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
     * se asigna el valor de precio de estacionamiento con el valor ingresado por el usuario
     * @param actionEvent
     */
    public void grabaDatos(ActionEvent actionEvent) {
        // antes de grabar validamos que los campos esten llenos

        if(comboTipoVehiculo.getValue()==null){
            MiMensaje.MuestraMensaje("Atencion","Por favor ingrese el Tipo de Vehiculo");

        } else if(txtSegundos.getText().isEmpty()){
            MiMensaje.MuestraMensaje("Atencion","Por favor ingrese la Cantidad de Segundos");

        } else if(txtPrecio.getText().isEmpty()){
            MiMensaje.MuestraMensaje("Atencion","Por favor ingrese el Precio por Estacionamiento");

        } else {

            tipoVehiculoPrecio = comboTipoVehiculo.getValue().toString();

            segundosPrecio = Integer.parseInt(txtSegundos.getText()) ;

            precioTiempo = Double.parseDouble(txtPrecio.getText());

            if(segundosPrecio<0){
                MiMensaje.MuestraMensaje("Atencion","Por favor los segundos deben ser mayores o igual a 0");

            } else if (precioTiempo<0.00) {
                MiMensaje.MuestraMensaje("Atencion","Por favor el precio debe ser mayor o igual a 0.00");

            } else {

                System.out.println("tipo de vehiculo: "+tipoVehiculoPrecio);

                // guardamos la informacion
                switch (tipoVehiculoPrecio){
                    case "MOTOCICLETA":
                        TarifasVehiculos.setTarifasMoto(segundosPrecio,precioTiempo);
                        break;
                    case "VEHICULO":
                        TarifasVehiculos.setTarifasAutomovil(segundosPrecio,precioTiempo);
                        break;
                    case "CAMION":
                        TarifasVehiculos.setTarifasCamion(segundosPrecio,precioTiempo);
                        break;
                    default:
                        break;
                }

                MiMensaje.MuestraMensaje("Atencion","La informacion se guardo correctamente");

            /*
            System.out.println("");
            System.out.println("MOSTRANDO LAS TARIFAS DE LOS PARQUEOS");
            System.out.println("Para las motos: "+TarifasVehiculos.getSegundosMoto()+" segundos, con precio de: "+TarifasVehiculos.getTarifaMoto());
            System.out.println("Para las aumotomoviles: "+TarifasVehiculos.getSegundosAutomovil()+" segundos, con precio de: "+TarifasVehiculos.getTarifaAutomovil());
            System.out.println("Para las camiones: "+TarifasVehiculos.getSegundosCamion()+" segundos, con precio de: "+TarifasVehiculos.getTarifaCamion());
            */

            }

        }

    }

    /**
     * se cierra la pantalla
     * @param actionEvent
     */
    public void CerrarPantalla(ActionEvent actionEvent) {

        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

    }
}
