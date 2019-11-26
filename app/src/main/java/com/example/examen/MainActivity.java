package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences infoDatos;
    //VARIABLES GUARDADAS EN SHAREPREFERENCES
    String mNombre, mEmail, mTelefono;

    //VARIABLES GUARDADAS DE LOS CAMPOS DE TEXTO
    EditText txtNombre, txtEmail, txtTelefono;

    Button mBtnDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnDatos = findViewById(R.id.btnDatos);

        infoDatos = getSharedPreferences("misDatos",
                Context.MODE_PRIVATE);
        mNombre = infoDatos.getString("nombre", "");
        mEmail = infoDatos.getString("email", "");
        mTelefono = infoDatos.getString("telefono", "");

        txtNombre = findViewById(R.id.nombre);
        txtEmail = findViewById(R.id.email);
        txtTelefono = findViewById(R.id.telefono);

        txtNombre.setText(mNombre);
        txtEmail.setText(mEmail);
        txtTelefono.setText(mTelefono);


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

    public void guardarDatos(View view){
        if(view.getId() == R.id.botonDatos){
            SharedPreferences.Editor editor = infoDatos.edit();
            editor.putString("nombre",txtNombre.getText().toString());
            editor.putString("email",txtEmail.getText().toString());
            editor.putString("telefono",txtTelefono.getText().toString());

            editor.commit();
            Toast.makeText(this,
                    "Datos Guardados",
                    Toast.LENGTH_LONG).show();

        }
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
