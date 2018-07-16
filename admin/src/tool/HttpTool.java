package tool;

import org.json.JSONArray;
import org.json.JSONObject;
import tool.exception.HTTPConflictException;
import tool.exception.HTTPException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class HttpTool {

    private final static HttpTool instance = new HttpTool();

    private HttpTool() {}

    public static HttpTool getInstance() {
        return instance;
    }

    public HttpResponse httpCall(HttpRequest httpRequest) throws HTTPException, IOException {
        URL url = new URL(httpRequest.getUrl());
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        String method = httpRequest.getMethod();

        httpURLConnection.setRequestMethod(method);
        httpURLConnection.setRequestProperty("Content-Type", httpRequest.getContentType());
        httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
        httpURLConnection.setRequestProperty("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJtYWlsIjoiYSIsInBhc3N3b3JkIjoiYSIsInJvbGUiOiJ1c2VyIiwiaWF0IjoxNTMxNzMwNjI0LCJleHAiOjE1MzE3NzQ0MjR9.CPa_55LWEoPL1dkPT_MIKuxa8oGTxeGqR8VE2Sy-WyE");


        if (!"GET".equalsIgnoreCase(method) && !"DELETE".equalsIgnoreCase(method)) {
            httpURLConnection.setDoOutput(true);

            try (OutputStreamWriter outputStream = new OutputStreamWriter(httpURLConnection.getOutputStream(), StandardCharsets.UTF_8)) {
                outputStream.write(httpRequest.getBody().toString());
                outputStream.flush();
            }
        }

        int responseCode = httpURLConnection.getResponseCode();

        System.out.println("Response code " + responseCode);

        HttpResponse httpResponse = null;
        try {
            httpResponse = readResponse(httpURLConnection, httpRequest.getResponseType());
        } catch (IOException e) {
            if(e.getMessage().contains("409")) {
                throw new HTTPConflictException();
            }
        }

        return httpResponse;
    }

    private HttpResponse readResponse(URLConnection urlConnection, Class responseType) throws IOException {
        StringBuilder source = new StringBuilder();
        String inputline;

        try ( BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8))) {
            while((inputline = in.readLine()) != null) {
                source.append(inputline);
            }
        }

        return (responseType == null)
                ? null
                : (responseType == JSONArray.class)
                ? new HttpResponse( new JSONArray(source.toString()) )
                : new HttpResponse( new JSONObject(source.toString()) );
    }

}