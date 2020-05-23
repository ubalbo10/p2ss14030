package com.example.p2ss14030;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class eliminarequipoActivity extends AppCompatActivity {
    EditText cod;
    Button Eliminar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opc2);
        cod=findViewById(R.id.editText_codequipo);
        Eliminar=findViewById(R.id.buttoneliminarequipo);
    }
}
