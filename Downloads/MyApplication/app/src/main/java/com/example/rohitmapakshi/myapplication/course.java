package com.example.rohitmapakshi.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nvanbenschoten.motion.ParallaxImageView;

/**
 * Created by root on 6/2/17.
 */

public class course extends Fragment{

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){



        return  inflater.inflate(R.layout.content_main,null);
    }
}