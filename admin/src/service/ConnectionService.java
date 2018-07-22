package service;

import model.Student;
import org.json.JSONObject;
import tool.HttpRequest;
import tool.HttpTool;

import java.io.IOException;

/**
 * Created on 22/07/2018.
 */
public class ConnectionService {
    private String authApi = "http://localhost:3000/auth";

    private HttpTool httpTool = HttpTool.getInstance();

    public String checkIfAdmin(String mail, String password) {
        String accessToken = null;
        try {
            JSONObject studentOrAdmin = new JSONObject();

            studentOrAdmin.put("mail", mail);
            studentOrAdmin.put("password", password);

            HttpRequest<JSONObject> httpRequest = new HttpRequest<>(authApi, JSONObject.class);
            httpRequest.setBody(studentOrAdmin);
            httpRequest.setMethod("POST");

            JSONObject responseJson = httpTool.httpCallWithoutAuth(httpRequest).getObject();

            accessToken = responseJson.get("access_token").toString();

        }catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(accessToken);
        return accessToken;

    }
}
