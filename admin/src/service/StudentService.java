package service;

import javafx.scene.control.ListCell;
import javafx.scene.control.TableView;
import model.Student;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 22/05/2018.
 */
public class StudentService {
    String studentApi = "http://localhost:3000/student";

    //Student student = new Student();

    List<Student> studentArrayList = new ArrayList<>();

    public List<Student> getStudent() {
        Student student = null;

        String source = "";
        try {
        URL nodeJs = new URL(studentApi);
        URLConnection urlConnection = nodeJs.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String inputline;

        while((inputline = in.readLine()) != null) {
            source += inputline;
        }
        in.close();

        JSONArray jsonArray = new JSONArray(source);

            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                student = new Student(jsonObject.getInt("id"), jsonObject.getString("firstname"), jsonObject.getString("lastname"));
                studentArrayList.add(student);
                //student.setId(jsonObject.getInt("id"));
                /*student.setFirstname(jsonObject.getString("firstname"));
                student.setLastname(jsonObject.getString("lastname"));*/

                /*ObservableList<String> items = FXCollections.observableArrayList(student.toString());
                studentTableView.setItems(items);*/
            }

            return studentArrayList;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return studentArrayList;

    }

}

