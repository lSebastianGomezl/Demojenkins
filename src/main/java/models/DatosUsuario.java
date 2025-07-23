package models;



public class DatosUsuario {

    private String tipoDocumento;
    private String usuario;
    private String contrasenna;

    public DatosUsuario(String tipoDocumento, String usuario, String contrasenna) {
        this.tipoDocumento = tipoDocumento;
        this.usuario = usuario;
        this.contrasenna = contrasenna;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }
}
