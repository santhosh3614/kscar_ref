package com.kscar.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kscar.R;
import com.kscar.activities.MainActivity;

/**
 * Created by SONI on 12/22/2018.
 */

public class EndTripFragment extends BaseFragment {


    public static EndTripFragment getInstance() {
        EndTripFragment endTripFragment = new EndTripFragment();
        return endTripFragment;
    }

    public static String TAG = EndTripFragment.class.getSimpleName();

    private TextView txtEndTrip;
    private MainActivity mainActivity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_end_trip, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainActivity = (MainActivity) getActivity();
        txtEndTrip = view.findViewById(R.id.txtEndTrip);
        setHeader();
        txtEndTrip.setOnClickListener(v -> {
            mainActivity.onBackPressed();
        });

    }

    private void setHeader() {
        mainActivity = (MainActivity) getActivity();
        mainActivity.imgBack.setVisibility(View.VISIBLE);
        mainActivity.imgMenu.setVisibility(View.GONE);
        mainActivity.txtTitle.setText("End Trip");
        mainActivity.imgBack.setOnClickListener(v -> {
            mainActivity.onBackPressed();
        });
    }


    @Override
    public void init() {

    }
}
