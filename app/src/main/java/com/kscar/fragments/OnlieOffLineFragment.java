package com.kscar.fragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kscar.R;
import com.kscar.activities.MainActivity;
import com.kscar.models.OnlineOffline;
import com.kscar.prefrences.SessionManager;
import com.kscar.retrofit.WsFactory;
import com.kscar.retrofit.WsResponse;
import com.kscar.retrofit.WsUtils;
import com.kscar.utils.StaticUtils;

import java.util.HashMap;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;

public class OnlieOffLineFragment extends BaseFragment implements WsResponse {

    public static String TAG = OnlieOffLineFragment.class.getSimpleName();
    private ImageView imgOnnOffDuaty;
    private TextView txtSubmit;
    private int onlineOffline = 1;
    private SessionManager sessionManager;
    private AlertDialog progressDialog;
    private MainActivity mainActivity;

    public static OnlieOffLineFragment getInstance(Bundle bundle) {
        OnlieOffLineFragment myProfileFragment = new OnlieOffLineFragment();
        myProfileFragment.setArguments(bundle);
        return myProfileFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_online_offlie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imgOnnOffDuaty = view.findViewById(R.id.imgOnnOffDuaty);
        txtSubmit = view.findViewById(R.id.txtSubmit);
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
        progressDialog = new SpotsDialog(mainActivity, R.style.Custom);
        String onlineofline = sessionManager.getOnlineOfline();

        if (TextUtils.isEmpty(onlineofline)) {
            if (onlineofline.equalsIgnoreCase("1")) {
                imgOnnOffDuaty.setSelected(true);
            } else {
                imgOnnOffDuaty.setSelected(false);
            }
        }
        imgOnnOffDuaty.setOnClickListener(v -> {
            if (imgOnnOffDuaty.isSelected()) {
                imgOnnOffDuaty.setSelected(false);
                onlineOffline = 1;
            } else {
                imgOnnOffDuaty.setSelected(true);
                onlineOffline = 1;
            }
        });

        txtSubmit.setOnClickListener(v -> {
            progressDialog.show();
            HashMap<String, String> map = new HashMap<>();
            map.put("iDriverId", sessionManager.getUserId());
            map.put("tiOnlineStatus", onlineOffline + "");
            Call callOnlineOffline = WsFactory.onlineOffline(map);
            WsUtils.getReponse(callOnlineOffline, StaticUtils.REQUEST_ONLINE_OFFLINE, this);
        });
    }

    @Override
    public void successResponse(Object response, int code) {
        progressDialog.cancel();
        switch (code) {
            case StaticUtils.REQUEST_ONLINE_OFFLINE:
                OnlineOffline onlineOffline = (OnlineOffline) response;
                sessionManager.setOnlineOfline(onlineOffline + "");
                break;
            default:
                break;
        }
    }

    @Override
    public void failureRespons(Throwable error, int code) {
        progressDialog.cancel();
    }
}
