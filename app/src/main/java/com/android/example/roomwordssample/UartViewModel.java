package com.android.example.roomwordssample;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.ServiceConnection;

public class UartViewModel extends ViewModel {
    private final MutableLiveData<Boolean> isScrollToEndSelected = new MutableLiveData<Boolean>();
    private final MutableLiveData<Boolean> hasReceivedServices = new MutableLiveData<Boolean>();
    private final MutableLiveData<Integer> connectionState = new MutableLiveData<Integer>();

    public void setScrollToEnd(Boolean isScrollToEndSelected) {
        this.isScrollToEndSelected.setValue(isScrollToEndSelected);
    }

    public LiveData<Boolean> getScrollToEnd() {
        return isScrollToEndSelected;
    }

    public void setHasReceivedServices(Boolean hasReceivedServices) {
        this.hasReceivedServices.setValue(hasReceivedServices);
    }

    public LiveData<Boolean> getHasReceivedServices() {
        return hasReceivedServices;
    }

    //get from leconnectedDeviceActivity
    public void setConnectionState(Integer connectionState) {
        this.connectionState.setValue(connectionState);
    }

    public LiveData<Integer> getConnectionState() {
        return connectionState;
    }








}
