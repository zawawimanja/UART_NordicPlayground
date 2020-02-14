package com.android.example.roomwordssample;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    UartViewModel mUartViewModel;
    TextView connectionStatus;
    private int connectionState;
    private boolean hasReceivedServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        connectionStatus=findViewById(R.id.textview);


        // Set up the WordViewModel.
        mUartViewModel = ViewModelProviders.of(this).get(UartViewModel.class);
        mUartViewModel.getConnectionState().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@NonNull Integer connectState) {
                connectionState = connectState;
                setConnectionState(connectionState, hasReceivedServices);
            }
        });

        mUartViewModel.getHasReceivedServices().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@NonNull Boolean servicesStatus) {
                hasReceivedServices = servicesStatus;
                setConnectionState(connectionState, hasReceivedServices);
            }
        });

    }

    public void setConnectionState(int connectionState, boolean hasReceivedServices) {
        this.connectionState = connectionState;
        this.hasReceivedServices = hasReceivedServices;
        switch(connectionState) {
            case 0:
                connectionStatus.setText(R.string.device_connected);
                if(!hasReceivedServices) {
                    //   progressCircle.setVisibility(View.VISIBLE);
//                    retrievalStatus.setText(R.string.waiting_services);
//                    retrievalStatus.setVisibility(View.VISIBLE);
                } else {
//                    progressCircle.setVisibility(View.GONE);
//                    retrievalStatus.setVisibility(View.GONE);
                }
                break;
            case 1:
                connectionStatus.setText(R.string.device_disconnected);
                //  progressCircle.setVisibility(View.VISIBLE);
//                retrievalStatus.setText(R.string.connection_lost);
//                retrievalStatus.setVisibility(View.VISIBLE);
                break;
            case 2:
                connectionStatus.setText(R.string.device_connected);
                // progressCircle.setVisibility(View.VISIBLE);
//                retrievalStatus.setText(R.string.waiting_notified_characteristic);
//                retrievalStatus.setVisibility(View.VISIBLE);
                break;
            case 3:
                connectionStatus.setText(R.string.device_connected);
//                progressCircle.setVisibility(View.GONE);
//                retrievalStatus.setVisibility(View.GONE);
                break;
            default:
                break;

        }

    }


}
