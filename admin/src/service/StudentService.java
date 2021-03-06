package service;

import model.Student;
import org.json.JSONArray;
import org.json.JSONObject;
import tool.DateFormatter;
import tool.HttpRequest;
import tool.HttpResponse;
import tool.HttpTool;
import tool.exception.HTTPConflictException;
import tool.exception.HTTPException;

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
            HttpRequest<JSONObject> httpRequest = new HttpRequest<>(studentApi, JSONArray.class);
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
                        "*****",
                        jsonObject.getString("role"));

                studentArrayList.add(student);
            }

            return studentArrayList;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return studentArrayList;
    }

    public List<Student> searchByName(String firstname, String lastname) {
        List<Student> students = new ArrayList<>();
        try {
            HttpRequest<JSONObject> httpRequest = new HttpRequest<>(studentApi, JSONArray.class);
            JSONArray studentArray = httpTool.httpCall(httpRequest).getArray();

            Student student = new Student();

            for (int index = 0; index < studentArray.length(); index++){
                JSONObject jsonObject = studentArray.getJSONObject(index);

                if(jsonObject.getString("firstname").equalsIgnoreCase(firstname)
                        && jsonObject.getString("lastname").equalsIgnoreCase(lastname)){

                    student.setFirstname(jsonObject.getString("firtsname"));
                    student.setLastname(jsonObject.getString("lasname"));

                    students.add(student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    public int postStudent(Student student) throws HTTPConflictException, IOException {
        JSONObject jsonStudent = new JSONObject();

        jsonStudent.put("firstname", student.getFirstname());
        jsonStudent.put("lastname", student.getLastname());
        jsonStudent.put("mail", student.getMail());
        jsonStudent.put("school", student.getSchool());
        jsonStudent.put("password", student.getPassword());
        jsonStudent.put("register_date", student.getRegisterDate());
        jsonStudent.put("role", student.getRole());

        HttpRequest<JSONObject> httpRequest = new HttpRequest<>(studentApi, JSONObject.class);
        httpRequest.setBody(jsonStudent);
        httpRequest.setMethod("POST");

        JSONObject responseJson = httpTool.httpCall(httpRequest).getObject();

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

        httpTool.httpCall(httpRequest);
    }
}

