package com.example.newcalculator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterView extends RecyclerView.Adapter<Viewholder> {
    ArrayList<String> data;

    public AdapterView (){
        data= new ArrayList<>();
        data.add("Results :");
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.view_holder,parent,false);
        return new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.textView.setText(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void addText(String text){
        data.add(text);
        notifyDataSetChanged();
    }
}
