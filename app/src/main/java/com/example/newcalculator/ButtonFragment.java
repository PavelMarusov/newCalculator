package com.example.newcalculator;


import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ButtonFragment extends Fragment {
    Double firstNum;
    Double secNum;
    Double reult;
    String operation;
    ResultFragment resultFragment = new ResultFragment();
    IButtonFragment iButtonFragment;
    TextView textView;


    public static ButtonFragment creatButtonFragment(IButtonFragment iButtonFragment){
        ButtonFragment fragment = new ButtonFragment();
        fragment.iButtonFragment = iButtonFragment;
        return fragment;

    }


    public ButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_button, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.FB_text_view);
        Button buttonH =  view.findViewById(R.id.FC_histori);
        Button button0 = view.findViewById(R.id.FC_button_0);
        Button button1 = view.findViewById(R.id.FC_button_1);
        Button button2 = view.findViewById(R.id.FC_button_2);
        Button button3 = view.findViewById(R.id.FC_button_3);
        Button button4 = view.findViewById(R.id.FC_button_4);
        Button button5 = view.findViewById(R.id.FC_button_5);
        Button button6 = view.findViewById(R.id.FC_button_6);
        Button button7 = view.findViewById(R.id.FC_button_7);
        Button button8 = view.findViewById(R.id.FC_button_8);
        Button button9 = view.findViewById(R.id.FC_button_9);
        Button buttonPluse = view.findViewById(R.id.FC_button_addition);
        Button buttonMinus = view.findViewById(R.id.FC_button_subtraction);
        Button buttonMult = view.findViewById(R.id.FC_button_multipl);
        Button buttonDiv = view.findViewById(R.id.FC_button_division);
        Button buttonEqual = view.findViewById(R.id.FC_button_equal);
        Button buttonCline = view.findViewById(R.id.FC_button_cline);
        Button buttonPoint = view.findViewById(R.id.FC_button_point);
        buttonH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getResult();
            }
        });
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.FC_button_0:
                        textView.setText("0");
                        break;
                    case R.id.FC_button_1:
                        textView.setText("1");
                        break;
                    case R.id.FC_button_2:
                        textView.setText("2");
                        break;
                    case R.id.FC_button_3:
                        textView.setText("3");
                        break;
                    case R.id.FC_button_4:
                        textView.setText("4");
                        break;
                    case R.id.FC_button_5:
                        textView.setText("5");
                        break;
                    case R.id.FC_button_6:
                        textView.setText("7");
                        break;
                    case R.id.FC_button_8:
                        textView.setText("8");
                        break;
                    case R.id.FC_button_9:
                        textView.setText("9");
                        break;
                    case R.id.FC_button_point:
                        textView.setText(".");
                        break;
                    case R.id.FC_button_addition:
                        operation = "+";
                        firstNum = Double.valueOf(textView.getText().toString());
                        textView.setText("+");
                        break;
                    case R.id.FC_button_division:
                        operation = "/";
                        firstNum = Double.valueOf(textView.getText().toString());
                        textView.setText("/");
                        break;
                    case R.id.FC_button_multipl:
                        operation = "x";
                        firstNum = Double.valueOf(textView.getText().toString());
                        textView.setText("x");
                        break;
                    case R.id.FC_button_subtraction:
                        operation = "-";
                        firstNum = Double.valueOf(textView.getText().toString());
                        textView.setText("-");
                        break;
                    case R.id.FC_button_cline:
                        textView.setText("");
                        break;
                    case R.id.FC_button_equal:
                        if (operation != null) {
                            String next = textView.getText().toString().replace(firstNum + operation + "", "");
                            secNum = Double.valueOf(next);
                            switch (operation) {
                                case "+":
                                    reult = firstNum + secNum;
                                    textView.setText(reult + "");

                                    break;
                                case "-":
                                    reult = firstNum - secNum;
                                    textView.setText(reult + "");
                                    break;
                                case "/":
                                    reult = firstNum /secNum;
                                    textView.setText(reult + "");
                                    break;
                                case "x":
                                    reult = firstNum * secNum;
                                    textView.setText(reult + "");
                                    break;
                            }




                        }


                }


            }
        };
        button0.setOnClickListener(listener);
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);
        buttonCline.setOnClickListener(listener);
        buttonDiv.setOnClickListener(listener);
        buttonEqual.setOnClickListener(listener);
        buttonMinus.setOnClickListener(listener);
        buttonPluse.setOnClickListener(listener);
        buttonMult.setOnClickListener(listener);
        buttonPoint.setOnClickListener(listener);


    }


     public void getResult(){
        String text = textView.getText().toString();
        Log.d("pop", "Otpravka"+text);
        Bundle bundle = new Bundle();
        bundle.putString("key",text);
        resultFragment.setArguments(bundle);
         iButtonFragment.showRecycler();
     }
}
