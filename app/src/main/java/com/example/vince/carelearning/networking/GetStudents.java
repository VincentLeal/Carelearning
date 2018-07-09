package com.example.vince.carelearning.networking;

import android.os.AsyncTask;
import android.util.Log;

import com.example.vince.carelearning.model.Student;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GetStudents  extends AsyncTask<String, Void, List<Student>> {
    HttpURLConnection conn;
    List<Student> studentList = new ArrayList<>();

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<Student> doInBackground(String... strings) {
        //http://localhost:3000/student

        String studentLink = strings[0];
        try {
            URL url = new URL(studentLink);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoInput(true);

            //reading HTTP response code
            int response = conn.getResponseCode();
            if(response != HttpURLConnection.HTTP_OK) {
                return null;
            }

            InputStream is = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String studentListStr = "";
            String data = "";

            while ((data = reader.readLine()) != null) {
                studentListStr += data;
            }

            JSONArray jsonArray = new JSONArray(studentListStr);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                Student student = new Student();
                student.setId(jsonObject.getInt("id"));
                student.setFirstname(jsonObject.getString("firstname"));
                student.setLastname(jsonObject.getString("lastname"));
                student.setMail(jsonObject.getString("mail"));
                student.setSchool(jsonObject.getString("school"));
                student.setPassword(jsonObject.getString("password"));
                student.setRegisterDate(jsonObject.getString("register_date"));

                studentList.add(student);
            }

            is.close();

            Log.d("GET", studentList.toString());

            return studentList;
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        finally{

            conn.disconnect();
        }
        return studentList;
    }

    @Override
    protected void onPostExecute(List<Student> students) {
        super.onPostExecute(students);

    }
}
