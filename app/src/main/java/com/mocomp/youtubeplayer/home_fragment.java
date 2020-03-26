package com.mocomp.youtubeplayer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class home_fragment extends Fragment {

    private Button subbutton;
    private Button subbutton1;
    private Button subbutton2;
    private Button subbutton3;
    private Button subbutton4;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        subbutton=view.findViewById(R.id.SubButton);
        subbutton1=view.findViewById(R.id.SubButton1);
        subbutton2=view.findViewById(R.id.SubButton2);
        subbutton3=view.findViewById(R.id.SubButton3);
        subbutton4=view.findViewById(R.id.SubButton4);

        if (Application.getPrefranceDataBoolean("clicked1")){
            subbutton.setTextColor(getResources().getColor(R.color.textColorHighlight));
            subbutton.setBackgroundColor(getResources().getColor(R.color.colorGrey500));
        }
        if (Application.getPrefranceDataBoolean("clicked2")){
            subbutton1.setTextColor(getResources().getColor(R.color.textColorHighlight));
            subbutton1.setBackgroundColor(getResources().getColor(R.color.colorGrey500));
        }
        if (Application.getPrefranceDataBoolean("clicked3")){
            subbutton2.setTextColor(getResources().getColor(R.color.textColorHighlight));
            subbutton2.setBackgroundColor(getResources().getColor(R.color.colorGrey500));
        }
        if (Application.getPrefranceDataBoolean("clicked4")){
            subbutton3.setTextColor(getResources().getColor(R.color.textColorHighlight));
            subbutton3.setBackgroundColor(getResources().getColor(R.color.colorGrey500));
        }
        if (Application.getPrefranceDataBoolean("clicked5")){
            subbutton4.setTextColor(getResources().getColor(R.color.textColorHighlight));
            subbutton4.setBackgroundColor(getResources().getColor(R.color.colorGrey500));
        }

        subbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Application.setPreferencesBoolean("clicked1",true);
                subbutton.setTextColor(getResources().getColor(R.color.textColorHighlight));
                subbutton.setBackgroundColor(getResources().getColor(R.color.colorGrey500));
                Application.setPreferences("CLIENT_SECRETS","first.json");
                Application.setPreferences("ChannelId","UCAIxr4DpLZH-Iih4mlbLjiA");
                try {
                    ApiExample.getService();
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        subbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Application.setPreferencesBoolean("clicked2",true);
                subbutton1.setTextColor(getResources().getColor(R.color.textColorHighlight));
                subbutton1.setBackgroundColor(getResources().getColor(R.color.colorGrey500));
                Application.setPreferences("CLIENT_SECRETS","second.json");
                Application.setPreferences("ChannelId","UC0tmxpySNunSEtTLXpMj36w");
                try {
                    ApiExample.getService();
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        subbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Application.setPreferencesBoolean("clicked3",true);
                subbutton2.setTextColor(getResources().getColor(R.color.textColorHighlight));
                subbutton2.setBackgroundColor(getResources().getColor(R.color.colorGrey500));
                Application.setPreferences("CLIENT_SECRETS","third.json");
                Application.setPreferences("ChannelId","UCs8vDlWQQJb21sLh9jh1qWA");
                try {
                    ApiExample.getService();
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        subbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Application.setPreferencesBoolean("clicked4",true);
                subbutton3.setTextColor(getResources().getColor(R.color.textColorHighlight));
                subbutton3.setBackgroundColor(getResources().getColor(R.color.colorGrey500));
                Application.setPreferences("CLIENT_SECRETS","forth.json");
                Application.setPreferences("ChannelId","UCYskjD6IuQJrxrW3I0EriZA");
                try {
                    ApiExample.getService();
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        subbutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Application.setPreferencesBoolean("clicked5",true);
                subbutton4.setTextColor(getResources().getColor(R.color.textColorHighlight));
                subbutton4.setBackgroundColor(getResources().getColor(R.color.colorGrey500));
                Application.setPreferences("CLIENT_SECRETS","fives.json");
                Application.setPreferences("ChannelId","UCX5lX80yKjkzyXQWkkm3rOQ");
                try {
                    ApiExample.getService();
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        return view ;
    }
}
