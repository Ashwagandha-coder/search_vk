package com.example.search_vk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.search_vk.utils.Generated;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private EditText search_field;
    private Button search_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // reference

        result = findViewById(R.id.tv_result);
        search_field = findViewById(R.id.et_search_field);
        search_button = findViewById(R.id.btn_search);

        // overide onclick

        View.OnClickListener onClickListener = view -> {

            URL generatedURL = Generated.generatedURL(search_field.getText().toString());

            String response = null;

            try {
                response = Generated.getResponseFromURL(generatedURL);
            } catch (IOException e) {
                e.printStackTrace();
            }


            result.setText(response);
        };

        search_button.setOnClickListener(onClickListener);


    }
}