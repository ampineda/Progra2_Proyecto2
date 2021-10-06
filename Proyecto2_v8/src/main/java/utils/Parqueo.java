package utils;

import java.text.DateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * En esta clase se definen las propiedades que tiene un Parqueo para
 * registrar los vehiculos que le sean enviados, asi como la capacidad
 * maxima de parqueos para Automoviles, Motos y Camiones
 * @author: Pedro Luis de Jesus Hernandez, Angel Magdiel Pineda Cruz
 * @version: 2021/08/31/E
 */
public class Parqueo {
  // atributos de la clase
  private static ArrayList<Vehiculo> miParqueo = new ArrayList<Vehiculo>();
  private static int maxParqueoAuto;
  private static int maxParqueoMoto;
  private static int maxParqueoCamion;
  private static int numeroParqueo = 0;
  private static double ventaDiaria = 0.00;

    /**
     * Retorna el total de ventas diarias asignado
     * @return
     */
    public static double getVentaDiaria() {
        return ventaDiaria;
    }

    /**
     * incrementa el total de ventas diario
     * @param ventaDiaria1  total de ventas diario a asignar
     */
    public static void setVentaDiaria(double ventaDiaria1) {

        Parqueo.ventaDiaria = ventaDiaria1;

    }

    /**
   * Contructor de la clase sin parametros
   */
  public Parqueo(){
    this.maxParqueoAuto = 0;
    this.maxParqueoMoto = 0;
    this.maxParqueoCamion = 0;
  }

  /**
   * Metodo para agregar un vehiculo de cualquier tipo y
   * Imprime el Ticket de Parqueo
   * a la lista de espacios disponibles en el parqueo
   * @param vehi  Vehiculo que se va a gregar al parqueo
   */
   public static void agregarVehiculo(Vehiculo vehi){

       miParqueo.add(vehi);

       DateFormat formateadorFechaLarga = DateFormat.getDateInstance(DateFormat.LONG);
       DateFormat formateadorHoraMedia  = DateFormat.getTimeInstance(DateFormat.MEDIUM);
       String fechaIng = formateadorFechaLarga.format(vehi.getFechaIngreso())+" "+formateadorHoraMedia.format(vehi.getFechaIngreso());

       String[] imprime = new String[6];
       imprime[0] = "----- TICKET DE PARQUEO -----";
       imprime[1] = "\n";
       imprime[2] = "NUMERO DE PARQUEO: "+String.format("%03d",vehi.getNumeroParqueo());
       imprime[3] = vehi.getTipo().name()+" PLACA: "+vehi.getPlaca();
       imprime[4] = "FECHA DE INGRESO: "+fechaIng;
       imprime[5] = "TARIFA: Q. "+vehi.getTarifaPrecio()+" por cada "+vehi.getTarifaTiempo()+" segundos";

       /*
       System.out.println("");
       System.out.println("Imprimiendo el Ticket de Parqueo. Espere un momento por favor...");
       */

       MiMensaje.MuestraMensaje("Espere un momento por favor...","El Vehiculo se ha ingresado al Parqueo. " +
                                      "Ahora Imprimiendo el Ticket de Parqueo");

       ImprimePdf.imprime(imprime,"Ticket");

       ///MiMensaje.MuestraMensaje("Atencion",rutaPdf);

       //System.out.println("");

   }

   /**
    * se valida si el numero de placa existe en el parqueo
    */
   public static boolean VehiculoExisteParqueo(String placa){
       boolean existeVehiculo = false;
       int nSize = 0;

       nSize = miParqueo.size();
       Vehiculo movil = new Vehiculo();

       if(nSize>0){

           for(int i=0;i<nSize;i++){

               movil = miParqueo.get(i);

               if(movil.getPlaca().equalsIgnoreCase(placa)){
                   existeVehiculo = true;
                   break;
               }

           }

       }

       return existeVehiculo;
   }

  /**
   * En este metodo se obtiene el numero maximo de parqueos de Automoviles
   * @return maxParqueoAuto numero de parqueos asignados a los automoviles
   */
    public static int getMaxParqueoAuto() {

      return maxParqueoAuto;

    }

  /**
   * En este metodo asigna el numero maximo de parqueos de Automoviles
   * @param maxParqueoAuto1 numero de parqueos asignados a los automoviles
   */
  public static void setMaxParqueoAuto(int maxParqueoAuto1) {

      maxParqueoAuto = maxParqueoAuto1;

    }

