package co.edu.upb.calidad.appmed;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

/**
 * Clase de Aplicación
 */

public class Application extends android.app.Application {

    /**
     * Método constructor de la clase
     */
    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
    }
}