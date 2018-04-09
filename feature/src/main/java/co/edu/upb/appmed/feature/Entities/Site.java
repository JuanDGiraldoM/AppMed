package co.edu.upb.appmed.feature.Entities;

import com.google.android.gms.maps.model.LatLng;

public class Site {

    protected String name;
    protected String address;
    protected LatLng location;

    /**
     * Constructor vacío
     */
    public Site() {
    }

    public Site(String name, String address, LatLng location) {
        this.name = name;
        this.address = address;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }
}
