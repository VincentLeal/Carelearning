package tool;

import model.Lesson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CsvMapper {
    private String lessonApi = "http://localhost:3000/lesson";
    private HttpTool httpTool = HttpTool.getInstance();

    public void readCsv() throws IOException {
        String csvFile = "C:/Users/lukile/Desktop/carelearning_test.csv";
        String line = "\" \"";
        String separator = ",";
        int countLine = 1;


        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile))){
            while ((line = bufferedReader.readLine()) != null){
                String[] lesson = line.split(separator);
                JSONArray lessonArray = new JSONArray(Arrays.asList(lesson));

                HttpRequest<JSONObject> httpRequest = new HttpRequest<JSONObject>(lessonApi, JSONArray.class);
                lessonArray = httpTool.httpCall(httpRequest).getArray();






                countLine++;
            }
        }catch (IOException e) {
            e.printStackTrace();
        }


    }


}
