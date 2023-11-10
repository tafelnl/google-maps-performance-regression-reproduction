package com.example.mapdemo;

import android.os.Bundle;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        googleMapOptions.mapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMapOptions.camera(new CameraPosition(new LatLng(41.390205, 2.154007), 10, 0, 0));

        MapView mapView = new MapView(this, googleMapOptions);

        mapView.onCreate(new Bundle());
        mapView.getMapAsync(this);

        RelativeLayout relativeLayout = new RelativeLayout(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.addView(mapView);

        setContentView(relativeLayout);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        int markersCount = 1000;

        for (int i = 0; i < markersCount; i++) {
            double latitude = random(41.308048, 41.454140);
            double longitude = random(2.055976, 2.263161);
            LatLng latLng = new LatLng(latitude, longitude);

            MarkerOptions markerOptions = new MarkerOptions().position(latLng);

            googleMap.addMarker(markerOptions);
        }
    }

    public double random(double min, double max) {
        return min + Math.random() * (max - min);
    }
}
