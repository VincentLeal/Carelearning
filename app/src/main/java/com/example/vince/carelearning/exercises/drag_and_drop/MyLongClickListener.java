package com.example.vince.carelearning.exercises.drag_and_drop;

import android.content.ClipData;
import android.view.View;

public class MyLongClickListener implements View.OnLongClickListener {
    @Override
    public boolean onLongClick(View view) {
        ClipData clipData = ClipData.newPlainText("", "");
        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
        view.startDrag(clipData, shadowBuilder,view,0);

        return true;
    }
}
