package com.example.tplabovestadisticafutbol;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  Handler.Callback, SearchView.OnQueryTextListener{
    public static List<Futbolista> listaDeJugadores;
    public static AdapterFutbolista adapterFutbolista;

    public int keyLigaSeleccionada=207;
    Handler handler;
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler(this);
        traerMaximosGoleadoresSegunLaLiga(keyLigaSeleccionada);
        actionBar = super.getSupportActionBar();
        //HiloConexion hDetalle = new HiloConexion(handler,false);
        //hDetalle.start();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.serieA) {
            keyLigaSeleccionada = 207;
            actionBar.setTitle("Serie A - Maximos Goleadores");
        } else if (id == R.id.LaLiga) {
            keyLigaSeleccionada = 302;
            actionBar.setTitle("LaLiga - Maximos Goleadores");
        } else if (id == R.id.Premier) {
            keyLigaSeleccionada = 152;
            actionBar.setTitle("Premier - Maximos Goleadores");
        } else if (id == R.id.Mls) {
            keyLigaSeleccionada = 332;
            actionBar.setTitle("MLS - Maximos Goleadores");
        }else if (id == R.id.Ligue1) {
            keyLigaSeleccionada = 168;
            actionBar.setTitle("Ligue 1 - Maximos Goleadores");
        }

        traerMaximosGoleadoresSegunLaLiga(keyLigaSeleccionada);
        return super.onOptionsItemSelected(item);
    }

    private void traerMaximosGoleadoresSegunLaLiga(int keyLigaSeleccionada) {
        // CAMBIO LA CATEGORIA DE COMIDA
        String ruta = "https://apiv2.allsportsapi.com/football/?&met=Topscorers&leagueId="+keyLigaSeleccionada+"&APIkey=f9f23b7d28dadcf3a99d5c2fb69f62d2fb40ac61a1bc8f007dd0300ab09bea47";
        //LE PASO AL HILO LOS VALORES
        HiloConexion h = new HiloConexion(handler, ruta, HiloConexion.MOSTRAR_GOLEADORES);
        h.start();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);

        MenuItem searchItem = menu.findItem(R.id.svBuscar);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean handleMessage(@NonNull Message message) {
        if(message.arg1==HiloConexion.MOSTRAR_GOLEADORES || message.arg1==HiloConexion.MOSTRAR_JUGADORES_SV)
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
            adapterFutbolista.notifyDataSetChanged();
        }

        return false;
    }


    //Para Search View
    @Override
    public boolean onQueryTextSubmit(String nombreIngresado) {
        // CAMBIO LA CATEGORIA DE COMIDA
        String ruta = "https://apiv2.allsportsapi.com/football/?&met=Players&playerName="+nombreIngresado+"&APIkey=f9f23b7d28dadcf3a99d5c2fb69f62d2fb40ac61a1bc8f007dd0300ab09bea47";
        //LE PASO AL HILO LOS VALORES
        HiloConexion h = new HiloConexion(handler, ruta, HiloConexion.MOSTRAR_JUGADORES_SV);
        h.start();
        return false;
    }

    //Para Search View
    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}