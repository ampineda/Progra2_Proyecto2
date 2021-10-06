package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.ClienteParqueo;
import utils.MiMensaje;
import utils.ServidorParqueo;
import utils.TareaIniciarServidor;

import java.net.InetAddress;

/**
 * Clase para controlar la interactividad de la pantalla principal del cliente del parqueo
 * @author: Pedro Luis de Jesus Hernandez, Angel Magdiel Pineda Cruz
 * @version: 2021/10/06/E
 */

public class MenuClienteController {

    public TextField txtDireccionIp;

    /**
     * se asigna la direccion ip a textfiel txtDireccionIp
     */
    public void initialize() {

        InetAddress address = null;

        try {

            address = InetAddress.getByName("localhost");
            txtDireccionIp.setText(address.getHostAddress());

        }

        catch (Exception e) {

        }

    }

    /**
     * se cierra la pantalla
     * @param actionEvent
     */
    public void SalirSistema(ActionEvent actionEvent) {

        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

    }

    /**
     * se manda a consultar el servidor del parqueo y se muestra la respuesta
     * @param actionEvent
     */
    public void ConsultarServidor(ActionEvent actionEvent) {

        String ipServer = txtDireccionIp.getText().trim();

        if(ipServer.isEmpty()){
            ipServer = "";
        }

        ClienteParqueo c = new ClienteParqueo(ipServer);
        c.Inicio("llamada","Prueba");

    }

    /**
     * se manda a consultar el total del ventas diarias al servidor de parqueo
     * y se muestra la respuesta
     * @param actionEvent
     */
    public void ConsultarVentas(ActionEvent actionEvent) {

        String ipServer = txtDireccionIp.getText().trim();

        if(ipServer.isEmpty()){
            ipServer = "";
        }

        ClienteParqueo c = new ClienteParqueo(ipServer);
        c.Inicio("VENTAS","TOTAL DE VENTAS DEL DIA");

    }

    /**
     * se manda a consultar la disponibilidad del parqueo y se muestra la respuesta
     * @param actionEvent
     */
    public void ConsultarParqueos(ActionEvent actionEvent) {

        String ipServer = txtDireccionIp.getText().trim();

        if(ipServer.isEmpty()){
            ipServer = "";
        }


        ClienteParqueo c = new ClienteParqueo(ipServer);
        c.Inicio("PARQUEOS","ESTADO DEL PARQUEO");
    }

}
