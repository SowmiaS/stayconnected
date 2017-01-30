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
    private OnWidgetClickListener profileClickListener;

    public FamilyMembersCursorAdapter(Context context, ArrayList<ProfileInfo> profileInfos) {
        this.context = context;
        this.profileInfos = profileInfos;
    }

    public void setProfileClickListener(OnWidgetClickListener profileClickListener) {
        this.profileClickListener = profileClickListener;
    }

    @Override
    public ProfileInfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ProfileInfoViewHolder viewHolder = new ProfileInfoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_familymember_profile, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ProfileInfoViewHolder holder, final int position) {
        holder.profilPic.setImageDrawable(ContextCompat.getDrawable(context, Integer.parseInt(profileInfos.get(position).getProfilePicURI())));

        if(profileClickListener != null){
            holder.profilPic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    profileClickListener.onClickOfWidget(profileInfos.get(position));
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return profileInfos.size();
    }

    public interface OnWidgetClickListener{
        public void onClickOfWidget(ProfileInfo profileInfo);
    }
}


class ProfileInfoViewHolder extends RecyclerView.ViewHolder {

    public ImageView profilPic;

    public ProfileInfoViewHolder(View itemView) {
        super(itemView);
        profilPic = (ImageView) itemView.findViewById(R.id.familymembers_profilepic);
    }
}





