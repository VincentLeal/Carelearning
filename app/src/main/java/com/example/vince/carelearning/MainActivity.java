package com.example.vince.carelearning;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.vince.carelearning.model.Session;
import com.example.vince.carelearning.model.Student;
import com.example.vince.carelearning.networking.Authentification;
import com.example.vince.carelearning.networking.GetStudents;
import com.example.vince.carelearning.networking.IApi;
import com.example.vince.carelearning.networking.Networking;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


// student url: http://10.0.2.2:3000/student
public class MainActivity extends AppCompatActivity {
    private Button signupButton;
    private Button loginButton;
    private EditText usernameInput;
    private EditText passwordInput;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signupButton = findViewById(R.id.signup_button);
        loginButton = findViewById(R.id.login_button);
        usernameInput = findViewById(R.id.username_input);
        passwordInput = findViewById(R.id.password_input);
        context = this;
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainMenuActivity.class);

                    login();
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });


    }

    boolean areFieldsValid(){
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();

        // Check if any of the fields is empty
        if (username.isEmpty() || password.isEmpty()){
            Toast.makeText(getApplicationContext(), "Votre mot de passe ou votre identifiant n'a pas été entré.", Toast.LENGTH_LONG).show();
            return false;
        }
        // If none of them is empty, go on
        else {
            // Check if the mail written in the login field by the user is valid
            if(!isMailValid(username)) {
                Toast.makeText(getApplicationContext(), "Le mail fourni n'est pas valide: xyz@gmail.com", Toast.LENGTH_LONG).show();
                return false;
            }
            // If mail is valid, return true
        }
        return true;
    }

    boolean laugin(){
        if(areFieldsValid() == false)
            return false;

        List<Student> studentList;
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();

        Networking networking = new Networking();

        studentList = networking.getStudents();
        Log.d("SATE", networking.getStudents().toString());
        for(int i = 0; i < studentList.size(); i++ ) {
            if (studentList.get(i).getMail().equals(username) && studentList.get(i).getPassword().equals(password)) {
                Toast.makeText(getApplicationContext(), "Correct !",
                        Toast.LENGTH_LONG).show();
                return true;
            }
        }
        Toast.makeText(getApplicationContext(),"Votre identifiant ou votre mot de passe est incorrect.",
                Toast.LENGTH_LONG).show();

        return false;
    }

    void login(){
        if(areFieldsValid() == false)
            return;

        String userName = usernameInput.getText().toString();
        String pwd = passwordInput.getText().toString();

        AndroidNetworking.post(IApi.ENDPOINT + "auth")
                .addBodyParameter("mail", userName)
                .addBodyParameter("password", pwd)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("TOKEN =>", response.toString());
                        Intent intent = new Intent(context, MainMenuActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(context, anError.getErrorDetail(), Toast.LENGTH_SHORT).show();
                    }
                });


    }

    boolean isMailValid(String mail){
        return android.util.Patterns.EMAIL_ADDRESS.matcher(mail).matches();
    }
}
