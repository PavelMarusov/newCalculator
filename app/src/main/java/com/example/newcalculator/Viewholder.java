package com.example.newcalculator;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Viewholder extends RecyclerView.ViewHolder {
    TextView textView;

    public Viewholder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.VH_text_view);
    }
}
