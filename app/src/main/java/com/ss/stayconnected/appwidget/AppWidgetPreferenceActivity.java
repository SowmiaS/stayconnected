package com.ss.stayconnected.appwidget;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RemoteViews;

import com.ss.stayconnected.R;
import com.ss.stayconnected.appwidget.adapter.FamilyMembersCursorAdapter;
import com.ss.stayconnected.base.BaseAppWidgetLaunchActivity;
import com.ss.stayconnected.model.ProfileInfo;

import java.util.ArrayList;

/**
 * This Activity displays the family members profile photos.
 * The user can chose profile photos to have their information in App Widget.
 * Created by sowmi on 06/01/17.
 */
public class AppWidgetPreferenceActivity extends BaseAppWidgetLaunchActivity implements FamilyMembersCursorAdapter.OnWidgetClickListener {

    private RecyclerView mRecyclerView;
    private FamilyMembersCursorAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appwidget_configure_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mRecyclerView = (RecyclerView) findViewById(R.id.familymembers_recyclerview);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this , 2));
        adapter = new FamilyMembersCursorAdapter(this, (ArrayList<ProfileInfo>) ProfileInfo.retriveAllProfiles(this));
        adapter.setProfileClickListener(this);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onClickOfWidget(ProfileInfo profileInfo) {
        RemoteViews view = getView(R.layout.layout_appwidget_main);
        view.setImageViewBitmap(R.id.appwidget_profilepic, BitmapFactory.decodeResource(getResources(),
                Integer.parseInt(profileInfo.getProfilePicURI())));
        updateAppWidget(view , appWidgetId);
        closeActivity();
    }
}
