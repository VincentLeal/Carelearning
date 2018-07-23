package com.example.vince.carelearning.exercises.prefix_sufix;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.vince.carelearning.R;
import com.example.vince.carelearning.model.Exercise;
import com.example.vince.carelearning.networking.IApi;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PrefixSufixActivity extends AppCompatActivity {

    private EditText responseEditText;
    private TextView responseText;
    private Context context;
    private ArrayList<Exercise> exercices = new ArrayList<>();
    private JsonParser parser = new JsonParser();
    private Gson gson = new Gson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefix_sufix);

        responseText = findViewById(R.id.responseText);
        responseEditText = findViewById(R.id.responseTextEdit);
        context = this;


        AndroidNetworking.get(IApi.ENDPOINT + "exercise")
                //.addPathParameter("pageNumber", "0")
                .addHeaders("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJwYXNzd29yZCI6InJvb3QiLCJtYWlsIjoiYUBhLmZyIiwiaWF0IjoxNTMyMjAyMTczLCJleHAiOjE1MzIyNDU5NzN9.J8UBc68kOvUeJ7v-NBThOKy68Z-pk6SzKM4p63XCFSA")
                .setTag("test")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("Response => ", response.toString());

                        for (int i = 0; i< response.length(); i++){
                            String mJsonString = null;
                            try {
                                mJsonString = response.getString(i);
                                JsonElement mJson = parser.parse(mJsonString);

                                Log.d("Element => ", mJsonString);
                                exercices.add(gson.fromJson(mJson, Exercise.class));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        Log.d("NBR EXERCICE", exercices.size() + "");
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d("Response => ", anError.getErrorDetail());
                    }
                });
    }
}
