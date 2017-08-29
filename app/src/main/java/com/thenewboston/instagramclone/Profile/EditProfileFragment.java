package com.thenewboston.instagramclone.Profile;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.thenewboston.instagramclone.R;
import com.thenewboston.instagramclone.Utils.UniversalImageLoader;

/**
 * Created by rgbur on 8/3/2017.
 */

public class EditProfileFragment extends Fragment {

    private ImageView mProfilePhoto;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editprofile, container, false);

        mProfilePhoto =  view.findViewById(R.id.profile_photo);
        setProfileImage();

        ImageView backArrow = view.findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });

        return view;
    }

    private void setProfileImage(){
        String imgURL = "https://www.google.gr/search?q=android&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjG8tCmkb3VAhXHAMAKHcKQCNYQ_AUICigB&biw=1366&bih=648#imgrc=dQ04JS-2jN_vQM:";
        UniversalImageLoader.setImage(imgURL, mProfilePhoto, null, "");
    }


}
