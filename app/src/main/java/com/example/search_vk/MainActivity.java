package com.example.search_vk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.search_vk.utils.Generated;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private EditText search_field;
    private Button search_button;
    private TextView error_message;

    class VKQueryParametr extends AsyncTask<URL,Void, String> {

        public void showResultOK() {

            result.setVisibility(View.VISIBLE);
            error_message.setVisibility(View.INVISIBLE);
        }

        public void showResultError() {

            result.setVisibility(View.INVISIBLE);
            error_message.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(URL... urls) {

            String response = null;

            try {
                response = Generated.getResponseFromURL(urls[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return response;

        }

        @Override
        protected void onPostExecute(String string) {

            String firstName = null;
            String lastName = null;

            if (string != null && !string.equals("")) {

                try {
                    JSONObject jsonObject = new JSONObject(string);
                    JSONArray jsonArray = jsonObject.getJSONArray("response");
                    JSONObject resultJSONObject = jsonArray.getJSONObject(0);

                    firstName = resultJSONObject.getString("first_name");
                    lastName = resultJSONObject.getString("last_name");
                } catch (JSONException e) {
                    e.printStackTrace();

                }

                String resultString = "Имя: " + firstName + "\n" + "Фамилия: " + lastName;

                result.setText(resultString);

                showResultOK();
            }
            else {
                showResultError();
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // reference

        result = findViewById(R.id.tv_result);
        search_field = findViewById(R.id.et_search_field);
        search_button = findViewById(R.id.btn_search);
        error_message = findViewById(R.id.tv_error_message);

        // overide onclick

        View.OnClickListener onClickListener = view -> {

            URL generatedURL = Generated.generatedURL(search_field.getText().toString());

            new VKQueryParametr().execute(generatedURL);


        };

        search_button.setOnClickListener(onClickListener);


    }
}