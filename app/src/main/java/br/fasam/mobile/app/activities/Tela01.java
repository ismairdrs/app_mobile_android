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

public class Tela01 extends DebugActivity {

    EditText txtNome;
    EditText txtSobrenome;
    EditText txtEmail;
    EditText txtTelefone;
    List<Map<String,String>> lista = new ArrayList<>();
    ListView listaViewPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela01);

        //Capturar dados da tela HomeActiviy;
        Bundle bundle = getIntent().getExtras();
        String dados = bundle.getString("nome");

        Toast.makeText(this, dados, Toast.LENGTH_SHORT).show();
    }

    public void enviar(View view) {
        //ENTRADA

        txtNome = findViewById(R.id.txtNome);
        txtSobrenome = findViewById(R.id.txtSobrenome);
        txtEmail = findViewById(R.id.txtEmail);
        txtTelefone = findViewById(R.id.txtTelefone);

        //PROCESSAMENTO
        String nome, sobrenome, email, telefone;
        nome = txtNome.getText().toString();
        sobrenome = txtSobrenome.getText().toString();
        email = txtEmail.getText().toString();
        telefone = txtTelefone.getText().toString();


        //Adicionar dados de entrada e associá-los a uma ListView
        HashMap<String,String> map = new HashMap<>();
        map.put("nome", nome);
        map.put("sobrenome", sobrenome);
        map.put("email", email);
        map.put("telefone", telefone);

        lista.add(map); //Adiciona dados na lista

        //Mapeamento do map com os items do layout
        String[] from = {"nome","email","telefone"};
        int[] to = {R.id.txtViewNome, R.id.txtViewEmail, R.id.txtViewTelefone};

        //Procurar listView no projeto Android;
        listaViewPessoa = findViewById(R.id.listViewPessoa);


        SimpleAdapter simpleAdapter = new SimpleAdapter(
                this, //Contexto da tela
                lista, //Lista de dados inseridos pelo app
                R.layout.item_pessoa, //Layout que irá exibir os dados
                from, //Keys (chaves) de dentro do HashMap
                to //Id dos itens do layout para exibir os dados para o usuário
        );

        //Pluga o adapter no SimpleAdapter
        listaViewPessoa.setAdapter(simpleAdapter);

        //SAÍDA
        //%s - string
        // %d - inteiro
        // %f - float
        String dados = String.format("Os dados digitados foram: Nome: %s\n Sobrenome: %s\n Email: %s\n Telefone: %s",
                nome,sobrenome, email, telefone);
        Toast.makeText(this, dados, Toast.LENGTH_LONG).show();

    }
}