package service;

import controller.CustomDate;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableView;
import model.Student;
import org.json.JSONArray;
import org.json.JSONObject;
import tool.DateFormatter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created on 22/05/2018.
 */
public class StudentService {
    String studentApi = "http://localhost:3000/student";

    //Student student = new Student();

    List<Student> studentArrayList = new ArrayList<>();

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
}

