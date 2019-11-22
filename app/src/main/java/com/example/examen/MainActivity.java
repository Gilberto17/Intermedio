package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mBtnDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnDatos = findViewById(R.id.btnDatos);

        mBtnDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,pantalla2.class);
                        startActivity(intent);
                Toast.makeText(getApplicationContext(),
                        "hola Soy el Boton",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    public void cambiarActivity(View view) {
        Intent miIntent=null;
        switch (view.getId()){
            case R.id.botonDatos:
                Toast.makeText(this,"Entrando a la nueva actividad", Toast.LENGTH_LONG).show();
                miIntent=new Intent(MainActivity.this,pantalla2.class);
                break;
        }
        if (miIntent!=null){
            startActivity(miIntent);
        }
    }



}