  /**
   * En este metodo se obtiene el numero maximo de parqueos de Motos
   * @return  numero de parqueos asignados a las Motos
   */
    public static int getMaxParqueoMoto() {

      return maxParqueoMoto;

    }

  /**
   * En este metodo asigna el numero maximo de parqueos de Motos
   * @param maxParqueoMoto1 numero de parqueos asignados a las Motos
   */
  public static void setMaxParqueoMoto(int maxParqueoMoto1) {

        maxParqueoMoto = maxParqueoMoto1;

    }

  /**
   * En este metodo se obtiene el numero maximo de parqueos de Camiones
   * @return numero de parqueos asignados a los Camiones
   */
  public static int getMaxParqueoCamion() {

      return maxParqueoCamion;

    }

  /**
   * En este metodo asigna el numero maximo de parqueos de Camiones
   * @param maxParqueoCamion1 numero de parqueos asignados a los Camiones
   */
  public static void setMaxParqueoCamion(int maxParqueoCamion1) {

      maxParqueoCamion = maxParqueoCamion1;

    }

  /**
   * Metodo que devuelve un numero de parqueo disponible para el tipo
   * de vehiculo indicado (Automovil, Moto o Camion)
   * si no hubiera disponible un parqueo para el tipo de vehiculo
   * se devuelve el numero -1
   * @param tipoParqueo tipo de vehiculo que se quiere el parqueo
   * @return numero de parqueo asignado al vehiculo
   */
  public static int getNumeroParqueo(TipoVehiculo tipoParqueo){
      int nRetorno = 0;

      String tipoSolicitado = tipoParqueo.getCodigo();

      numeroParqueo = 1;

      miParqueo.forEach((movil) -> {

        String tipoActual = movil.getTipo().getCodigo();
        int numeroActual = movil.getNumeroParqueo();

        if(tipoSolicitado.equalsIgnoreCase(tipoActual) ){


          if(numeroParqueo == numeroActual){
            numeroParqueo = numeroParqueo+1;
          }

        }

      });


      switch (tipoSolicitado){
        case "1":

          if(numeroParqueo<=maxParqueoMoto){
            nRetorno = numeroParqueo;
          } else{
            nRetorno = -1;
          }

          break;
        case "2":
          if(numeroParqueo<=maxParqueoAuto){
            nRetorno = numeroParqueo;
          } else{
            nRetorno = -1;
          }

          break;
        case "3":
          if(numeroParqueo<=maxParqueoCamion){
            nRetorno = numeroParqueo;
          } else{
            nRetorno = -1;
          }

          break;
      }


      return nRetorno;
    }


  /**
   * Este metodo recorre los vehiculos que esten en el parqueo
   * y muestra en pantalla la informacion de cada vehiculo
   */
  public static void MostrarParqueo(){
        miParqueo.forEach((movil) -> {
            System.out.println(movil);
        });
    }

