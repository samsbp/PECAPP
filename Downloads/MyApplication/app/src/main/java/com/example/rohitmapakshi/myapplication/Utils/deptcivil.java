package com.example.rohitmapakshi.myapplication.Utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rohitmapakshi.myapplication.R;

/**
 * Created by root on 5/2/17.
 */

public class deptcivil extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return  inflater.inflate(R.layout.deptcivil,null);
    }
}
