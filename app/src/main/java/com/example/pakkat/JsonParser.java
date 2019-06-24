package com.example.pakkat;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonParser {

    public JsonParser() {

    }

    public static String GetJson (String link){

        try{

            URL url = new URL(link);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            InputStream in = con.getInputStream();
            BufferedReader bfreader = new BufferedReader(new InputStreamReader(in));

            String line;
            StringBuilder response = new StringBuilder();

            while((line = bfreader.readLine()) != null){
                response.append(line);
            }
            bfreader.close();
             return response.toString();
        }catch (Exception e){
            e.getStackTrace();
            Log.e("Log","Exception " + e.getMessage());
        }
        return "";
    }
}
