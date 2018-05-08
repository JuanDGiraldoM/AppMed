package co.edu.upb.appmed.feature.Entities;

import com.google.android.gms.maps.model.LatLng;

public class Hospital extends Site{

    private String email;
    private String phone;
    private String municipality;

    public Hospital() {
    }

    public Hospital(String name, String address, LatLng location, String email, String phone, String municipality) {
        super(name, address, location);
        this.email = email;
        this.phone = phone;
        this.municipality = municipality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }
}
