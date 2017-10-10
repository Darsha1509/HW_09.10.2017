package com.github.darsha1509.hw_09102017.utils;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class IOUtils {

    private static final String LOG_TAG = IOUtils.class.getSimpleName();

    public static String getStringFromStream(final InputStream pInputStream) {
        final BufferedReader br = new BufferedReader(new InputStreamReader(pInputStream));

        final StringBuilder sb = new StringBuilder();
        String source = "";

        try {
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            source = sb.toString();
        } catch (final IOException e) {
            Log.e(LOG_TAG, "Error with build string from Inputstream");
        } finally {
            try {
                br.close();
            } catch (final IOException e) {
                Log.e(LOG_TAG, "Error with build string from Inputstream");
            }
        }
        return source;
    }
}
