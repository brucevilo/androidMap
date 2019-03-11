package com.example.brucenigelpvilo.semifinal;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listViewLocation;
   private DatabaseReference databaseLocation;
    List<location> locationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseLocation = FirebaseDatabase.getInstance().getReference("location");
        databaseLocation.keepSynced(true);
        listViewLocation =findViewById(R.id.locationList);
        locationList = new ArrayList <>();
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseLocation.addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            for(DataSnapshot locationSnapshot: dataSnapshot.getChildren())
                {
                    locationList.clear();
                    location loc = locationSnapshot.getValue(location.class);
                    locationList.add(loc);

                }
                LocationList adapter = new LocationList(MainActivity.this,locationList);
                listViewLocation.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id)
        {
            case R.id.add:
                Intent intent = new Intent(this,map.class);
                this.startActivity(intent);
                break;
            case R.id.export:
                Toast.makeText(this,"succesfully",Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
