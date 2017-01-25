package com.ss.stayconnected.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.ss.stayconnected.base.SCSqliteTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sowmi on 06/01/17.
 */
public class ProfileInfo extends SCSqliteTable {


    public static final String TABLE_NAME = ProfileInfo.class.getSimpleName();
    public static final String COLUMN_NAME_NAME = "NAME";
    public static final String COLUMN_NAME_LASTUPDATEDLOCATION = "LASTUPDATEDLOCATION";
    public static final String COLUMN_NAME_LASTUPDATEDTIME = "LASTUPDATEDTIME";
    public static final String COLUMN_NAME_PROFILEPICURI = "PROFILEPICURI";
    private ContentValues profileInfoContentValues ;


    private String name;
    private String lastUpdatedLocation;
    private String lastUpatedTime;
    private String profilePicURI;


    public ProfileInfo() {
    }

    public ProfileInfo(String name, String lastUpdatedLocation, String lastUpatedTime, String profilePicURI) {
        this.name = name;
        this.lastUpdatedLocation = lastUpdatedLocation;
        this.lastUpatedTime = lastUpatedTime;
        this.profilePicURI = profilePicURI;
    }

    @Override
    public ContentValues getContentValues() {
        if(profileInfoContentValues ==null){
            profileInfoContentValues = new ContentValues();
        }
        profileInfoContentValues.put(COLUMN_NAME_NAME , name);
        profileInfoContentValues.put(COLUMN_NAME_LASTUPDATEDLOCATION , lastUpdatedLocation);
        profileInfoContentValues.put(COLUMN_NAME_LASTUPDATEDTIME , lastUpatedTime);
        profileInfoContentValues.put(COLUMN_NAME_PROFILEPICURI , profilePicURI);
        return profileInfoContentValues;
    }


    public static List<ProfileInfo> retriveAllProfiles(Context context){
        List<ProfileInfo> profiles = new ArrayList<>();

        Cursor c = retriveAll(context, ProfileInfo.class);
        c.moveToFirst();

        int nameColumnIndex = c.getColumnIndex(COLUMN_NAME_NAME);
        int lastUpdatedLocationColumnIndex = c.getColumnIndex(COLUMN_NAME_LASTUPDATEDLOCATION);
        int lastUpdatedTimeColumnIndex = c.getColumnIndex(COLUMN_NAME_LASTUPDATEDTIME);
        int profilePicColumnIndex = c.getColumnIndex(COLUMN_NAME_PROFILEPICURI);

        while( !c.isAfterLast() ){
            ProfileInfo profileInfo = new ProfileInfo();
            profileInfo.setName(c.getString(nameColumnIndex));
            profileInfo.setLastUpdatedLocation(c.getString(lastUpdatedLocationColumnIndex));
            profileInfo.setLastUpatedTime(c.getString(lastUpdatedTimeColumnIndex));
            profileInfo.setProfilePicURI(c.getString(profilePicColumnIndex));
            profiles.add(profileInfo);
            c.moveToNext();
        }
        return profiles;
    }


    public void setProfileInfoContentValues(ContentValues profileInfoContentValues) {
        this.profileInfoContentValues = profileInfoContentValues;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastUpdatedLocation(String lastUpdatedLocation) {
        this.lastUpdatedLocation = lastUpdatedLocation;
    }

    public void setLastUpatedTime(String lastUpatedTime) {
        this.lastUpatedTime = lastUpatedTime;
    }

    public void setProfilePicURI(String profilePicURI) {
        this.profilePicURI = profilePicURI;
    }

    public String getName() {
        return name;
    }

    public String getLastUpdatedLocation() {
        return lastUpdatedLocation;
    }

    public String getLastUpatedTime() {
        return lastUpatedTime;
    }

    public String getProfilePicURI() {
        return profilePicURI;
    }
}