  /**
   * Este metodo saca un Vehiculo del parqueo y
   * Imprime la factura por el parqueo
   * para esto recorre toda la lista de vehiculos y busca
   * el numero de placa, si lo encuentra lo saca del parqueo
   * @param placa numero de placa
   */
  public static void SacaVehiculoParqueo(String placa,boolean imprimirFactura){

      int nEliminar = -1;
      int nSize = 0;

      nSize = miParqueo.size();
      Vehiculo movil = new Vehiculo();

      if(nSize>0){

        for(int i=0;i<nSize;i++){

          movil = miParqueo.get(i);

          if(movil.getPlaca().equalsIgnoreCase(placa)){
            nEliminar = i;
            break;
          }

        }

      }

      if(nEliminar>=0){
        //System.out.println("el vehiculo es: "+movil.toString());
        miParqueo.remove(nEliminar);

        // Calculo de la tarifa a pagar
        Date fechaSalida = new Date();
        float segundosCobrar = (float) ((fechaSalida.getTime()/1000) - (movil.getFechaIngreso().getTime()/1000));

        //System.out.println("pasaron "+segundosCobrar+" cantidad de segundos entre una fecha y otra");

        // calculo de tarifas
        TipoVehiculo tipo = movil.getTipo();

        /*
        int segundosPorPeriodo = 0;
        double tarifaPorPeriodo = 0.00;
        double periodosPorCobrar = 0.00;
        double periodosExtra = 0.00;
         */

        double subTotal = 0.00;
        double descuento = 0.00;
        double recargo = 0.00;
        double total = 0.00;

        if(movil instanceof Moto) {
            Moto at = (Moto) movil;
            subTotal = at.calculaTotal(segundosCobrar);
            descuento = at.calculaDescuento(subTotal);
            recargo = at.calculaRecargo(segundosCobrar);
        }

        if(movil instanceof Automovil) {
            Automovil at = (Automovil) movil;
            subTotal = at.calculaTotal(segundosCobrar);
            descuento = at.calculaDescuento(subTotal);
            recargo = at.calculaRecargo(segundosCobrar);
        }

        if(movil instanceof Camion) {
            Camion at = (Camion) movil;
            subTotal = at.calculaTotal(segundosCobrar);
            descuento = at.calculaDescuento(subTotal);
            recargo = at.calculaRecargo(segundosCobrar);
        }

        /*
        segundosPorPeriodo = movil.getTarifaTiempo();
        tarifaPorPeriodo = movil.getTarifaPrecio();

        if(segundosPorPeriodo > 0){
           periodosPorCobrar = (segundosCobrar/segundosPorPeriodo);
        }

        subTotal = periodosPorCobrar * tarifaPorPeriodo;

          switch (tipo.getCodigo()){
              case "1":
                  descuento = subTotal * 0.10;
                  break;
              case "2":

                  break;
              case "3":

                  periodosExtra = periodosPorCobrar - 1;

                  if(periodosExtra>0.00){
                      recargo = periodosExtra * 5.00;
                  }

                  break;
              default:
                  break;
          }
          */

              total = (subTotal + recargo) - descuento;

              DateFormat formateadorFechaLarga = DateFormat.getDateInstance(DateFormat.LONG);
              DateFormat formateadorHoraMedia  = DateFormat.getTimeInstance(DateFormat.MEDIUM);
              String fechaIng = formateadorFechaLarga.format(movil.getFechaIngreso())+" "+formateadorHoraMedia.format(movil.getFechaIngreso());
              String fechaSal = formateadorFechaLarga.format(fechaSalida)+" "+formateadorHoraMedia.format(fechaSalida);

              String[] imprime = new String[19];
              imprime[0] = "--- FACTURA ---";
              imprime[1] = "\n";
              imprime[2] = "NIT: "+FacturaParqueo.getNit();
              imprime[3] = "CLIENTE: "+FacturaParqueo.getNombreCliente();
              imprime[4] = "NUMERO DE PARQUEO: "+String.format("%03d",movil.getNumeroParqueo());
              imprime[5] = "FECHA DE INGRESO: "+fechaIng;
              imprime[6] = "FECHA DE SALIDA:    "+fechaSal;
              imprime[7] = TipoVehiculo.MOTO.name()+" PLACA: "+placa;
              imprime[8] = "\n";
              imprime[9] = "--- RESUMEN DE LA FACTURA ---";
              imprime[10] = "TIEMPO TOTAL EN EL PARQUEO: "+segundosCobrar+" segundos";
              imprime[11] = "\n";

              imprime[12] = "PERIODOS A COBRAR: "+String.format("%.2f", FacturaParqueo.getPeriodosPorCobrar());
              imprime[13] = "TARIFA POR PERIODO: "+String.format("%.2f", FacturaParqueo.getTarifaPorPeriodo());
              imprime[14] = "\n";

              imprime[15] = "SUB-TOTAL  (+): "+String.format("%.2f", subTotal);
              imprime[16] = "RECARGO    (+): "+String.format("%.2f", recargo);
              imprime[17] = "DESCUENTOS (-): "+String.format("%.2f", descuento);
              imprime[18] = "TOTAL:          "+String.format("%.2f", total);

              /*
              FacturaParqueo.setNumeroParqueo(String.format("%03d",movil.getNumeroParqueo()));
              FacturaParqueo.setFechaSalida(fechaSalida.toString());
              FacturaParqueo.setFechaIngreso(movil.getFechaIngreso().toString());
              FacturaParqueo.setNombreTipoVehiculo(TipoVehiculo.MOTO.name());
              FacturaParqueo.setNumeroPlaca(placa);
              FacturaParqueo.setTiempoParqueo(segundosCobrar);
              FacturaParqueo.setSubTotal(subTotal);
              FacturaParqueo.setRecargo(recargo);
              FacturaParqueo.setDescuento(descuento);
              FacturaParqueo.setTotal(total);
              */

          // Asignamos el total de ventas
          setVentaDiaria( (total + getVentaDiaria()) );

          MiMensaje.MuestraMensaje(" Atencion","El vehiculo se saco del parqueo exitosamente");

          //System.out.println("Imprimiendo la Factura. Espere un momento por favor...");
          if(imprimirFactura){
              MiMensaje.MuestraMensaje("Atencion","Imprimiendo la Factura. Espere un momento por favor...");
              ImprimePdf.imprime(imprime,"Factura");
          }

          // System.out.println("");

      } else {

          //System.out.println("ERROR: NO SE ENCONTRO UN VEHICULO CON EL NUMERO DE PLACA "+placa);
          MiMensaje.MuestraMensaje("ERROR","NO SE ENCONTRO UN VEHICULO CON EL NUMERO DE PLACA "+placa);

      }

    }

