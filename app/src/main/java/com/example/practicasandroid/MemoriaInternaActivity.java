package com.example.practicasandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MemoriaInternaActivity extends Activity {

    EditText texto;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);

        LinearLayout panel = new LinearLayout(this);
        panel.setOrientation(LinearLayout.VERTICAL);
        panel.setPadding(40,40,40,40);

        texto = new EditText(this);
        texto.setHint("Escribe texto");

        Button guardar = new Button(this);
        guardar.setText("Guardar");

        Button recuperar = new Button(this);
        recuperar.setText("Recuperar");

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

    private void guardar() {

        try {

            OutputStreamWriter archivo =
                    new OutputStreamWriter(openFileOutput("datos.txt", MODE_PRIVATE));

            archivo.write(texto.getText().toString());
            archivo.flush();
            archivo.close();

            Toast.makeText(this,"Guardado correctamente",Toast.LENGTH_SHORT).show();

        } catch (Exception e) {

            Toast.makeText(this,"Error al guardar",Toast.LENGTH_SHORT).show();
        }
    }

    private void recuperar() {

        try {

            BufferedReader archivo =
                    new BufferedReader(
                            new InputStreamReader(openFileInput("datos.txt"))
                    );

            String linea = archivo.readLine();

            String contenido = "";

            while(linea != null){

                contenido = contenido + linea + "\n";
                linea = archivo.readLine();
            }

            archivo.close();

            texto.setText(contenido);

        } catch (Exception e) {

            Toast.makeText(this,"Error al recuperar",Toast.LENGTH_SHORT).show();
        }
    }
}