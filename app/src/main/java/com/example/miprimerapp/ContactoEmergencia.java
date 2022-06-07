package com.example.miprimerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class ContactoEmergencia extends AppCompatActivity {

    ImageButton imageButton4;
    ImageButton imageButton7;
    ImageButton imageButton6;
    ImageButton imageButton5;
    Button button11;
    Button button12;
    String nombreg;
    EditText editTextText7, editTextText6,editTextText5, editTextText8,editTextText9, editTextText10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto_emergencia);

        String usuario = getIntent().getStringExtra("usuario");
        if(usuario != null) {
            nombreg = usuario;

        }

        editTextText10 = (EditText)findViewById(R.id.editTextText10);
        editTextText9 = (EditText)findViewById(R.id.editTextText9);
        editTextText8 = (EditText)findViewById(R.id.editTextText8);
        editTextText7 = (EditText)findViewById(R.id.editTextText7);
        editTextText6 = (EditText)findViewById(R.id.editTextText6);
        editTextText5 = (EditText)findViewById(R.id.editTextText5);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        Cursor fila = BaseDeDatos.rawQuery("select nombre, celular from contacto where usuario = '" + nombreg + "'", null);
        while (fila.moveToNext()) {
            String nombre = fila.getString(0);
            String celular = fila.getString(1);
            String nombreet = editTextText5.getText().toString();
            String celularet = editTextText6.getText().toString();
            String nombreet2 = editTextText7.getText().toString();
            String celularet2 = editTextText8.getText().toString();
            String nombreet3 = editTextText9.getText().toString();
            String celularet3 = editTextText10.getText().toString();
            if(nombreet.isEmpty() && celularet.isEmpty()) {
                editTextText5.setText(nombre);
                editTextText6.setText(celular);
            }else{
                if(nombreet2.isEmpty() && celularet2.isEmpty()) {
                    editTextText7.setText(nombre);
                    editTextText8.setText(celular);
                }else{
                    if(nombreet3.isEmpty() && celularet3.isEmpty()) {
                        editTextText9.setText(nombre);
                        editTextText10.setText(celular);
                    }
                }
            }


        }
        BaseDeDatos.close();


        button12 = (Button) findViewById(R.id.button12);

        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(ContactoEmergencia.this, Ajustes.class);
                intentReg.putExtra("usuario",usuario);
                ContactoEmergencia.this.startActivity(intentReg);
            }
        });


        imageButton5 = (ImageButton) findViewById(R.id.imageButton5);

        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(ContactoEmergencia.this, Recomendaciones.class);
                intentReg.putExtra("usuario",usuario);
                ContactoEmergencia.this.startActivity(intentReg);
            }
        });

        imageButton4 = (ImageButton) findViewById(R.id.imageButton4);

        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(ContactoEmergencia.this, InicioMenu.class);
                intentReg.putExtra("usuario",usuario);
                ContactoEmergencia.this.startActivity(intentReg);
            }
        });

        imageButton7 = (ImageButton) findViewById(R.id.imageButton7);

        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(ContactoEmergencia.this, Ajustes.class);
                intentReg.putExtra("usuario",usuario);
                ContactoEmergencia.this.startActivity(intentReg);
            }
        });


        imageButton6 = (ImageButton) findViewById(R.id.imageButton6);

        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(ContactoEmergencia.this, Reportes.class);
                intentReg.putExtra("usuario",usuario);
                ContactoEmergencia.this.startActivity(intentReg);
            }
        });
    }

    public void Registrar(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String nombre = editTextText5.getText().toString();
        String celular = editTextText6.getText().toString();

        String nombre2 = editTextText7.getText().toString();
        String celular2 = editTextText8.getText().toString();

        String nombre3 = editTextText9.getText().toString();
        String celular3 = editTextText10.getText().toString();

        if((!nombre.isEmpty() && !celular.isEmpty())||(!nombre2.isEmpty() && !celular2.isEmpty())||(!nombre3.isEmpty() && !celular3.isEmpty())){
           if(!nombre.isEmpty() && !celular.isEmpty()) {
               if (celular.length()==9){
                   ContentValues registro = new ContentValues();
                   registro.put("nombre", nombre);
                   registro.put("usuario", nombreg);
                   registro.put("celular", celular);

                   BaseDeDatos.insert("contacto", null, registro);
                   Toast.makeText(this, "Se inserto el primer contacto", Toast.LENGTH_SHORT).show();
               }else{
                   Toast.makeText(this, "El celular ingresado es incorrecto", Toast.LENGTH_SHORT).show();
               }

           }
            if(!nombre2.isEmpty() && !celular2.isEmpty()) {
                if (celular2.length()==9){
                ContentValues registro2 = new ContentValues();
                registro2.put("nombre", nombre2);
                registro2.put("usuario", nombreg);
                registro2.put("celular", celular2);

                BaseDeDatos.insert("contacto", null, registro2);
                Toast.makeText(this, "Se inserto el segundo contacto", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "El celular ingresado es incorrecto", Toast.LENGTH_SHORT).show();
                }
            }
            if(!nombre3.isEmpty() && !celular3.isEmpty()) {
                if (celular3.length()==9){
                ContentValues registro3 = new ContentValues();
                registro3.put("nombre", nombre3);
                registro3.put("usuario", nombreg);
                registro3.put("celular", celular3);

                BaseDeDatos.insert("contacto", null, registro3);
                Toast.makeText(this, "Se inserto el tercer contacto", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "El celular ingresado es incorrecto", Toast.LENGTH_SHORT).show();
            }
            }

        }else{
            Toast.makeText(this, "Falta completar datos", Toast.LENGTH_SHORT).show();
        }


        BaseDeDatos.close();
    }
}