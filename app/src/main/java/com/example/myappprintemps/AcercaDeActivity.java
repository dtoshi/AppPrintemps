package com.example.myappprintemps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class AcercaDeActivity extends AppCompatActivity {

    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        video = findViewById(R.id.vw);
        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.videoflores;
        Uri uri = Uri.parse(ruta);//parseo la rura
        video.setVideoURI(uri); // paso el video all videoView

        video.start();//reproduccion automatica

        //controles para el video
        //MediaController media = new MediaController(this);
        //video.setMediaController(media);
    }

    public void Marcado(View view)
    {
        //intent implicito

        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel: " + "956154232"));
        startActivity(i);
    }

    public void Maps(View view)
    {
        //intent implicito

        Intent i = new Intent(this,MapsActivity.class);
        startActivity(i);
    }

    public void facebook(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.facebook.com/"));
        startActivity(i);
    }

    public void instagram(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.instagram.com/"));
        startActivity(i);
    }

    public void twitter(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://twitter.com/"));
        startActivity(i);
    }


}