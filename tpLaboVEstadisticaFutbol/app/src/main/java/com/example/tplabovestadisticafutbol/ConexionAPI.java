package com.example.tplabovestadisticafutbol;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConexionAPI {
    public byte[] obtenerInfo(String urlNoti){
        try {
            URL url = new URL(urlNoti);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            if(urlConnection.getResponseCode()==200) {
                InputStream is = urlConnection.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int cant=0;

                while (( cant = is.read(buffer))!=-1)
                {
                    baos.write(buffer, 0, cant);
                }
                is.close();
                return baos.toByteArray();
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}