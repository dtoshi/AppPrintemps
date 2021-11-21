package com.example.myappprintemps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import DAO.daoUsuario;
import Objetos.Usuario;

public class PerfilModificarActivity extends AppCompatActivity{

    EditText ediUser,ediPass,ediNombre,ediApellido;Button btnactualizar,btnCancelaredit;
    int id=0;
    Usuario u;
    daoUsuario dao;
    Intent x;

    private ProgressBar pbEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_modificar);

        ediUser = (EditText) findViewById(R.id.EdiUser);
        ediPass = (EditText) findViewById(R.id.EdiPass);
        ediNombre = (EditText) findViewById(R.id.EdiNombre);
        ediApellido = (EditText) findViewById(R.id.EdiApellido);
        pbEditar=(ProgressBar)findViewById(R.id.pbEditar);
        pbEditar.setVisibility(View.INVISIBLE);

        btnactualizar = (Button) findViewById(R.id.btnActualizar);
        btnCancelaredit = (Button) findViewById(R.id.btnCancelare);


        Bundle b =getIntent().getExtras();
        id=b.getInt("Id");
        dao=new daoUsuario(this);
        u=dao.getUsuarioById(id);
        ediUser.setText(u.getUsuario());
        ediPass.setText(u.getPassword());
        ediNombre.setText(u.getNombre());
        ediApellido.setText(u.getApellidos());


        btnactualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //cerrar tarea asincrona
                new Task3().execute();
            }
        });
        btnCancelaredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(PerfilModificarActivity.this,PerfilActivity.class);
                i2.putExtra("Id",u.getId());
                startActivity(i2);
                finish();
            }
        });
    }

    class Task3 extends AsyncTask<String,Void,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pbEditar.setVisibility(View.VISIBLE);
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

            pbEditar.setVisibility(View.INVISIBLE);

            u.setUsuario(ediUser.getText().toString());
            u.setPassword(ediPass.getText().toString());
            u.setNombre(ediNombre.getText().toString());
            u.setApellidos(ediApellido.getText().toString());
            if (!u.isNull()){
                Toast.makeText(PerfilModificarActivity.this, "Campos vacios, porfavor intente nuevamente", Toast.LENGTH_SHORT).show();
            }else if (dao.updateUsuario(u)){
                Toast.makeText(PerfilModificarActivity.this, "Actualizacion Exitosa", Toast.LENGTH_SHORT).show();
                Intent i2 = new Intent(PerfilModificarActivity.this,PerfilActivity.class);
                i2.putExtra("Id",u.getId());
                startActivity(i2);
                finish();
            }else{
                Toast.makeText(PerfilModificarActivity.this, "No se puede Actualizar", Toast.LENGTH_SHORT).show();
            }
        }
    }
}