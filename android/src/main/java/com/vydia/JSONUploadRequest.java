package com.vydia;

import android.content.Context;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableNativeMap;

import net.gotev.uploadservice.HttpUploadRequest;
import net.gotev.uploadservice.HttpUploadTask;
import net.gotev.uploadservice.UploadTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;

public class JSONUploadRequest extends HttpUploadRequest<JSONUploadRequest> {
    public JSONUploadRequest(Context context, String uploadId, String serverUrl) throws MalformedURLException, IllegalArgumentException {
        super(context, uploadId, serverUrl);
    }

    @Override
    protected Class<? extends UploadTask> getTaskClass() {
        return HttpUploadTask.class;
    }
}
