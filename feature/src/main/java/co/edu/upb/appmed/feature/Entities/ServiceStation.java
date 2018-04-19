package co.edu.upb.appmed.feature.Entities;

public class ServiceStation {

    private String flag;
    private String district;
    private double price;
    private String product;

    public ServiceStation() {
    }

    public ServiceStation(String flag, String district, double price, String product) {
        this.flag = flag;
        this.district = district;
        this.price = price;
        this.product = product;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
