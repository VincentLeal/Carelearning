package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Student;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;
import tool.DateFormatter;
import tool.ParameterStringBuilder;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 22/05/2018.
 */
public class StudentService {
    private String studentApi = "http://localhost:3000/student";
    private final String USER_AGENT = "Mozilla/5.0";

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
            in.close();

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
       // httpURLConnection.setRequestProperty("User-Agent", USER_AGENT);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");

        /*Map<String, String> parameters = new HashMap<>();
        parameters.put("id", student.getId().toString());
        parameters.put("firstname", student.getFirstname());
        parameters.put("lastname", student.getLastname());
        parameters.put("mail", student.getMail());
        parameters.put("school", student.getPassword());
        parameters.put("password", student.getPassword());
        parameters.put("register_date", student.getRegisterDate());

*/
        JSONObject jsonObject = new JSONObject("{" +
                "\"firstname\":" +
                 student.getFirstname() +"," +
                "\"lastname\":\"Dixon\"," +
                "\"mail\":\"dd@gmail.com\"," +
                "\"school\":\"ESGI\"," +
                "\"password\":\"azertyui\"," +
                "\"register_date\":\"2018-10-04T22:00:00.000Z" +
                "\"}");

        httpURLConnection.setDoOutput(true);
        DataOutputStream outputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        outputStream.writeBytes(jsonObject.toString());
        //outputStream.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        outputStream.flush();

        closeQuietly(outputStream);

        int responseCode = httpURLConnection.getResponseCode();
        System.out.println("nSending 'POST' request to url " + url);
        System.out.println("Post data : " + jsonObject.toString());
        System.out.println("Response code " + responseCode);

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(httpURLConnection.getInputStream()));
        String output;
        StringBuffer response = new StringBuffer();

        while ((output = bufferedReader.readLine()) != null) {
            response.append(output);
        }
        bufferedReader.close();

        System.out.println(response.toString());
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

