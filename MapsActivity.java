package com.example.alfamaps;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.alfamaps.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
    mMap = googleMap;

    // Add a marker in jalanmerpati and move the camera
    LatLng jalanmerpati = new LatLng(-0.8948736, 119.8953802);
    LatLng vatulemo = new LatLng(-0.9004524, 119.8891133);
    // custom size marker
    int tinggi = 100;
    int lebar = 100;
    BitmapDrawable bitmapStart = (BitmapDrawable)getResources().getDrawable(R.drawable.pin_map_hitam);
    BitmapDrawable bitmapDes = (BitmapDrawable)getResources().getDrawable(R.drawable.pin_map_merah);
    Bitmap s = bitmapStart.getBitmap();
    Bitmap d = bitmapDes.getBitmap();
    Bitmap markerStart = Bitmap.createScaledBitmap(s, lebar, tinggi, false);
    Bitmap markerDes = Bitmap.createScaledBitmap(d, lebar, tinggi, false);

    // Add marker to map
    mMap.addMarker(new MarkerOptions().position(jalanmerpati).title("Marker in jalanmerpati")
            .snippet("Ini adalah tempat tinggal saya")
            .icon(BitmapDescriptorFactory.fromBitmap(markerStart)));
    mMap.addMarker(new MarkerOptions().position(vatulemo).title("Marker in vatulemo")
            .snippet("Ini adalah lapangan vatulemo")
            .icon(BitmapDescriptorFactory.fromBitmap(markerDes)));

    mMap.addPolyline(new PolylineOptions().add(
                            jalanmerpati,
                            new LatLng(-0.8948736, 119.8953802),
                            new LatLng(-0.8953118, 119.8952781),
                            new LatLng(-0.8945061, 119.8905998),
                            new LatLng(-0.8977327, 119.8904549),
                            new LatLng(-0.8977633, 119.8900421),
                            new LatLng(-0.9004524, 119.8891133),
                            vatulemo
                    ).width(10)
                    .color(Color.BLUE)
    );

    mMap.moveCamera(CameraUpdateFactory.newLatLng(jalanmerpati));
}
}
