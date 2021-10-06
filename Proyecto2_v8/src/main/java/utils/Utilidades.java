package utils;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * En esta clase se Metodos que serviran para pedir los distintos tipos
 * de datos a ser ingresados en las clases de vehiculos
 * @author: Pedro Luis de Jesus Hernandez, Angel Magdiel Pineda Cruz
 * @version: 2021/08/31/E
 */

public class Utilidades {

    /**
     * Metodo que solicita al usuario un tipo de vehiculo para
     * validar que exista en el Enumeration de Tipos de Vehiculo
     * Si el tipo de Vehiculo es valido se retorno el tipo de vehiculo
     * @return tipo de vehiculo valido
     */
    public static TipoVehiculo ValidaTipo(){

        TipoVehiculo retornoTipo = null;
        boolean lEncontrado = false;
        Scanner entrada = new Scanner(System.in);


        do{


            try{

                System.out.println("POR FAVOR INGRESE EL TIPO DE VEHICULO: \n"+
                        TipoVehiculo.MOTO.getCodigo()+" PARA "+TipoVehiculo.MOTO.name()+"\n"+
                        TipoVehiculo.AUTOMOVIL.getCodigo()+" PARA "+TipoVehiculo.AUTOMOVIL.name()+"\n"+
                        TipoVehiculo.CAMION.getCodigo()+" PARA "+TipoVehiculo.CAMION.name());

                String texto = entrada.next();

                for (TipoVehiculo tipo: TipoVehiculo.values()){

                    if(tipo.getCodigo().equalsIgnoreCase(texto)){

                        retornoTipo = tipo;

                        lEncontrado = true;
                        break;
                 }

                }

                if(!lEncontrado){
                    System.out.println("");
                    System.out.println("ERROR: POR FAVOR INGRESE UN TIPO DE VEHICULO VALIDO");
                    System.out.println("");
                }


            }
            catch(Exception e){
                System.out.println("");
                System.out.println("SE PRODUJO EL SIGUIENTE ERROR: "+e.getMessage());
                System.out.println("");
            }


        }
        while(!lEncontrado);

        return retornoTipo;

    }

    /**
     * Metodo que pide al usuario el ingreso de un numero double
     * y valida que se ingrese un numero double valido
     * @param mensaje   mensaje que se mostrara al usuario
     * @param error mensaje de error que se mostrara, si hubiera error
     * @return  numero double valido
     */
    public static double pideDouble(String mensaje, String error){
        double nRetorno = 0.00;
        boolean lpedir = true;
        Scanner entrada = new Scanner(System.in);

        while(lpedir){

            try{

                System.out.println(mensaje);
                nRetorno = entrada.nextDouble();
                lpedir = false;

            }
            catch(Exception e){
                System.out.println(error);
                entrada.nextLine();
            }

        }

        return nRetorno;
    }

    /**
     * Metodo que pide al usuario el ingreso de un numero entero
     * y valida que se ingrese un numero entero valido
     * @param mensaje   mensaje que se mostrara al usuario
     * @param error mensaje de error que se mostrara, si hubiera error
     * @return  numero entero valido
     */
    public static int pideInteger(String mensaje, String error){
        int nRetorno = 0;
        boolean lpedir = true;
        Scanner entrada = new Scanner(System.in);

        while(lpedir){

            try{

                System.out.println(mensaje);
                nRetorno = entrada.nextInt();
                lpedir = false;

            }
            catch(Exception e){
                System.out.println(error);
                entrada.nextLine();
            }

        }

        return nRetorno;
    }

    /**
     * Metodo que pide al usuario el ingreso de una cadena string
     * y valida que se ingrese una cadena string valida
     * @param mensaje   mensaje que se mostrara al usuario
     * @param error mensaje de error que se mostrara, si hubiera error
     * @return  cadena string valida
     */
    public static String pideString(String mensaje, String error){
        String cRetorno = "";
        boolean lpedir = true;
        Scanner entrada = new Scanner(System.in);

        while(lpedir){

            try{

                System.out.println(mensaje);

                //cRetorno = entrada.next();

                cRetorno = entrada.nextLine();
                cRetorno = cRetorno.toUpperCase();
                lpedir = false;

            }
            catch(Exception e){
                System.out.println(error);
                entrada.nextLine();
            }

        }

        return cRetorno;
    }

    /**
     * Metodo que pide al usuario el ingreso de un numero de NIT v
     * y valida que el numero de nit sea valido o bien sea C/F
     * @param mensaje   mensaje que se mostrara al usuario
     * @param error mensaje de error que se mostrara, si hubiera error
     * @return  NIT valida
     */
    public static String validaNit(String mensaje, String error){
        String cRetorno = "";
        boolean lValido = false;
        String nitRegExp = "^[0-9]+(-?[0-9kK])?$";
        String cNit = "";

        while(!lValido){

            try{

                cNit = pideString(mensaje,error);

                if(cNit.equalsIgnoreCase("C/F") || cNit.equalsIgnoreCase("CF"))   {
                    lValido = true;
                } else {
                    lValido = Pattern.matches(nitRegExp,cNit);

                }

                if(lValido){
                    cRetorno = cNit.toUpperCase();
                }

            }
            catch(Exception e){
                System.out.println(error);
            }

        }

        return cRetorno;
    }

    /**
     * Metodo que pide al usuario el ingreso de un numero de NIT v
     * y valida que el numero de nit sea valido o bien sea C/F
     * @param cNit nit que se va a validar
     * @return  si el nit es valido
     */
    public static boolean validaNitFac(String cNit){
        boolean lValido = false;
        String nitRegExp = "^[0-9]+(-?[0-9kK])?$";

        //while(!lValido){

            try{

                if(cNit.equalsIgnoreCase("C/F") || cNit.equalsIgnoreCase("CF"))   {
                    lValido = true;
                } else {
                    lValido = Pattern.matches(nitRegExp,cNit);

                }

            }
            catch(Exception e){
                System.out.println(e);
            }

        //}

        return lValido;
    }

}
