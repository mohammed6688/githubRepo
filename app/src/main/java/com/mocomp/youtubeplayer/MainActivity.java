package com.mocomp.youtubeplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import com.google.api.client.http.javanet.NetHttpTransport;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class MainActivity extends AppCompatActivity implements YouTubePlayer.OnInitializedListener{

    SlidingUpPanelLayout mLayout;
    private Fragment selectfragment;
    Button subbutton;

    public BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            int numper = intent.getIntExtra("numper",1);

            if (numper == 1){
                Application.setPreferences("VideoLink","ygYqplz52Pc");
                intitialise();

            }else if (numper==2){
                Application.setPreferences("VideoLink","0COAMy0NNNI");
                intitialise();

            }else if (numper==3){
                Application.setPreferences("VideoLink","Wkci7qWGIiE");
                intitialise();

            }else if (numper==4){
                Application.setPreferences("VideoLink","HT5T1PuPQbQ");
                intitialise();

            }else if (numper==5){
                Application.setPreferences("VideoLink","LLPWaHnlIj4");
                intitialise();

            }
        }
    };

    private static final int RECOVERY_DIALOG_REQUEST = 1;
    Toolbar toolbar;
    YouTubePlayerFragment youTubePlayerFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
                new IntentFilter("custom-message"));

        mLayout = findViewById(R.id.mLayout);
        toolbar = findViewById(R.id.toolbar);
        mLayout.setPanelState(SlidingUpPanelLayout.PanelState.HIDDEN);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");



        if(savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.nav_container, new home_fragment());
            transaction.commit();
        }
        int sessionId = getIntent().getIntExtra("Fragment_num",1);
        if (sessionId == 1){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.nav_container, new home_fragment());
            transaction.commit();
        }else if (sessionId == 2){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.nav_container, new Second_fragment());
            transaction.commit();
        }

        final BottomNavigationView bottnav = findViewById(R.id.navegat);
        bottnav.setOnNavigationItemSelectedListener(navlistener);

        mLayout.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                toolbar.setAlpha(1-slideOffset);
                bottnav.setAlpha(1-slideOffset);
                slideToTop(toolbar , slideOffset);
                slideToBottomnav(bottnav , slideOffset);
            }

            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {
                if (newState == SlidingUpPanelLayout.PanelState.EXPANDED){
                    toolbar.setVisibility(View.GONE);


                }
                if (newState == SlidingUpPanelLayout.PanelState.COLLAPSED){

                    toolbar.setVisibility(View.VISIBLE);

                    bottnav.setVisibility(View.VISIBLE);

                }
            }
        });

    }

    private void intitialise() {
        mLayout.setVisibility(View.VISIBLE);
        mLayout.setTouchEnabled(true);
        mLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
        youTubePlayerFragment =
                (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.youtube_fragment);
        youTubePlayerFragment.onDestroy();
        youTubePlayerFragment.initialize("AIzaSyB43vfEpUD3NFH5ZV3l1UXcJOZ5aZ7SIZQ",
                this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        if (!wasRestored) {
            youTubePlayer.cueVideo(Application.getPrefranceData("VideoLink"));
        }else {
            youTubePlayer.cueVideo(Application.getPrefranceData("VideoLink"));
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {
            String errorMessage = String.format("There was an error initializing the YouTubePlayer (%1$s)", youTubeInitializationResult.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
    }
    public void slideToTop(View view , float offset){
        TranslateAnimation animate = new TranslateAnimation(0,0,0,-view.getHeight()*offset);
        animate.setDuration(100);
        animate.setFillAfter(true);
        view.startAnimation(animate);
        view.setVisibility(View.GONE);
    }
    public void slideToBottomnav(View view, float offset){
        TranslateAnimation animate = new TranslateAnimation(0,0,view.getHeight()*offset,0);
        animate.setDuration(100);
        animate.setFillAfter(true);
        view.startAnimation(animate);
        //view.setVisibility(View.GONE);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navlistener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    selectfragment =null;

                    switch (menuItem.getItemId()){
                        case R.id.nav_home:
                            selectfragment = new home_fragment();
                            break;
                        case R.id.nav_explore:
                            selectfragment = new Second_fragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_container,
                            selectfragment).commit();
                    return true;
                }
            };
}
