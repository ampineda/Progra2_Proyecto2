package utils;

/**
 * En esta clase se definen las tarifas que pueden tener los 3 tipos de vehiculos
 * usados en este proyecto (Moto, Automovil, Camion)
 * las tarifas se indican en segundos y dinero, es decir
 * los segundos se usan para calcular los periodos que
 * un vehiculo estuvo en el parqueo
 * y la tarifa se usa para calcular el monto en dinero que se
 * debe cobrar por el tiempo que paso el vehiculo en el parqueo
 * @author: Pedro Luis de Jesus Hernandez, Angel Magdiel Pineda Cruz
 * @version: 2021/08/31/E
 */

public class TarifasVehiculos {

    // atributos de la clase
    private static int segundosAutomovil;
    private static double tarifaAutomovil;
    private static int segundosMoto;
    private static double tarifaMoto;
    private static int segundosCamion;
    private static double tarifaCamion;

    /**
     * Contructor de la clase, sin parametros
     */
    public TarifasVehiculos(){
        segundosAutomovil = 0;
        segundosMoto = 0;
        segundosCamion = 0;
        tarifaAutomovil=0.0;
        tarifaMoto=0.0;
        tarifaCamion=0.0;
    }

    /**
     * Metodo que asigna las tarifas de un Automovil
     * @param segundosAuto1 segundos por periodo a cobrar
     * @param tarifaAuto1   precio por cada periodo de segundos
     */
    public static void setTarifasAutomovil(int segundosAuto1,double tarifaAuto1){
        segundosAutomovil = segundosAuto1;
        tarifaAutomovil=tarifaAuto1;
    }

    /**
     * Metodo que asigna las tarifas de una moto
     * @param segundosMoto1 segundos por periodo a cobrar
     * @param tarifaMoto1   precio por cada periodo de segundos
     */
    public static void setTarifasMoto(int segundosMoto1,double tarifaMoto1){
        segundosMoto = segundosMoto1;
        tarifaMoto=tarifaMoto1;
    }

    /**
     * Metodo que asigna las tarifas de un camion
     * @param segundosCamion1   segundos por periodo a cobrar
     * @param tarifaCamion1     precio por cada periodo de segundos
     */
    public static void setTarifasCamion(int segundosCamion1,double tarifaCamion1){
        segundosCamion = segundosCamion1;
        tarifaCamion=tarifaCamion1;
    }

    /**
     * Metod que recupera los segundos por periodo a cobrar para un Automovil
     * @return  segundos por periodo a cobrar
     */
    public static int getSegundosAutomovil() {

        return segundosAutomovil;

    }

    /**
     * Metod que recupera los segundos por periodo a cobrar para un Automovil
     * @return  segundos por periodo a cobrar
     */
    public static double getTarifaAutomovil() {

        return tarifaAutomovil;

    }

    /**
     * Metod que recupera los segundos por periodo a cobrar para un Automovil
     * @return  segundos por periodo a cobrar
     */
    public static int getSegundosMoto() {

        return segundosMoto;

    }

    /**
     * Metod que recupera los segundos por periodo a cobrar para un Automovil
     * @return  segundos por periodo a cobrar
     */
    public static double getTarifaMoto() {

        return tarifaMoto;

    }

    /**
     * Metod que recupera los segundos por periodo a cobrar para un Camion
     * @return  segundos por periodo a cobrar
     */
    public static int getSegundosCamion() {

        return segundosCamion;

    }

    /**
     * Metod que recupera la tarifa en dinero por periodo de segundos a cobrar para un Automovil
     * @return  tarifa en dinero a cobrar por periodo a cobrar
     */
    public static double getTarifaCamion() {
        return tarifaCamion;
    }

}
