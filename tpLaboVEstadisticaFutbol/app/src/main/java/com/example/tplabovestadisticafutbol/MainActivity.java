package com.example.tplabovestadisticafutbol;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;

import java.util.List;

public class MainActivity extends AppCompatActivity implements  Handler.Callback{
    public static List<Futbolista> listaDeJugadores;
    public static AdapterFutbolista adapterFutbolista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler handler = new Handler(this);
        HiloConexion h = new HiloConexion(handler, true);
        h.start();
       //HiloConexion hDetalle = new HiloConexion(handler,false);
        //hDetalle.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean handleMessage(@NonNull Message message) {
        if(message.arg1==HiloConexion.GOLEADORES)
        {
            listaDeJugadores = (List<Futbolista>) message.obj;
            //Generamos nuestro objeto adapter y le pasamos la lista de usuarios
            adapterFutbolista = new AdapterFutbolista(listaDeJugadores);

            //recuperamos el RecyclerView (el que esta en el activity_main.xml) de nuestra pantalla
            RecyclerView recyclerView = findViewById(R.id.rvMaximoGoleadores);

            //Una vez que tenemos el RecyclerView y tenemos generado el adapter, al RecyclerView le decimos quien es el adapter
            recyclerView.setAdapter(adapterFutbolista);

            //Cuando el RecyclerView ya tiene su adapter le tenemos que decir de que manera tiene que representar estos items
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(linearLayoutManager);
        }

        return false;
    }
}