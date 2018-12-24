package com.kscar.utils;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kscar.R;
import com.kscar.adapter.CarCategoryAdapter;
import com.kscar.adapter.CityAdapter;
import com.kscar.adapter.StateAdapter;
import com.kscar.listeners.RvClickListeners;
import com.kscar.models.CarCategoryModel;
import com.kscar.models.CityListModel;
import com.kscar.models.StateModel;

import java.util.Calendar;
import java.util.List;


public class PoupUtils {

    public static void showConfirmationDailog(Activity activity, String message, View.OnClickListener yesClick, View.OnClickListener noClick) {
        final Dialog dialog = new Dialog(activity, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(R.color.black_tran_60);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.layout_dialog);
        TextView txtYes = dialog.findViewById(R.id.txtYes);
        TextView txtNo = dialog.findViewById(R.id.txtNo);
        TextView txtTitle = dialog.findViewById(R.id.txtTitle);
        txtTitle.setText(message);
        txtYes.setOnClickListener(v -> {
            dialog.cancel();
            yesClick.onClick(txtYes);

        });
        txtNo.setOnClickListener(v -> {
            dialog.cancel();
            noClick.onClick(txtNo);
        });
        dialog.show();
    }

    public static void showCameraAndGallery(Activity activity, String message, View.OnClickListener cameraClick, View.OnClickListener galleryClick) {
        final Dialog dialog = new Dialog(activity, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(R.color.black_tran_60);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.layout_camera_galary_dialog);

        ImageView imgCamera = dialog.findViewById(R.id.imgCamera);
        ImageView imgGallary = dialog.findViewById(R.id.imgGallary);
        TextView txtTitle = dialog.findViewById(R.id.txtTitle);
        txtTitle.setText(message);

        imgCamera.setOnClickListener(v -> {
            imgCamera.setTag("Take Photo");
            dialog.cancel();
            cameraClick.onClick(imgCamera);
        });
        imgGallary.setOnClickListener(v -> {
            imgGallary.setTag("Choose from Library");
            dialog.cancel();
            galleryClick.onClick(imgGallary);
        });
        dialog.show();
    }

    public static void showCarCategory(Activity activity, String message,
                                       List<CarCategoryModel.ResponseDatum> responseData,
                                       RvClickListeners rvClickListeners) {

        final Dialog dialog = new Dialog(activity, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(R.color.black_tran_60);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.layout_category_car);
        RecyclerView rvCarList = dialog.findViewById(R.id.rvCarList);
        rvCarList.setLayoutManager(new LinearLayoutManager(activity));
        CarCategoryAdapter carCategoryAdapter = new CarCategoryAdapter(activity, responseData, (v, pos) -> {
            rvClickListeners.onItemclick(v, pos);
            dialog.cancel();
        });
        rvCarList.setAdapter(carCategoryAdapter);
        TextView txtTitle = dialog.findViewById(R.id.txtTitle);
        txtTitle.setText(message);
        dialog.show();
    }


    public static void showAlertDailog(Activity activity, String message) {

        final Dialog dialog = new Dialog(activity, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(R.color.black_tran_30);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.layout_alert_dailog);
        TextView txtOK = dialog.findViewById(R.id.txtOK);
        TextView txtTitle = dialog.findViewById(R.id.txtTitle);
        txtTitle.setText(message);

        txtOK.setOnClickListener(v -> {
            dialog.cancel();

        });

        dialog.show();
    }


    public static void showDatePicker(Context context) {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(context,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                    }
                }, mYear, mMonth, mDay);

        datePickerDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "cancel", (v, which) -> {
            Toast.makeText(context, "click on cancel", Toast.LENGTH_SHORT).show();
        });
        datePickerDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", (v, which) -> {
            showTimePicker(context);

        });
        datePickerDialog.show();
    }

    public static void showTimePicker(Context context) {
        final Calendar c = Calendar.getInstance();
        int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(context,
                (view, hourOfDay, minute) -> {
//                        txtTime.setText(hourOfDay + ":" + minute);
                }, mHour, mMinute, false);

        timePickerDialog.show();

        timePickerDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "cancel",
                (view, which) -> {

                });

        timePickerDialog.setButton(DialogInterface.BUTTON_POSITIVE, "cancel",
                (view, which) -> {

                });

    }

    public static void showState(Activity activity, String message,
                                 List<StateModel.ResponseDatum> responseData,
                                 RvClickListeners rvClickListeners) {
        final Dialog dialog = new Dialog(activity, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(R.color.black_tran_60);
        dialog.setContentView(R.layout.layout_state);
        RecyclerView rvState = dialog.findViewById(R.id.rvState);

        rvState.setLayoutManager(new LinearLayoutManager(activity));
        StateAdapter carCategoryAdapter = new StateAdapter(activity, responseData, (v, pos) -> {
            rvClickListeners.onItemclick(v, pos);
            dialog.cancel();
        });
        rvState.setAdapter(carCategoryAdapter);
        TextView txtTitle = dialog.findViewById(R.id.txtTitle);
        txtTitle.setText(message);
        dialog.show();
    }

    public static void showCity(Activity activity, String message,
                                List<CityListModel.ResponseDatum> responseData,
                                RvClickListeners rvClickListeners) {
        final Dialog dialog = new Dialog(activity, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(R.color.black_tran_60);
        dialog.setContentView(R.layout.layout_category_car);
        TextView txtCityNa = dialog.findViewById(R.id.txtCityNa);
        RecyclerView rvCarList = dialog.findViewById(R.id.rvCarList);
        rvCarList.setLayoutManager(new LinearLayoutManager(activity));
        TextView txtTitle = dialog.findViewById(R.id.txtTitle);
        txtTitle.setText(message);
        if (responseData.size() > 0) {
            txtCityNa.setVisibility(View.GONE);
            CityAdapter carCategoryAdapter = new CityAdapter(activity, responseData, (v, pos) -> {
                rvClickListeners.onItemclick(v, pos);
                dialog.cancel();
            });
            rvCarList.setAdapter(carCategoryAdapter);
        } else {
            txtCityNa.setVisibility(View.VISIBLE);
        }
        dialog.show();
    }


}



