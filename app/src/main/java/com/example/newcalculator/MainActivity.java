package com.example.newcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements IButtonFragment,IResFragment {
ButtonFragment buttonFragment = new ButtonFragment();
ResultFragment resultFragment = new ResultFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chengeButtonFragment();
        resultFragment.iresFragment = this;
        buttonFragment.iButtonFragment = this;
    }

    public void chengeButtonFragment(){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container,ButtonFragment.creatButtonFragment(this));

        transaction.commit();
    }

    @Override
    public void showRecycler() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container,resultFragment);
        transaction.commit();



    }



    @Override
    public void showCalculator() {
        Log.d("pop","в меин пришел");
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container,buttonFragment);
        transaction.commit();
    }

}
