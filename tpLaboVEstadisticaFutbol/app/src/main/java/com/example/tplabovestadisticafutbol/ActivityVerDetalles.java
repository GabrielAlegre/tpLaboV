package com.example.tplabovestadisticafutbol;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MenuItem;

import com.example.tplabovestadisticafutbol.mvc.ControllerFutbolista;
import com.example.tplabovestadisticafutbol.mvc.ModelFutbolista;
import com.example.tplabovestadisticafutbol.mvc.ViewFutbolista;

public class ActivityVerDetalles extends AppCompatActivity implements Handler.Callback {

    public static ModelFutbolista futbolistaModel;
    ViewFutbolista futbolistaView;
    ControllerFutbolista futbolistaController;
    public static Futbolista jugadorParaVerDetalle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_detalle_jugador);
        ActionBar actionBar = super.getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        SharedPreferences sp = getSharedPreferences("Confing", Context.MODE_PRIVATE);

        Bundle bundle = this.getIntent().getExtras();
        jugadorParaVerDetalle = (Futbolista) bundle.getSerializable("jugadorQueSeEligio");
        Handler handler = new Handler(this);

        String ruta = "https://apiv2.allsportsapi.com/football/?&met=Players&playerId="+jugadorParaVerDetalle.getKeyDelJugador()+"&APIkey="+sp.getString("keyApi", "-1");;
        HiloConexion h = new HiloConexion(handler, ruta, HiloConexion.VER_DETALLE);
        h.start();


        //Modelo
        futbolistaModel = new ModelFutbolista();
        //View
        futbolistaView = new ViewFutbolista(this, futbolistaModel);
        //Controler
        futbolistaController = new ControllerFutbolista(futbolistaView, futbolistaModel);
        futbolistaView.setControlador(futbolistaController);


    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            super.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean handleMessage(@NonNull Message message) {
        if(message.arg1==HiloConexion.VER_DETALLE)
        {
            this.futbolistaModel= (ModelFutbolista) message.obj;
            futbolistaController.recuperarDatosDelFutbolistaClickeado(this.futbolistaModel);
        }
        return false;
    }
}