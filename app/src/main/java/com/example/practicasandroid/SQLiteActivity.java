package com.example.practicasandroid;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SQLiteActivity extends Activity {

    EditText codigo, descripcion, precio;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);

        LinearLayout panel = new LinearLayout(this);
        panel.setOrientation(LinearLayout.VERTICAL);
        panel.setPadding(40,40,40,40);

        codigo = new EditText(this);
        codigo.setHint("Código");

        descripcion = new EditText(this);
        descripcion.setHint("Descripción");

        precio = new EditText(this);
        precio.setHint("Precio");

        Button guardar = new Button(this);
        guardar.setText("Guardar");

        Button consultar = new Button(this);
        consultar.setText("Consultar");

        panel.addView(codigo);
        panel.addView(descripcion);
        panel.addView(precio);
        panel.addView(guardar);
        panel.addView(consultar);

        setContentView(panel);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar();
            }
        });

        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consultar();
            }
        });
    }

    private void guardar(){

        AdminSQLiteOpenHelper admin =
                new AdminSQLiteOpenHelper(this,"administracion",null,1);

        SQLiteDatabase bd = admin.getWritableDatabase();

        ContentValues registro = new ContentValues();

        registro.put("codigo",codigo.getText().toString());
        registro.put("descripcion",descripcion.getText().toString());
        registro.put("precio",precio.getText().toString());

        bd.insert("articulos",null,registro);

        bd.close();

        Toast.makeText(this,"Guardado",Toast.LENGTH_SHORT).show();
    }

    private void consultar(){

        AdminSQLiteOpenHelper admin =
                new AdminSQLiteOpenHelper(this,"administracion",null,1);

        SQLiteDatabase bd = admin.getWritableDatabase();

        Cursor fila = bd.rawQuery(
                "select descripcion, precio from articulos where codigo=?",
                new String[]{codigo.getText().toString()}
        );

        if(fila.moveToFirst()){

            descripcion.setText(fila.getString(0));
            precio.setText(fila.getString(1));

        }else{

            Toast.makeText(this,"No existe",Toast.LENGTH_SHORT).show();
        }

        bd.close();
    }
}