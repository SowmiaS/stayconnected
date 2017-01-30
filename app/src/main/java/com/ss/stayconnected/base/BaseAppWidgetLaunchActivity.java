package com.ss.stayconnected.base;

import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.RemoteViews;

/**
 * This class for common functionality needed for Launching activity of App Wigets.
 * Created by sowmi on 06/01/17.
 */
public class BaseAppWidgetLaunchActivity extends FragmentActivity {

    private static final String TAG = "BaseAppWidgetLaunchActivity";
    protected int appWidgetId;
    private RemoteViews remoteViews;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SCLog.d(TAG , "onCreate");
        getAppWidgetId(getIntent());
    }

    /**
     * This method returns the app widgetId for the launching activity.
     *
     * @param intent the intent from activity
     * @return int appWidgetId
     */
    private int getAppWidgetId(Intent intent) {
        if (appWidgetId == 0) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                SCLog.d(TAG , "appwidgetId 0"+appWidgetId);
                appWidgetId = extras.getInt(
                        AppWidgetManager.EXTRA_APPWIDGET_ID,
                        AppWidgetManager.INVALID_APPWIDGET_ID);
                return appWidgetId;
            }
            SCLog.d(TAG , "appwidgetId 1"+appWidgetId);
            return 0;
        } else {
            SCLog.d(TAG , "appwidgetId 2"+appWidgetId);
            return appWidgetId;
        }
    }

    public RemoteViews getView( int layoutResourceId ) {
        if(remoteViews == null){
            remoteViews = new RemoteViews(getPackageName(),
                    layoutResourceId);
        }
        return remoteViews;
    }

    public void updateAppWidget(RemoteViews views, int appWidgetId) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    public void updateAppWidget(RemoteViews views) {
        updateAppWidget(views, appWidgetId);
    }

    public void closeActivity() {
        Intent resultValue = new Intent();
        resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
        setResult(RESULT_OK, resultValue);
        finish();
    }

}
