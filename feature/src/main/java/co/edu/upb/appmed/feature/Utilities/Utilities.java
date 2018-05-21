package co.edu.upb.appmed.feature.Utilities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.IntDef;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Clase que contiene métodos comunes entre las demás actividades
 */

public class Utilities {

    public static final int SERVICE_STATIONS = 0;
    public static final int HOSPITALS = 1;
    public static final int HOTELS = 2;
    public static final int MUSEUMS = 3;
    public static final int PARKS = 4;
    public static final int WIFI_STATIONS = 5;
    public static final int RESTAURANTS = 6;
    public static LatLng actual_position;

    private @Activity
    int activity;

    public static boolean hasConnection(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean state = networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
        if (!state)
            showAlert(context, "Comprueba tu conexión de red");
        return state;
    }

    public double calcularDistaciaKms(LatLng coordenadas) {
        double radioTierra = 6371;
        double dLat = Math.toRadians(coordenadas.latitude - actual_position.latitude);
        double dLng = Math.toRadians(coordenadas.longitude - actual_position.longitude);
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(actual_position.latitude)) * Math.cos(Math.toRadians(coordenadas.latitude));
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
        double distancia = radioTierra * va2;

        return distancia;
    }

    public static void showAlert(Context context, String message) {
        Toast alert = Toast.makeText(context, message, Toast.LENGTH_LONG);
        alert.show();
    }

    @Retention(SOURCE)
    @IntDef({
            SERVICE_STATIONS,
            HOSPITALS,
            HOTELS,
            MUSEUMS,
            PARKS,
            WIFI_STATIONS,
            RESTAURANTS
    })

    public @interface Activity {
    }
}
