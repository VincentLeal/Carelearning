package com.example.vince.carelearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = findViewById(R.id.btn);
        bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openLogActivity();
            };
        });
    };

    public void openLogActivity(){
        Intent i = new Intent(MainActivity.this, LogActivity.class);
        startActivity(i);
    };

}