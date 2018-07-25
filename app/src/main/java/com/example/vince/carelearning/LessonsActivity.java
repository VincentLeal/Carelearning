package com.example.vince.carelearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.example.vince.carelearning.data.mainapi.Token;
import com.example.vince.carelearning.model.Exercise;
import com.example.vince.carelearning.model.Lesson;
import com.example.vince.carelearning.networking.IApi;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class LessonsActivity extends AppCompatActivity {

    private JsonParser parser = new JsonParser();
    private Gson gson = new Gson();
    private ArrayList<Lesson> lessons = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);

        Token token = new Token();
        AndroidNetworking.get(IApi.ENDPOINT + "lesson")
                .addHeaders("Authorization", "Bearer " + token.getTokenFile(getPackageName()))
                .setTag("test")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            String mJsonString = null;
                            try {
                                mJsonString = response.getString(i);
                                JsonElement mJson = parser.parse(mJsonString);
                                lessons.add(gson.fromJson(mJson, Lesson.class));
                                Log.d("Element => ", lessons.get(i).toString());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }
}
