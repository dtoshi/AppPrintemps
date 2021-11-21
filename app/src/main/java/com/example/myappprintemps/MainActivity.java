package com.example.myappprintemps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogin, btnRegistrar, btnsalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button) findViewById(R.id.btnIniciarSesion);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrarse);
        btnsalir = (Button) findViewById(R.id.btnSalir);

        btnLogin.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnIniciarSesion:
                Intent i = new Intent(this,loginActivity.class);
                startActivity(i);
                break;
            case R.id.btnRegistrarse:
                Intent i2 = new Intent(this,RegistroActivity.class);
                startActivity(i2);
                break;
        }
    }

    public void Closeapp(View view)
    {
        finish();
    }
}