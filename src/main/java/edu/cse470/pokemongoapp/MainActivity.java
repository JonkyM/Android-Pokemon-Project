package edu.cse470.pokemongoapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

import edu.cse470.pokemongoapp.inventory.Data;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    Button mapButton;
    ImageButton listButton;
    private Spinner spinner_pokemon;
    private PokemonAdapter adapter;
    double latitude;
    double longitude;
    int CombatPower;
    int NeededPlayers;
    String Date;


    //spinner code test
    String selectedPokemon;
    Button saveButton;
    //





    // Activity Launcher Code for Map
    ActivityResultLauncher<Intent> activityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == 21) {
                        Intent intent = result.getData();

                        if(intent != null) {
                            latitude = intent.getDoubleExtra("latitude", 404);
                            longitude = intent.getDoubleExtra("longitude", 404);
                            TextView displayCoords = (TextView) findViewById(R.id.textViewDisplayCoords);
                            displayCoords.setText("Lat: " + String.format("%.6f",latitude) + "       Long: " + String.format("%.6f",longitude));

                        }
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ////
        mapButton = (Button) findViewById(R.id.buttonOpenMap);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                activityLauncher.launch(intent);
            }
        });
        ////

        listButton = (ImageButton) findViewById(R.id.imageButtonRaidList);
        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listIntent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(listIntent);
            }
        });


        spinner_pokemon = findViewById(R.id.spinnerLegendaryPokemon);
        adapter = new PokemonAdapter(MainActivity.this, Data.getPokemonList());
        spinner_pokemon.setAdapter(adapter);

        // AAAAAAAAA Spinner Test Code

        saveButton = (Button) findViewById(R.id.buttonSaveData);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedPokemon = spinner_pokemon.getSelectedItem().toString();
                TextView spinnerText = (TextView) findViewById(R.id.textViewTempText);
                spinnerText.setText(selectedPokemon);

                EditText cp = (EditText) findViewById(R.id.editTextNumberCombatP);
                String combatPower = cp.getText().toString();

                EditText players = (EditText) findViewById(R.id.editTextNumberPlayers);
                String neededPlayers = players.getText().toString();

                TextView dateText = (TextView) findViewById(R.id.textViewDisplayDate);
                String date = dateText.getText().toString();

                String lat = String.format("%.6f",latitude);
                String lon = String.format("%.6f",longitude);



                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Pokemon Name", selectedPokemon);
                editor.putString("Combat Power", combatPower);
                editor.putString("Needed Players", neededPlayers);
                editor.putString("Latitude", lat);
                editor.putString("Longitude", lon);
                editor.putString("Date", date);
                editor.apply();

                Toast.makeText(MainActivity.this, "Raid Info Saved", Toast.LENGTH_SHORT).show();
            }
        });

        // AAAAAAAAA Spinner Test Code



        Button selectDateButton = (Button) findViewById(R.id.buttonPickDate);
        selectDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "Date Picker");
            }
        });


    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance().format(c.getTime());

        TextView displayDate = (TextView) findViewById(R.id.textViewDisplayDate);
        displayDate.setText(currentDateString);
    }
}