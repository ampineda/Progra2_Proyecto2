
package utils;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Clase Main
 * Se muestran los Menus donde se puede ingresar a las distintas
 * opciones del parqueo
 * @author: Pedro Luis de Jesus Hernandez, Angel Magdiel Pineda Cruz
 * @version: 2021/08/31/E
 */

public class Main {

    /**
     * Se muestran en pantalla las opciones del menu
     * @param args
     */
    public static void main(String[] args) {
	// write your code here

        Scanner entrada = new Scanner(System.in);
        int opcion1 = 0;
        int opcion2 = 0;

        Parqueo parqueo1 = new Parqueo();

        do {

            menuPrincipal();

            System.out.println("INGRESE UNA OPCION: ");
            opcion1 = entrada.nextInt();

            switch (opcion1){
                case 1:

                    do{

                        menuAdministracion();

                        System.out.println("INGRESE UNA OPCION: ");
                        opcion2 = entrada.nextInt();

                        switch (opcion2){
                            case 1:
                                System.out.println("*** DEFINIR ESTACIONAMIENTOS ***");

                                int no = 0,
                                    letra = 0;
                                String respuesta;

                                do {
                                    System.out.println("¿QUE TIPO DE ESTACIONAMIENTO DESEA INGRESAR?: ");

                                    //System.out.println("1 para Motocicletas");
                                    //System.out.println("2 para Automoviles");
                                    //System.out.println("3 para Camiones");

                                    //letra = entrada.nextInt();

                                    letra = Utilidades.pideInteger("1 PARA MOTOCICLETAS \n2 PARA AUTOMOVILES \n3 PARA CAMIONES","Por Favor ingrese un numero entre 1 y 3");


                                    if (letra == 1) {
                                        no = Utilidades.pideInteger("INGRESE EL NUMERO DE ESTACIONAMIENTOS HABILITADOS PARA MOTOCICLETAS:",
                                                                       "ERROR: INGRESE UN NUMERO DE ESTACIONAMIENTOS VALIDO");
                                        parqueo1.setMaxParqueoMoto(no);
                                    } else if (letra == 2) {
                                        no = Utilidades.pideInteger("INGRESE EL NUMERO DE ESTACIONAMIENTOS HABILITADOS PARA AUTOMOVILES:",
                                                                        "ERROR: INGRESE UN NUMERO DE ESTACIONAMIENTOS VALIDO");
                                        parqueo1.setMaxParqueoAuto(no);
                                    } else if (letra == 3) {
                                        no = Utilidades.pideInteger("INGRESE EL NUMERO DE ESTACIONAMIENTOS HABILITADOS PARA CAMIONES:",
                                                                        "ERROR: INGRESE UN NUMERO DE ESTACIONAMIENTOS VALIDO");
                                        parqueo1.setMaxParqueoCamion(no);
                                    } else {
                                        System.out.println("ERROR: INGRESE UN TIPO DE VEHICULO VALIDO (MOTOCICLETA, AUTOMOVIL O CAMION)");
                                    }

                                    System.out.println("");
                                    System.out.println("¿DESEA REGRESAR AL MENU ANTERIOR?. \nINGRESE SI O NO");
                                    respuesta = entrada.next();
                                    System.out.println("");

                                } while (respuesta.equalsIgnoreCase("no"));

                                break;
                            case 2:
                                System.out.println("DEFINIR TARIFAS POR TIPO DE VEHICULO");

                                TipoVehiculo tipo = Utilidades.ValidaTipo();
                                int segundos = Utilidades.pideInteger("INGRESE LA CANTIDAD DE SEGUNDOS PARA LA TARIFA DE "+tipo.name()+":",
                                                                        "LOS SEGUNDOS DEBEN SER NUMEROS");
                                double tarifa = Utilidades.pideDouble("INGRESE EL PRECIO PARA LA TARIFA DE "+tipo.name()+":",
                                                                            "LA TARIFA DEBE SER NUMERICA");

                                switch (tipo.getCodigo()){
                                    case "1":
                                        TarifasVehiculos.setTarifasMoto(segundos,tarifa);
                                        break;
                                    case "2":
                                        TarifasVehiculos.setTarifasAutomovil(segundos,tarifa);
                                        break;
                                    case "3":
                                        TarifasVehiculos.setTarifasCamion(segundos, tarifa);
                                        break;
                                    default:
                                        break;
                                }

                                break;
                            default:
                                System.out.println();
                                break;
                        }

                        System.out.println("");

                    }while(opcion2 != 9);

                    break;

                case 2:
                    System.out.println("INGRESO DE VEHICULOS");

                    TipoVehiculo tipo = Utilidades.ValidaTipo();
                    int numeroParqueo = parqueo1.getNumeroParqueo(tipo);

                    if (numeroParqueo > 0){

                        String placa = Utilidades.pideString("INGRESE EL NUMERO DE PLACA: ","ERROR: DEBE INGRESAR UN NUMERO DE PLACA VALIDO");

                        switch (tipo.getCodigo()){
                            case "1":
                                parqueo1.agregarVehiculo(new Moto(placa,numeroParqueo,new Date()));
                                break;
                            case "2":
                                parqueo1.agregarVehiculo(new Automovil(placa,numeroParqueo,new Date()));
                                break;
                            case "3":
                                parqueo1.agregarVehiculo(new Camion(placa,numeroParqueo,new Date()));
                                break;
                            default:
                                break;
                        }



                    } else {
                        System.out.println("");
                        System.out.println("ATENCION: NO HAY PARQUEOS DISPONIBLES PARA "+tipo.name());
                        System.out.println("");
                    }

                    break;
                case 3:
                    System.out.println("EGRESO DE VEHICULOS");
                    String placa2 = Utilidades.pideString("INGRESE EL NUMERO DE PLACA: ","ERROR: DEBE INGRESAR UN NUMERO DE PLACA VALIDO");
                    parqueo1.SacaVehiculoParqueo(placa2,true);
                    System.out.println("");
                    break;

                case 4:

                    System.out.println("MOSTRANDO LOS PARQUEOS DISPONIBLES");
                    System.out.println("De Motocicletas hay: " + parqueo1.getMaxParqueoMoto() +" habilitados");
                    System.out.println("De Automoviles hay: " + parqueo1.getMaxParqueoAuto() +" habilitados");
                    System.out.println("De Camiones hay: " + parqueo1.getMaxParqueoCamion() +" habilitados");

                    System.out.println("");
                    System.out.println("MOSTRANDO LAS TARIFAS DE LOS PARQUEOS");
                    System.out.println("Para las motos: "+TarifasVehiculos.getSegundosMoto()+" segundos, con precio de: "+TarifasVehiculos.getTarifaMoto());
                    System.out.println("Para las aumotomoviles: "+TarifasVehiculos.getSegundosAutomovil()+" segundos, con precio de: "+TarifasVehiculos.getTarifaAutomovil());
                    System.out.println("Para las camiones: "+TarifasVehiculos.getSegundosCamion()+" segundos, con precio de: "+TarifasVehiculos.getTarifaCamion());

                    System.out.println();
                    System.out.println("MOSTRANDO LOS VEHICULOS EN EL PARQUEO");
                    parqueo1.MostrarParqueo();

                    //System.out.println("SEGUNDOS: "+TarifaMoto.getSegundos());
                    //System.out.println("PRECIO: "+TarifaMoto.getTarifa());

                    break;

                default:
                    System.out.println();
                    break;
            }


        } while (opcion1 != 9);

        System.out.println("!!! GRACIAS POR USAR EL SISTEMA !!!");

    }

    /**
     * Se muestra en pantalla las opciones principales del Menu
     */
    private static void menuPrincipal(){
        System.out.println("PROYECTO 1");
        System.out.println("\t1. ADMINISTRACION");
        System.out.println("\t2. INGRESO DE VEHICULOS");
        System.out.println("\t3. EGRESO DE VEHICULOS");
        System.out.println("\t4. MOSTRAR VEHICULOS EN EL PARQUEO");
        System.out.println("\t9. SALIR");
    }

    /**
     * Se muestra en pantalla las opciones del menu Administracion
     */
    private static void menuAdministracion(){
        System.out.println("ADMINSITRACION");
        System.out.println("\t1. Definir el numero de Estacionamientos");
        System.out.println("\t2. Definir el precio de Estacionamientos");
        System.out.println("\t9. REGRESAR AL MENU PRINCIPAL");
    }

}
