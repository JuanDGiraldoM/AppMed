package co.edu.upb.appmed.feature.Data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class InfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    private final View mWindow;
    private Context context;

    public InfoWindowAdapter(Context context) {
        this.mWindow = LayoutInflater.from(context).inflate(R.layout.custom_info_window, null);
        this.context = context;
    }

    private void renderizarWindowText(Marker marker, View view) {
        String title = marker.getTitle();
        TextView txtTitle = view.findViewById(R.id.title);

        if (!title.equals("")) {
            txtTitle.setText(title);
        }
        String snippet = marker.getSnippet();
        TextView txtSnippet = view.findViewById(R.id.snippet);

        if (!snippet.equals("")) {
            txtSnippet.setText(snippet);
        }
    }

    @Override
    public View getInfoWindow(Marker marker) {
        renderizarWindowText(marker, mWindow);
        return mWindow;
    }

    @Override
    public View getInfoContents(Marker marker) {
        renderizarWindowText(marker, mWindow);
        return mWindow;
    }
}
