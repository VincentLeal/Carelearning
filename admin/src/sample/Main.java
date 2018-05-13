package sample;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Observable;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        String getStudent = "http://localhost:3000/student";

        primaryStage.setTitle("Main menu");
        Button btn = new Button();
        btn.setText("Display students");
            btn.setOnAction(event -> {
                try{
                    get(getStudent);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            });
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }



    public static void main(String[] args) { launch(args);
        /*try {
            get("http://localhost:3000/student");
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }*/
    }

    public  String get(String url) throws IOException {
        String source = "";
        URL nodeJs = new URL(url);
        URLConnection urlConnection = nodeJs.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        urlConnection.getInputStream()));
        String inputLine;

        while((inputLine = in.readLine()) != null ){
            source += inputLine;
           // in.close();
        }

        JSONArray jsonArray = new JSONArray(source);
        ListView<String> list = new ListView<>();
        Student student = new Student();


        for(int i = 0; i < jsonArray.length(); i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            student.setId(jsonObject.getInt("id"));
            student.setFirstname(jsonObject.getString("firstname"));
            student.setLastname(jsonObject.getString("lastname"));
            student.setPassword(jsonObject.getString("password"));
            student.setMail(jsonObject.getString("mail"));
            student.setSchool(jsonObject.getString("school"));
            student.setRegisterDate(jsonObject.getString("register_date"));

            String studentToString = student.toString();

            //student.displayStudent(text);
            //System.out.println("Firstname : " + firstname + ", lastname : " + lastname + ", mail : " + mail + ", school : " + school + ", register date : " + registerDate + "\n");

            ObservableList<String> items = FXCollections.observableArrayList(studentToString);
            list.setItems(items);


           /* try {
                final URL uri = getClass().getResource("displayStudent.fxml");
                final FXMLLoader fxmlLoader = new FXMLLoader(uri);
                final AnchorPane root = (AnchorPane) fxmlLoader.load();

                final Scene scene = new Scene(root, 500, 500);
                primaryStage.setScene(scene);
            } catch (IOException e) {
                System.out.println("Loading Error...");
            }*/


            System.out.println(student.toString());
        }
        Stage primaryStage = new Stage();
        final Scene scene = new Scene(list, 500, 500);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Student List");
        primaryStage.show();
/*
        JSONObject obj = new JSONObject(source);
        JSONObject res = obj.getJSONArray("results").getJSONObject(0);
        System.out.println(res.getString("firstname"));
*/
        in.close();
        return source;
    }

        ;

       /* Stage displayStudentStage = new Stage();
        displayStudentStage.setTitle("Student List");

        final Group group = new Group();
        Scene scene = new Scene(group, 500, 400);

        Text text = new Text(message);
        //StackPane displayStudent = new StackPane();
        group.getChildren().add(text);
        displayStudentStage.setScene(scene);
        displayStudentStage.show();*/

}
