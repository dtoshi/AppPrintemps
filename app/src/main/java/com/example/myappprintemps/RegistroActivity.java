package com.example.myappprintemps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import DAO.daoUsuario;
import Objetos.Usuario;

public class RegistroActivity extends AppCompatActivity {

    EditText us, pas, nom, ap;
    Button reg,can;
    TextView txms1;
    private ProgressBar pb1;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        us =(EditText) findViewById(R.id.RegUser);
        nom =(EditText) findViewById(R.id.RegNombre);
        ap =(EditText) findViewById(R.id.RegApellido);
        pas =(EditText) findViewById(R.id.RegPass);

        reg = (Button)findViewById(R.id.btnRegistrar);
        can = (Button)findViewById(R.id.btnCancelar);

        txms1 = (TextView) findViewById(R.id.txms1);
        pb1 = (ProgressBar) findViewById(R.id.pb1);

        pb1.setVisibility(View.INVISIBLE);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //cerrar tarea asincrona
                new Task2().execute();
            }
        });
        can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(),MainActivity.class);
                startActivity(i);
            }
        });

        dao = new daoUsuario(this);
    }

    class Task2 extends AsyncTask<String,Void,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pb1.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                for (int i = 0; i <= 10; i++)
                {
                    Thread.sleep(300);
                }
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            pb1.setVisibility(View.INVISIBLE);

            Usuario u = new Usuario();
            u.setUsuario(us.getText().toString());
            u.setPassword(pas.getText().toString());
            u.setNombre(nom.getText().toString());
            u.setApellidos(ap.getText().toString());
            if (!u.isNull()){
                Toast.makeText(RegistroActivity.this, "Campos vacios, porfavor intente nuevamente", Toast.LENGTH_SHORT).show();
            }else if (dao.insertUsuario(u)){
                Toast.makeText(RegistroActivity.this, "En Hora buena...Registro Exitoso!!!", Toast.LENGTH_SHORT).show();
                Intent i2 = new Intent(RegistroActivity.this,loginActivity.class);
                startActivity(i2);
                finish();
            }else{
                Toast.makeText(RegistroActivity.this, "ERROR: Usuario ya registrado", Toast.LENGTH_SHORT).show();

            }
        }
    }
}