    /**
     * calcula  el numero de parqueos disponible y los devuelve formateados
     * para su impresion en pantalla
     * @return  una cadena de texto con los parqueos disponibles formatedo para su impresion
     */
    public static String ParqueosDisponibles(){

        int[] usados = new int[3];

        miParqueo.forEach((movil) -> {

            String tipoActual = movil.getTipo().getCodigo();

            switch (tipoActual){
                case "1":
                    usados[0] = usados[0] + 1;
                    break;
                case "2":
                    usados[1] = usados[1] + 1;
                    break;
                case "3":
                    usados[2] = usados[2] + 1;
                    break;
            }

        });

        String retorno = "Parqueo de Motos:     "+"\n"+(maxParqueoMoto-usados[0])  +" disponibles de "+maxParqueoMoto+"\n"+"\n"+
                         "Parqueo de Automoviles: "+"\n"+(maxParqueoAuto-usados[1])  +" disponibles de "+maxParqueoAuto+"\n"+"\n"+
                         "Parqueo de Camiones:    "+"\n"+(maxParqueoCamion-usados[2])+" disponibles de "+maxParqueoCamion;


        /*
        String retorno = "ESTADO DEL PARQUEO"+"\n"+"\n"+
                         "Parqueo de Motos:     "+"\n"+(maxParqueoMoto-usados[0])  +" disponibles de "+maxParqueoMoto+"\n"+"\n"+
                         "Parqueo de Automoviles: "+"\n"+(maxParqueoAuto-usados[1])  +" disponibles de "+maxParqueoAuto+"\n"+"\n"+
                         "Parqueo de Camiones:    "+"\n"+(maxParqueoCamion-usados[2])+" disponibles de "+maxParqueoCamion;

        */

        /*
        String retorno1[] = new String[4];
        retorno1[0] = "Estado del Parqueo"+"\n";
        retorno1[1] = "Parqueo de MOTOS:     "+(maxParqueoMoto-usados[0])  +" disponibles de "+maxParqueoMoto+"\n";
        retorno1[2] = "Parqueo de AUTOMOVIL: "+(maxParqueoAuto-usados[1])  +" disponibles de "+maxParqueoAuto+"\n";
        retorno1[3] = "Parqueo de CAMION:    "+(maxParqueoCamion-usados[2])+" disponibles de "+maxParqueoCamion;

        String.format()
        */

        return retorno;
    }

    /**
     * calcula  el total de ventas del dia losdevuelve
     * para su impresion en pantalla
     * @return  una cadena de texto con el total de ventas formatedo para su impresion
     */
    public static String VentaDiaria(){
        String retorno = "";

        Date fechaSalida = new Date();
        DateFormat formateadorFechaLarga = DateFormat.getDateInstance(DateFormat.LONG);
        String fechaSal = formateadorFechaLarga.format(fechaSalida);

        /*
        retorno = "TOTAL DE VENTAS DEL DIA"+"\n"+"\n"+
                "Fecha: "+fechaSal+"\n"+"\n"+
                "Se ha vendido un total de: Q. "+String.format("%10.2f",getVentaDiaria());
        */

        retorno = "Fecha: "+fechaSal+"\n"+"\n"+
                  "Se ha vendido un total de: Q. "+String.format("%10.2f",getVentaDiaria());

      return retorno;
    }




}



