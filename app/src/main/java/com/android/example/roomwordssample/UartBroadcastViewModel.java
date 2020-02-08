//package com.android.example.roomwordssample;
//
//import android.arch.lifecycle.LiveData;
//import android.arch.lifecycle.MutableLiveData;
//import android.arch.lifecycle.ViewModel;
//import android.content.ComponentName;
//import android.content.ServiceConnection;
//import android.os.IBinder;
//import android.util.Log;
//
//import static com.android.example.roomwordssample.MainActivity.TAG;
//
//public class UartBroadcastViewModel extends ViewModel {
//    private UartService mService = null;
//    private MutableLiveData<UartService.LocalBinder> mBinder = new MutableLiveData<>();
//    private final MutableLiveData<Boolean> hasReceivedServices = new MutableLiveData<Boolean>();
//    private final MutableLiveData<Integer> connectionState = new MutableLiveData<Integer>();
//
//
////    // Keeping this in here because it doesn't require a context
////    private ServiceConnection serviceConnection = new ServiceConnection() {
////        @Override
////        public void onServiceConnected(ComponentName className, IBinder iBinder) {
////            Log.d(TAG, "ServiceConnection: connected to service.");
////            // We've bound to MyService, cast the IBinder and get MyBinder instance
////         mService = (UartService.LocalBinder) iBinder;
////            mBinder.postValue(binder);
////        }
////
////        @Override
////        public void onServiceDisconnected(ComponentName arg0) {
////            Log.d(TAG, "ServiceConnection: disconnected from service.");
////            mBinder.postValue(null);
////        }
////    };
//
//    //UART service connected/disconnected
////    private ServiceConnection mServiceConnection = new ServiceConnection() {
////        public void onServiceConnected(ComponentName className, IBinder rawBinder) {
////            mService = ((UartService.LocalBinder) rawBinder).getService();
////            Log.d(TAG, "onServiceConnected mService= " + mService);
//////            if (!mService.initialize()) {
//////                Log.e(TAG, "Unable to initialize Bluetooth");
//////                finish();
//////            }
////
////
////
////        }
////
////        public void onServiceDisconnected(ComponentName classname) {
////            ////     mService.disconnect(mDevice);
////            mService = null;
////        }
////    };
//
//
//
//
//
//
//    public ServiceConnection getServiceConnection(){
//        return mServiceConnection;
//    }
//
//    public LiveData<UartService.LocalBinder> getBinder(){
//        return mBinder;
//    }
//
//
//    public void setHasReceivedServices(Boolean hasReceivedServices) {
//        this.hasReceivedServices.setValue(hasReceivedServices);
//    }
//
//    public LiveData<Boolean> getHasReceivedServices() {
//        return hasReceivedServices;
//    }
//
//    //get from leconnectedDeviceActivity
//    public void setConnectionState(Integer connectionState) {
//        this.connectionState.setValue(connectionState);
//    }
//
//    public LiveData<Integer> getConnectionState() {
//        return connectionState;
//    }
//
//
//
//
//}
