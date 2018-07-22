package service;

import model.Student;
import org.json.JSONObject;
import tool.HttpRequest;
import tool.HttpTool;

import java.io.IOException;
import java.util.Base64;

/**
 * Created on 22/07/2018.
 */
public class ConnectionService {
    private String authApi = "http://localhost:3000/auth";

    private HttpTool httpTool = HttpTool.getInstance();

    public void checkIfAdmin(String mail, String password) {
        try {
            JSONObject studentOrAdmin = new JSONObject();

            studentOrAdmin.put("mail", mail);
            studentOrAdmin.put("password", password);

            HttpRequest<JSONObject> httpRequest = new HttpRequest<>(authApi, JSONObject.class);
            httpRequest.setBody(studentOrAdmin);
            httpRequest.setMethod("POST");

            JSONObject responseJson = httpTool.httpCall(httpRequest).getObject();

            String accessToken = responseJson.get("access_token").toString();

            String payload = new String(Base64.getDecoder().decode(accessToken.split("\\.")[1]));
            String role = new JSONObject(payload).getString("role");
            if("user".equalsIgnoreCase(role)) {
                throw new RuntimeException("Ceci n'est pas un compte administrateur");
            }
            httpTool.setAccessToken(accessToken);

        }catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
