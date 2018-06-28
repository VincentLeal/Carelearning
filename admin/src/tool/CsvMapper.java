package tool;

import model.Lesson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CsvMapper {
    private String lessonApi = "http://localhost:3000/lesson";

    private HttpTool httpTool = HttpTool.getInstance();

    Pattern pattern = Pattern.compile("[^a-zA-Z-0-9]");

    public void readCsv() throws IOException {
        String csvFile = "C:/Users/lukile/Desktop/test.csv";


        List<Lesson> lessons = getLessons(csvFile);

        JSONArray jsonArray = toJsonArray(lessons);

        HttpRequest<JSONArray> httpRequest = new HttpRequest<>(lessonApi, JSONObject.class);
        httpRequest.setBody(jsonArray);
        httpRequest.setMethod("POST");

        JSONArray responseJson = httpTool.httpCall(httpRequest).getArray();
    }

    private List<Lesson> getLessons(String csvFile) {
        int counterLine = 0;

        String separator = null;

        String line;
        List<Lesson> lessons = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile))){
            while((line = bufferedReader.readLine()) != null) {
                separator = findSeparator(counterLine, separator, pattern, line);

                String[] lessonPart = line.split(String.valueOf("\\" + separator));
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

    private String findSeparator(int counterLine, String separator, Pattern pattern, String line) {
        //Read first line to find separator
        if(counterLine == 0){
            Matcher matcher = pattern.matcher(line);
            if(matcher.find()){
                separator = matcher.group(0);
            }
        }
        return separator;
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
