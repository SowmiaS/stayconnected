package com.ss.stayconnected;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.ss.stayconnected.mock.FamilyMembersMock;

public class ContainerActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container_main);
        FamilyMembersMock.createMock(this); // TODO: To Remove once user story related to Family Invite is done.

    }
}
