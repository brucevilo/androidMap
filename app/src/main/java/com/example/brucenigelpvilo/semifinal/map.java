package com.example.brucenigelpvilo.semifinal;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class map extends AppCompatActivity implements LocationListener {
  TextView textView1,textView2,places;
  LocationManager locationManager;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        databaseReference = FirebaseDatabase.getInstance().getReference("location");
        places =findViewById(R.id.editText2);
        textView1 = findViewById(R.id.txt_latitude);
        textView2=findViewById(R.id.txt_longtitude);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = locationManager.getLastKnownLocation(locationManager.NETWORK_PROVIDER);
        onLocationChanged(location);
    }

    public void onLocationChanged(Location location) {

        double longitude = location.getLongitude();
        double latitude = location.getLatitude();

        textView1.setText(""+latitude);
        textView2.setText(""+longitude);
    }



    public void onStatusChanged(String provider, int status, Bundle extras) {

    }


    public void onProviderEnabled(String provider) {

    }


    public void onProviderDisabled(String provider) {

    }

    public void  AddLocation(View view)
    {
       String db_longtitude = textView1.getText().toString();
       String db_latitude = textView2.getText().toString();
        String db_places = places.getText().toString();

        if(!TextUtils.isEmpty(db_places))
        {
          String id = databaseReference.push().getKey();
          location location = new location(id,db_latitude,db_longtitude,db_places);
          databaseReference.child(id).setValue(location);
            Toast.makeText(this,"Successfully Added!",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }else
            {
                Toast.makeText(this,"Please Enter a place",Toast.LENGTH_SHORT).show();
            }
    }

}
