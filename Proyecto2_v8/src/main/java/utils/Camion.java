package utils;

import java.util.Date;

/**
 * En esta clase se definen las propiedades que tiene un vehiculo de tipo Camion para
 * ser registrado en un parqueo (en este caso el vehiculo solo puede ser un Camion)
 * @author: Pedro Luis de Jesus Hernandez, Angel Magdiel Pineda Cruz
 * @version: 2021/08/31/E
 */

public class Camion extends Vehiculo {

    /**
     * constructor de la clase Automovil, sin parametros
     */
    public Camion(){

        super();

    }

    /**
     * Constructor para inicializar las propiedades de un Vehiculo de tipo Camion
     * @param placa numero de placa del Camion
     * @param numeroParqueo numero de parqueo asignado al Camion
     * @param fecha fecha de ingreso del Camion al parqueo
     * @param tari  tarifa para aplicar al parqueo del Camion
     */
    /*
    public Camion(String placa, int numeroParqueo,Date fecha, Tarifas tari){

        super(placa, TipoVehiculo.CAMION, tari,numeroParqueo,fecha);

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
    public double calculaRecargo(float segundosPorCobrar) {
        double periodosPorCobrar = 0.00;
        double periodosExtra = 0.00;
        double recargo = 0.00;

        if(this.getTarifaTiempo() > 0){
            periodosPorCobrar = (segundosPorCobrar/this.getTarifaTiempo());
        }

        periodosExtra = periodosPorCobrar - 1;

        if(periodosExtra>0.00){
            recargo = periodosExtra * 5.00;
        }

        return recargo  ;
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
     * Contructor para inicializar las propiedades de un Vehiculo de tipo Camion
     * @param placa numero de placa del Camion
     * @param numeroParqueo numero de parqueo asignado al Camion
     * @param fecha fecha de ingreso del Camion al parqueo
     */
    public Camion(String placa, int numeroParqueo,Date fecha){

        super(placa, TipoVehiculo.CAMION, TarifasVehiculos.getSegundosCamion(), TarifasVehiculos.getTarifaCamion(),numeroParqueo,fecha);
    }



}
