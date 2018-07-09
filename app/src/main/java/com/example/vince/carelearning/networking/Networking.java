package com.example.vince.carelearning.networking;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.example.vince.carelearning.model.Student;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Networking {

    public List<Student> studentList = new ArrayList<>();

    public List<Student> getStudents(){
        AndroidNetworking.get("http://10.0.2.2:3000/student")
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                Student student = new Student();

                                student.setId(jsonObject.getInt("id"));
                                student.setFirstname(jsonObject.getString("firstname"));
                                student.setLastname(jsonObject.getString("lastname"));
                                student.setMail(jsonObject.getString("mail"));
                                student.setPassword(jsonObject.getString("password"));
                                student.setSchool(jsonObject.getString("school"));
                                student.setRegisterDate(jsonObject.getString("register_date"));

                                studentList.add(student);
                                Log.d("TEST", i + ": " + studentList.toString());
                            }
                        }
                        catch (JSONException e){
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });

        return studentList;
    }

}