package com.example.vince.carelearning.networking;

import android.os.AsyncTask;
import android.util.Log;

import com.example.vince.carelearning.model.Student;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostStudent extends AsyncTask<Student, Void, Boolean> {
    HttpURLConnection conn;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Boolean doInBackground(Student... students) {
        //http://localhost:3000/student

        String studentLink = "http://10.0.2.2:3000/student";
        try {
            URL url = new URL(studentLink);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoInput(true);
            conn.setDoOutput(true);

//            //reading HTTP response code
//            int response = conn.getResponseCode();
//            if(response != HttpURLConnection.HTTP_OK) {
//                return null;
//            }

            JSONObject jsonParam = new JSONObject();
            //jsonParam.put("id", students[0].getId());
            jsonParam.put("firstname", students[0].getFirstname());
            jsonParam.put("lastname", students[0].getLastname());
            jsonParam.put("mail", students[0].getMail());
            jsonParam.put("password", students[0].getPassword());
            jsonParam.put("school", students[0].getSchool());
            jsonParam.put("register_date", students[0].getRegisterDate());

            Log.d("JSON", jsonParam.toString());

//            DataOutputStream os = new DataOutputStream(conn.getOutputStream());
//            os.writeBytes(jsonParam.toString());
//
//            os.flush();
//            os.close();

            OutputStream outputStream = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            writer.write(jsonParam.toString());
            writer.close();
            outputStream.close();

            Log.i("STATUS", String.valueOf(conn.getResponseCode()));
            Log.i("MSG" , conn.getResponseMessage());
            Log.d("NEWSTUDENT", students[0].toString());

            if(conn.getResponseCode() != 201)
                return false;

            return true;
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
        return null;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);

        if(aBoolean == true)
            Log.d("SUCCESS", "Post request was done successfully");
        else
            Log.d("FAIL", "Post request has failed.");

    }
}
