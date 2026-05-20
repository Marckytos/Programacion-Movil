package com.example.practicasandroid;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaFragmentosActivity extends Activity {

    ListView lista;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);

        setContentView(R.layout.activity_lista_fragmentos);

        lista = findViewById(R.id.listaAnimales);

        String[] animales = {"Gato", "Perro", "Vaca"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                animales
        );

        lista.setAdapter(adapter);

        remplazarFragmento(new GatoFragment());

        lista.setOnItemClickListener((parent, view, position, id) -> {

            switch(position){

                case 0:
                    remplazarFragmento(new GatoFragment());
                    break;

                case 1:
                    remplazarFragmento(new PerroFragment());
                    break;

                case 2:
                    remplazarFragmento(new VacaFragment());
                    break;
            }
        });
    }

    public void remplazarFragmento(Fragment fragmento){

        FragmentManager manager = getFragmentManager();

        manager.beginTransaction()
                .replace(R.id.contenedorFragmentos, fragmento)
                .commit();
    }
}