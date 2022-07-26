package com.example.search_vk.utils;

import java.net.URL;

public class Testing {

    public static void main(String[] args) {

        URL result = Generated.generatedURL("111");

        String abc = String.valueOf(result);

        System.out.println(abc);
    }
}
