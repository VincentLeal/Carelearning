package com.example.vince.carelearning.exercises.drag_and_drop;

import android.util.Log;
import android.view.DragEvent;
import android.view.View;

public class MyDragListener implements View.OnDragListener {

    @Override
    public boolean onDrag(View view, DragEvent dragEvent) {
        int event = dragEvent.getAction();
        final View v = (View) dragEvent.getLocalState();
        int x_pos, y_pos;
        x_pos = (int) dragEvent.getX();
        y_pos = (int) dragEvent.getY();

        switch (event){
            case DragEvent.ACTION_DRAG_ENTERED:
                Log.d("ADENT", v.getTag() + " . " + view.getTag() + "ACTION_DRAG_ENTERED | x="
                        + x_pos + " y=" + y_pos);
                break;
            case DragEvent.ACTION_DRAG_LOCATION:
                Log.d("ADL", v.getTag() + " . " + view.getTag() + "ACTION_DRAG_LOCATION | x="
                        + x_pos + " y=" + y_pos);
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                Log.d("ADEX", v.getTag() + " . " + view.getTag() + "ACTION_DRAG_EXITED | x="
                        + x_pos + " y=" + y_pos);
                break;
            case DragEvent.ACTION_DROP:
                Log.d("ADD", v.getTag() + " . " + view.getTag() + "ACTION_DRAG_DROP | x="
                        + x_pos + " y=" + y_pos);
                if(v.getTag() == view.getTag()) {
                    v.animate()
                            .x(view.getX())
                            .y(view.getY())
                            .setDuration(500)
                            .start();
                    view.setVisibility(View.INVISIBLE);
                }
                break;
        }
        return true;
    }
}
