package com.example.impulse.fragments;


import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.impulse.R;


import java.text.DateFormat;
import java.util.Calendar;

    public class PressureFragment extends Fragment  {

        Button btnÖlç, btnKaydet;


        public PressureFragment() {
            // Required empty public constructor
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View v = inflater.inflate(R.layout.fragment_pressure, container, false);



            Calendar calendar = Calendar.getInstance();
            String currentData = DateFormat.getDateInstance().format(calendar.getTime());
            TextView textDate = (TextView) v.findViewById(R.id.text_date);
            textDate.setText(currentData);
            btnÖlç = v.findViewById(R.id.btnPressure);
            btnKaydet = v.findViewById(R.id.btn_Pressure);
            btnÖlç.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            btnKaydet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            return v;
        }

    }