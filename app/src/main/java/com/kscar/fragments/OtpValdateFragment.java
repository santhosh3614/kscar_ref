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

public class OtpValdateFragment extends BaseFragment {

    public static OtpValdateFragment getInstance() {
        OtpValdateFragment otpValdateFragment = new OtpValdateFragment();
        return otpValdateFragment;
    }

    public static String TAG = OtpValdateFragment.class.getSimpleName();
    private TextView txtDone;
    private MainActivity mainActivity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_otp, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtDone = view.findViewById(R.id.txtDone);
        mainActivity = (MainActivity) getActivity();
        setHeader();
        txtDone.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            mainActivity.replaceFragmenr(EndTripFragment.getInstance(), EndTripFragment.TAG);

        });
    }

    @Override
    public void init() {

    }


    private void setHeader() {
        mainActivity = (MainActivity) getActivity();
        mainActivity.imgBack.setVisibility(View.GONE);
        mainActivity.imgMenu.setVisibility(View.VISIBLE);
        mainActivity.txtTitle.setText("Start Trip");
        mainActivity.imgBack.setOnClickListener(v -> {
            mainActivity.onBackPressed();
        });
    }


}
