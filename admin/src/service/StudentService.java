package service;

import model.Student;
import org.json.JSONArray;
import org.json.JSONObject;
import tool.DateFormatter;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 22/05/2018.
 */
public class StudentService {
    private String studentApi = "http://localhost:3000/student";

    private List<Student> studentArrayList = new ArrayList<>();

    public List<Student> getStudents() {
        StringBuilder source = new StringBuilder();
        try {
            URL nodeJs = new URL(studentApi);
            URLConnection urlConnection = nodeJs.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String inputline;

            while((inputline = in.readLine()) != null) {
                source.append(inputline);
            }
            closeQuietly(in);

            JSONArray jsonArray = new JSONArray(source.toString());

            Student student;

            for(int index = 0; index < jsonArray.length(); index++) {
                JSONObject jsonObject = jsonArray.getJSONObject(index);
                String registerDate = jsonObject.getString("register_date");
                String frenchRegisterDate = DateFormatter.toFrenchDate(registerDate);

                student = new Student(jsonObject.getInt("id"),
                        jsonObject.getString("firstname"),
                        jsonObject.getString("lastname"),
                        jsonObject.getString("mail"),
                        jsonObject.getString("school"),
                        frenchRegisterDate);

                studentArrayList.add(student);
            }

            return studentArrayList;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return studentArrayList;
    }

    public void postStudent(Student student) throws IOException {
        URL url = new URL(studentApi);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstname", student.getFirstname());
        jsonObject.put("lastname", student.getLastname());
        jsonObject.put("mail", student.getMail());
        jsonObject.put("school", student.getSchool());
        jsonObject.put("password", student.getPassword());
        jsonObject.put("register_date", student.getRegisterDate());

        httpURLConnection.setDoOutput(true);
        DataOutputStream outputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        outputStream.writeBytes(jsonObject.toString());
        outputStream.flush();

        closeQuietly(outputStream);

        int responseCode = httpURLConnection.getResponseCode();
        System.out.println("nSending 'POST' request to url " + url);
        System.out.println("Post data : " + jsonObject.toString());
        System.out.println("Response code " + responseCode);

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(httpURLConnection.getInputStream()));
        String output;
        StringBuilder response = new StringBuilder();

        while ((output = bufferedReader.readLine()) != null) {
            response.append(output);
        }
        closeQuietly(bufferedReader);

        System.out.println(response.toString());
    }

    public void updateStudent(String key, String newValue, int id) throws IOException {
        URL url = new URL(studentApi + "/" + id);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        httpURLConnection.setRequestMethod("PUT");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key, newValue);

        httpURLConnection.setDoOutput(true);
        DataOutputStream outputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        outputStream.writeBytes(jsonObject.toString());
        outputStream.flush();

        closeQuietly(outputStream);

        int responseCode = httpURLConnection.getResponseCode();
        System.out.println("nSending" + httpURLConnection.getRequestMethod() + "request to url " + url);
        System.out.println("Patch data : " + jsonObject.toString());
        System.out.println("Response code " + responseCode);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        String output;
        StringBuilder response = new StringBuilder();

        while ((output = bufferedReader.readLine()) != null) {
            response.append(output);
        }

        closeQuietly(bufferedReader);

        System.out.println(response.toString());
    }

    public void deleteStudent(int id) throws IOException {
        URL url = new URL(studentApi + "/" + id);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        httpURLConnection.setRequestMethod("DELETE");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
    }

    private void closeQuietly(Closeable closeable) {
        try {
            if(closeable != null) {
                closeable.close();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

