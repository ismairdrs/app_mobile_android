package br.fasam.mobile.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.fasam.mobile.app.activities.DebugActivity;
import br.fasam.mobile.app.activities.Tela01;
import br.fasam.mobile.app.activities.Tela02;
import br.fasam.mobile.app.activities.Tela03;

public class HomeActivity extends DebugActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void exibir(View view) {
        //Exibe a tela de acordo com a opção do usuário.

        Intent intent = null;
        Bundle bundle = null;
        switch (view.getId()){
            case R.id.btnTela01:

                //Executar comando para chamar tela 01
                intent = new Intent(this, Tela01.class);

                //Passagem de parâmetro para a outra tela.
                bundle = new Bundle();
                bundle.putString("nome","Faculdade Fasam");

                intent.putExtras(bundle);

                startActivity(intent);

                break;
            case R.id.btnTela02:
                //Executar comando para chamar tela 02
                intent = new Intent(this, Tela02.class);

                bundle = new Bundle();
                bundle.putString("nome","Faculdade Fasam");

                intent.putExtras(bundle);

                startActivity(intent);

                break;

            case R.id.btnTela03:
                //Executar comando para chamar tela 03
                intent = new Intent(this, Tela03.class);

                bundle = new Bundle();
                bundle.putString("nome","Faculdade Fasam");

                intent.putExtras(bundle);

                startActivity(intent);

                break;

            default:
                Toast.makeText(this,"Opção inválida", Toast.LENGTH_LONG).show();;
        }


    }
}