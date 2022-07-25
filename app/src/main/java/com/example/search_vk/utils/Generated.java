package com.example.search_vk.utils;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Generated {

    private static final String BASE_URL = "https://api.vk.com";
    private static final String METHOD_QUERY = "/method/users.get";
    private static final String PARAM_USER_ID = "user_ids";
    private static final String PARAM_V = "v";
    private static final String ACCESS_TOKEN = "";



    public static URL generatedURL(String userID) {

        Uri builtUri = Uri.parse(BASE_URL + METHOD_QUERY)
                .buildUpon()
                .appendQueryParameter(PARAM_USER_ID,userID)
                .appendQueryParameter(PARAM_V, "5.8")
                .build();

        URL url = null;

        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;


    }

    public static String getResponseFromURL(URL url) throws IOException {

        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        try {

            InputStream inputStream = httpURLConnection.getInputStream();

            Scanner scanner = new Scanner(inputStream);

            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();

            if (hasInput) {

                return scanner.next();

            } else
                return null;
        }
        finally {

            httpURLConnection.disconnect();

        }



    }
}
