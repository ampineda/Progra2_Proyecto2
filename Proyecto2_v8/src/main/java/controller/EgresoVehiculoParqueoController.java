package controller;

import com.itextpdf.text.pdf.PdfWriter;
import com.sun.xml.internal.txw2.TxwException;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.FacturaParqueo;
import utils.MiMensaje;
import utils.Parqueo;
import utils.Utilidades;

/**
 * Clase para controlar la interactividad de la pantalla de egreso de vehiculos del servidor de Parqueo
 * @author: Pedro Luis de Jesus Hernandez, Angel Magdiel Pineda Cruz
 * @version: 2021/10/06/E
 */
public class EgresoVehiculoParqueoController {

    public TextField txtNumeroPlaca;
    public TextField txtNit;
    public TextField txtNombre;
    public CheckBox checkImprimirFactura;

    /**
     * en esta funcion se valida que el numero de placa este lleno
     * y se llama la funcion que saca el vehiculo del parqueo
     * @param actionEvent
     */
    public void SacarVehiculo(ActionEvent actionEvent) {
        String placa = txtNumeroPlaca.getText();

        if(placa.isEmpty()){
            MiMensaje.MuestraMensaje("Atencion","Por favor ingrese el Numero de Placa del Vehiculo a retirar");
        } else {

            String cNit = txtNit.getText();
            boolean sacarVehiculo = true;

            if(checkImprimirFactura.isSelected()){

                if (cNit.isEmpty()){
                    MiMensaje.MuestraMensaje("Error","Por favor ingrese el NIT para la factura");

                } else {

                    cNit.toUpperCase();

                    if(!Utilidades.validaNitFac(cNit)){
                        sacarVehiculo = false;
                        MiMensaje.MuestraMensaje("Error","Por favor ingrese un numero de NIT valido");
                    }

                }


            }


            if (sacarVehiculo) {
                FacturaParqueo.setNombreCliente(txtNombre.getText());
                FacturaParqueo.setNit(cNit);

                Parqueo.SacaVehiculoParqueo(placa,checkImprimirFactura.isSelected());
            }


        }

    }

    /**
     * se cierra la pantalla de egreso de vehiculos
     * @param actionEvent
     */
    public void CerrarPantalla(ActionEvent actionEvent) {

        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

    }

    /**
     * se asignan los valores por default del nit y nombre de cliente para impirimr factura
     * @param actionEvent
     */
    public void ControlesFactura(ActionEvent actionEvent) {

        if(checkImprimirFactura.isSelected()){
            txtNit.setDisable(false);
            txtNombre.setDisable(false);
            txtNit.setText("CF");
            txtNombre.setText("CONSUMIDOR FINAL");
        }else{
            txtNit.setDisable(true);
            txtNombre.setDisable(true);
            txtNit.setText("");
            txtNombre.setText("");
        }

    }
}
