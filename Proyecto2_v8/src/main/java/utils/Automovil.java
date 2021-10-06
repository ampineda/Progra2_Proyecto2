package utils;

import java.util.Date;

/**
 * En esta clase se definen las propiedades que tiene un vehiculo de tipo Automovil para
 * ser registrado en un parqueo (en este caso el vehiculo solo puede ser un Automovil)
 * @author: Pedro Luis de Jesus Hernandez, Angel Magdiel Pineda Cruz
 * @version: 2021/08/31/E
 */

public class Automovil extends Vehiculo  {

    /**
     * constructor de la clase Automovil, sin parametros
     */
    public Automovil(){
        super();
    }

    /**
     * Constructor para inicializar las propiedades de un Vehiculo de tipo Automovil
     * @param placa numero de placa del Automovil
     * @param numeroParqueo numero de parqueo asignado al Automovil
     * @param fecha fecha de ingreso del Automovil al parqueo
     * @param tari  tarifa para aplicar al parqueo del Automovil
     */
    /*
    public Automovil(String placa, int numeroParqueo,Date fecha,Tarifas tari){

        super(placa, TipoVehiculo.AUTOMOVIL, tari,numeroParqueo,fecha);

    }
    */

    /**
     * se calcula el total de la factura por parqueo
     * @param segundosPorCobrar     cantidad de segundos que se deben calcular
     * @return                      el total que se va a cobrar
     */
    @Override
    public double calculaTotal(float segundosPorCobrar) {
        double retorno = 0.00;


        return retorno;
    }

    /**
     * se calcula el recargo de la factura por parqueo
     * @param segundosPorCobrar     cantidad de segundos que se deben calcular
     * @return                      el recargo que se va a cobrar
     */
    @Override
    public double calculaRecargo(float segundosPorCobrar) {
        return 0.00;
    }

    /**
     * se calcula el descuento de la factura por parqueo
     * @param subTotal      cantidad de segundos que se deben cobrar
     * @return              el descuento que se va a realizar sobre el total
     */
    @Override
    public double calculaDescuento(double subTotal) {
        return 0.00;
    }

    /**
     * Contructor para inicializar las propiedades de un Vehiculo de tipo Automovil
     * @param placa numero de placa del Automovil
     * @param numeroParqueo numero de parqueo asignado al Automovil
     * @param fecha fecha de ingreso del Automovil al parqueo
     */
    public Automovil(String placa, int numeroParqueo,Date fecha){

        super(placa, TipoVehiculo.AUTOMOVIL, TarifasVehiculos.getSegundosAutomovil(),TarifasVehiculos.getTarifaAutomovil(),numeroParqueo,fecha);
    }

}
