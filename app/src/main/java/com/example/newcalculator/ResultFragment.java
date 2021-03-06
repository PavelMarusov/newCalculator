package com.example.newcalculator;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResultFragment extends Fragment {
    AdapterView adapterView;
    RecyclerView recyclerView;
    IResFragment iresFragment;
    ArrayList<String> list = new ArrayList<>();

    public ResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);
        adapterView = new AdapterView();
        recyclerView.setAdapter(adapterView);


        Button button = view.findViewById(R.id.RF_button_back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IResFragment iResFragment = (IResFragment) getActivity();
                iResFragment.showCalculator();
            }
        });
        Button button1 = view.findViewById(R.id.get);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRes();
            }
        });


    }

    public void getRes() {
        list = getArguments().getStringArrayList("key");
        for (int i = 0; i < list.size(); i++) {
            Log.d("pop", list.get(i));
            adapterView.addText(list.get(i));
        }

    }
}
