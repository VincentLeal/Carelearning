 package com.example.vince.carelearning;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.ImageButton;

        import com.example.vince.carelearning.data.mainapi.Token;
        import com.example.vince.carelearning.exercises.drag_and_drop.DragDropActivity;
        import com.example.vince.carelearning.exercises.label.LabelActivity;
        import com.example.vince.carelearning.exercises.prefix_sufix.PrefixSufixActivity;

 public class MainMenuActivity extends AppCompatActivity {

    private ImageButton lsnButton;
    private ImageButton exButton;
    private ImageButton histButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        histButton = findViewById(R.id.history_button);


        histButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainMenuActivity.this, PrefixSufixActivity.class);
                startActivity(i);
            }
        });

        exButton = findViewById(R.id.exercises_button);

        exButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainMenuActivity.this, ExercisesActivity.class);
                startActivity(i);
            }
        });

        lsnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainMenuActivity.this, LessonsActivity.class);
                startActivity(i);
            }
        });


    }
}