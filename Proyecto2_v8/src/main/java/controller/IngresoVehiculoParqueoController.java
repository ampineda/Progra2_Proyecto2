package controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.*;

import java.util.Date;

/**
 * Clase para controlar la interactividad de la pantalla de ingreso de precios de estacionamientos
 * @author: Pedro Luis de Jesus Hernandez, Angel Magdiel Pineda Cruz
 * @version: 2021/10/06/E
 */
public class IngresoVehiculoParqueoController {

    public TextField txtNumeroPlaca;

    /**
     * funcion que valida que ingresa un vehiculo al parqueo
     * @param actionEvent
     */
    public void IngresaVehiculo(ActionEvent actionEvent) {

            String placa = txtNumeroPlaca.getText();

            //String placa = Utilidades.pideString("INGRESE EL NUMERO DE PLACA: ","ERROR: DEBE INGRESAR UN NUMERO DE PLACA VALIDO");

            // si el numero de placa esta vacio se muestra una alerta
            if(placa.isEmpty()){
                MiMensaje.MuestraMensaje("Atencion","Por favor ingrese el numero de placa del vehiculo");

            } else {

                placa = placa.toUpperCase().trim();

                // se valida que la placa no este en el parqueo
                if(Parqueo.VehiculoExisteParqueo(placa)){
                    MiMensaje.MuestraMensaje("Atencion","El Vehiculo ya esta ingresado en el parqueo");

                } else {

                    String cTipo = placa.substring(0,1);
                    TipoVehiculo tipo = TipoVehiculo.AUTOMOVIL;
                    Boolean placaValida = true;

                    switch (cTipo){
                        case "P":
                            tipo = TipoVehiculo.AUTOMOVIL;
                            break;
                        case "M":
                            tipo = TipoVehiculo.MOTO;
                            break;
                        case "C":
                            tipo = TipoVehiculo.CAMION;
                            break;
                        default:
                            placaValida = false;
                            break;
                    }


                    if(placaValida){

                        int numeroParqueo = Parqueo.getNumeroParqueo(tipo);

                        if (numeroParqueo > 0){

                            // se graba el vehiculo en el parqueo
                            switch (tipo.getCodigo()){
                                case "1":
                                    Parqueo.agregarVehiculo(new Moto(placa,numeroParqueo,new Date()));
                                    break;
                                case "2":
                                    Parqueo.agregarVehiculo(new Automovil(placa,numeroParqueo,new Date()));
                                    break;
                                case "3":
                                    Parqueo.agregarVehiculo(new Camion(placa,numeroParqueo,new Date()));
                                    break;
                                default:
                                    break;
                            }


                        } else {

                            MiMensaje.MuestraMensaje("Atencion","NO HAY PARQUEOS DISPONIBLES PARA "+tipo.name());

                        }

                    } else {
                        MiMensaje.MuestraMensaje("Atencion","El numero de placa que ingreso no es valido");
                    }


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
