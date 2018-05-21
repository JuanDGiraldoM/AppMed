package co.edu.upb.appmed.feature;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import co.edu.upb.appmed.feature.Entities.Hospital;
import co.edu.upb.appmed.feature.Entities.ServiceStation;
import co.edu.upb.appmed.feature.Entities.WiFiZone;
import co.edu.upb.appmed.feature.Holders.SiteHolder;
import co.edu.upb.appmed.feature.Utilities.Utilities;

public class SitesListActivity extends AppCompatActivity {

    FirebaseRecyclerAdapter firebaseRecyclerAdapter;
    private int activityCaller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sites_list);

        Bundle data = this.getIntent().getExtras();
        activityCaller = data.getInt("activity");

        switch (activityCaller) {
            case Utilities.HOSPITALS:
                Query dbHospitals = FirebaseDatabase.getInstance().getReference()
                        .child("3")
                        .orderByChild("nombre_sede");

                RecyclerView recycler = findViewById(R.id.sites_list);
                recycler.setHasFixedSize(true);
                recycler.setLayoutManager(new LinearLayoutManager(this));
                firebaseRecyclerAdapter =
                        new FirebaseRecyclerAdapter<Hospital, SiteHolder>(
                                Hospital.class, R.layout.place, SiteHolder.class, dbHospitals) {

                            @Override
                            protected void populateViewHolder(SiteHolder viewHolder, Hospital model, int position) {
                                viewHolder.setName(model.getName());
                                viewHolder.setAddress(model.getAddress());
                                viewHolder.setExtra(model.getMunicipality());
                            }
                        };
                recycler.setAdapter(firebaseRecyclerAdapter);
                break;

            case Utilities.SERVICE_STATIONS:
                Query dbEstacionesServicio = FirebaseDatabase.getInstance().getReference()
                        .child("2")
                        .orderByChild("nombrecomercial");

                recycler = findViewById(R.id.sites_list);
                recycler.setHasFixedSize(true);
                recycler.setLayoutManager(new LinearLayoutManager(this));

                firebaseRecyclerAdapter =
                        new FirebaseRecyclerAdapter<ServiceStation, SiteHolder>(
                                ServiceStation.class, R.layout.place, SiteHolder.class, dbEstacionesServicio) {

                            @Override
                            protected void populateViewHolder(SiteHolder viewHolder, ServiceStation model, int position) {
                                viewHolder.setName(model.getName());
                                viewHolder.setAddress(model.getAddress());
                                viewHolder.setExtra(model.getProduct());
                            }
                        };
                recycler.setAdapter(firebaseRecyclerAdapter);
                break;

            case Utilities.WIFI_STATIONS:
                Query dbZonasWifi = FirebaseDatabase.getInstance().getReference()
                        .child("4")
                        .orderByChild("nombre_del_sitio");

                recycler = findViewById(R.id.sites_list);
                recycler.setHasFixedSize(true);
                recycler.setLayoutManager(new LinearLayoutManager(this));

                firebaseRecyclerAdapter =
                        new FirebaseRecyclerAdapter<WiFiZone, SiteHolder>(
                                WiFiZone.class, R.layout.place, SiteHolder.class, dbZonasWifi) {

                            @Override
                            protected void populateViewHolder(SiteHolder viewHolder, WiFiZone model, int position) {
                                viewHolder.setName(model.getName());
                                viewHolder.setAddress(model.getAddress());
                                viewHolder.setExtra(model.getTownship_name());
                            }
                        };
                recycler.setAdapter(firebaseRecyclerAdapter);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        firebaseRecyclerAdapter.cleanup();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_place, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == R.id.control_map) {
            Intent intent_maps = new Intent(this, MapsActivity.class);
            startActivity(intent_maps);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }

    }
}