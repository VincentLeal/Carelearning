package com.example.vince.carelearning;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.example.vince.carelearning.data.mainapi.Adapter;
import com.example.vince.carelearning.data.mainapi.Token;
import com.example.vince.carelearning.exercises.drag_and_drop.DragDropActivity;
import com.example.vince.carelearning.exercises.prefix_sufix.PrefixSufixActivity;
import com.example.vince.carelearning.model.Exercise;
import com.example.vince.carelearning.networking.IApi;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class ExercisesActivity extends AppCompatActivity implements Adapter.ItemClickListener {
    private Context context;
    private RecyclerView recyclerView;
    private ArrayList<Exercise> exercises = new ArrayList<>();
    private JsonParser parser = new JsonParser();
    private Gson gson = new Gson();
    private Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);
        recyclerView = findViewById(R.id.exerciseList);

        context = this;

        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        Token token = new Token();
        AndroidNetworking.get(IApi.ENDPOINT + "exercise")
                .addHeaders("Authorization", "Bearer " + token.getTokenFile(getPackageName()))
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

                                exercises.add(gson.fromJson(mJson, Exercise.class));
                                Log.d("Element => ", exercises.get(i).toString());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        Log.d("NBR EXERCICE", exercises.size() + "");
                        setAdapter(context);
                        Toast.makeText(context, "exerciseList size " + exercises.size() , Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d("Response => ", anError.getErrorDetail());
                    }
                });


    }

    public void onItemClick(View view, int position) {
        //Toast.makeText(this, "You clicked " + mAdapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
        //Intent intent = new Intent(this, CardDetailActivity.class);
        //intent.putExtra("card", gson.toJson(cardsList.get(position)));
        //startActivity(intent);
        Exercise ex = mAdapter.getItem(position);

        switch (ex.getType().toLowerCase()){
            case "schéma" :
                Intent intent = new Intent(this, DragDropActivity.class);
                startActivity(intent);
                break;
            case "qcm":
                //TODO
                break;
            case "suffixe et préfixe":
                Intent intent1 = new Intent(this, PrefixSufixActivity.class);
                startActivity(intent1);
                break;
            case "calcul de dose":
                //TODO
                break;
            default:
                Toast.makeText(this, "Il semblerait qu'il y ai une erreur. Veuillez contactez l'administrateur.", Toast.LENGTH_LONG).show();

        }

    }

    public void setAdapter(Context context){
        mAdapter = new Adapter(context,exercises);
        mAdapter.setClickListener(this);
        recyclerView.setAdapter(mAdapter);
    }
}
