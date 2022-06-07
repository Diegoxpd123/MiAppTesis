package com.example.miprimerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Ajustes extends AppCompatActivity {

    ImageButton imageButton4;
    ImageButton imageButton5;
    ImageButton imageButton6;
    Button button;
    Button button3;
    Button button4;
    Button button6;
    String nombreg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        String usuario = getIntent().getStringExtra("usuario");
        if(usuario != null) {
            nombreg = usuario;

        }

        button6 = (Button) findViewById(R.id.button6);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(Ajustes.this, MainActivity.class);
                intentReg.putExtra("usuario",usuario);
                Ajustes.this.startActivity(intentReg);
            }
        });


        button4 = (Button) findViewById(R.id.button4);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(Ajustes.this, CambiarContra.class);
                intentReg.putExtra("usuario",usuario);
                Ajustes.this.startActivity(intentReg);
            }
        });


        button3 = (Button) findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(Ajustes.this, ContactoEmergencia.class);
                intentReg.putExtra("usuario",usuario);
                Ajustes.this.startActivity(intentReg);
            }
        });


        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(Ajustes.this, MiPerfil.class);
                intentReg.putExtra("usuario",usuario);
                Ajustes.this.startActivity(intentReg);
            }
        });

        imageButton4 = (ImageButton) findViewById(R.id.imageButton4);

        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(Ajustes.this, InicioMenu.class);
                intentReg.putExtra("usuario",usuario);
                Ajustes.this.startActivity(intentReg);
            }
        });

        imageButton5 = (ImageButton) findViewById(R.id.imageButton5);

        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(Ajustes.this, Recomendaciones.class);
                intentReg.putExtra("usuario",usuario);
                Ajustes.this.startActivity(intentReg);
            }
        });


        imageButton6 = (ImageButton) findViewById(R.id.imageButton6);

        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(Ajustes.this, Reportes.class);
                intentReg.putExtra("usuario",usuario);
                Ajustes.this.startActivity(intentReg);
            }
        });



    }
}