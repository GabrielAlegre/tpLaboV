package com.example.tplabovestadisticafutbol.mvc;

public class ModelFutbolista {
    // Atributos
    private String nombreApellido;
    private String equipo;
    private String nacionalidad;
    private int edad;
    private int dorsal;
    private int partidosJugados;
    private int golesConvertidos;
    private int asistencias;
    private int pases;
    private int intentosDeGambeta;
    private int faltasCometidas;
    private int tarjetasAmarillas;
    private int tarjetasRojas;
    private double ratingPromedio;
    private int golesDePenales;
    private String foto;

    private int pasesAcertados;

    private int gambetasExitosas;

    private int minutosJugados;
    public ModelFutbolista() {
    }

    public ModelFutbolista(String nombreApellido, String equipo, String nacionalidad, int edad, int dorsal, int partidosJugados, int golesConvertidos, int asistencias, int pases, int intentosDeGambeta, int faltasCometidas, int tarjetasAmarillas, int tarjetasRojas, double ratingPromedio, int golesDePenales) {
        this.nombreApellido = nombreApellido;
        this.equipo = equipo;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.dorsal = dorsal;
        this.partidosJugados = partidosJugados;
        this.golesConvertidos = golesConvertidos;
        this.asistencias = asistencias;
        this.pases = pases;
        this.intentosDeGambeta = intentosDeGambeta;
        this.faltasCometidas = faltasCometidas;
        this.tarjetasAmarillas = tarjetasAmarillas;
        this.tarjetasRojas = tarjetasRojas;
        this.ratingPromedio = ratingPromedio;
        this.golesDePenales = golesDePenales;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getGolesConvertidos() {
        return golesConvertidos;
    }

    public void setGolesConvertidos(int golesConvertidos) {
        this.golesConvertidos = golesConvertidos;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public int getPases() {
        return pases;
    }

    public void setPases(int pases) {
        this.pases = pases;
    }

    public int getIntentosDeGambeta() {
        return intentosDeGambeta;
    }

    public void setIntentosDeGambeta(int intentosDeGambeta) {
        this.intentosDeGambeta = intentosDeGambeta;
    }

    public int getFaltasCometidas() {
        return faltasCometidas;
    }

    public void setFaltasCometidas(int faltasCometidas) {
        this.faltasCometidas = faltasCometidas;
    }

    public int getTarjetasAmarillas() {
        return tarjetasAmarillas;
    }

    public void setTarjetasAmarillas(int tarjetasAmarillas) {
        this.tarjetasAmarillas = tarjetasAmarillas;
    }

    public int getTarjetasRojas() {
        return tarjetasRojas;
    }

    public void setTarjetasRojas(int tarjetasRojas) {
        this.tarjetasRojas = tarjetasRojas;
    }

    public double getRatingPromedio() {
        return ratingPromedio;
    }

    public void setRatingPromedio(double ratingPromedio) {
        this.ratingPromedio = ratingPromedio;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getGolesDePenales() {
        return golesDePenales;
    }

    public void setGolesDePenales(int golesDePenales) {
        this.golesDePenales = golesDePenales;
    }


    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getPasesAcertados() {
        return pasesAcertados;
    }

    public void setPasesAcertados(int pasesAcertados) {
        this.pasesAcertados = pasesAcertados;
    }

    public int getGambetasExitosas() {
        return gambetasExitosas;
    }

    public void setGambetasExitosas(int gambetasExitosas) {
        this.gambetasExitosas = gambetasExitosas;
    }

    public int getMinutosJugados() {
        return minutosJugados;
    }

    public void setMinutosJugados(int minutosJugados) {
        this.minutosJugados = minutosJugados;
    }

    @Override
    public String toString() {
        return "ModelFutbolista{" +
                "nombreApellido='" + nombreApellido + '\'' +
                ", equipo='" + equipo + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", edad=" + edad +
                ", dorsal=" + dorsal +
                ", partidosJugados=" + partidosJugados +
                ", golesConvertidos=" + golesConvertidos +
                ", asistencias=" + asistencias +
                ", pases=" + pases +
                ", intentosDeGambeta=" + intentosDeGambeta +
                ", faltasCometidas=" + faltasCometidas +
                ", tarjetasAmarillas=" + tarjetasAmarillas +
                ", tarjetasRojas=" + tarjetasRojas +
                ", ratingPromedio=" + ratingPromedio +
                ", golesDePenales=" + golesDePenales +
                '}';
    }
}
