package models;

public class PlanDeResultadosData {
    private String nombre;
    private String descripcion;
    private String cantidadResultados;
    private String tipoPlan;
    private String tiempoRetardo;
    private boolean activarVisualizador;


    public PlanDeResultadosData(String nombre, String descripcion, String cantidadResultados, String tipoPlan, String tiempoRetardo, boolean activarVisualizador) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidadResultados = cantidadResultados;
        this.tipoPlan = tipoPlan;
        this.tiempoRetardo = tiempoRetardo;
        this.activarVisualizador = activarVisualizador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidadResultados() {
        return cantidadResultados;
    }

    public void setCantidadResultados(String cantidadResultados) {
        this.cantidadResultados = cantidadResultados;
    }

    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public String getTiempoRetardo() {
        return tiempoRetardo;
    }

    public void setTiempoRetardo(String tiempoRetardo) {
        this.tiempoRetardo = tiempoRetardo;
    }

    public boolean isActivarVisualizador() {
        return activarVisualizador;
    }

    public void setActivarVisualizador(boolean activarVisualizador) {
        this.activarVisualizador = activarVisualizador;
    }
}
