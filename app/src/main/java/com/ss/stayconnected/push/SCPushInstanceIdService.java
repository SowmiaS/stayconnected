package com.ss.stayconnected.push;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by sowmi on 30/01/17.
 */
public class SCPushInstanceIdService extends FirebaseInstanceIdService{

    private static final String TAG = "SCPushInstanceIdService";

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);
        // need to update token in server for this user.
    }

    
}
