package tool;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

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

        if (!"GET".equalsIgnoreCase(method) && !"DELETE".equalsIgnoreCase(method)) {
            httpURLConnection.setDoOutput(true);

            try (DataOutputStream outputStream = new DataOutputStream(httpURLConnection.getOutputStream())) {
                outputStream.writeBytes(httpRequest.getBody().toString());
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

        try ( BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream())) ) {
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