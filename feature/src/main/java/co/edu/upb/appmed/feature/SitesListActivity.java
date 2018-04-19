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
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        firebaseRecyclerAdapter.cleanup();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(co.edu.upb.appmed.R.menu.menu_place, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case co.edu.upb.appmed.R.id.control_map:
                Intent intent_maps = new Intent(this, MapsActivity.class);
                startActivity(intent_maps);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
