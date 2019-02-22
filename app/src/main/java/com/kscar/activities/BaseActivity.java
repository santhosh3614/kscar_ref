package com.kscar.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import com.kscar.R;


/**
 * Created by SONI on 10/19/2018.
 */

public abstract class BaseActivity extends AppCompatActivity {


    public abstract void initComponents();

    public void replaceFragmenr(Fragment fragment, String tag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_cantainer, fragment);
        transaction.addToBackStack(tag);
        transaction.commit();
    }


    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right); //slide_in_right
    }


}
