package com.example.miprimerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.channels.spi.AbstractSelectionKey;

public class InicioMenu extends AppCompatActivity {

    ImageButton imageButton7;
    ImageButton imageButton5;
    ImageButton imageButton6;
    Button button20;

    TextView textView15;
    TextView textView24;
    TextView textView16;
    TextView textView26;
    TextView textView28;
    TextView textView29;


    String latidos="060";
    int segundos = 60;
    int variable =2;
    String nombreg;

    int TIEMPO = 1000;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_menu);
        String usuario = getIntent().getStringExtra("usuario");

        button20 = (Button) findViewById(R.id.button20);
        imageButton7 = (ImageButton) findViewById(R.id.imageButton7);

        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(InicioMenu.this, Ajustes.class);
                intentReg.putExtra("usuario",usuario);
                InicioMenu.this.startActivity(intentReg);
            }
        });

        imageButton5 = (ImageButton) findViewById(R.id.imageButton5);

        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(InicioMenu.this, Recomendaciones.class);
                intentReg.putExtra("usuario",usuario);
                InicioMenu.this.startActivity(intentReg);
            }
        });


        imageButton6 = (ImageButton) findViewById(R.id.imageButton6);

        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(InicioMenu.this, Reportes.class);
                intentReg.putExtra("usuario",usuario);
                InicioMenu.this.startActivity(intentReg);
            }
        });
        Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();


        if(usuario != null) {
            nombreg = usuario;

        }
         if(nombreg != null) {
            textView15 = (TextView) findViewById(R.id.textView15);

            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
            SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

            Cursor fila = BaseDeDatos.rawQuery("select nombre, apaterno,amaterno from usuarios where usuario = '" + usuario + "'", null);
             if (fila.moveToFirst()) {
                 String nombre = fila.getString(0) + " " + fila.getString(1) + " " + fila.getString(2);
                 textView15.setText(nombre);
             }
             BaseDeDatos.close();
        }


        textView24 = (TextView) findViewById(R.id.textView24);
        textView16 = (TextView) findViewById(R.id.textView16);
        textView26 = (TextView) findViewById(R.id.textView26);
        textView28 = (TextView) findViewById(R.id.textView28);
        textView29 = (TextView) findViewById(R.id.textView29);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        Cursor fila = BaseDeDatos.rawQuery("select nombre, usuario from reporte group by nombre", null);
        if (fila.moveToFirst()) {
            String alertas = "Alertas "+ String.valueOf(fila.getCount());
            if(nombreg.contains("admin")) {
                button20.setText(alertas);
            }
        }
        BaseDeDatos.close();





    }

    public void hilo(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    public void ejecutar() {
        time time= new time();
        time.execute();

        String tiempo ="000";
        if(segundos>0){
            segundos--;
            tiempo = "0"+String.valueOf(segundos);
            textView24.setText(tiempo);
            textView16.setText("CALCULANDO");
            textView26.setText("CALCULANDO");

        }else {
            if (segundos==0) {
                if(nombreg.contains("admin")){
                    textView16.setText("OPTIMO");
                    textView24.setText("083");
                    textView26.setText("NEUTRO");
                    textView28.setText("085");
                    textView29.setText("077");
                    variable = 8;
                    segundos=-1;
                }else{
                    if(nombreg.contains("angi")){
                        textView16.setText("OPTIMO");
                        textView24.setText("072");
                        textView26.setText("NEUTRO");
                        textView28.setText("080");
                        textView29.setText("071");
                        variable = 8;
                        segundos=-1;
                    }else{
                        if(nombreg.contains("alito")){
                            textView16.setText("OPTIMO");
                            textView24.setText("071");
                            textView26.setText("NEUTRO");
                            textView28.setText("077");
                            textView29.setText("070");
                            variable = 8;
                            segundos=-1;
                        }
                    }
                }


            } else {
                if(nombreg.contains("angi")) {
                    // función a ejecutar angi
                    if (textView24.getText().toString() == "072") {
                        textView24.setText("074");
                    } else {
                        if (textView24.getText().toString() == "074") {
                            textView24.setText("077");
                        } else {
                            if (textView24.getText().toString() == "077") {
                                textView24.setText("084");
                                textView16.setText("REGULAR");
                                textView26.setText("ESTRESADO");
                                Toast.makeText(this, "NIVEL DE ESTRES REGULAR Y ESTADO DE ANIMO ESTRESADO", Toast.LENGTH_SHORT).show();

                            }
                        }
                    }
                    //termina el del angi
                }else {
                    if(nombreg.contains("alito")) {
                        // función a ejecutar alito
                        if (textView24.getText().toString() == "071") {
                            textView24.setText("072");
                        } else {
                            if (textView24.getText().toString() == "072") {
                                textView24.setText("076");
                            } else {
                                if (textView24.getText().toString() == "076") {
                                    textView24.setText("074");
                                }
                            }
                        }
                        //termina el del alito
                    }else {


                        // función a ejecutar admin
                        if (textView24.getText().toString() == "083") {
                            textView24.setText("077");
                        } else {
                            if (textView24.getText().toString() == "077") {
                                textView24.setText("085");
                            } else {
                                if (textView24.getText().toString() == "085") {
                                    textView24.setText("090");
                                    textView16.setText("LEVE");
                                    Toast.makeText(this, "NIVEL DE ESTRES LEVE", Toast.LENGTH_SHORT).show();
                                } else {
                                    if (textView24.getText().toString() == "090") {
                                        textView24.setText("093");
                                        textView16.setText("REGULAR");
                                        textView26.setText("ESTRESADO");
                                        Toast.makeText(this, "NIVEL DE ESTRES REGULAR Y ESTADO DE ANIMO ESTRESADO", Toast.LENGTH_SHORT).show();
                                    } else {
                                        if (textView24.getText().toString() == "093") {
                                            textView24.setText("098");
                                            textView16.setText("ALTO");
                                            textView26.setText("ESTRESADO");
                                            Toast.makeText(this, "NIVEL DE ESTRES ALTO Y ESTADO DE ANIMO ESTRESADO", Toast.LENGTH_SHORT).show();

                                        }
                                    }
                                }
                            }
                        }
                        //termina el del admin
                    }
                }
            }

        }

    }

    public void calcular(View view){


        time time = new time();
        time.execute();
    }

    public class time extends AsyncTask<Void,Integer, Boolean>{

        @Override
        protected Boolean doInBackground(Void... voids) {
            for (int i=1; i<variable;i++){
                hilo();
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            ejecutar();




        }
    }


    public void MostrarAlertas(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        Cursor fila = BaseDeDatos.rawQuery("select usuario, fecha,hora,frecuencia,estado from reporte where estado = '" + "ESTRESADO" + "'", null);
        while (fila.moveToNext()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(InicioMenu.this);
            builder.setTitle("El usuario "+ fila.getString(0));
            builder.setMessage("Sufrio Estres el dia "+ fila.getString(1)+" hora "+fila.getString(2)+ " con frecuencia "+ fila.getString(3))
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    })
                    .setCancelable(false)
                    .show();
        }

        BaseDeDatos.close();
    }




}