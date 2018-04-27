package com.example.vince.carelearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LogActivity extends AppCompatActivity {
    private Button sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        sign = findViewById(R.id.button2);
        sign.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openSignActivity();
            }
        });
    }

    public void openSignActivity(){
        Intent i = new Intent(LogActivity.this, SignActivity.class);
        startActivity(i);
    };

}
