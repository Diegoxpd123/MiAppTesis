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
import android.widget.TextView;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    TextView tv_iniciarsesion;
    Button bt_crearcuenta;
    private EditText et_nombre, et_apaterno, et_amaterno, et_fecha, et_celular, et_correo, et_usuario, et_contra, et_contrac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        et_nombre = (EditText)findViewById(R.id.et_nombre);
        et_apaterno = (EditText)findViewById(R.id.et_apaterno);
        et_amaterno = (EditText)findViewById(R.id.et_materno);
        et_fecha = (EditText)findViewById(R.id.et_fecha);
        et_celular = (EditText)findViewById(R.id.et_celular);
        et_correo = (EditText)findViewById(R.id.et_correo);
        et_usuario = (EditText)findViewById(R.id.et_usuario);
        et_contra = (EditText)findViewById(R.id.et_contra);
        et_contrac = (EditText)findViewById(R.id.et_contrac);




        tv_iniciarsesion = (TextView) findViewById(R.id.tv_iniciarsesion);

        tv_iniciarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(Registro.this, MainActivity.class);
                Registro.this.startActivity(intentReg);
            }
        });
    }

    //Metodo para registrar usuario
    public void Registrar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String nombre = et_nombre.getText().toString();
        String apaterno = et_apaterno.getText().toString();
        String amaterno = et_amaterno.getText().toString();
        String fecha = et_fecha.getText().toString();
        String celular = et_celular.getText().toString();
        String correo = et_correo.getText().toString();
        String usuario = et_usuario.getText().toString();
        String contra = et_contra.getText().toString();
        String contrac = et_contrac.getText().toString();

        if(!nombre.isEmpty() && !apaterno.isEmpty() && !amaterno.isEmpty() && !fecha.isEmpty() &&!celular.isEmpty() && !correo.isEmpty() && !usuario.isEmpty() && !contra.isEmpty() && !contrac.isEmpty()) {
            //if(!nombre.isEmpty()) {
                //validamos que las contraseñas sean iguales
                if (contra.equals(contrac)) {
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
                                //Validar que exista el usuario
                                Cursor fila = BaseDeDatos.rawQuery("select nombre, apaterno from usuarios where usuario = '" + usuario + "'", null);

                                if (fila.moveToFirst()) {

                                    Toast.makeText(this, "Usuario existente", Toast.LENGTH_SHORT).show();

                                } else {

                                    //Validar que exista el celular
                                    Cursor fila2 = BaseDeDatos.rawQuery("select nombre, apaterno from usuarios where celular = '" + celular + "'", null);

                                    if (fila2.moveToFirst()) {

                                        Toast.makeText(this, "Campo “Celular” incorrecto", Toast.LENGTH_SHORT).show();

                                    } else {
                                        //Validar que exista el correo
                                        Cursor fila3 = BaseDeDatos.rawQuery("select nombre, apaterno from usuarios where correo = '" + correo + "'", null);

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
                                            registro.put("contra", contra);

                                            BaseDeDatos.insert("usuarios", null, registro);

                                            BaseDeDatos.close();
                                            et_nombre.setText("");
                                            et_apaterno.setText("");
                                            et_amaterno.setText("");
                                            et_fecha.setText("");
                                            et_celular.setText("");
                                            et_correo.setText("");
                                            et_usuario.setText("");
                                            et_contra.setText("");
                                            et_contrac.setText("");
                                            Toast.makeText(this, "El usuario fue registrado exitosamente", Toast.LENGTH_SHORT).show();

                 /*  bt_crearcuenta = (Button) findViewById(R.id.bt_crearcuenta);

                    bt_crearcuenta.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intentReg = new Intent(Registro.this, MainActivity.class);
                            Registro.this.startActivity(intentReg);
                        }
                    });*/
                                        }
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
            }else {
                    Toast.makeText(this, "Campo “Contraseña” incorrecto", Toast.LENGTH_SHORT).show();
                }

        }else{
            //CAMPOS VACIOS
            Toast.makeText(this, "Falta completar datos", Toast.LENGTH_SHORT).show();
        }
        BaseDeDatos.close();
    }



}