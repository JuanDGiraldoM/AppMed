package co.edu.upb.appmed.feature.Entities;

import android.net.Uri;

import com.google.android.gms.maps.model.LatLng;

public class PlaceInfo extends Site {

    private String phone;
    private String id;
    private Uri websiteUri;
    private float rating;
    private String attributions;

    public PlaceInfo() {
    }

    public PlaceInfo(String name, String address, LatLng location, String phone, String id, Uri websiteUri, float rating, String attributions) {
        super(name, address, location);
        this.phone = phone;
        this.id = id;
        this.websiteUri = websiteUri;
        this.rating = rating;
        this.attributions = attributions;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Uri getWebsiteUri() {
        return websiteUri;
    }

    public void setWebsiteUri(Uri websiteUri) {
        this.websiteUri = websiteUri;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getAttributions() {
        return attributions;
    }

    public void setAttributions(String attributions) {
        this.attributions = attributions;
    }
}
