package com.example.miprimerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toolbar;

public class Reportes extends AppCompatActivity {

    ImageButton imageButton4;
    ImageButton imageButton5;
    ImageButton imageButton7;
    Spinner spinner;
    EditText editTextDate3;
    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportes);

        String[] arraySpinner = new String[] {
                "TODOS","NEUTRO", "ESTRESADO"
        };

        tableLayout = (TableLayout) findViewById(R.id.tableLayout);

        editTextDate3 = (EditText) findViewById(R.id.editTextDate3);
        spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        imageButton4 = (ImageButton) findViewById(R.id.imageButton4);

        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(Reportes.this, InicioMenu.class);
                Reportes.this.startActivity(intentReg);
            }
        });

        imageButton5 = (ImageButton) findViewById(R.id.imageButton5);

        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(Reportes.this, Recomendaciones.class);
                Reportes.this.startActivity(intentReg);
            }
        });


        imageButton7 = (ImageButton) findViewById(R.id.imageButton7);

        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(Reportes.this, Ajustes.class);
                Reportes.this.startActivity(intentReg);
            }
        });
    }

    public void Borrar(View view){
        editTextDate3.setText("");
        spinner.setSelection(0);
    }

    public void Llenar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        Cursor fila = BaseDeDatos.rawQuery("select usuario, fecha,hora,frecuencia,estado from reporte", null);
            while (fila.moveToNext()) {
                TableRow row = new TableRow(getBaseContext());
                TextView textView;
                for (int i = 0; i < 5; i++) {
                    textView = new TextView(getBaseContext());
                    textView.setGravity(Gravity.CENTER_VERTICAL);
                    textView.setPadding(15,15,15,15);

                    if(i==0) {
                        textView.setText(fila.getString(0));
                    }
                    if(i==1) {
                        textView.setText(fila.getString(1));

                    }
                    if(i==2) {
                        textView.setText(fila.getString(2));
                    }
                    if(i==3) {
                        textView.setText(fila.getString(3));
                    }
                    if(i==4) {
                        textView.setText(fila.getString(4));
                    }


                    row.addView(textView);
                }

                tableLayout.addView(row);
            }
        BaseDeDatos.close();
    }




}