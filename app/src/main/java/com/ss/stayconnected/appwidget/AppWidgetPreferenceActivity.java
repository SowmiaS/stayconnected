package com.ss.stayconnected.appwidget;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ss.stayconnected.R;
import com.ss.stayconnected.base.BaseAppWidgetLaunchActivity;

/**
 * This Activity displays the family members profile photos.
 * The user can chose profile photos to have their information in App Widget.
 * Created by sowmi on 06/01/17.
 */
public class AppWidgetPreferenceActivity extends BaseAppWidgetLaunchActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appwidget_configure_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        populateFamilyMembers();
        closeActivity();
    }


    private void populateFamilyMembers(){
        //TODO: Retrieve Family members details and populate the GridView with information.
    }
}
