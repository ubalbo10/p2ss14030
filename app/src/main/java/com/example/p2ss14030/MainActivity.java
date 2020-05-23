package com.example.p2ss14030;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button llenar;
    Button op1;
    Button op2;
    Button op3;
    BdControladora helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llenar=findViewById(R.id.button1);
        op1=findViewById(R.id.button2);
        op2=findViewById(R.id.button3);
        op3=findViewById(R.id.button4);
        op1.setText("Jugadores de brazil");

        helper=new BdControladora(this);
        llenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                helper.abrir();
                helper.llenarbd();
                helper.cerrar();
                Toast.makeText(v.getContext(), "bd llenada", Toast.LENGTH_SHORT).show();



            }
        });
        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                helper.abrir();
                Intent inten= new Intent(v.getContext(), jugadorbrazilActivity.class);

                startActivity(inten);



            }
        });
        op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                helper.abrir();
                Intent inten= new Intent(v.getContext(), eliminarequipoActivity.class);

                startActivity(inten);



            }
        });
        op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                helper.abrir();
                helper.llenarbd();
                Intent inten= new Intent(v.getContext(), addjugadorActivity.class);

                startActivity(inten);



            }
        });

    }
}
