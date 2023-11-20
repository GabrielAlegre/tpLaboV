package com.example.tplabovestadisticafutbol.mvc;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.tplabovestadisticafutbol.ActivityVerDetalles;
import com.example.tplabovestadisticafutbol.Futbolista;
import com.example.tplabovestadisticafutbol.HiloConexion;

public class ControllerFutbolista implements View.OnClickListener{
    private ViewFutbolista viewFut;
    private ModelFutbolista modelFut;
    public ControllerFutbolista(ViewFutbolista view, ModelFutbolista model) {
        this.viewFut = view;
        this.modelFut = model;
    }


    @Override
    public void onClick(View view) {

    }

    public void recuperarDatosDelFutbolistaClickeado(ModelFutbolista futbolistaModel){

        this.modelFut.setNombreApellido(ActivityVerDetalles.jugadorParaVerDetalle.getNombreDelJugador());
        this.modelFut.setEquipo(ActivityVerDetalles.jugadorParaVerDetalle.getEquipoDondeJuega());
        this.modelFut.setGolesConvertidos(ActivityVerDetalles.jugadorParaVerDetalle.getCantDeGolesConvertidos());
        this.modelFut.setGolesDePenales(ActivityVerDetalles.jugadorParaVerDetalle.getGolesDePenales());
        this.modelFut.setEdad(futbolistaModel.getEdad());
        this.modelFut.setNacionalidad(futbolistaModel.getNacionalidad());
        this.modelFut.setDorsal(futbolistaModel.getDorsal());
        this.modelFut.setPartidosJugados(futbolistaModel.getPartidosJugados());
        this.modelFut.setAsistencias(futbolistaModel.getAsistencias());
        this.modelFut.setPases(futbolistaModel.getPases());
        this.modelFut.setIntentosDeGambeta(futbolistaModel.getIntentosDeGambeta());
        this.modelFut.setFaltasCometidas(futbolistaModel.getFaltasCometidas());
        this.modelFut.setTarjetasAmarillas(futbolistaModel.getTarjetasAmarillas());
        this.modelFut.setTarjetasRojas(futbolistaModel.getTarjetasRojas());
        this.modelFut.setRatingPromedio(futbolistaModel.getRatingPromedio());
        Log.d("recuperarDatosDeltbolis", futbolistaModel.toString());
        this.viewFut.mostrarModel();


    }

}
