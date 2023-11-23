package com.example.tplabovestadisticafutbol;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.tplabovestadisticafutbol.mvc.ModelFutbolista;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HiloConexion extends Thread{
    public static final int MOSTRAR_GOLEADORES = 10;
    public static final int VER_DETALLE = 1;
    public static final int MOSTRAR_JUGADORES_SV = 100;
    Handler handler;
    String ruta;

    int queHacer;
    ModelFutbolista modelFutbolista;
    List<Futbolista> listaJugadores;

    public HiloConexion(Handler handler, String ruta, int queHacer) {
        this.handler = handler;
        this.listaJugadores = new ArrayList<>();
        this.ruta=ruta;
        this.queHacer=queHacer;

    }
    public void run () {
        ConexionAPI c = new ConexionAPI();
        Message message = new Message();
        if(this.queHacer==HiloConexion.MOSTRAR_GOLEADORES) {
            if (listaJugadores.isEmpty()) {
                byte[] rta = c.obtenerInfo(this.ruta);
                message.arg1 = MOSTRAR_GOLEADORES;
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
                } catch (Exception e) {
                    e.printStackTrace();
                }
                message.obj = listaJugadores;
            }
        }else if(this.queHacer==HiloConexion.MOSTRAR_JUGADORES_SV) {
            if (listaJugadores.isEmpty()) {
                byte[] rta = c.obtenerInfo(this.ruta);
                message.arg1 = MOSTRAR_JUGADORES_SV;
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
                                playerData.getInt("player_goals"),
                                playerData.getString("player_name"),
                                0));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                message.obj = listaJugadores;
            }
        }

        if(this.queHacer==HiloConexion.VER_DETALLE) {
            if (listaJugadores.isEmpty()) {
                byte[] rta = c.obtenerInfo(this.ruta);
                message.arg1 = VER_DETALLE;
                try {
                    // Convierte la cadena JSON en un objeto JSONObject
                    JSONObject jsonObject = new JSONObject(new String(rta));

                    // Obtén el array "result" del objeto JSON
                    JSONArray resultArray = jsonObject.getJSONArray("result");

                    // Ahora puedes acceder a los datos dentro del arreglo "result"
                    JSONObject playerData = resultArray.getJSONObject(0);

                    // Accede a los campos que necesites, por ejemplo:
                    modelFutbolista = new ModelFutbolista();
                    modelFutbolista.setNacionalidad(playerData.getString("player_country"));
                    modelFutbolista.setEdad(Integer.parseInt(playerData.getString("player_age")));
                    modelFutbolista.setDorsal(Integer.parseInt(playerData.getString("player_number")));
                    modelFutbolista.setPartidosJugados(Integer.parseInt(playerData.getString("player_match_played")));
                    modelFutbolista.setAsistencias(Integer.parseInt(playerData.getString("player_assists")));
                    modelFutbolista.setPases(Integer.parseInt(verificarQueNoLlegueVacio(playerData.optString("player_passes", "0"))));
                    modelFutbolista.setIntentosDeGambeta(Integer.parseInt(verificarQueNoLlegueVacio(playerData.getString("player_dribble_attempts"))));
                    modelFutbolista.setFaltasCometidas(Integer.parseInt(verificarQueNoLlegueVacio(playerData.getString("player_fouls_commited"))));
                    modelFutbolista.setTarjetasAmarillas(Integer.parseInt(verificarQueNoLlegueVacio(playerData.getString("player_yellow_cards"))));
                    modelFutbolista.setTarjetasRojas(Integer.parseInt(verificarQueNoLlegueVacio(playerData.getString("player_red_cards"))));
                    modelFutbolista.setGambetasExitosas(Integer.parseInt(verificarQueNoLlegueVacio(playerData.getString("player_dribble_succ"))));
                    modelFutbolista.setMinutosJugados(Integer.parseInt(verificarQueNoLlegueVacio(playerData.getString("player_minutes"))));
                    modelFutbolista.setPasesAcertados(Integer.parseInt(verificarQueNoLlegueVacio(playerData.getString("player_passes_accuracy"))));
                    modelFutbolista.setRatingPromedio(Double.parseDouble(verificarQueNoLlegueVacio(playerData.getString("player_rating"))));
                    modelFutbolista.setFoto(verificarQueNoLlegueVacio(playerData.optString("player_image", "/drawable/hombre.png")));

                    Log.d("viendoooooooo desde hlo", modelFutbolista.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                message.obj = modelFutbolista;
            }
        }
        handler.sendMessage(message);
    }


    private String verificarQueNoLlegueVacio(String atributoValor)
    {
        return  atributoValor.isEmpty()?"0":atributoValor;
    }


}