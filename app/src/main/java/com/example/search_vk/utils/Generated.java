package com.example.search_vk.utils;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Generated {

    private static final String BASE_URL = "https://api.vk.com";
    private static final String METHOD_QUERY = "/method/users.get";
    private static final String PARAM_USER_ID = "user_ids";
    private static final String PARAM_V = "v";
    private static final String ACCESS_TOKEN = "8e5a71e38e5a71e38e5a71e3f48e27057b88e5a8e5a71e3ec8f08bcc3d7557a8295ea6b";
    private static final String field_ACCESS_TOKEN = "access_token";



    public static URL generatedURL(String userID) {

        Uri builtUri = Uri.parse(BASE_URL + METHOD_QUERY)
                .buildUpon()
                .appendQueryParameter(PARAM_USER_ID,userID)
                .appendQueryParameter(PARAM_V, "5.131")
                .appendQueryParameter(field_ACCESS_TOKEN,ACCESS_TOKEN)
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
        catch (UnknownHostException e) {
            return null;
        }
        finally {

            httpURLConnection.disconnect();

        }



    }
}
