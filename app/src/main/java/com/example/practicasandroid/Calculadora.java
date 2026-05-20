package com.example.practicasandroid;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Calculadora extends Activity implements View.OnClickListener {
    Button [] btnDigitos = new Button[10];
    int col=0;
    boolean pintarPunto=true;
    EditText pantalla;
    double op1,op2,res;
    String operacion = "";
    Button btnSuma, btnResta, btnMultiplicacion, btnDivision, btnPunto, btnIgual;

    protected void onCreate(Bundle b){
        super.onCreate(b);
        LinearLayout panelPrincipal = new LinearLayout(this);
        panelPrincipal.setBackgroundColor(Color.BLACK);
        panelPrincipal.setOrientation(LinearLayout.VERTICAL);

        LinearLayout panelPantalla = new LinearLayout(this);
        panelPantalla.setOrientation(LinearLayout.VERTICAL);
        panelPantalla.setBackgroundColor(Color.GRAY);
        panelPantalla.setMinimumHeight(200);

        TextView cuadro = new TextView(this);
        cuadro.setBackgroundColor(Color.BLUE);
        cuadro.setText(" ");
        cuadro.setMinimumHeight(50);

        pantalla = new EditText(this);
        pantalla.setTextColor(Color.WHITE);
        pantalla.setTextSize(40);
        pantalla.setMaxLines(1);
        pantalla.setTextAlignment(EditText.TEXT_ALIGNMENT_TEXT_END);

        panelPantalla.addView(cuadro);
        panelPantalla.addView(pantalla);


        LinearLayout panelControles = new LinearLayout(this);
        panelControles.setBackgroundColor(Color.RED);

        LinearLayout panelBotones1 = new LinearLayout(this);
        panelBotones1.setBackgroundColor(Color.WHITE);
        panelBotones1.setOrientation(LinearLayout.VERTICAL);
        LinearLayout panelBotones2 = new LinearLayout(this);
        panelBotones2.setOrientation(LinearLayout.VERTICAL);
        panelBotones2.setBackgroundColor(Color.GREEN);

        LinearLayout li1 = new LinearLayout(this);
        LinearLayout li2 = new LinearLayout(this);
        LinearLayout li3 = new LinearLayout(this);
        LinearLayout li4 = new LinearLayout(this);


        for(int i = 0; i<=9;i++){
            btnDigitos[i] = new Button(this);
            btnDigitos[i].setText(i+"");
            btnDigitos[i].setOnClickListener(this);

            switch(i) {
                case 0:
                    li4.addView(btnDigitos[i]);
                    break;
                case 1:
                case 2:
                case 3:
                    li3.addView(btnDigitos[i]);
                    break;
                case 4:
                case 5:
                case 6:
                    li2.addView(btnDigitos[i]);
                    break;
                case 7:
                case 8:
                case 9:
                    li1.addView(btnDigitos[i]);
                    break;
            }
            col = col+1;
        }

        btnPunto = new Button(this);
        btnPunto.setText(".");
        btnPunto.setOnClickListener(this);

        btnIgual = new Button(this);
        btnIgual.setText("=");
        btnIgual.setOnClickListener(this);

        li4.addView(btnPunto);
        li4.addView(btnIgual);

        btnSuma = new Button(this);
        btnSuma.setText("+");
        btnSuma.setOnClickListener(this);

        btnResta = new Button(this);
        btnResta.setText("-");
        btnResta.setOnClickListener(this);

        btnMultiplicacion = new Button(this);
        btnMultiplicacion.setText("*");
        btnMultiplicacion.setOnClickListener(this);

        btnDivision = new Button(this);
        btnDivision.setText("/");
        btnDivision.setOnClickListener(this);

        panelBotones1.addView(li1);
        panelBotones1.addView(li2);
        panelBotones1.addView(li3);
        panelBotones1.addView(li4);

        panelBotones2.addView(btnSuma);
        panelBotones2.addView(btnResta);
        panelBotones2.addView(btnMultiplicacion);
        panelBotones2.addView(btnDivision);

        panelPrincipal.addView(panelPantalla);
        panelControles.addView(panelBotones1);
        panelControles.addView(panelBotones2);
        panelPrincipal.addView(panelControles);

        setContentView(panelPrincipal);
    }

    public void onClick(View v) {
        if (v.equals(btnDigitos[0])){
//pantalla.setText(pantalla.getText()+"1");
            pantalla.setText(pantalla.getText()+"0");
        }
        if (v.equals(btnDigitos[1])){
//pantalla.setText(pantalla.getText()+"1");
            pantalla.setText(pantalla.getText()+"1");
        }
        if (v.equals(btnDigitos[2])){
//pantalla.setText(pantalla.getText()+"1");
            pantalla.setText(pantalla.getText()+"2");
        }
        if (v.equals(btnDigitos[3])){
//pantalla.setText(pantalla.getText()+"1");
            pantalla.setText(pantalla.getText()+"3");
        }
        if (v.equals(btnDigitos[4])){
//pantalla.setText(pantalla.getText()+"1");
            pantalla.setText(pantalla.getText()+"4");
        }
        if (v.equals(btnDigitos[5])){
//pantalla.setText(pantalla.getText()+"1");
            pantalla.setText(pantalla.getText()+"5");
        }
        if (v.equals(btnDigitos[6])){
//pantalla.setText(pantalla.getText()+"1");
            pantalla.setText(pantalla.getText()+"6");
        }
        if (v.equals(btnDigitos[7])){
//pantalla.setText(pantalla.getText()+"1");
            pantalla.setText(pantalla.getText()+"7");
        }
        if (v.equals(btnDigitos[8])){
//pantalla.setText(pantalla.getText()+"1");
            pantalla.setText(pantalla.getText()+"8");
        }
        if (v.equals(btnDigitos[9])){
//pantalla.setText(pantalla.getText()+"1");
            pantalla.setText(pantalla.getText()+"9");
        }
        if (v.equals(btnPunto)){
            if(pintarPunto){
                pantalla.setText(pantalla.getText()+".");
                pintarPunto=false;
            }
        }
        if (v.equals(btnSuma)){
            pintarPunto=true;
            op1 = Double.parseDouble(pantalla.getText()+"");
            operacion = "+";
            pantalla.setText("");
        }

        if (v.equals(btnResta)){
            pintarPunto=true;
            op1 = Double.parseDouble(pantalla.getText()+"");
            operacion = "-";
            pantalla.setText("");
        }

        if (v.equals(btnMultiplicacion)){
            pintarPunto=true;
            op1 = Double.parseDouble(pantalla.getText()+"");
            operacion = "*";
            pantalla.setText("");
        }

        if (v.equals(btnDivision)){
            pintarPunto=true;
            op1 = Double.parseDouble(pantalla.getText()+"");
            operacion = "/";
            pantalla.setText("");
        }

        if (v.equals(btnIgual)){
            pintarPunto=true;
            op2 = Double.parseDouble(pantalla.getText()+"");

            if(operacion.equals("+")){
                res = op1 + op2;
            }

            if(operacion.equals("-")){
                res = op1 - op2;
            }

            if(operacion.equals("*")){
                res = op1 * op2;
            }

            if(operacion.equals("/")){
                res = op1 / op2;
            }

            pantalla.setText(String.valueOf(res));
        }
    }
}