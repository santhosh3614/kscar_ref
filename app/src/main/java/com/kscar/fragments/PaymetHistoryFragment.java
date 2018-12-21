package com.kscar.fragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kscar.R;
import com.kscar.activities.MainActivity;
import com.kscar.adapter.PaymentHistoryAdapter;
import com.kscar.prefrences.SessionManager;

import java.util.ArrayList;

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
    private RecyclerView rvPaymentHistory;
    private ArrayList<String> payments = new ArrayList<>();
    private TextView txtTitle;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_payment_history, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtTitle = view.findViewById(R.id.txtTitle);
        rvPaymentHistory = view.findViewById(R.id.rvPaymentHistory);
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
        rvPaymentHistory.setLayoutManager(new LinearLayoutManager(mainActivity));
        progressDialog = new SpotsDialog(getContext(), R.style.Custom);
        setHeader();
        getPayment();
    }


    private void setHeader() {
        mainActivity = (MainActivity) getActivity();
        mainActivity.imgBack.setVisibility(View.VISIBLE);
        mainActivity.imgMenu.setVisibility(View.GONE);
        mainActivity.txtTitle.setText("Payment History");
    }

    private void getPayment() {
//        progressDialog.show();
        for (int i = 0; i < 8; i++) {
            payments.add("name");
        }
        PaymentHistoryAdapter paymentHistoryAdapter = new PaymentHistoryAdapter(mainActivity, payments, (v, pos) -> {
            Bundle bundle = new Bundle();
            mainActivity.replaceFragmenr(MyProfileFragment.getInstance(bundle), MyProfileFragment.TAG);
        });
        rvPaymentHistory.setAdapter(paymentHistoryAdapter);
    }
}
