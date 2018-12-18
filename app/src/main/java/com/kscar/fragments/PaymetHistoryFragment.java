package com.kscar.fragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kscar.R;
import com.kscar.activities.MainActivity;
import com.kscar.prefrences.SessionManager;

import dmax.dialog.SpotsDialog;

/**
 * Created by SONI on 12/15/2018.
 */

public class PaymetHistoryFragment extends BaseFragment {

    public static PaymetHistoryFragment getInstance() {
        PaymetHistoryFragment paymetHistoryFragment = new PaymetHistoryFragment();
        return paymetHistoryFragment;
    }
    public static String TAG = PaymetHistoryFragment.class.getSimpleName();
    private MainActivity mainActivity;
    private SessionManager sessionManager;
    private AlertDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_payment_history, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() {
        mainActivity = (MainActivity) getActivity();
        sessionManager = new SessionManager(mainActivity);
        progressDialog = new SpotsDialog(getContext(), R.style.Custom);
        getPayment();
      }

    private void getPayment() {
        progressDialog.show();

    }

}
