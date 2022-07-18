package com.example.search_vk.utils;

import android.net.Uri;

import java.net.MalformedURLException;
import java.net.URL;

public class Generated {

    private static final String BASE_URL = "https://api.vk.com";
    private static final String METHOD_QUERY = "/method/users.get";
    private static final String PARAM_USER_ID = "user_ids";
    private static final String PARAM_V = "v";



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
}
