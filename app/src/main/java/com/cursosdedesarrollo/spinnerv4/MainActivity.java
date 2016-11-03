package com.cursosdedesarrollo.spinnerv4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private static String[]cadenas={"Ninguno","Lunes","Martes",
    "Miércoles","Jueves","Viernes","Sábado","Domingo"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=(Spinner)findViewById(R.id.spinner);

        ArrayAdapter<String> adapter =
                new ArrayAdapter(
                        getApplicationContext(),
                        android.R.layout.simple_spinner_item,cadenas);
        /*ArrayAdapter<CharSequence> adapter=
                ArrayAdapter.createFromResource(getApplicationContext(),
                        R.array.planets_array,
                        android.R.layout.simple_spinner_item);
        */
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(
                    AdapterView<?> parent, View view,
                    int position, long id) {
                TextView tv=(TextView)view;
                String salida="Has seleccionado '"+
                        parent.getItemAtPosition(position).toString()
                        //tv.getText().toString()
                        +"'";
                Toast.makeText(
                        getApplicationContext(),
                        salida,
                        Toast.LENGTH_LONG
                ).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(),
                        "No han seleccionado nada",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
