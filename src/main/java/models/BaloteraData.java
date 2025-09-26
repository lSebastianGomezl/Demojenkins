package models;

public class BaloteraData {

    private String nombre;
    private String rangoInicio;
    private String rangoFin;
    private String tipo; // opcional: si no se envía, se toma la primera opción

    public BaloteraData(String nombre, String rangoInicio, String rangoFin, String tipo) {
        this.nombre = nombre;
        this.rangoInicio = rangoInicio;
        this.rangoFin = rangoFin;
        this.tipo = tipo;
    }

    public static BaloteraData of(String nombre, String rangoInicio, String rangoFin, String tipo) {
        return new BaloteraData(nombre, rangoInicio, rangoFin, tipo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRangoInicio() {
        return rangoInicio;
    }

    public void setRangoInicio(String rangoInicio) {
        this.rangoInicio = rangoInicio;
    }

    public String getRangoFin() {
        return rangoFin;
    }

    public void setRangoFin(String rangoFin) {
        this.rangoFin = rangoFin;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
