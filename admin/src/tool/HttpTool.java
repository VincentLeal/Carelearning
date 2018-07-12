package tool;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
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

    public HttpResponse httpCall(HttpRequest httpRequest) throws IOException {
        URL url = new URL(httpRequest.getUrl());
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        String method = httpRequest.getMethod();

        httpURLConnection.setRequestMethod(method);
        httpURLConnection.setRequestProperty("Content-Type", httpRequest.getContentType());
        httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
        httpURLConnection.setRequestProperty("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJtYWlsIjoiZmplb2pmQGdtYWlsLmNvbSIsInBhc3N3b3JkIjoiYSIsImlhdCI6MTUzMTQyNjcwMSwiZXhwIjoxNTMxNDcwNTAxfQ.uoGAC_T5hd60P-FGubU5ARdserUUm2_FYr7nK0HbqGU");


        if (!"GET".equalsIgnoreCase(method) && !"DELETE".equalsIgnoreCase(method)) {
            httpURLConnection.setDoOutput(true);

            try (OutputStreamWriter outputStream = new OutputStreamWriter(httpURLConnection.getOutputStream(), StandardCharsets.UTF_8)) {
                outputStream.write(httpRequest.getBody().toString());
                outputStream.flush();
            }
        }

        int responseCode = httpURLConnection.getResponseCode();

        System.out.println("Response code " + responseCode);

        return readResponse(httpURLConnection, httpRequest.getResponseType());
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