package com.example.impulse.fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.impulse.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    CardView cardViewPressure, cardViewPulse, cardViewTemperature, cardViewLocation, cardViewRemember, cardViewAlert;
    GridLayout gridLayout;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        gridLayout = (GridLayout) v.findViewById(R.id.grid);
        cardViewPressure = (CardView) v.findViewById(R.id.cardPressure);
        cardViewPulse = (CardView) v.findViewById(R.id.cardPulse);
        cardViewTemperature = (CardView) v.findViewById(R.id.cardTemperature);
        cardViewRemember = (CardView) v.findViewById(R.id.cardRemember);
        cardViewLocation = (CardView) v.findViewById(R.id.cardLocation);
        cardViewAlert = (CardView) v.findViewById(R.id.cardAlert);

        cardViewPressure.setOnClickListener(this);
        cardViewPulse.setOnClickListener(this);
        cardViewTemperature.setOnClickListener(this);
        cardViewRemember.setOnClickListener(this);
        cardViewLocation.setOnClickListener(this);
        cardViewAlert.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction ft;
        switch (view.getId()) {

            case R.id.cardPressure: {
                ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame_layout_users, new PressureFragment());
                ft.commit();
                break;
            }
            case R.id.cardPulse:{
                ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame_layout_users, new PulseFragment());
                ft.commit();
                break;
            }
            case R.id.cardTemperature:{
                ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame_layout_users, new TemperatureFragment());
                ft.commit();
                break;
            }
            case R.id.cardRemember:{
                ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame_layout_users, new RememberFragment());
                ft.commit();
                break;
            }
            case R.id.cardLocation:{
                ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame_layout_users, new LocationFragment());
                ft.commit();
                break;
            }
            case R.id.cardAlert:{
                ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame_layout_users, new AlertFragment());
                ft.commit();
                break;
            }
        }
    }
}