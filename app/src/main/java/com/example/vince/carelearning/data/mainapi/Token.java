package com.example.vince.carelearning.data.mainapi;

import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Token {
    private String token;

    public Token(){}

    public Token(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void writeTokenFile(String packageName){

        try {
            File FILE;

            FILE = new File(Environment.getExternalStorageDirectory().getPath() + "/android/data/" + packageName + "/" + "Token.txt");
            if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                    && !Environment.MEDIA_MOUNTED_READ_ONLY.equals(Environment.getExternalStorageState())){
                FILE.getParentFile().mkdirs();
                FILE.createNewFile();
                FileOutputStream outputStream = new FileOutputStream(FILE);

                outputStream.write(this.token.getBytes());

                outputStream.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getTokenFile(String packageName){
        try{
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
            StringBuilder stringBuilder = new StringBuilder();
            File FILE = new File(Environment.getExternalStorageDirectory().getPath() + "/android/data/" + packageName + "/" + "Token.txt");
            FileInputStream inputStream = new FileInputStream(FILE);
            int value = 0;
            while((value = inputStream.read()) != -1){
                stringBuilder.append((char) value);
            }
            return stringBuilder.toString();
        }
    } catch (java.io.IOException e) {
        e.printStackTrace();

    }
    return "Error";
    }

}
