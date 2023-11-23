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

import java.text.DecimalFormat;

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
        this.modelFut.setFoto(futbolistaModel.getFoto());
        this.modelFut.setMinutosJugados(futbolistaModel.getMinutosJugados());
        this.modelFut.setGolesDePenales(futbolistaModel.getGolesDePenales());
        this.modelFut.setPasesAcertados(futbolistaModel.getPasesAcertados());
        this.modelFut.setGambetasExitosas(futbolistaModel.getGambetasExitosas());
        Log.d("recuperarDatosDeltbolis", futbolistaModel.toString());
        this.viewFut.mostrarModel();
    }

    public static String calcularPorcentajeMinutosJugados(int minJug, int partJug)
    {
        String porcentaje = "0";
        if(minJug != 0 && partJug !=0)
        {
            int minEnJugo=partJug*90;
            double rta = (double) minJug/minEnJugo;
            porcentaje = new DecimalFormat("#.##").format(rta*100);
        }

        return minJug+ " ("+porcentaje+"%)";

    }

    public static String calcularPorcentajePasesCorrectos(int pasesAcertados, int pasesDados)
    {
        String porcentaje = "0";
        if(pasesAcertados!=0 && pasesDados !=0)
        {
            Double rta = (double) pasesAcertados/pasesDados;
            porcentaje = new DecimalFormat("#.##").format(rta*100);
            return pasesAcertados+ " ("+porcentaje+"%)";
        }

        return pasesAcertados+ " ("+porcentaje+"%)";
    }
    public static String calcularPorcentajeGambetasCorrectos(int gambetasExitosas, int gambetasIntentadas)
    {
        String porcentaje = "0";
        if(gambetasExitosas!=0 && gambetasIntentadas!=0)
        {
            Double rta = (double) gambetasExitosas/gambetasIntentadas;
            porcentaje = new DecimalFormat("#.##").format(rta*100);
        }

        return gambetasExitosas+ " ("+porcentaje+"%)";
    }
}
