package com.example.miprimerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv_registrar;
    TextView tv_recuperarclave;
    Button bt_ingresar;
    int una=0;
    private EditText et_usuario, et_contra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_usuario = (EditText)findViewById(R.id.et_usuario);
        et_contra = (EditText)findViewById(R.id.et_contra);



        tv_registrar = (TextView) findViewById(R.id.tv_registrar);

        tv_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(MainActivity.this, Registro.class);
                MainActivity.this.startActivity(intentReg);
            }
        });

        tv_recuperarclave = (TextView) findViewById(R.id.tv_recuperarclave);

        tv_recuperarclave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(MainActivity.this, RecuperarContra.class);
                MainActivity.this.startActivity(intentReg);
            }
        });


        if(una==0){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        ContentValues registro = new ContentValues();
        registro.put("nombre", "Aldair");
        registro.put("apaterno", "Herrera");
        registro.put("amaterno", "Rosas");
        registro.put("fecha", "21/12/1998");
        registro.put("celular", "998321658");
        registro.put("correo", "pachecoxpd@gmail.com");
        registro.put("usuario", "admin");
        registro.put("contra", "1234");
        registro.put("dni", "75589599");

        BaseDeDatos.insert("usuarios", null, registro);

        ContentValues registro2 = new ContentValues();
        registro2.put("nombre", "robe");
        registro2.put("usuario", "Roberto Landa Sandoval");
        registro2.put("fecha", "04/05/2022");
        registro2.put("hora", "09:00 am");
        registro2.put("frecuencia", "070");
        registro2.put("estado", "NEUTRO");

        BaseDeDatos.insert("reporte", null, registro2);

        ContentValues registro3 = new ContentValues();
        registro3.put("nombre", "alexis");
        registro3.put("usuario", "Alexis Cordova");
        registro3.put("fecha", "04/05/2022");
        registro3.put("hora", "10:00 am");
        registro3.put("frecuencia", "083");
        registro3.put("estado", "NEUTRO");



        ContentValues registro4 = new ContentValues();
        registro4.put("nombre", "robe");
        registro4.put("usuario", "Roberto Landa Sandoval");
        registro4.put("fecha", "04/05/2022");
        registro4.put("hora", "09:25 am");
        registro4.put("frecuencia", "085");
        registro4.put("estado", "ESTRESADO");



        ContentValues registro5 = new ContentValues();
        registro5.put("nombre", "alexis");
        registro5.put("usuario", "Alexis Cordova");
        registro5.put("fecha", "04/05/2022");
        registro5.put("hora", "10:40 am");
        registro5.put("frecuencia", "94");
        registro5.put("estado", "ESTRESADO");

            ContentValues registro6 = new ContentValues();
            registro6.put("nombre", "angi");
            registro6.put("usuario", "Angie Espinoza Melendez");
            registro6.put("fecha", "02/05/2022");
            registro6.put("hora", "09:00 am");
            registro6.put("frecuencia", "74");
            registro6.put("estado", "NEUTRO");

            ContentValues registro7 = new ContentValues();
            registro7.put("nombre", "angi");
            registro7.put("usuario", "Angie Espinoza Melendez");
            registro7.put("fecha", "02/05/2022");
            registro7.put("hora", "09:23 am");
            registro7.put("frecuencia", "77");
            registro7.put("estado", "NEUTRO");

            ContentValues registro8 = new ContentValues();
            registro8.put("nombre", "angi");
            registro8.put("usuario", "Angie Espinoza Melendez");
            registro8.put("fecha", "02/05/2022");
            registro8.put("hora", "09:37 am");
            registro8.put("frecuencia", "84");
            registro8.put("estado", "ESTRESADO");

            ContentValues registro10 = new ContentValues();
            registro10.put("nombre", "alito");
            registro10.put("usuario", "Alisson Albujar Pacheco");
            registro10.put("fecha", "04/05/2022");
            registro10.put("hora", "10:50 am");
            registro10.put("frecuencia", "72");
            registro10.put("estado", "NEUTRO");

            ContentValues registro11 = new ContentValues();
            registro11.put("nombre", "alito");
            registro11.put("usuario", "Alisson Albujar Pacheco");
            registro11.put("fecha", "04/05/2022");
            registro11.put("hora", "11:05 am");
            registro11.put("frecuencia", "76");
            registro11.put("estado", "NEUTRO");

            ContentValues registro12 = new ContentValues();
            registro12.put("nombre", "alito");
            registro12.put("usuario", "Alisson Albujar Pacheco");
            registro12.put("fecha", "04/05/2022");
            registro12.put("hora", "11:15 am");
            registro12.put("frecuencia", "74");
            registro12.put("estado", "NEUTRO");


            BaseDeDatos.insert("reporte", null, registro4);
        BaseDeDatos.insert("reporte", null, registro3);
        BaseDeDatos.insert("reporte", null, registro5);
            BaseDeDatos.insert("reporte", null, registro6);
            BaseDeDatos.insert("reporte", null, registro7);
            BaseDeDatos.insert("reporte", null, registro8);
            BaseDeDatos.insert("reporte", null, registro10);
            BaseDeDatos.insert("reporte", null, registro11);
            BaseDeDatos.insert("reporte", null, registro12);

            ContentValues usuario2 = new ContentValues();
            usuario2.put("nombre", "Angie");
            usuario2.put("apaterno", "Espinoza");
            usuario2.put("amaterno", "Melendez");
            usuario2.put("fecha", "13/06/1998");
            usuario2.put("celular", "998321658");
            usuario2.put("correo", "pachecoxpd@gmail.com");
            usuario2.put("usuario", "angi");
            usuario2.put("contra", "1234");
            usuario2.put("dni", "75589599");

            BaseDeDatos.insert("usuarios", null, usuario2);

            ContentValues usuario3 = new ContentValues();
            usuario3.put("nombre", "Alisson");
            usuario3.put("apaterno", "Albujar");
            usuario3.put("amaterno", "Pacheco");
            usuario3.put("fecha", "13/06/1998");
            usuario3.put("celular", "998321658");
            usuario3.put("correo", "pachecoxpd@gmail.com");
            usuario3.put("usuario", "alito");
            usuario3.put("contra", "1234");
            usuario3.put("dni", "75589599");

            BaseDeDatos.insert("usuarios", null, usuario3);

        BaseDeDatos.close();
        una=1;
        }

    }




    //Metodo para loguearse
    public void Login(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String usuario = et_usuario.getText().toString();
        String contra = et_contra.getText().toString();

        if(!usuario.isEmpty() && !contra.isEmpty()){

            Cursor fila = BaseDeDatos.rawQuery("select nombre, apaterno from usuarios where usuario = '" + usuario + "'", null);

            if (fila.moveToFirst()) {
                Cursor fila2 = BaseDeDatos.rawQuery("select nombre, apaterno from usuarios where contra = '" + contra + "'", null);

                if (fila2.moveToFirst()) {
                    BaseDeDatos.close();

                            Intent intentReg = new Intent(MainActivity.this, InicioMenu.class);
                            intentReg.putExtra("usuario",et_usuario.getText().toString() );
                            MainActivity.this.startActivity(intentReg);


                }else{
                    Toast.makeText(this, "Campo “Contraseña” incorrecto", Toast.LENGTH_SHORT).show();
                }

            }else{
                Toast.makeText(this, "Campo “Usuario” incorrecto", Toast.LENGTH_SHORT).show();
            }




        }else{
        //CAMPOS VACIOS
        Toast.makeText(this, "Falta completar datos", Toast.LENGTH_SHORT).show();
        }
        BaseDeDatos.close();

    }

}