package utils;

import java.io.*;
import java.net.Socket;

/**
 * En esta clase se definen las propiedades y metodos para recuperar informacion
 * del servidor de Parqueo
 * @author: Pedro Luis de Jesus Hernandez, Angel Magdiel Pineda Cruz
 * @version: 2021/10/06/E
 */

public class ClienteParqueo {

    //final String Host = "127.0.0.1";

    String Host = "";
    final int puerto = 5000;
    DataInputStream in;
    DataOutputStream out;
    String ip = "";

    public ClienteParqueo(){

    }

    /**
     * se inicializa la clase con la direccion ip
     * @param ip1
     */
    public ClienteParqueo(String ip1){

        this.Host = ip1;

    }

    /**
     * se inicia el proceso que recuperar la informacion del parqueo desde el servidor
     * @param consulta
     * @param titulo
     */
    public void Inicio(String consulta,String titulo){

        try{

            // MiMensaje.MuestraMensaje("HOST",Host);

            Socket sc = new Socket(Host,puerto);
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            out.writeUTF(consulta);

            String mensaje = in.readUTF();

            MiMensaje.MuestraMensaje(titulo,mensaje);

            sc.close();


        }catch (Exception e){
            MiMensaje.MuestraMensaje("Error: ",e.getMessage());
        }


    }

}
