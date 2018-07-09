 package com.example.vince.carelearning;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ImageButton;

        import com.example.vince.carelearning.exercises.drag_and_drop.DragDropActivity;
        import com.example.vince.carelearning.exercises.label.LabelActivity;

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
                Intent i = new Intent(MainMenuActivity.this, HistoryActivity.class);
                startActivity(i);
            }
        });

        exButton = findViewById(R.id.exercises_button);

        exButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainMenuActivity.this, DragDropActivity.class);
                startActivity(i);
            }
        });

        exButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent i = new Intent(MainMenuActivity.this, LabelActivity.class);
                startActivity(i);
                return true;
            }
        });


    }
}