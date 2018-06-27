package tool;

import model.Lesson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvMapper {
    private String lessonApi = "http://localhost:3000/lesson";

    private HttpTool httpTool = HttpTool.getInstance();

    public void readCsv() throws IOException {
        String csvFile = "C:/Users/lukile/Desktop/carelearning_test.csv";
        String separator = "|";

        List<Lesson> lessons = getLessons(csvFile, separator);

        JSONArray jsonArray = toJsonArray(lessons);

        HttpRequest<JSONArray> httpRequest = new HttpRequest<>(lessonApi, JSONObject.class);
        httpRequest.setBody(jsonArray);
        httpRequest.setMethod("POST");

        JSONArray responseJson = httpTool.httpCall(httpRequest).getArray();



        System.out.println(responseJson);
    }

    private List<Lesson> getLessons(String csvFile, String separator) {
        int counterLine = 0;

        String line;
        List<Lesson> lessons = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile))){
            while((line = bufferedReader.readLine()) != null) {

                    String[] lessonPart = line.split(separator);
                    if(lessonPart.length >= 3) {
                        if(counterLine > 0){
                        lessons.add(listStringToListLesson(lessonPart));
                    }
                }
                counterLine++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lessons;
    }

    private Lesson listStringToListLesson(String[] stringList) {
        Lesson lesson = new Lesson();

        lesson.setModule(stringList[0]);
        lesson.setTitle(stringList[1]);
        lesson.setContent(stringList[2]);

        return lesson;
    }

    private JSONArray toJsonArray(List<Lesson> lessons) {
        List<JSONObject> lessonListJsonObject = new ArrayList<>();

        for (Lesson lesson : lessons) {
            JSONObject lessonJsonObject = new JSONObject();
            lessonJsonObject.put("module", lesson.getModule());
            lessonJsonObject.put("title", lesson.getTitle());
            lessonJsonObject.put("content", lesson.getContent());

            lessonListJsonObject.add(lessonJsonObject);
        }

        return new JSONArray(lessonListJsonObject);
    }
}
