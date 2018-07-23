package com.example.vince.carelearning.data.mainapi;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vince.carelearning.R;
import com.example.vince.carelearning.model.Exercise;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Exercise> mData;
    private LayoutInflater mInflater;
    protected ItemClickListener mClickListener;

    // data is passed into the constructor
    public Adapter(Context context, List<Exercise> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    public ItemClickListener getmClickListener() {
        return mClickListener;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_exercise, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String exercise = mData.get(position).getQuestion();
        holder.titleTextView.setText(exercise);
        String exerciseType = mData.get(position).getType();
        holder.typeTextView.setText(exerciseType);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titleTextView;
        TextView typeTextView;
        ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title_tv);
            typeTextView = itemView.findViewById(R.id.type_tv);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public Exercise getItem(int id) {
        return mData.get(id);

        //return mData.get(id).getId().toString();
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}