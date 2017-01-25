package com.ss.stayconnected.mock;

import android.content.Context;

import com.ss.stayconnected.model.ProfileInfo;

/**
 * Created by sowmi on 07/01/17.
 */
public class FamilyMembersMock {

    private FamilyMembersMock() {
    }


    public static void createMock(Context context){

        ProfileInfo daddy = new ProfileInfo("Sundararajan", "Pathayam Palayam", "5th March 2017 10.00 p.m", "");
        ProfileInfo mummy = new ProfileInfo("Jayalakshmi", "Krishnagiri", "5th March 2017 10.00 p.m", "");
        ProfileInfo bro = new ProfileInfo("Arunkumar", "Erode", "5th March 2017 10.00 p.m", "");
        ProfileInfo browife = new ProfileInfo("Ranjani", "Arachalur", "5th March 2017 10.00 p.m", "");
        ProfileInfo husband = new ProfileInfo("Sharma", "Ammapettai", "5th March 2017 10.00 p.m", "");

        daddy.save(context);
        mummy.save(context);
        bro.save(context);
        browife.save(context);
        husband.save(context);
    }

}
