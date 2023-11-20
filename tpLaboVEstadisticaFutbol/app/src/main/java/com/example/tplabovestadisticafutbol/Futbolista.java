package com.example.tplabovestadisticafutbol;

import java.io.Serializable;

public class Futbolista implements Serializable {
        // Atributos
        private long keyDelJugador;
        private String equipoDondeJuega;
        private int cantDeGolesConvertidos;
        private String nombreDelJugador;
        private int golesDePenales;

        public Futbolista(long key, String equipoDondeJuega, int cantDeGolesConvertidos, String nombreDelJugador, int golesDePenales) {
            this.keyDelJugador=key;
            this.equipoDondeJuega = equipoDondeJuega;
            this.cantDeGolesConvertidos = cantDeGolesConvertidos;
            this.nombreDelJugador = nombreDelJugador;
            this.golesDePenales=golesDePenales;
        }
        // Métodos getters y setters para equipoDondeJuega
        public String getEquipoDondeJuega() {
            return equipoDondeJuega;
        }

    public int getGolesDePenales() {
        return golesDePenales;
    }

    public void setGolesDePenales(int golesDePenales) {
        this.golesDePenales = golesDePenales;
    }

    public long getKeyDelJugador() {
        return keyDelJugador;
    }

    public void setKeyDelJugador(long keyDelJugador) {
        this.keyDelJugador = keyDelJugador;
    }

    public void setEquipoDondeJuega(String equipoDondeJuega) {
            this.equipoDondeJuega = equipoDondeJuega;
        }

        // Métodos getters y setters para cantDeGolesConvertidos
        public int getCantDeGolesConvertidos() {
            return cantDeGolesConvertidos;
        }

        public void setCantDeGolesConvertidos(int cantDeGolesConvertidos) {
            this.cantDeGolesConvertidos = cantDeGolesConvertidos;
        }

        // Métodos getters y setters para nombreDelJugador
        public String getNombreDelJugador() {
            return nombreDelJugador;
        }

        public void setNombreDelJugador(String nombreDelJugador) {
            this.nombreDelJugador = nombreDelJugador;
        }

        // Sobrescritura del método toString
        @Override
        public String toString() {
            return "Jugador{" +
                    "equipoDondeJuega='" + equipoDondeJuega + '\'' +
                    ", cantDeGolesConvertidos=" + cantDeGolesConvertidos +
                    ", nombreDelJugador='" + nombreDelJugador + '\'' +
                    '}';
        }


}
