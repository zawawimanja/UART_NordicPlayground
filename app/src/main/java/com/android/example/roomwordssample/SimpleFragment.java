package com.android.example.roomwordssample;

import android.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
public class SimpleFragment extends Fragment {

    private String mParam1;
    View view;
    Button firstButton;
    private static final String ARG_PARAM1 = "param1";
    UartViewModel sharedViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_simple, container, false);
// get the reference of Button
        firstButton = (Button) view.findViewById(R.id.firstButton);
// perform setOnClickListener on first Button
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// display a message by using a Toast
                Toast.makeText(getActivity(), "First Fragment", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        sharedViewModel= ViewModelProviders.of((FragmentActivity) getActivity()).get(UartViewModel.class);

        sharedViewModel.getConnectionState().observe((FragmentActivity) getActivity(), new Observer<Integer>() {
            @Override
            public void onChanged(@NonNull Integer connectState) {
                Log.i("Test",connectState.toString());
            }
        });



    }





}