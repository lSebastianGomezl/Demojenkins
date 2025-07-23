package models;

public class DatosSorteo {

    private String empresa;
    private String nombreSorteo;
    private String codigoUnico;
    private String tipoSorteo;
    private String descripcion;
    private String fechaInicio;
    private String fechaFin;
    private String parametro;


    public DatosSorteo(String empresa, String nombreSorteo, String codigoUnico, String tipoSorteo,
                       String descripcion, String fechaInicio, String fechaFin, String parametro) {
        this.empresa = empresa;
        this.nombreSorteo = nombreSorteo;
        this.codigoUnico = codigoUnico;
        this.tipoSorteo = tipoSorteo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.parametro = parametro;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getNombreSorteo() {
        return nombreSorteo;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public String getTipoSorteo() {
        return tipoSorteo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public String getParametro() {
        return parametro;
    }
}
