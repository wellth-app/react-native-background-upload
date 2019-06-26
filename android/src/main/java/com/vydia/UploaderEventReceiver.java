package com.vydia;

import android.content.Context;
import androidx.annotation.Nullable;
import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import net.gotev.uploadservice.ServerResponse;
import net.gotev.uploadservice.UploadInfo;
import net.gotev.uploadservice.UploadServiceBroadcastReceiver;

/**
 * Uploader Event Receiver
 * Kyle Weisel
 * October 28 2018
 */
public class UploaderEventReceiver extends UploadServiceBroadcastReceiver {

    public static final String TAG = "UploaderEventReceiver";
    private final ReactApplicationContext reactApplicationContext;

    public UploaderEventReceiver(ReactApplicationContext context) {
        this.reactApplicationContext = context;
    }


    private void sendEvent(String eventName, @Nullable WritableMap params) {
        this.reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit("RNFileUploader-" + eventName, params);
    }

    @Override
    public void onProgress(Context context, UploadInfo uploadInfo) {
        WritableMap params = Arguments.createMap();
        params.putString("id", uploadInfo.getUploadId());
        params.putInt("progress", uploadInfo.getProgressPercent());
        sendEvent("progress", params);
    }

    @Override
    public void onError(Context context, UploadInfo uploadInfo, ServerResponse serverResponse, Exception exception) {
        WritableMap params = Arguments.createMap();
        params.putString("id", uploadInfo.getUploadId());
        params.putString("error", exception.getMessage());
        sendEvent("error", params);
    }

    @Override
    public void onCompleted(Context context, UploadInfo uploadInfo, ServerResponse serverResponse) {
        WritableMap params = Arguments.createMap();
        params.putString("id", uploadInfo.getUploadId());
        params.putInt("responseCode", serverResponse.getHttpCode());
        params.putString("responseBody", serverResponse.getBodyAsString());
        sendEvent("completed", params);
    }

    @Override
    public void onCancelled(Context context, UploadInfo uploadInfo) {
        WritableMap params = Arguments.createMap();
        params.putString("id", uploadInfo.getUploadId());
        sendEvent("cancelled", params);
    }
}