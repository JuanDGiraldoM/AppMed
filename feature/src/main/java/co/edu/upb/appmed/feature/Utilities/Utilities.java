package co.edu.upb.appmed.feature.Utilities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.IntDef;
import android.widget.Toast;

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
