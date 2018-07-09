package com.example.vince.carelearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vince.carelearning.model.Student;
import com.example.vince.carelearning.networking.GetStudents;
import com.example.vince.carelearning.networking.PostStudent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ExecutionException;

public class SignUpActivity extends AppCompatActivity {
    private Button signupButton;
    private EditText firstnameInput;
    private EditText lastnameInput;
    private EditText mailInput;
    private EditText schoolInput;
    private EditText passwordInput;
    private EditText confirmPasswordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        signupButton = findViewById(R.id.signup_button);
        firstnameInput = findViewById(R.id.firstname_input);
        lastnameInput = findViewById(R.id.lastname_input);
        mailInput = (EditText) findViewById(R.id.mail_input);
        schoolInput = (EditText) findViewById(R.id.school_input);
        passwordInput = (EditText) findViewById(R.id.password_input);
        confirmPasswordInput = (EditText) findViewById(R.id.confirm_password_input);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);

                if(signup() == true)
                    startActivity(intent);
            }
        });
    }


    // Check the validity of the field without comparing them to the database
    boolean areFieldsValid(){
        String firstname = firstnameInput.getText().toString();
        String lastname = lastnameInput.getText().toString();
        String mail = mailInput.getText().toString();
        String school = schoolInput.getText().toString();
        String password = passwordInput.getText().toString();
        String confirmPassword = confirmPasswordInput.getText().toString();

        // Check if any of the fields is empty
        if (firstname.isEmpty() || lastname.isEmpty() ||
                mail.isEmpty() || school.isEmpty() ||
                password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Veillez à remplir le formulaire entièrement.", Toast.LENGTH_LONG).show();
            return false;
        }
        // If none of them is empty, go on
        else {
            if(!isMailValid(mail)) {
                Toast.makeText(getApplicationContext(), "Le mail fourni n'est pas valide.", Toast.LENGTH_LONG).show();
                return false;
            }
            // If mail is valid, go on
            else{
                // Check if the password & the confirmation password don't match
                if (!passwordInput.getText().toString().equals(confirmPasswordInput.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "The passwords don't match. Try again.", Toast.LENGTH_LONG).show();
                    return false;
                }
            }
        }

        // If the password match, return true
        return true;
    }

    boolean signup() {
        if (areFieldsValid() == false) {
            return false;
        }

            String firstname = firstnameInput.getText().toString();
            String lastname = lastnameInput.getText().toString();
            String mail = mailInput.getText().toString();
            String school = schoolInput.getText().toString();
            String password = passwordInput.getText().toString();
            String confirmPassword = confirmPasswordInput.getText().toString();

        Student newStudent = new Student(firstname, lastname, mail, school, password, getCurrentTime());
        Log.d("NEWSTUDENT", newStudent.toString());
        try {
            List<Student> studentList =
                    new GetStudents().execute("http://10.0.2.2:3000/student", "student", "all").get();
            for (int i = 0; i < studentList.size(); i++) {
                Log.d("STUDENT" + i, studentList.get(i).toString());
                if (newStudent.getMail().equals(studentList.get(i).getMail())) {
                    Toast.makeText(getApplicationContext(), "L'adresse mail entré existe dèjà dans la base de données." +
                            "Choisissez-en une autre.", Toast.LENGTH_LONG).show();
                     return false;
                }
            }
            new PostStudent().execute(newStudent);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        catch (ExecutionException e){
            e.printStackTrace();
        }
        return true;
    }

    boolean isMailValid(String mail){
        return android.util.Patterns.EMAIL_ADDRESS.matcher(mail).matches();
    }

    String getCurrentTime(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault());

        format.setTimeZone(TimeZone.getTimeZone("GMT+2"));
        String timeString = format.format(new Date());
        return timeString;
    }
}
