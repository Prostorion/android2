package com.example.lab2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class InputFragment extends Fragment {

    EditText editText;
    Button buttonOk;

    RadioButton radioYes;
    RadioButton radioNo;


    CommunicationInterface communicationInterface;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof CommunicationInterface) {
            communicationInterface = (CommunicationInterface) context;
        } else {
            throw new RuntimeException(context + " must implement CommunicationInterface");
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container, false);

        editText = view.findViewById(R.id.editTextText);
        buttonOk = view.findViewById(R.id.buttonOk);
        radioYes = view.findViewById(R.id.radioButtonYes);
        radioNo = view.findViewById(R.id.radioButtonNo);

        buttonOk.setOnClickListener(v -> {
            String enteredText = editText.getText().toString();
            if (enteredText.trim().equals("")) {
                Toast.makeText(getActivity(), "Please, enter text", Toast.LENGTH_LONG).show();
            } else if (!radioYes.isChecked() && !radioNo.isChecked()) {
                Toast.makeText(getActivity(), "Please, choose answer to your question", Toast.LENGTH_LONG).show();
            } else {
                String answer = radioYes.isChecked() ? "Yes" : "No";
                communicationInterface.showResultFragment(String.format("%s - %s", enteredText, answer));
            }
        });

        return view;
    }
}