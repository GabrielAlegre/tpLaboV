package com.example.tplabovestadisticafutbol;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HiloConexion extends Thread{
    public static final int GOLEADORES = 10;
    public static final int DTALLE = 1;
    Handler handler;
    String ruta;

    List<Futbolista> listaJugadores;

    public HiloConexion(Handler handler, String ruta) {
        this.handler = handler;
        listaJugadores = new ArrayList<>();
        this.ruta=ruta;
    }
    public void run () {
        ConexionAPI c = new ConexionAPI();
        Message message = new Message();
        if (listaJugadores.isEmpty()) {
            byte[] rta = c.obtenerInfo(this.ruta);
            message.arg1 = GOLEADORES;
            try {
                // Convierte la cadena JSON en un objeto JSONObject
                JSONObject jsonObject = new JSONObject(new String(rta));

                // Obtén el array "result" del objeto JSON
                JSONArray resultArray = jsonObject.getJSONArray("result");

                // Ahora puedes acceder a los datos dentro del arreglo "result"
                for (int i = 0; i < resultArray.length(); i++) {
                    JSONObject playerData = resultArray.getJSONObject(i);

                    // Accede a los campos que necesites, por ejemplo:
                    listaJugadores.add(new Futbolista(playerData.getLong("player_key"),
                            playerData.getString("team_name"),
                            playerData.getInt("goals"),
                            playerData.getString("player_name"),
                            playerData.getInt("penalty_goals")));
                }
                /*
                for (Jugador jug:listaJugadores)
                {
                    byte[] rtaDetalle = c.obtenerInfo("https://apiv2.allsportsapi.com/football/?&met=Players&playerId=" + String.valueOf( jug.getJugadorKey()) + "&APIkey=f9f23b7d28dadcf3a99d5c2fb69f62d2fb40ac61a1bc8f007dd0300ab09bea47");
                    JSONObject jsonObjectDetalle = new JSONObject(new String(rtaDetalle));
                    JSONArray resultArrayDetalle = jsonObjectDetalle.getJSONArray("result");
                    JSONObject playerDataDetalle = resultArrayDetalle.getJSONObject(0);
                    jug.setFoto(playerDataDetalle.getString(      "player_country"));
                }*/
            } catch (Exception e) {
                e.printStackTrace();
            }
            message.obj = listaJugadores;
        }
        handler.sendMessage(message);
    }

}