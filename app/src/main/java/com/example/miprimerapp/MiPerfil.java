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

public class MiPerfil extends AppCompatActivity {

    ImageButton imageButton4;
    ImageButton imageButton7;
    ImageButton imageButton6;
    ImageButton imageButton5;
    Button button8;
    Button button7;
    String nombreg;
    EditText editTextText1, editTextText2,editTextText3,editTextText4, editTextText5,editTextText6, editTextText7,editTextText8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_perfil);

        String usuario = getIntent().getStringExtra("usuario");
        if(usuario != null) {
            nombreg = usuario;

        }

        editTextText1 = (EditText)findViewById(R.id.editTextText);
        editTextText2 = (EditText)findViewById(R.id.editTextText2);
        editTextText3 = (EditText)findViewById(R.id.editTextText3);
        editTextText4 = (EditText)findViewById(R.id.editTextNumber2);
        editTextText5 = (EditText)findViewById(R.id.editTextText4);
        editTextText6 = (EditText)findViewById(R.id.editTextDate);
        editTextText7 = (EditText)findViewById(R.id.editTextNumber);
        editTextText8 = (EditText)findViewById(R.id.editTextTextEmailAddress);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        Cursor fila = BaseDeDatos.rawQuery("select nombre, apaterno,amaterno,dni,usuario,fecha,celular,correo from usuarios where usuario = '" + usuario + "'", null);
        if (fila.moveToFirst()) {
            editTextText1.setText(fila.getString(0));
            editTextText2.setText(fila.getString(1));
            editTextText3.setText(fila.getString(2));
            editTextText4.setText(fila.getString(3));
            editTextText5.setText(fila.getString(4));
            editTextText6.setText(fila.getString(5));
            editTextText7.setText(fila.getString(6));
            editTextText8.setText(fila.getString(7));
        }
        BaseDeDatos.close();



        button8 = (Button) findViewById(R.id.button8);

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(MiPerfil.this, Ajustes.class);
                intentReg.putExtra("usuario",usuario);
                MiPerfil.this.startActivity(intentReg);
            }
        });

        imageButton5 = (ImageButton) findViewById(R.id.imageButton5);

        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(MiPerfil.this, Recomendaciones.class);
                intentReg.putExtra("usuario",usuario);
                MiPerfil.this.startActivity(intentReg);
            }
        });

        imageButton4 = (ImageButton) findViewById(R.id.imageButton4);

        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(MiPerfil.this, InicioMenu.class);
                intentReg.putExtra("usuario",usuario);
                MiPerfil.this.startActivity(intentReg);
            }
        });




        imageButton6 = (ImageButton) findViewById(R.id.imageButton6);

        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(MiPerfil.this, Reportes.class);
                intentReg.putExtra("usuario",usuario);
                MiPerfil.this.startActivity(intentReg);
            }
        });

    }

    public void GuardarCambios(View view) {
        String nombre = editTextText1.getText().toString();
        String apaterno = editTextText2.getText().toString();
        String amaterno = editTextText3.getText().toString();
        String dni = editTextText4.getText().toString();
        String usuario = editTextText5.getText().toString();
        String fecha = editTextText6.getText().toString();
        String celular = editTextText7.getText().toString();
        String correo = editTextText8.getText().toString();
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        if(!nombre.isEmpty() && !apaterno.isEmpty() && !amaterno.isEmpty() && !fecha.isEmpty() &&!celular.isEmpty() && !correo.isEmpty() && !usuario.isEmpty() && !dni.isEmpty() ) {


//validamos que el correo tengo @gmail @hotmail
            if (correo.contains("@gmail.com") || correo.contains("@hotmail.com")) {
                //valiamos si el apellido materno contiene numeros
                if (amaterno.contains("1") || amaterno.contains("2") || amaterno.contains("3") || amaterno.contains("4") || amaterno.contains("5") || amaterno.contains("6") || amaterno.contains("7") || amaterno.contains("8") || amaterno.contains("9")) {
                    Toast.makeText(this, "El campo “Apellido Materno” es incorrecto.", Toast.LENGTH_SHORT).show();
                } else {
                    //valiamos si el apellido paterno contiene numeros
                    if (apaterno.contains("1") || apaterno.contains("2") || apaterno.contains("3") || apaterno.contains("4") || apaterno.contains("5") || apaterno.contains("6") || apaterno.contains("7") || apaterno.contains("8") || apaterno.contains("9")) {
                        Toast.makeText(this, "El campo “Apellido Paterno” es incorrecto.", Toast.LENGTH_SHORT).show();
                    } else {
                        //valiamos si el nombre contiene numeros
                        if (nombre.contains("1") || nombre.contains("2") || nombre.contains("3") || nombre.contains("4") || nombre.contains("5") || nombre.contains("6") || nombre.contains("7") || nombre.contains("8") || nombre.contains("9")) {
                            Toast.makeText(this, "El campo “Nombres” es incorrecto.", Toast.LENGTH_SHORT).show();
                        } else {


                                //Validar que exista el celular
                                Cursor fila2 = BaseDeDatos.rawQuery("select nombre, apaterno from usuarios where celular = '" + celular + "' and usuario !='"+ nombreg + "'", null);

                                if (fila2.moveToFirst()) {

                                    Toast.makeText(this, "Campo “Celular” incorrecto", Toast.LENGTH_SHORT).show();

                                } else {
                                    //Validar que exista el correo
                                    Cursor fila3 = BaseDeDatos.rawQuery("select nombre, apaterno from usuarios where correo = '" + correo + "' and usuario !='"+ nombreg + "'", null);

                                    if (fila3.moveToFirst()) {

                                        Toast.makeText(this, "Campo “Correo” incorrecto", Toast.LENGTH_SHORT).show();

                                    } else {

                                        ContentValues registro = new ContentValues();
                                        registro.put("nombre", nombre);
                                        registro.put("apaterno", apaterno);
                                        registro.put("amaterno", amaterno);
                                        registro.put("fecha", fecha);
                                        registro.put("celular", celular);
                                        registro.put("correo", correo);
                                        registro.put("usuario", usuario);
                                        registro.put("dni", dni);
                                        BaseDeDatos.update("usuarios", registro, "usuario='" + nombreg + "'", null);
                                        Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show();
                                    }
                                }


                            //termina el validar si el usuario existe
                        }
                        //termina el validar si el nombre tiene numero
                    }
                    //termina el validar si el apellido paterno tiene numero
                }
                //termina el validar si el apellido materno tiene numero
            } else {
                Toast.makeText(this, "Campo “Correo” incorrecto", Toast.LENGTH_SHORT).show();
            }
        }else{
            //CAMPOS VACIOS
            Toast.makeText(this, "Falta completar datos", Toast.LENGTH_SHORT).show();
        }
        BaseDeDatos.close();

        }


}