package service;

import model.Exercise;
import org.json.JSONObject;
import tool.HttpRequest;
import tool.HttpTool;

import java.io.IOException;

/**
 * Created on 11/07/2018.
 */
public class ExerciseService {
    private String exerciseApi = "http://localhost:3000/exercise";

    private HttpTool httpTool = HttpTool.getInstance();

    public void postExercise(Exercise exercise) throws IOException {
        JSONObject jsonExercise = new JSONObject();

        jsonExercise.put("question", exercise.getQuestion());
        jsonExercise.put("goodAnswer", exercise.getGoodAnswer());
        jsonExercise.put("choice1", exercise.getChoice1());
        jsonExercise.put("choice2", exercise.getChoice2());
        jsonExercise.put("choice3", exercise.getChoice3());
        jsonExercise.put("module", exercise.getModule());
        jsonExercise.put("type", exercise.getType());

        HttpRequest<JSONObject> httpRequest = new HttpRequest<>(exerciseApi, JSONObject.class);
        httpRequest.setBody(jsonExercise);
        httpRequest.setMethod("POST");

        JSONObject responseJson = httpTool.httpCall(httpRequest).getObject();
    }

}
