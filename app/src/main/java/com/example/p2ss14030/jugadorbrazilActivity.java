package com.example.p2ss14030;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class jugadorbrazilActivity extends AppCompatActivity {
    BdControladora helper;
    Button cantidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opc1);
      /*Haga una consulta que muestre la cantidad de Jugadores que sean de “Brasil” y cuya edad de
       ingreso al país sea superior a 25 años (20%).*/
      String pais="brasil";
      Integer edad=25;
      String consulta;
        consulta="select count(*) from Jugador where (codpais='br' and edadingreso>25);";

      cantidad=findViewById(R.id.cantidadbrasil);



    }
}
