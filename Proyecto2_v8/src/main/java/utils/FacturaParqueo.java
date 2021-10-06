package utils;

/**
 * En esta clase se definen las propiedades que tiene la Factura de Parqueo para
 * registrar las datos que pueden ser utiles en el calculo de los totales
 * @author: Pedro Luis de Jesus Hernandez, Angel Magdiel Pineda Cruz
 * @version: 2021/10/06/E
 */

public class FacturaParqueo {

    static String nit ="";
    static String nombreCliente = "";
    static String numeroParqueo = "";
    static String fechaIngreso = "";
    static String fechaSalida = "";
    static String nombreTipoVehiculo = "";
    static String numeroPlaca = "";
    static float  tiempoParqueo = 0;
    static double subTotal = 0.00;
    static double descuento = 0.00;
    static double recargo = 0.00;
    static double total = 0.00;
    static double tarifaPorPeriodo = 0.00;
    static double periodosPorCobrar = 0.00;
    static double periodosExtraPorCobrar = 0.00;

    public static double getTarifaPorPeriodo() {
        return tarifaPorPeriodo;
    }

    public static void setTarifaPorPeriodo(double tarifaPorPeriodo) {
        FacturaParqueo.tarifaPorPeriodo = tarifaPorPeriodo;
    }

    public static double getPeriodosPorCobrar() {
        return periodosPorCobrar;
    }

    public static void setPeriodosPorCobrar(double periodosPorCobrar) {
        FacturaParqueo.periodosPorCobrar = periodosPorCobrar;
    }

    public static double getPeriodosExtraPorCobrar() {
        return periodosExtraPorCobrar;
    }

    public static void setPeriodosExtraPorCobrar(double periodosExtraPorCobrar) {
        FacturaParqueo.periodosExtraPorCobrar = periodosExtraPorCobrar;
    }

    public static String getNumeroPlaca() {
        return numeroPlaca;
    }

    public static void setNumeroPlaca(String numeroPlaca) {
        FacturaParqueo.numeroPlaca = numeroPlaca;
    }

    public FacturaParqueo() {
    }

    public static String getNit() {
        return nit;
    }

    public static void setNit(String nit) {
        FacturaParqueo.nit = nit;
    }

    public static String getNombreCliente() {
        return nombreCliente;
    }

    public static void setNombreCliente(String nombreCliente) {
        FacturaParqueo.nombreCliente = nombreCliente;
    }

    public static String getNumeroParqueo() {
        return numeroParqueo;
    }

    public static void setNumeroParqueo(String numeroParqueo) {
        FacturaParqueo.numeroParqueo = numeroParqueo;
    }

    public static String getFechaIngreso() {
        return fechaIngreso;
    }

    public static void setFechaIngreso(String fechaIngreso) {
        FacturaParqueo.fechaIngreso = fechaIngreso;
    }

    public static String getFechaSalida() {
        return fechaSalida;
    }

    public static void setFechaSalida(String fechaSalida) {
        FacturaParqueo.fechaSalida = fechaSalida;
    }

    public static String getNombreTipoVehiculo() {
        return nombreTipoVehiculo;
    }

    public static void setNombreTipoVehiculo(String nombreTipoVehiculo) {
        FacturaParqueo.nombreTipoVehiculo = nombreTipoVehiculo;
    }

    public static float getTiempoParqueo() {
        return tiempoParqueo;
    }

    public static void setTiempoParqueo(float tiempoParqueo) {
        FacturaParqueo.tiempoParqueo = tiempoParqueo;
    }

    public static double getSubTotal() {
        return subTotal;
    }

    public static void setSubTotal(double subTotal) {
        FacturaParqueo.subTotal = subTotal;
    }

    public static double getDescuento() {
        return descuento;
    }

    public static void setDescuento(double descuento) {
        FacturaParqueo.descuento = descuento;
    }

    public static double getRecargo() {
        return recargo;
    }

    public static void setRecargo(double recargo) {
        FacturaParqueo.recargo = recargo;
    }

    public static double getTotal() {
        return total;
    }

    public static void setTotal(double total) {
        FacturaParqueo.total = total;
    }
}
