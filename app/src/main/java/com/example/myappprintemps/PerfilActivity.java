package com.example.myappprintemps;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import DAO.daoUsuario;
import Objetos.Usuario;

public class PerfilActivity extends AppCompatActivity implements View.OnClickListener {


    Button btnActualizar, btnVolverHome, btneliminarCuenta;
    int id=0;
    Usuario u;
    daoUsuario dao;
    TextView tvnombre,tvapellidos,tvusuario,tvpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        btnActualizar=(Button) findViewById(R.id.btnActualizar);
        btneliminarCuenta=(Button) findViewById(R.id.btnEliminar);
        btnVolverHome=(Button) findViewById(R.id.btnvolverHome);

        tvnombre=(TextView)findViewById(R.id.tvNombre);
        tvapellidos=(TextView)findViewById(R.id.tvApellido);
        tvusuario=(TextView)findViewById(R.id.tvUsuario);
        tvpass=(TextView)findViewById(R.id.tvPass);

        btnActualizar.setOnClickListener(this);
        btneliminarCuenta.setOnClickListener(this);
        btnVolverHome.setOnClickListener(this);

        Bundle b =getIntent().getExtras();
        id=b.getInt("Id");
        dao=new daoUsuario(this);
        u=dao.getUsuarioById(id);

        tvusuario.setText(u.getUsuario());
        tvpass.setText(u.getPassword());
        tvnombre.setText(u.getNombre());
        tvapellidos.setText(u.getApellidos());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.btnActualizar:
                Intent p = new Intent(PerfilActivity.this,PerfilModificarActivity.class);
                p.putExtra("Id", id);
                startActivity(p);
                break;
            case R.id.btnEliminar:
                AlertDialog.Builder b=new AlertDialog.Builder(this);
                b.setMessage("Estas seguro de Eliminar tu cuenta????");
                b.setCancelable(false);
                b.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(dao.deleteUsuario(id)){
                            Toast.makeText(PerfilActivity.this, "Se elimino correctamente", Toast.LENGTH_SHORT).show();
                            Intent a = new Intent(PerfilActivity.this,MainActivity.class);
                            startActivity(a);
                            finish();
                        }else{
                            Toast.makeText(PerfilActivity.this, "ERROR: No se elimino cuenta", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                b.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();

                    }
                });
                b.show();
                break;
            case R.id.btnvolverHome:
                Intent c = new Intent(PerfilActivity.this,HomeActivity.class);
                c.putExtra("Id",u.getId());
                startActivity(c);
                finish();
                break;
        }
    }
}