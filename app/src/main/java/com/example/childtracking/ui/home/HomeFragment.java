package com.example.childtracking.ui.home;

import android.app.Activity;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.ViewModelProvider;

import com.example.childtracking.AppHistoryActivity;
import com.example.childtracking.Map;
import com.example.childtracking.R;
import com.example.childtracking.UsageStatsActivity;
import com.example.childtracking.databinding.FragmentHomeBinding;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HomeFragment extends Fragment {


    private Fragment myFragment;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
      /*  HomeViewModel homeViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(HomeViewModel.class);*/

        View view = inflater.inflate(R. layout. fragment_home, container, false);

        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AppHistoryActivity.class);

                intent.putExtra("welcome","UsageStats");
                startActivity(intent);
            }
        });

        Button button1 = (Button) view.findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Map.class);

                intent.putExtra("welcome","UsageStats");
                startActivity(intent);
            }
        });
        return view;


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
    }