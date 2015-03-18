package com.example.juandiego.conversor;

import android.R.*;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends ActionBarActivity implements OnClickListener{

    // CAMPOS /////////////////////////////////////////////////////
    EditText dolar;
    EditText peso;
    EditText cambio;
    RadioButton RadDolar;
    RadioButton RadPeso;
    Button Convert;
    Button Limpiar;
    // FIN CAMPOS //////////////////////////////////////////////////


    /** Al inicar la actividad ... */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);

        // INICIALIZACIÓN DE CAMPOS //////////////////////////////////////////////
        dolar = (EditText)this.findViewById(R.id.EditDolar);
        peso = (EditText)this.findViewById(R.id.EditPesos);
        cambio = (EditText)this.findViewById(R.id.EditCambio);

        RadDolar = (RadioButton)this.findViewById(R.id.RadDolarAPeso);
        RadDolar.setChecked(false);
        RadPeso = (RadioButton)this.findViewById(R.id.RadPesoADolar);
        RadPeso.setChecked(false);
        Convert = (Button)this.findViewById(R.id.btnconversor);
        Limpiar = (Button)this.findViewById(R.id.btnclear);
        // FIN INICIALIZACIÓN DE CAMPOS ////////////////////////////////////////////////


        // EVENTOS ///////////////////////////////////////////
        Convert.setOnClickListener(this);
        Limpiar.setOnClickListener(this);
        RadDolar.setOnClickListener(this);
        RadPeso.setOnClickListener(this);
        // FIN EVENTOS ///////////////////////////////////////

    }
    /**
     * Convierte los dólares a pesos
     */
    protected void ConvierteDolarPeso() {

        double dol;
        double cam;


        // Controla los campos introducidos
        if ("".equals(dolar.getText().toString())){
            dol = 0;
        }
        else{
            dol = Double.parseDouble(dolar.getText().toString());
        }

        if ("".equals(cambio.getText().toString())){
            cam = 0;
        }
        else{
            cam = Double.parseDouble(cambio.getText().toString());
        }

        // Convierte el cambio a pesos


        peso.setText(Double.toString(dol*cam));
    }


    /**
     * Convierte los pesos a dólares
     */
    protected void ConviertePesoDolar() {

        double pes;
        double cam;

        // Controla los campos introducidos
        if ("".equals(peso.getText().toString())) {
            pes = 0;
        } else {
            pes = Double.parseDouble(peso.getText().toString());
        }

        if ("".equals(cambio.getText().toString())) {
            cam = 0;
        } else {
            cam = Double.parseDouble(cambio.getText().toString());
        }
        // Convierte los cambios a dólares



        dolar.setText(Double.toString(pes/cam));
    }
    /**
     * Convierte los pesos a dólares o
     * los dólares a pesos
     */
    public void onClick(View v) {

       String moneda = null;

        if(v== Limpiar){
            Toast.makeText(Limpiar.getContext(), "Limpiando", Toast.LENGTH_SHORT).show();
            peso.setText("");
            dolar.setText("");
            cambio.setText("");
        }
        // Controla que no estén dos radioButtons chequeados


        if (v == RadDolar) {
            RadDolar.setChecked(true);
            RadPeso.setChecked(false);

        }

        if (v == RadPeso) {
             RadPeso.setChecked(true);
             RadDolar.setChecked(false);


        }

        // Controla el radioButtons chequeado
        if (v == Convert) {

            if( "".equals(cambio.getText().toString())&&"".equals(peso.getText().toString())&&"".equals(dolar.getText().toString())){
                Toast.makeText(Convert.getContext(), "Campos vacios", Toast.LENGTH_SHORT).show();
            }else {

                if (RadDolar.isChecked() == true) {
                    if ("".equals(cambio.getText().toString())) {
                        Toast.makeText(Convert.getContext(), "Tipo de cambio vacio", Toast.LENGTH_SHORT).show();
                    } else {
                        ConvierteDolarPeso();
                        Toast.makeText(Convert.getContext(), "Convirtiendo a Pesos", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    if (RadPeso.isChecked() == true) {
                        if ("".equals(cambio.getText().toString())) {
                            Toast.makeText(Convert.getContext(), "Tipo de cambio vacio", Toast.LENGTH_SHORT).show();
                        } else {
                            ConviertePesoDolar();
                            Toast.makeText(Convert.getContext(), "Convirtiendo a Dolares", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        }


    }
    }