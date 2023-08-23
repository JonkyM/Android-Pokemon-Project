package edu.cse470.pokemongoapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCaller;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Map;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerDragListener, ActivityResultCaller {

    Button returnButton;

    private Marker markerRaid;
    double latitude;
    double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout file as the content view.
        setContentView(R.layout.activity_map);


        returnButton = (Button) findViewById(R.id.buttonReturnCoords);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("latitude", latitude);
                intent.putExtra("longitude", longitude);
                setResult(21, intent);

                finish();
            }
        });

        // Get a handle to the fragment and register the callback.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    // Get a handle to the GoogleMap object and display marker.
    @Override
    public void onMapReady(GoogleMap googleMap) {
        markerRaid = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(38.2123, -85.7585))
                .title("Raid Spot")
                .draggable(true));
        markerRaid.setTag(0);

        googleMap.setOnMarkerDragListener(this);
    }

    @Override
    public void onMarkerDrag(@NonNull Marker marker) {
        TextView displayCoords = (TextView) findViewById(R.id.textViewMapTitle);
        latitude = markerRaid.getPosition().latitude;
        longitude = markerRaid.getPosition().longitude;
        displayCoords.setText("CURRENT LOCATION: " + Double.toString(latitude) + " " + Double.toString(longitude));
    }

    @Override
    public void onMarkerDragEnd(@NonNull Marker marker) {
        TextView displayCoords = (TextView) findViewById(R.id.textViewMapTitle);
        latitude = markerRaid.getPosition().latitude;
        longitude = markerRaid.getPosition().longitude;
        displayCoords.setText("CURRENT LOCATION: " + Double.toString(latitude) + " " + Double.toString(longitude));
    }

    @Override
    public void onMarkerDragStart(@NonNull Marker marker) {
        TextView displayCoords = (TextView) findViewById(R.id.textViewMapTitle);
        displayCoords.setText("PRESS AND DRAG PIN TO RAID LOCATION");
    }
}
