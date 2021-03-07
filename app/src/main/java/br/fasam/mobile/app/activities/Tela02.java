package br.fasam.mobile.app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.fasam.mobile.app.R;

public class Tela02 extends DebugActivity {

    EditText txtName;
    EditText txtDiameter;
    EditText txtRotationPeriod;
    EditText txtOrbitalPeriod;
    EditText txtGravity;
    EditText txtPopulation;
    EditText txtClimate;
    EditText txtTerrain;
    EditText txtSurface_water;
    EditText txtResidents;
    EditText txtFilms;
    EditText txtUrl;
    List<Map<String,String>> lista = new ArrayList<>();
    ListView listViewTela2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela02);

        Bundle bundle = getIntent().getExtras();

        String dados = bundle.getString("nome");

        Toast.makeText(this, dados, Toast.LENGTH_SHORT).show();
    }

    public void enviar(View view) {

        txtName = findViewById(R.id.txtName);
        txtDiameter = findViewById(R.id.txtDiameter);
        txtRotationPeriod = findViewById(R.id.txtRotationPeriod);
        txtOrbitalPeriod = findViewById(R.id.txtOrbitalPeriod);
        txtGravity = findViewById(R.id.txtGravity);
        txtPopulation = findViewById(R.id.txtPopulation);
        txtClimate = findViewById(R.id.txtClimate);
        txtTerrain = findViewById(R.id.txtTerrain);
        txtSurface_water = findViewById(R.id.txtSurface_water);
        txtResidents = findViewById(R.id.txtResidents);
        txtFilms = findViewById(R.id.txtFilms);
        txtUrl = findViewById(R.id.txtUrl);

        String name, diameter, rotationPeriod, orbitalPeriod,
                gravity, population, climate, terrain, surface_water,
                residents, films, url;

        name = txtName.getText().toString();
        diameter = txtDiameter.getText().toString();
        rotationPeriod = txtRotationPeriod.getText().toString();
        orbitalPeriod = txtOrbitalPeriod.getText().toString();
        gravity = txtGravity.getText().toString();
        population = txtPopulation.getText().toString();
        climate = txtClimate.getText().toString();
        terrain = txtTerrain.getText().toString();
        surface_water = txtSurface_water.getText().toString();
        residents = txtResidents.getText().toString();
        films = txtFilms.getText().toString();
        url = txtUrl.getText().toString();


        HashMap<String, String> map = new HashMap<>();
        map.put("name", 	name);
        map.put("diameter",	diameter);
        map.put("rotationPeriod",	rotationPeriod);
        map.put("orbitalPeriod",	orbitalPeriod);
        map.put("gravity",	gravity);
        map.put("population",	population);
        map.put("climate",	climate);
        map.put("terrain",	terrain);
        map.put("surface_water",	surface_water);
        map.put("residents",	residents);
        map.put("films",	films);
        map.put("url",	url);

        lista.add(map);

        String[] from = {
                "name",
                "diameter",
                "rotationPeriod",
                "orbitalPeriod",
                "gravity",
                "population",
                "climate",
                "terrain",
                "surface_water",
                "residents",
                "films",
                "url"
        };

        int[] to = {
                R.id.textViewName,
                R.id.textViewDiameter,
                R.id.textViewDiameter,
                R.id.textViewOrbitalPeriod,
                R.id.textViewGravity,
                R.id.textViewPopulation,
                R.id.textViewClimate,
                R.id.textViewTerrain,
                R.id.textViewSurfaceWater,
                R.id.textViewResidents,
                R.id.textViewFilms,
                R.id.textViewUrl,
        };

        listViewTela2 = findViewById(R.id.listViewTela2);


        SimpleAdapter simpleAdapter = new SimpleAdapter(this, lista, R.layout.item_tela2, from, to);

        listViewTela2.setAdapter(simpleAdapter);

        String dados = String.format("Os dados digitados foram: " +
                        "Name: %s\n " +
                        "Diameter: %s\n " +
                        "Rotation period: %s\n " +
                        "Orbital period: %s\n " +
                        "Gravity: %s ",
                        "Population: %s ",
                name, diameter, rotationPeriod, orbitalPeriod, gravity, population);
        Toast.makeText(this, dados, Toast.LENGTH_LONG).show();
    }
}