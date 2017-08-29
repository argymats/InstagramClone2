package com.thenewboston.instagramclone.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.thenewboston.instagramclone.R;
import com.thenewboston.instagramclone.Utils.BottomNavigationViewHelper;
import com.thenewboston.instagramclone.Utils.GridImageAdapter;
import com.thenewboston.instagramclone.Utils.UniversalImageLoader;

import java.util.ArrayList;

/**
 * Created by rgbur on 8/2/2017.
 */

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "ProfileActivity";
    private static final int ACTIVITY_NUM = 4;
    private static final int GRID_COLUMNS_NUM = 3;

    private ProgressBar mProgressBar;
    private ImageView profilePhoto;
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate: activity started");

        setupBottomNavigationView();
        setToolBar();
        setupActivityWidgets();
        setProfileImage();
        tempGridSetup();
    }

    private void setToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.profileToolBar);
        setSupportActionBar(toolbar);
        ImageView profileMenu = (ImageView) findViewById(R.id.profileMenu);
        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProfileActivity.this, AccountSettingsActivity.class);
                startActivity(i);
            }
        });
    }

    private void tempGridSetup() {
        ArrayList<String> imgURLs = new ArrayList<>();

        imgURLs.add("https://www.bmw.gr/content/dam/bmw/common/home/teaser/efficient_dynamics.png");
        imgURLs.add("https://www.bmw.gr/content/dam/bmw/common/home/teaser/efficient_dynamics.png");
        imgURLs.add("https://www.bmw.gr/content/dam/bmw/common/home/teaser/efficient_dynamics.png");
        imgURLs.add("https://www.bmw.gr/content/dam/bmw/common/home/teaser/efficient_dynamics.png");
        imgURLs.add("https://www.bmw.gr/content/dam/bmw/common/home/teaser/efficient_dynamics.png");
        imgURLs.add("https://www.bmw.gr/content/dam/bmw/common/home/teaser/efficient_dynamics.png");
        imgURLs.add("https://www.bmw.gr/content/dam/bmw/common/home/teaser/efficient_dynamics.png");
        imgURLs.add("https://www.bmw.gr/content/dam/bmw/common/home/teaser/efficient_dynamics.png");
        imgURLs.add("https://www.bmw.gr/content/dam/bmw/common/home/teaser/efficient_dynamics.png");
        imgURLs.add("https://www.bmw.gr/content/dam/bmw/common/home/teaser/efficient_dynamics.png");

        setupImageGrid(imgURLs);
    }

    private void setupImageGrid(ArrayList<String> imgURLs){
        GridView gridView = (GridView) findViewById(R.id.gridView);
        GridImageAdapter adapter = new GridImageAdapter(ProfileActivity.this, R.layout.layout_grid_imageview, "", imgURLs);
        gridView.setAdapter(adapter);

        int gridWidth = getResources().getDisplayMetrics().widthPixels;
        int imageWidth = gridWidth/GRID_COLUMNS_NUM;
        gridView.setColumnWidth(imageWidth);
    }

    private void setProfileImage(){

        String imgURL = "https://www.google.gr/search?q=android&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjG8tCmkb3VAhXHAMAKHcKQCNYQ_AUICigB&biw=1366&bih=648#imgrc=dQ04JS-2jN_vQM:";
        UniversalImageLoader.setImage(imgURL, profilePhoto, mProgressBar, "");
    }

    private void setupActivityWidgets(){
        profilePhoto = (ImageView) findViewById(R.id.profile_photo);
    }



    private void setupBottomNavigationView() {
        Log.d(TAG, "setupBottomNavigationView: setting up her");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(ProfileActivity.this,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);


    }


}
