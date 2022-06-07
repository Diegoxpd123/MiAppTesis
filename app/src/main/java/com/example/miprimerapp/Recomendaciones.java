package com.example.miprimerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Recomendaciones extends AppCompatActivity {

    ImageButton imageButton4;
    ImageButton imageButton7;
    ImageButton imageButton6;
    Button button14;
    String _url = "https://www.psyciencia.com/6-ejercicios-de-respiracion-para-relajarse/";

    Button button13;
    String _url2 = "https://www.momentosfelices.com.uy/de-interes/5-libros-para-quitarte-el-stress/";

    Button button16;
    String _url3 = "https://www.planetfitness.com/es/community/articles/5-stress-relieving-stretches-you-can-do-anywhere#:~:text=Simplemente%20coloca%20las%20palmas%20de,estirarte%20tanto%20que%20sientas%20dolor!";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recomendaciones);


        button16 = (Button) findViewById(R.id.button16);

        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri _link = Uri.parse(_url3);
                Intent intentReg = new Intent(Intent.ACTION_VIEW, _link);
                startActivity(intentReg);

            }
        });


        button13 = (Button) findViewById(R.id.button13);

        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri _link = Uri.parse(_url2);
                Intent intentReg = new Intent(Intent.ACTION_VIEW, _link);
                startActivity(intentReg);

            }
        });


        button14 = (Button) findViewById(R.id.button14);

        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri _link = Uri.parse(_url);
                Intent intentReg = new Intent(Intent.ACTION_VIEW, _link);
                startActivity(intentReg);

            }
        });


        imageButton4 = (ImageButton) findViewById(R.id.imageButton4);

        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(Recomendaciones.this, InicioMenu.class);
                Recomendaciones.this.startActivity(intentReg);
            }
        });

        imageButton7 = (ImageButton) findViewById(R.id.imageButton7);

        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(Recomendaciones.this, Ajustes.class);
                Recomendaciones.this.startActivity(intentReg);
            }
        });


        imageButton6 = (ImageButton) findViewById(R.id.imageButton6);

        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(Recomendaciones.this, Reportes.class);
                Recomendaciones.this.startActivity(intentReg);
            }
        });
    }
}