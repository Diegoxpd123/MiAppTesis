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

public class CambiarContra extends AppCompatActivity {

    ImageButton imageButton4;
    ImageButton imageButton7;
    ImageButton imageButton6;
    ImageButton imageButton5;
    Button button11;
    Button button12;
    String nombreg;
    EditText editTextText7, editTextText6,editTextText5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_contra);

        String usuario = getIntent().getStringExtra("usuario");
        if(usuario != null) {
            nombreg = usuario;

        }
        editTextText7 = (EditText)findViewById(R.id.editTextText7);
        editTextText6 = (EditText)findViewById(R.id.editTextText6);
        editTextText5 = (EditText)findViewById(R.id.editTextText5);

        button12 = (Button) findViewById(R.id.button12);

        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(CambiarContra.this, Ajustes.class);
                intentReg.putExtra("usuario",usuario);
                CambiarContra.this.startActivity(intentReg);
            }
        });


        imageButton5 = (ImageButton) findViewById(R.id.imageButton5);

        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(CambiarContra.this, Recomendaciones.class);
                intentReg.putExtra("usuario",usuario);
                CambiarContra.this.startActivity(intentReg);
            }
        });

        imageButton4 = (ImageButton) findViewById(R.id.imageButton4);

        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(CambiarContra.this, InicioMenu.class);
                intentReg.putExtra("usuario",usuario);
                CambiarContra.this.startActivity(intentReg);
            }
        });

        imageButton7 = (ImageButton) findViewById(R.id.imageButton7);

        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(CambiarContra.this, Ajustes.class);
                intentReg.putExtra("usuario",usuario);
                CambiarContra.this.startActivity(intentReg);
            }
        });


        imageButton6 = (ImageButton) findViewById(R.id.imageButton6);

        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(CambiarContra.this, Reportes.class);
                intentReg.putExtra("usuario",usuario);
                CambiarContra.this.startActivity(intentReg);
            }
        });
    }

    public void GuardarContra(View view) {
        String contra = editTextText5.getText().toString();
        String ncontra = editTextText6.getText().toString();
        String ncontra2 = editTextText7.getText().toString();
        if(!contra.isEmpty() && !ncontra.isEmpty() && !ncontra2.isEmpty()){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        if (ncontra.equals(ncontra2)) {
            Cursor fila = BaseDeDatos.rawQuery("select usuario, contra from usuarios where usuario = '" + nombreg + "'", null);
            if (fila.moveToFirst()) {
                String contracomparar = fila.getString(1);
                if (contra.equals(contracomparar)) {
                    ContentValues registro = new ContentValues();
                    registro.put("contra", contra);

                    BaseDeDatos.update("usuarios", registro, "usuario='" + nombreg + "'", null);
                    Toast.makeText(this, "Contraseña actualizada", Toast.LENGTH_SHORT).show();
                    Intent intentReg = new Intent(CambiarContra.this, Ajustes.class);
                    intentReg.putExtra("usuario",nombreg);
                    CambiarContra.this.startActivity(intentReg);

                } else {
                    Toast.makeText(this, "Contraseña actual incorrecto", Toast.LENGTH_SHORT).show();
                }
            }

        } else {
            //CAMPOS VACIOS
            Toast.makeText(this, "Confirmar Nueva Contraseña incorrecto", Toast.LENGTH_SHORT).show();
        }
            BaseDeDatos.close();
    }else {
            //CAMPOS VACIOS
            Toast.makeText(this, "Falta completar datos", Toast.LENGTH_SHORT).show();
        }


    }
}