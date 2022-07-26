package com.example.myapplication;
import java.util.ArrayList;
import android.annotation.SuppressLint;
import android.app.ApplicationErrorReport;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.ModelClass;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private static CustomClickListener customClickListener;
    private final ArrayList<ModelClass> arrayList;
    private ModelClass modelClass;
    private final Context context;
    public RecyclerAdapter(Context context,  ArrayList<ModelClass> list) {
        this.arrayList=list;
        this.context = context;
    }
    public void setCustomClickListener(CustomClickListener customClickListener)
    {
        this.customClickListener = customClickListener;
    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false);
        return new RecyclerViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.RecyclerViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if (!arrayList.isEmpty()) modelClass = arrayList.get(position);
        holder.dateTextView.setText(""+modelClass.getDate());
        holder.systolicTextView.setText(""+modelClass.getSystolic());
        holder.diastolicTextView.setText(""+modelClass.getDiastolic());
        holder.heartTextView.setText(""+modelClass.getHeartRate());
        holder.editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (customClickListener != null) {
                    if (position != RecyclerView.NO_POSITION) {
                        customClickListener.onEditClick(position);
                    }
                }

            }
        });
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (customClickListener != null) {
                    if (position != RecyclerView.NO_POSITION) {
                        customClickListener.onDeleteClick(position);
                    }
                }


            }

        });

        if (modelClass.getDiastolic()<80) holder.diastolicTextView.setTextColor(Color.parseColor("#FF018786"));
        else if(modelClass.getDiastolic()<90) holder.diastolicTextView.setTextColor(Color.parseColor("#FF9800"));
        else holder.diastolicTextView.setTextColor(Color.parseColor("#C3473E"));
        if (modelClass.getSystolic()<120) holder.systolicTextView.setTextColor(Color.parseColor("#FF018786"));
        else if(modelClass.getSystolic()<139) holder.systolicTextView.setTextColor(Color.parseColor("#FF9800"));
        else holder.systolicTextView.setTextColor(Color.parseColor("#C3473E"));
        if (modelClass.getHeartRate()>60 && modelClass.getHeartRate()<100) holder.heartTextView.setTextColor(Color.parseColor("#FF018786"));
        else if(modelClass.getHeartRate()>=40&&modelClass.getHeartRate()<110) holder.heartTextView.setTextColor(Color.parseColor("#FF9800"));
        else holder.heartTextView.setTextColor(Color.parseColor("#C3473E"));


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public interface CustomClickListener {
        void cusOnClick(int position, View v);
        void onDeleteClick(int position);
        void onEditClick(int position);
    }
    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView systolicTextView;
        TextView heartTextView;
        TextView diastolicTextView;
        TextView dateTextView;
        CardView containerCardView;
        ImageView editButton, deleteButton;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            systolicTextView = itemView.findViewById(R.id.tvSystolic);
            diastolicTextView = itemView.findViewById(R.id.tvDiastolic);
            dateTextView = itemView.findViewById(R.id.tvDate);
            heartTextView = itemView.findViewById(R.id.tvHeartRate);
            containerCardView = itemView.findViewById(R.id.llContainerCardView);
            editButton = itemView.findViewById(R.id.editButton);
            deleteButton = itemView.findViewById(R.id.deleteButton);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            customClickListener.cusOnClick(getAdapterPosition(), view);  //position and view setting to provide to mainactivity
        }

    }


}


