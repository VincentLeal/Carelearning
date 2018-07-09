package com.example.vince.carelearning.exercises.drag_and_drop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.vince.carelearning.R;
import com.example.vince.carelearning.exercises.drag_and_drop.MyDragListener;
import com.example.vince.carelearning.exercises.drag_and_drop.MyLongClickListener;

public class DragDropActivity extends AppCompatActivity {

    ImageView stomach, liver, largeIntestine, smallIntestine, esophagus, pancreas;
    ImageView stomachTarget, liverTarget, largeIntestineTarget, smallIntestineTarget, esophagusTarget, pancreasTarget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_drop);

        stomach = findViewById(R.id.stomach);
        stomachTarget = findViewById(R.id.stomach_target);
        liver = findViewById(R.id.liver);
        liverTarget = findViewById(R.id.liver_target);
        smallIntestine = findViewById(R.id.smallintestine);
        smallIntestineTarget = findViewById(R.id.smallintestine_target);
        largeIntestine = findViewById(R.id.largeintestine);
        largeIntestineTarget = findViewById(R.id.largeintestine_target);
        esophagus = findViewById(R.id.esophagus);
        esophagusTarget = findViewById(R.id.esophagus_target);
        pancreas = findViewById(R.id.pancreas);
        pancreasTarget = findViewById(R.id.pancreas_target);

        stomach.setTag("stomach");
        stomachTarget.setTag("stomach");
        liver.setTag("liver");
        liverTarget.setTag("liver");
        smallIntestine.setTag("smallIntestine");
        smallIntestineTarget.setTag("smallIntestine");
        largeIntestine.setTag("largeIntestine");
        largeIntestineTarget.setTag("largeIntestine");
        esophagus.setTag("esophagus");
        esophagusTarget.setTag("esophagus");
        pancreas.setTag("pancreas");
        pancreasTarget.setTag("pancreas");

        stomach.setOnLongClickListener(longClickListener);
        liver.setOnLongClickListener(longClickListener);
        smallIntestine.setOnLongClickListener(longClickListener);
        largeIntestine.setOnLongClickListener(longClickListener);
        esophagus.setOnLongClickListener(longClickListener);
        pancreas.setOnLongClickListener(longClickListener);

        stomachTarget.setOnDragListener(dragListener);
        liverTarget.setOnDragListener(dragListener);
        smallIntestineTarget.setOnDragListener(dragListener);
        largeIntestineTarget.setOnDragListener(dragListener);
        esophagusTarget.setOnDragListener(dragListener);
        pancreasTarget.setOnDragListener(dragListener);


    }

    View.OnDragListener dragListener = new MyDragListener();

   View.OnLongClickListener longClickListener = new MyLongClickListener();

}
