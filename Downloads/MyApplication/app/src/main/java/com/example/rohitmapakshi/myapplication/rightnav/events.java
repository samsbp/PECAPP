package com.example.rohitmapakshi.myapplication.rightnav;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rohitmapakshi.myapplication.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

// Created by root on 12/2/17.

public class events extends Fragment {


    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.events, container, false);
        final ArrayList<String> addArray = new ArrayList<String>();

        final ListView listView1 = (ListView) view.findViewById(R.id.eventlistview);
        String[] menu = {"sam", "Jude", "cyril"};

        final Button bt1;
        final ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, addArray);
        bt1 = (Button) view.findViewById(R.id.bt1);
        final String myhttpurl = "https://sites.google.com/site/samapp2k17/events.txt?attredirects=0&d=1";
        final String name = URLUtil.guessFileName(myhttpurl, null, MimeTypeMap.getFileExtensionFromUrl(myhttpurl));

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myhttpurl));
                request.setTitle("SAM");
                request.setDescription("FIles is bla bla");
                request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOCUMENTS, "android2k17pec.txt");
                String che = Environment.DIRECTORY_DOWNLOADS;
                DownloadManager manager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                manager.enqueue(request);
                bt1.setEnabled(true);
                File file = new File("/storage/emulated/0/Documents/", "android2k17pec.txt");
                if (file.exists()) {
                    file.delete();
                }

                for (int i = 0; i < 100000; i++) {
                    Boolean fe = file.exists();
                    if (file.exists()) {
                        break;
                    }
                    }


                File sdcard = Environment.getExternalStorageDirectory();
                //Get the text file


                //Read text from file
                StringBuilder text = new StringBuilder();
                String line = new String();

                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));

                    line = br.readLine();
                    while ((line = br.readLine()) != null) {
                        text.append(line);
                        text.append('\n');
                        addArray.add(line);

                    }
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();

                    //You'll need to add proper error handling here
                }
                listView1.setAdapter(adapter);

            }
        });
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "Downloading starts", Toast.LENGTH_SHORT).show();
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(browserIntent);

            }
        });



        return view;
    }


    @Override
    public void onResume() {
        ArrayList<String> addArray = new ArrayList<String>();
        ListView listView = (ListView) getView().findViewById(R.id.eventlistview);
        ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, addArray);
        File file = new File("/storage/emulated/0/Documents/", "android2k17pec.txt");
        StringBuilder text = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
                addArray.add(line);
            }
            br.close();
        }
        catch (IOException e) {
            e.printStackTrace();

            //You'll need to add proper error handling here
        }
        listView.setAdapter(adapter);

        super.onResume();
    }


@Override
    public void onStop() {
    ArrayList<String> addArray = new ArrayList<String>();
    ListView listView = (ListView) getView().findViewById(R.id.eventlistview);
    ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, addArray);
    File file = new File("/storage/emulated/0/Documents/", "android2k17pec.txt");
    StringBuilder text = new StringBuilder();

    try {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            text.append(line);
            text.append('\n');
            addArray.add(line);
        }
        br.close();
    }
    catch (IOException e) {
        e.printStackTrace();

        //You'll need to add proper error handling here
    }
    listView.setAdapter(adapter);
        super.onStop();
    }
}

