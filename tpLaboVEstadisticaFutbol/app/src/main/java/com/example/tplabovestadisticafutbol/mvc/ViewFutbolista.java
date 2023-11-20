package com.example.tplabovestadisticafutbol.mvc;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.tplabovestadisticafutbol.ActivityVerDetalles;
import com.example.tplabovestadisticafutbol.R;
import com.squareup.picasso.Picasso;

public class ViewFutbolista {
    ActivityVerDetalles ac;
    private TextView tvNombreJugador;
    private TextView tvEdad;
    private TextView tvDorsal;
    private TextView tvPartidosJugados;
    private TextView tvGoles;
    private TextView tvAsistencias;
    private TextView tvPases;
    private TextView tvGambetas;
    private TextView tvFaltas;
    private TextView tvAmarillas;
    private TextView tvRojas;
    private TextView tvRatingProm;
    private TextView tvEquipo;
    private TextView tvNacionalidad;
    private TextView tvMinutosJugados;
    private TextView tvGolesDePenal;
    private TextView tvPasesCorrectos;
    private TextView tvGambetasExitosas;
    private ControllerFutbolista controllerFut;

    ImageView imgJugador;
    private ModelFutbolista futbolistaModel;
    public ViewFutbolista(ActivityVerDetalles ac, ModelFutbolista futbolistaModel){
        this.ac=ac;
        this.futbolistaModel=futbolistaModel;
    }

    public void setControlador(ControllerFutbolista controladorFut)
    {
        this.controllerFut=controladorFut;
        this.cargarElementos();
    }
    public void cargarElementos(){
        this.tvNombreJugador = this.ac.findViewById(R.id.tvNombreJugador);
        this.tvEdad = this.ac.findViewById(R.id.tvEdad);
        this.tvDorsal = this.ac.findViewById(R.id.tvDorsal);
        this.tvPartidosJugados = this.ac.findViewById(R.id.tvPartidosJugados);
        this.tvGoles = this.ac.findViewById(R.id.tvGoles);
        this.tvAsistencias = this.ac.findViewById(R.id.tvAsistencias);
        this.tvPases = this.ac.findViewById(R.id.tvPases);
        this.tvGambetas = this.ac.findViewById(R.id.tvGambetas);
        this.tvFaltas = this.ac.findViewById(R.id.tvFaltas);
        this.tvAmarillas = this.ac.findViewById(R.id.tvAmarillas);
        this.tvRojas = this.ac.findViewById(R.id.tvRojas);
        this.tvRatingProm = this.ac.findViewById(R.id.tvRatingProm);
        this.tvEquipo = this.ac.findViewById(R.id.tvEquipo);  // Nuevo TextView para el equipo
        this.tvNacionalidad = this.ac.findViewById(R.id.tvNacionalidad);
        this.imgJugador=this.ac.findViewById(R.id.ivImgJugador);
        this.tvMinutosJugados=this.ac.findViewById(R.id.tvMinutosJugados);
        this.tvGolesDePenal=this.ac.findViewById(R.id.tvGolesDePenal);
        this.tvPasesCorrectos=this.ac.findViewById(R.id.tvPasesCorrectos);
        this.tvGambetasExitosas=this.ac.findViewById(R.id.tvGambetasExitosas);
        //this.controllerFut.recuperarDatosDelFutbolistaClickeado();
    }

    public void llenarModelo(){
        this.futbolistaModel.setNombreApellido(this.tvNombreJugador.getText().toString());
        this.futbolistaModel.setEquipo(this.tvEquipo.getText().toString());
        this.futbolistaModel.setNacionalidad(this.tvNacionalidad.getText().toString());
        this.futbolistaModel.setEdad(Integer.parseInt(this.tvEdad.getText().toString()));
        this.futbolistaModel.setDorsal(Integer.parseInt(this.tvDorsal.getText().toString()));
        this.futbolistaModel.setPartidosJugados(Integer.parseInt(this.tvPartidosJugados.getText().toString()));
        this.futbolistaModel.setGolesConvertidos(Integer.parseInt(this.tvGoles.getText().toString()));
        this.futbolistaModel.setAsistencias(Integer.parseInt(this.tvAsistencias.getText().toString()));
        this.futbolistaModel.setPases(Integer.parseInt(this.tvPases.getText().toString()));
        this.futbolistaModel.setIntentosDeGambeta(Integer.parseInt(this.tvGambetas.getText().toString()));
        this.futbolistaModel.setFaltasCometidas(Integer.parseInt(this.tvFaltas.getText().toString()));
        this.futbolistaModel.setTarjetasAmarillas(Integer.parseInt(this.tvAmarillas.getText().toString()));
        this.futbolistaModel.setTarjetasRojas(Integer.parseInt(this.tvRojas.getText().toString()));
        this.futbolistaModel.setRatingPromedio(Double.parseDouble(this.tvRatingProm.getText().toString()));
        this.futbolistaModel.setTarjetasRojas(Integer.parseInt(this.tvRojas.getText().toString()));
        this.futbolistaModel.setRatingPromedio(Double.parseDouble(this.tvRatingProm.getText().toString()));
    }

    public void mostrarModel(){
        this.tvNombreJugador.setText(this.futbolistaModel.getNombreApellido());
        this.tvEquipo.setText(this.futbolistaModel.getEquipo());
        this.tvNacionalidad.setText(this.futbolistaModel.getNacionalidad());
        this.tvEdad.setText(String.valueOf(this.futbolistaModel.getEdad()));
        this.tvDorsal.setText(String.valueOf(this.futbolistaModel.getDorsal()));
        this.tvPartidosJugados.setText(String.valueOf(this.futbolistaModel.getPartidosJugados()));
        this.tvGoles.setText(String.valueOf(this.futbolistaModel.getGolesConvertidos()));
        this.tvAsistencias.setText(String.valueOf(this.futbolistaModel.getAsistencias()));
        this.tvPases.setText(String.valueOf(this.futbolistaModel.getPases()));
        this.tvGambetas.setText(String.valueOf(this.futbolistaModel.getIntentosDeGambeta()));
        this.tvFaltas.setText(String.valueOf(this.futbolistaModel.getFaltasCometidas()));
        this.tvAmarillas.setText(String.valueOf(this.futbolistaModel.getTarjetasAmarillas()));
        this.tvRojas.setText(String.valueOf(this.futbolistaModel.getTarjetasRojas()));
        this.tvRatingProm.setText(String.valueOf(this.futbolistaModel.getRatingPromedio()));
        Picasso.get().load(this.futbolistaModel.getFoto()).into(this.imgJugador);
        this.tvMinutosJugados.setText(ControllerFutbolista.calcularPorcentajeMinutosJugados(futbolistaModel.getMinutosJugados(), futbolistaModel.getPartidosJugados()));
        this.tvGolesDePenal.setText(String.valueOf(this.futbolistaModel.getGolesDePenales()));
        this.tvPasesCorrectos.setText(ControllerFutbolista.calcularPorcentajePasesCorrectos(this.futbolistaModel.getPasesAcertados(), this.futbolistaModel.getPases()));
        this.tvGambetasExitosas.setText(ControllerFutbolista.calcularPorcentajeGambetasCorrectos(this.futbolistaModel.getGambetasExitosas(), this.futbolistaModel.getIntentosDeGambeta()));
    }
}
