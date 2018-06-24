package service;

import model.Student;
import org.json.JSONArray;
import org.json.JSONObject;
import tool.DateFormatter;
import tool.HttpRequest;
import tool.HttpTool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 22/05/2018.
 */
public class StudentService {
    private String studentApi = "http://localhost:3000/student";

    private List<Student> studentArrayList = new ArrayList<>();
    private HttpTool httpTool = HttpTool.getInstance();

    public List<Student> getStudents() {
        try {
            HttpRequest<JSONObject> httpRequest = new HttpRequest<>( studentApi, JSONArray.class );
            JSONArray studentArray = httpTool.httpCall(httpRequest).getArray();

            Student student;

            for(int index = 0; index < studentArray.length(); index++) {
                JSONObject jsonObject = studentArray.getJSONObject(index);
                String registerDate = jsonObject.getString("register_date");
                String frenchRegisterDate = DateFormatter.toFrenchDate(registerDate);

                student = new Student(jsonObject.getInt("id"),
                        jsonObject.getString("firstname"),
                        jsonObject.getString("lastname"),
                        jsonObject.getString("mail"),
                        jsonObject.getString("school"),
                        frenchRegisterDate,
                        "*****");

                studentArrayList.add(student);
            }

            return studentArrayList;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return studentArrayList;
    }

    public int postStudent(Student student) throws IOException {
        JSONObject jsonStudent = new JSONObject();
        jsonStudent.put("firstname", student.getFirstname());
        jsonStudent.put("lastname", student.getLastname());
        jsonStudent.put("mail", student.getMail());
        jsonStudent.put("school", student.getSchool());
        jsonStudent.put("password", student.getPassword());
        jsonStudent.put("register_date", student.getRegisterDate());

        HttpRequest<JSONObject> httpRequest = new HttpRequest<>( studentApi, JSONObject.class);
        httpRequest.setBody( jsonStudent );
        httpRequest.setMethod("POST");

        JSONObject responseJson = httpTool.httpCall( httpRequest ).getObject();

        return responseJson.getJSONObject("student").getInt("id");
    }

    public void updateStudent(String studentProperty, String newValue, int id) throws IOException {
        JSONObject newStudentProperty = new JSONObject();
        newStudentProperty.put(studentProperty, newValue);

        HttpRequest<JSONObject> httpRequest = new HttpRequest<>( studentApi + "/" + id );
        httpRequest.setMethod("PUT");
        httpRequest.setBody(newStudentProperty);

        httpTool.httpCall(httpRequest);
    }

    public void deleteStudent(int id) throws IOException {
        HttpRequest<JSONObject> httpRequest = new HttpRequest<>(studentApi + "/" + id);
        httpRequest.setMethod("DELETE");

        httpTool.httpCall( httpRequest );
    }
}

