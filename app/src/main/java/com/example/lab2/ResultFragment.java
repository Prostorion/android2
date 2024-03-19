package com.example.lab2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ResultFragment extends Fragment {


    private String resultString;

    private TextView resultView;

    public ResultFragment() {
        // Required empty public constructor
    }

    public ResultFragment(String result) {
        resultString = result;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        resultView = view.findViewById(R.id.resultString);
        resultView.setText(resultString);
        return view;
    }


}