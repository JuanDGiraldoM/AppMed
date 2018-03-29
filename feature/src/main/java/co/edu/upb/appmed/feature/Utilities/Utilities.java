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

    public static final int ESTACIONES_SERVICIO = 0;
    public static final int HOSPITALES = 1;
    public static final int HOTELES = 2;
    public static final int MUSEOS = 3;
    public static final int PARQUES = 4;
    public static final int ESTACIONES_WIFI = 5;
    public static final int RESTAURANTES = 6;

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
            ESTACIONES_SERVICIO,
            HOSPITALES,
            HOTELES,
            MUSEOS,
            PARQUES,
            ESTACIONES_WIFI,
            RESTAURANTES
    })

    public @interface Activity {
    }
}
