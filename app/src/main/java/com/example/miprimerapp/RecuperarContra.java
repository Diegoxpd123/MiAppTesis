package com.example.miprimerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RecuperarContra extends AppCompatActivity {
    TextView tv_iniciarsesion2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_contra);

        tv_iniciarsesion2 = (TextView) findViewById(R.id.tv_iniciarsesion2);

        tv_iniciarsesion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(RecuperarContra.this, MainActivity.class);
                RecuperarContra.this.startActivity(intentReg);
            }
        });

    }
}