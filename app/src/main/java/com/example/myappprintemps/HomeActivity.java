package com.example.myappprintemps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import DAO.daoUsuario;
import Objetos.Usuario;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton btncatalogo, btnperfil, btnacercade, btncerrar;
    private ViewFlipper vf;
    private int[] image ={R.drawable.banner1, R.drawable.banner2, R.drawable.banner3,
            R.drawable.banner4, R.drawable.banner5, R.drawable.banner6, R.drawable.banner7};
    TextView nombre;
    int id=0;
    Usuario u;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btncatalogo = (ImageButton) findViewById(R.id.btnCatalogo);
        btnperfil = (ImageButton) findViewById(R.id.btnPerfil);
        btnacercade = (ImageButton) findViewById(R.id.btnAcercade);
        btncerrar = (ImageButton) findViewById(R.id.btnCerrarSesion);
        nombre=(TextView) findViewById(R.id.txtUsuarioNombre);

        vf=(ViewFlipper)findViewById(R.id.slider);
        for(int i=0; i<image.length;i++)
        {
            flip_image(image[i]);
        }

        btnacercade.setOnClickListener(this);
        btncerrar.setOnClickListener(this);
        btnperfil.setOnClickListener(this);
        btncatalogo.setOnClickListener(this);

        Bundle b =getIntent().getExtras();
        id=b.getInt("Id");
        dao=new daoUsuario(this);
        u=dao.getUsuarioById(id);
        nombre.setText(u.getNombre()+" "+u.getApellidos());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.btnCatalogo:
                Intent ca = new Intent(HomeActivity.this,CatalogoActivity.class);
                startActivity(ca);
                break;
            case  R.id.btnPerfil:
                Intent p = new Intent(HomeActivity.this,PerfilActivity.class);
                p.putExtra("Id", id);
                startActivity(p);
                break;
            case R.id.btnAcercade:
                Intent a = new Intent(HomeActivity.this,AcercaDeActivity.class);
                startActivity(a);
                break;
            case R.id.btnCerrarSesion:
                Intent c = new Intent(HomeActivity.this,MainActivity.class);
                startActivity(c);
                finish();
                break;
        }
    }

    public void flip_image(int i)
    {
        ImageView view =new ImageView(this);
        view.setBackgroundResource(i);
        vf.addView(view);
        vf.setFlipInterval(2700);
        vf.setAutoStart(true);

        vf.setInAnimation(this,android.R.anim.slide_in_left);
        vf.setInAnimation(this,android.R.anim.slide_in_left);
    }
}