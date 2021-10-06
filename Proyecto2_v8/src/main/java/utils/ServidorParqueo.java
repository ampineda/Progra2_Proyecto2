package utils;

import java.net.*;
import java.io.*;

/**
 * En esta clase se definen las propiedades y metodos iniciar el servidor de Parqueo
 * @author: Pedro Luis de Jesus Hernandez, Angel Magdiel Pineda Cruz
 * @version: 2021/10/06/E
 */
public class ServidorParqueo {

    ServerSocket servidor = null;
    Socket sc = null;
    final int puerto = 5000;
    InetAddress address = null;
    DataInputStream in;
    DataOutputStream out;
    static boolean servir = true ;

    /**
     * se inicia el servicio del servidor de parqueo
     */
    public void iniciar(){

        try{

            // address = InetAddress.getByName("localhost");

            servidor = new ServerSocket(puerto);
            System.out.println("servidor iniciado");

            while (servir) {

                sc = servidor.accept();

                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

                String mensaje = in.readUTF();

                System.out.println(mensaje);

                String respuesta = "";

                switch (mensaje){
                    case "VENTAS":
                        respuesta = Parqueo.VentaDiaria();
                        break;
                    case "PARQUEOS":
                        respuesta = Parqueo.ParqueosDisponibles();
                        break;
                    default:
                        respuesta = "LA SOLICITUD QUE REALIZO ES INCORRECTA";
                        break;
                }

                out.writeUTF(respuesta);

                // probamos regresar

                sc.close();

            }

            //servidor.close();

        } catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }


    }

    public ServidorParqueo(){

    }

    /**
     * Se cierra el servicio del servidor de parqueo
     * @param servir
     */
    public void setServir(boolean servir) {


        try{

            if(servidor != null){

                servidor.close();

            }

        }catch (IOException e){
            MiMensaje.MuestraMensaje("Error",e.getMessage());
        }


        ServidorParqueo.servir = servir;
    }
}
