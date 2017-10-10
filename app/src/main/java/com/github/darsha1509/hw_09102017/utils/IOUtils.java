package com.github.darsha1509.hw_09102017.utils;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOUtils {

    public static String getStringFromStream(InputStream pInputStream){
        final BufferedReader br = new BufferedReader(new InputStreamReader(pInputStream));

        final StringBuilder sb = new StringBuilder();
        String source="";

        try {
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            source = sb.toString();
        }catch (IOException e){
            e.printStackTrace();
        } finally {
            try{
                br.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return source;
    }
}
