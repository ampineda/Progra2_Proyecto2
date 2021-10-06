package utils;

import java.util.Date;
/**
 * En esta clase se definen las propiedades que tiene un vehiculo para
 * ser registrado en un parqueo (el vehiculo puede ser un Automovil, Una Moto o un Camion
 * @author: Pedro Luis de Jesus Hernandez, Angel Magdiel Pineda Cruz
 * @version: 2021/08/31/E
 */

public class Vehiculo {

    // Atributos de la clase
    private String placa;
    private TipoVehiculo tipo;
    private int numeroParqueo;
    private Date fechaIngreso;
    private Date fechaSalida;
    //private Tarifas tarifa;
    private int tarifaTiempo;
    private double tarifaPrecio;

    /**
     * Contructor de la clase sin parametros
     */
    public Vehiculo(){

    }


    /**
     * Contructor para inicializar las propiedades que tendra el vehiculo
     * @param placa numero de placa de vehiculo
     * @param tipo  tipo de vehiculo (Automovil, Moto, Camion)
     * @param tarifa    tarifa aplicada al vehiculo
     * @param numeroParqueo numero de parqueo asignado al vehiculo
     * @param fecha fecha de ingrese al parqueo
     */
    /*
    public Vehiculo(String placa, TipoVehiculo tipo,Tarifas tarifa,int numeroParqueo, Date fecha) {
        this.placa = placa;
        this.tipo = tipo;
        this.tarifa = tarifa;
        this.numeroParqueo = numeroParqueo;
        this.fechaIngreso = fecha;
    }
    */

    /**
     *
     * @param placa numero de placa del vehiculo
     * @param tipo  tipo de vehiculo (Automovil, Moto, Camion)
     * @param segundos  base de calculo para los segundos que este en el parqueo
     * @param precio    precio del periodo de segundos
     * @param numeroParqueo numero de parqueo asignado al vehiculo
     * @param fecha fecha de ingrese al parqueo
     */
    public Vehiculo(String placa, TipoVehiculo tipo,int segundos, double precio ,int numeroParqueo, Date fecha) {
        this.placa = placa;
        this.tipo = tipo;
        this.tarifaTiempo = segundos;
        this.tarifaPrecio = precio;
        this.numeroParqueo = numeroParqueo;
        this.fechaIngreso = fecha;
    }

    //Metodos

    /**
     * se calcula el total de la factura por parqueo
     */
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
     * se calcula el descuento de la factura por parqueo
     */
    public double calculaDescuento(double subTotal){
        return 0.00;
    }

    /**
     * se calcula el recargo de la factura por parqueo
     */
    public double calculaRecargo(float segundosPorCobrar){
        return 0.00;
    }

    public int getTarifaTiempo() {
        return tarifaTiempo;
    }

    public void setTarifaTiempo(int tarifaTiempo) {
        this.tarifaTiempo = tarifaTiempo;
    }

    public double getTarifaPrecio() {
        return tarifaPrecio;
    }

    public void setTarifaPrecio(double tarifaPrecio) {
        this.tarifaPrecio = tarifaPrecio;
    }

    /**
     * Metodo que devuelve el numero de placa
     * @return  el numero de placa
     */
    public String getPlaca() {

        return placa;
    }

    /**
     * se asigna el numero de placa
     * @param placa numero de placa
     */
    public void setPlaca(String placa) {

        this.placa = placa;
    }

    /**
     * se retorno a el tipo de vehiculo
     * @return  tipo de vehiculo
     */
    public TipoVehiculo getTipo() {

        return tipo;
    }

    /**
     * se asigna el tipo de vehiculo
     * @param tipo  de vehiculo
     */
    public void setTipo(TipoVehiculo tipo) {

        this.tipo = tipo;
    }

    /**
     * se obtiene la tarifa
     * @return tarifa.getTarifa()
     */
    /*
    public double getTarifa() {

        return this.tarifa.getTarifa();
    }
    */

    /**
     * se obiene la base de calculo para los segundos
     * @return  tarifa.getSegundos()
     */
    /*
    public int getSegundos(){


        return this.tarifa.getSegundos();

    }
    */

    /**
     * se asigna la tarifa
     * @param tarifa tarifa
     */
    /*
    public void setTarifa(Tarifas tarifa) {
        this.tarifa = tarifa;
    }
    */


    /**
     * se obtiene el numero de parqueo asignado al vehiculo
     * @return numeroParqueo
     */
    public int getNumeroParqueo() {
        return numeroParqueo;
    }

    /**
     * se asigna el numero de parqueo
     * @param ticket  numero de parqueo
     */
    public void setNumeroParqueo(int ticket) {
        this.numeroParqueo = ticket;
    }

    /**
     * se obtiene la fecha de ingresdo del vehiculo
     * @return fechaIngreso
     */
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * se asigna la fecha de ingreso del vehiculo
     * @param fechaIngreso  fecha ingreso del vehiculo
     */
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * se obtiene la fecha de salida de vehiculo
     * @return  fechasalida fecha de salida del vehiculo
     */
    public Date getFechaSalida() {
        return fechaSalida;
    }

    /**
     * se asigna la fecha de salida del vehiculo
     * @param fechaSalida   fecha de salida del vehiculo
     */
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**
     * se obtienen los valores de la propiedades de la clase vehiculo
     * @return cadena de texto con todos los valoresd de la clase vehiculo
     */
    @Override
    public String toString() {
        return "este es un Vehiculo prueba {" + "placa=" + this.placa
                + ", tipo=" + this.tipo.name()
                + ", segundos=" + this.tarifaTiempo
                + ", tarifa=" + this.tarifaPrecio
                + ", fecha=" + this.fechaIngreso
                + ", numero parqueo=" + this.numeroParqueo + '}';
    }

}
