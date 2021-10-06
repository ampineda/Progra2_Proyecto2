package utils;

import java.util.Date;

/**
 * En esta clase se definen las propiedades que tiene un vehiculo de tipo Moto para
 * ser registrado en un parqueo (en este caso el vehiculo solo puede ser una Moto)
 * @author: Pedro Luis de Jesus Hernandez, Angel Magdiel Pineda Cruz
 * @version: 2021/08/31/E
 */

public class Moto extends Vehiculo{

    /**
     * constructor de la clase Automovil, sin parametros
     */
    public Moto(){

        super();

    }

    /**
     * Constructor para inicializar las propiedades de un Vehiculo de tipo Moto
     * @param placa numero de placa de la moto
     * @param numeroParqueo numero de parqueo asignado a la moto
     * @param fecha fecha de ingreso de la moto al parqueo
     * @param tari  tarifa para aplicar al parqueo de la moto
     */
    /*
    public Moto(String placa, int numeroParqueo,Date fecha, Tarifas tari){

        super(placa, TipoVehiculo.MOTO, tari,numeroParqueo,fecha);
    }
    */

    /**
     * se calcula el total de la factura por parqueo
     * @param segundosPorCobrar     cantidad de segundos que se deben calcular
     * @return                      el total que se va a cobrar
     */
    @Override
    public double calculaTotal(float segundosPorCobrar){
        double retorno = 0.00;
        double periodosPorCobrar = 0.00;

        if(this.getTarifaTiempo() > 0){
            periodosPorCobrar = (segundosPorCobrar/this.getTarifaTiempo());
        }

        retorno = periodosPorCobrar *  this.getTarifaPrecio() ;

        FacturaParqueo.setTarifaPorPeriodo(this.getTarifaPrecio());
        FacturaParqueo.setPeriodosPorCobrar(periodosPorCobrar);

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
    public double calculaDescuento(double subTotal) {
        double descuento = 0.00;

        descuento = subTotal * 0.10;

        return descuento;
    }

    /**
     * Contructor para inicializar las propiedades de un Vehiculo de tipo Moto
     * @param placa numero de placa de la moto
     * @param numeroParqueo numero de parqueo asignado a la Moto
     * @param fecha fecha de ingreso de la Moto al parqueo
     */
    public Moto(String placa, int numeroParqueo,Date fecha){

        super(placa, TipoVehiculo.MOTO, TarifasVehiculos.getSegundosMoto(), TarifasVehiculos.getTarifaMoto(),numeroParqueo,fecha);
    }

}
