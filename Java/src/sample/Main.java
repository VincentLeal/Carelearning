package sample;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        String getStudent = "http://localhost:3000/student";

        primaryStage.setTitle("Student List");
        Button btn = new Button();
        btn.setText("Students");
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

    public static String get(String url) throws IOException {
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

        for(int i = 0; i < jsonArray.length(); i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String firstname = jsonObject.getString("firstname");
            String lastname = jsonObject.getString("lastname");
            String mail = jsonObject.getString("mail");
            String school = jsonObject.getString("school");
            String registerDate = jsonObject.getString("register_date");

            System.out.println("Firstname : " + firstname + ", lastname : " + lastname + ", mail : " + mail + ", school : " + school + ", register date : " + registerDate + "\n");
        }
/*
        JSONObject obj = new JSONObject(source);
        JSONObject res = obj.getJSONArray("results").getJSONObject(0);
        System.out.println(res.getString("firstname"));
*/
        return source;
    }
}
