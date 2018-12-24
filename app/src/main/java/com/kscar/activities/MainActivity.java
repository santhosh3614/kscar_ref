package com.kscar.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kscar.R;
import com.kscar.fragments.MyProfileFragment;
import com.kscar.fragments.OnlieOffLineFragment;
import com.kscar.fragments.OtpValdateFragment;
import com.kscar.fragments.PaymetHistoryFragment;

public class MainActivity extends BaseActivity {

    private LinearLayout llProfie;
    private DrawerLayout drawer;
    public ImageView imgMenu, imgNotification, imgBack;
    public TextView txtTitle, txtTrip;

    private TextView txtPaymentHistoy, txtSupport, txtTermAndCond, txtRegisterCar, txtLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            initComponents();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initComponents() {
        llProfie = findViewById(R.id.llProfie);
        drawer = findViewById(R.id.drawer_layout);
        imgMenu = findViewById(R.id.imgMenu);
        imgNotification = findViewById(R.id.imgNotification);
        imgBack = findViewById(R.id.imgBack);
        imgNotification = findViewById(R.id.imgNotification);
        txtPaymentHistoy = findViewById(R.id.txtPaymentHistoy);
        txtSupport = findViewById(R.id.txtSupport);
        txtTermAndCond = findViewById(R.id.txtTermAndCond);
        txtLogOut = findViewById(R.id.txtLogOut);
        txtTitle = findViewById(R.id.txtTitle);
        txtTrip = findViewById(R.id.txtTrip);

        imgMenu.setOnClickListener(v -> {
            drawer.openDrawer(Gravity.START);
        });
        llProfie.setOnClickListener(v -> {
            closeNavigation();
          /*  Bundle bundle = new Bundle();
            replaceFragmenr(OnlieOffLineFragment.getInstance(bundle), OnlieOffLineFragment.TAG);*/
        });

        txtTrip.setOnClickListener(v -> {
            closeNavigation();
            replaceFragmenr(OtpValdateFragment.getInstance(), OtpValdateFragment.TAG);
        });

        try {
            defaultCall();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void defaultCall() {
        txtPaymentHistoy.setOnClickListener(v -> {
            closeNavigation();
            replaceFragmenr(PaymetHistoryFragment.getInstance(), PaymetHistoryFragment.TAG);
        });
        txtSupport.setOnClickListener(v -> {
        });
        txtTermAndCond.setOnClickListener(v -> {
        });

        txtLogOut.setOnClickListener(v -> {
            closeNavigation();
        });
        Bundle bundle = new Bundle();
        replaceFragmenr(MyProfileFragment.getInstance(bundle), MyProfileFragment.TAG);
    }


    @Override
    public void onBackPressed() {
        closeNavigation();
        FragmentManager fragmentManager = getSupportFragmentManager();
        int count = fragmentManager.getBackStackEntryCount();
        String fragmentTag = fragmentManager.getBackStackEntryAt(count - 1).getName();
        if (fragmentTag.equalsIgnoreCase(MyProfileFragment.TAG)) {
            super.onBackPressed();
        } else {
            fragmentManager.popBackStackImmediate();
        }
    }

    private void closeNavigation() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }

}
