package co.edu.upb.appmed.feature;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import co.edu.upb.appmed.feature.Utilities.Utilities;

/**
 * Actividad principal
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    /**
     * Método constructor de la actividad
     *
     * @param savedInstanceState savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    /**
     * Método que captura el evento generado al presionar la tecla de retoceso
     */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * Método que verifica
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Método que captura el evento generado al presionar un ítem del menú de opciones
     *
     * @param item item seleccionado
     * @return true cuando finaliza correctamente
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * Método que captura los eventos generados al presionar algún ítem del menú de navegación
     *
     * @param item item seleccionado
     * @return true cuando finaliza correctamente
     */
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        //TODO: Actividad con Listado de Sitios
        Intent intent = new Intent(this, ListadoSitiosActivity.class);

        int i = item.getItemId();

        if (i == R.id.nav_hospital) {
            intent.putExtra("activity", Utilities.HOSPITALS);
            startActivity(intent);
            return true;
        } else if (i == R.id.nav_wifi) {
            intent.putExtra("activity", Utilities.WIFI_STATIONS);
            startActivity(intent);
            return true;
        } else if (i == R.id.nav_station) {
            intent.putExtra("activity", Utilities.SERVICE_STATIONS);
            startActivity(intent);
            return true;


        } //TODO: else if (i == R.id.nav_map)
        else {
            DrawerLayout drawer = findViewById(co.edu.upb.appmed.R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
    }
}
