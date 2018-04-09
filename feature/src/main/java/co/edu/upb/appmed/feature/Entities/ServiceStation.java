package co.edu.upb.appmed.feature.Entities;

public class ServiceStation {

    private String bandera;
    private String municipio;
    private double precio;
    private String producto;

    public ServiceStation() {
    }

    public ServiceStation(String bandera, String municipio, double precio, String producto) {
        this.bandera = bandera;
        this.municipio = municipio;
        this.precio = precio;
        this.producto = producto;
    }

    public String getBandera() {
        return bandera;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
}
