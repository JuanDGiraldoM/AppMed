package co.edu.upb.appmed.feature.Entities;

import com.google.android.gms.maps.model.LatLng;

public class WiFiZone extends Site{

    private String district;
    private String township;
    private String township_name;

    public WiFiZone() {
    }

    public WiFiZone(String name, String address, LatLng location, String district, String township, String township_name) {
        super(name, address, location);
        this.district = district;
        this.township = township;
        this.township_name = township_name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getTownship() {
        return township;
    }

    public void setTownship(String township) {
        this.township = township;
    }

    public String getTownship_name() {
        return township_name;
    }

    public void setTownship_name(String township_name) {
        this.township_name = township_name;
    }
}
