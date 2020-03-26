package com.mocomp.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class Second_fragment extends Fragment {
    private ImageView im1;
    private ImageView im2;
    private ImageView im3;
    private ImageView im4;
    private ImageView im5;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment, container, false);

        im1 = view.findViewById(R.id.post_image);
        im2 = view.findViewById(R.id.post_image1);
        im3 = view.findViewById(R.id.post_image2);
        im4 = view.findViewById(R.id.post_image3);
        im5 = view.findViewById(R.id.post_image4);

        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("custom-message");
                intent.putExtra("numper",1);
                LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
            }
        });
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("custom-message");
                intent.putExtra("numper",2);
                LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
            }
        });
        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("custom-message");
                intent.putExtra("numper",3);
                LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
            }
        });
        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("custom-message");
                intent.putExtra("numper",4);
                LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
            }
        });
        im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("custom-message");
                intent.putExtra("numper",5);
                LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
            }
        });

        return view ;
    }
}
