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

public class loginActivity extends AppCompatActivity {

    EditText user, pass;
    Button btnEntrar, btnCancelar;
    TextView txms;
    private ProgressBar pb;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (EditText) findViewById(R.id.etuser);
        pass = (EditText) findViewById(R.id.etpass);
        btnEntrar = (Button) findViewById(R.id.btnIngresar);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        pb = (ProgressBar) findViewById(R.id.pb);
        txms = (TextView) findViewById(R.id.txms);

        pb.setVisibility(View.INVISIBLE);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //cerrar tarea asincrona
                new Task().execute();
            }
        });
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        dao = new daoUsuario(this);
    }

    class Task extends AsyncTask<String,Void,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pb.setVisibility(View.VISIBLE);
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
            pb.setVisibility(View.INVISIBLE);

            String u = user.getText().toString();
            String p = pass.getText().toString();

            if(u.equals("")&&p.equals("")){
                Toast.makeText(loginActivity.this, "Campos vacios, porfavor intente nuevamente", Toast.LENGTH_SHORT).show();
            }else if(dao.login(u,p)==1){
                Usuario ux = dao.getUsuario(u,p);
                Toast.makeText(loginActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                Intent i2 = new Intent(getBaseContext(),HomeActivity.class);
                i2.putExtra("Id", ux.getId());
                startActivity(i2);
                finish();
            }else{
                Toast.makeText(loginActivity.this, "Campos incorrectos, porfavor intente nuevamente", Toast.LENGTH_SHORT).show();
            }
        }
    }
}