package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements CommunicationInterface {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        InputFragment inputFragment = new InputFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        fragmentTransaction.add(R.id.fragmentContainerView, inputFragment);


        fragmentTransaction.commit();





    }

    @Override
    public void showResultFragment(String result) {

        ResultFragment resultFragment = new ResultFragment(result);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, resultFragment)
                .commit();
    }
}