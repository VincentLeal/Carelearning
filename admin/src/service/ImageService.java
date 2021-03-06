package service;

import model.Exercise;
import model.Image;
import org.json.JSONArray;
import org.json.JSONObject;
import tool.HttpRequest;
import tool.HttpTool;

import java.io.IOException;
import java.util.List;

/**
 * Created on 16/07/2018.
 */
public class ImageService {
    private String imageApi = "http://localhost:3000/image";

    private HttpTool httpTool = HttpTool.getInstance();

    public void postImage(List<Image> images, Exercise exercise) throws IOException {
        JSONArray jsonArray = new JSONArray();

        for(int i = 0; i < images.size(); i++){
            JSONObject jsonImage = new JSONObject();

            jsonImage.put("title", images.get(i).getTitle());
            jsonImage.put("label", images.get(i).getLabel());
            jsonImage.put("url", images.get(i).getUrl());
            jsonImage.put("exerciseId", exercise.getId());

            jsonArray.put(jsonImage);
        }
        HttpRequest<JSONArray> httpRequest = new HttpRequest<>(imageApi, JSONObject.class);
        httpRequest.setBody(jsonArray);
        httpRequest.setMethod("POST");

        JSONObject responseJson = httpTool.httpCall(httpRequest).getObject();

        System.out.println(responseJson);
    }
}
