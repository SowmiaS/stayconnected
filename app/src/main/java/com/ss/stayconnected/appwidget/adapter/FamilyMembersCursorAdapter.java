package com.ss.stayconnected.appwidget.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ss.stayconnected.R;
import com.ss.stayconnected.model.ProfileInfo;

import java.util.ArrayList;

/**
 * Created by sowmi on 07/01/17.
 */
public class FamilyMembersCursorAdapter extends RecyclerView.Adapter<ProfileInfoViewHolder> {

    private ArrayList<ProfileInfo> profileInfos;
    private Context context;

    public FamilyMembersCursorAdapter(Context context, ArrayList<ProfileInfo> profileInfos) {
        this.context = context;
        this.profileInfos = profileInfos;
    }

    @Override
    public ProfileInfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ProfileInfoViewHolder viewHolder = new ProfileInfoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_familymember_profile, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ProfileInfoViewHolder holder, int position) {
        holder.profilPic.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.sc_profilepic));
    }

    @Override
    public int getItemCount() {
        return profileInfos.size();
    }
}


class ProfileInfoViewHolder extends RecyclerView.ViewHolder {

    public ImageView profilPic;

    public ProfileInfoViewHolder(View itemView) {
        super(itemView);
        profilPic = (ImageView) itemView.findViewById(R.id.familymembers_profilepic);
    }
}


