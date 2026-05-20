package com.example.practicasandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);

        LinearLayout panel = new LinearLayout(this);
        panel.setOrientation(LinearLayout.VERTICAL);
        panel.setPadding(40,40,40,40);

        TextView titulo = new TextView(this);
        titulo.setText("Erick Marcos - Programación Móvil");
        titulo.setTextSize(24);

        Button btnInterna = new Button(this);
        btnInterna.setText("Memoria Interna");

        Button btnSD = new Button(this);
        btnSD.setText("Memoria SD");

        Button btnSQLite = new Button(this);
        btnSQLite.setText("SQLite");

        panel.addView(titulo);
        panel.addView(btnInterna);
        panel.addView(btnSD);
        panel.addView(btnSQLite);

        setContentView(panel);

        btnInterna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MemoriaInternaActivity.class);
                startActivity(i);
            }
        });

        btnSD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MemoriaSDActivity.class);
                startActivity(i);
            }
        });

        btnSQLite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SQLiteActivity.class);
                startActivity(i);
            }
        });

    }
}