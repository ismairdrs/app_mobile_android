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

public class Tela03 extends DebugActivity {
    EditText txtName;
    EditText txtBirthYear;
    EditText txtEyeColor;
    EditText txtGender;
    EditText txtHairColor;
    EditText txtHeight;

    List<Map<String,String>> lista = new ArrayList<>();
    ListView listViewTela3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela03);

        Bundle bundle = getIntent().getExtras();

        String dados = bundle.getString("nome");

        Toast.makeText(this, dados, Toast.LENGTH_SHORT).show();
    }

    public void enviar(View view) {

        txtName = findViewById(R.id.txtName);
        txtBirthYear = findViewById(R.id.txtBirthYear);
        txtEyeColor = findViewById(R.id.txtEyeColor);
        txtGender = findViewById(R.id.txtGender);
        txtHairColor = findViewById(R.id.txtHairColor);
        txtHeight = findViewById(R.id.txtHeight);


        String name, birthYear, eyeColor, gender, hairColor, height;


        name = txtName.getText().toString();
        birthYear = txtBirthYear.getText().toString();
        eyeColor = txtEyeColor.getText().toString();
        gender = txtGender.getText().toString();
        hairColor = txtHairColor.getText().toString();
        height = txtHeight.getText().toString();



        HashMap<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("birthYear", birthYear);
        map.put("eyeColor",	eyeColor);
        map.put("gender", gender);
        map.put("hairColor", hairColor);
        map.put("height", height);


        lista.add(map);

        String[] from = {
                "name",
                "birthYear",
                "eyeColor",
                "gender",
                "hairColor",
                "height"
        };

        int[] to = {
                R.id.textViewName,
                R.id.textViewBirthYear,
                R.id.textViewEyeColor,
                R.id.textViewGender,
                R.id.textViewHairColor,
                R.id.textViewHeight
        };

        listViewTela3 = findViewById(R.id.listViewTela3);


        SimpleAdapter simpleAdapter = new SimpleAdapter(this, lista, R.layout.item_tela3, from, to);

        listViewTela3.setAdapter(simpleAdapter);

    }
}