package utils;

public enum TipoVehiculo {

    MOTO("1"),
    AUTOMOVIL("2"),
    CAMION("3");

    private String codigo;

    TipoVehiculo(String codigo){

        this.codigo = codigo;

    }

    TipoVehiculo(int a){
        System.out.println(a);
    }

    public String getCodigo() {

        return codigo;

    }

}
