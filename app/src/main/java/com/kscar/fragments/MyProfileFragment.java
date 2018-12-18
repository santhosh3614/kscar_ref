package com.kscar.fragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kscar.R;
import com.kscar.activities.MainActivity;
import com.kscar.models.SignUpModel;
import com.kscar.prefrences.SessionManager;
import com.kscar.retrofit.WsFactory;
import com.kscar.retrofit.WsResponse;
import com.kscar.retrofit.WsUtils;
import com.kscar.utils.StaticUtils;

import java.util.HashMap;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;

/**
 * Created by SONI on 12/14/2018.
 */

public class MyProfileFragment extends BaseFragment implements WsResponse {

    private ImageView imgProfile;
    private TextView txtName, txtDate;
    private SessionManager sessionManager;
    private AlertDialog progressDialog;
    private MainActivity mainActivity;

    public static MyProfileFragment getInstance() {
        MyProfileFragment myProfileFragment = new MyProfileFragment();
        return myProfileFragment;
    }

    public static String TAG = MyProfileFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_my_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imgProfile = view.findViewById(R.id.imgProfile);
        txtName = view.findViewById(R.id.txtName);
        txtDate = view.findViewById(R.id.txtDate);
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
        getProfile();
    }

    private void getProfile() {
        progressDialog.show();
        HashMap<String, String> map = new HashMap<>();
        map.put("iDriverId", sessionManager.getUserId());
        Call callOnlineOffline = WsFactory.profile(map);
        WsUtils.getReponse(callOnlineOffline, StaticUtils.REQUEST_PROFILE, this);
    }

    @Override
    public void successResponse(Object response, int code) {
        progressDialog.cancel();
        switch (code) {
            case StaticUtils.REQUEST_PROFILE:
                SignUpModel signUpModel = (SignUpModel) response;
                if (signUpModel != null) {
                    SignUpModel.ResponseData responseData = signUpModel.getResponseData();
                    Glide.with(mainActivity).load(responseData.getvDriverImage()).into(imgProfile);
                    txtName.setText(responseData.getVDriverName());
                    txtDate.setText(responseData.getDtCreatedAt());
                }
        }
    }

    @Override
    public void failureRespons(Throwable error, int code) {
        progressDialog.cancel();
    }


}
