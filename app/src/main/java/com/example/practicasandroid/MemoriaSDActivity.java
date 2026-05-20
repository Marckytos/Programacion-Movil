package com.example.practicasandroid;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MemoriaSDActivity extends Activity {

    EditText texto;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);

        LinearLayout panel = new LinearLayout(this);
        panel.setOrientation(LinearLayout.VERTICAL);
        panel.setPadding(40,40,40,40);

        texto = new EditText(this);

        Button guardar = new Button(this);
        guardar.setText("Guardar SD");

        Button recuperar = new Button(this);
        recuperar.setText("Recuperar SD");

        panel.addView(texto);
        panel.addView(guardar);
        panel.addView(recuperar);

        setContentView(panel);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar();
            }
        });

        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recuperar();
            }
        });

    }

    private void guardar(){

        try{

            File tarjeta = getExternalFilesDir(null);
            File archivo = new File(tarjeta.getAbsolutePath(),"datosSD.txt");

            FileOutputStream fos = new FileOutputStream(archivo);

            fos.write(texto.getText().toString().getBytes());

            fos.close();

            Toast.makeText(this,"Guardado en SD",Toast.LENGTH_SHORT).show();

        }catch(Exception e){

            Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();
        }
    }

    private void recuperar(){

        try{

            File tarjeta = getExternalFilesDir(null);

            File archivo = new File(tarjeta, "datosSD.txt");

            if(!archivo.exists()){

                Toast.makeText(this,"El archivo no existe",Toast.LENGTH_SHORT).show();

                return;
            }

            FileInputStream fis = new FileInputStream(archivo);

            byte[] buffer = new byte[(int) archivo.length()];

            fis.read(buffer);

            String textoRecuperado = new String(buffer);

            texto.setText(textoRecuperado);

            fis.close();

            Toast.makeText(this,"Archivo recuperado",Toast.LENGTH_SHORT).show();

        }catch(Exception e){

            Toast.makeText(this,"Error al recuperar",Toast.LENGTH_LONG).show();
        }
    }
}