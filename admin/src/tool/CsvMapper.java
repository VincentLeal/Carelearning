package tool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvMapper {
    private String lessonApi = "http://localhost:3000/lesson";
    private HttpTool httpTool = HttpTool.getInstance();

    public void readCsv() throws IOException {
        String csvFile = "C:/Users/lukile/Desktop/carelearning_test.csv";
        String line = "";
        String separator = ",";

        int headerLine = 1;

        //Get list string for each lines sauf 1ere ligne
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile))){
            while((line = bufferedReader.readLine()) != null) {
                String[] lessonPart = line.split(separator);
                if(lessonPart.length >= 3) {
                    System.out.println("Lesson " + lessonPart[0] + " " + lessonPart[1] + " " + lessonPart[2]);
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        //fonction list string -> list lesson
        //Get Lesson list




    }


}
