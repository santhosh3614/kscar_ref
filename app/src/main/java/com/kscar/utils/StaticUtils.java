package com.kscar.utils;

import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.kscar.R;

import java.io.ByteArrayOutputStream;


public class StaticUtils {

    // global topic to receive app wide push notifications
    public static final String TOPIC_GLOBAL = "global";

    // broadcast receiver intent filters
    public static final String REGISTRATION_COMPLETE = "registrationComplete";
    public static final String PUSH_NOTIFICATION = "pushNotification";
    // id to handle the notification in the notification tray
    public static final int NOTIFICATION_ID = 100;
    public static final int NOTIFICATION_ID_BIG_IMAGE = 101;
    public static final String SHARED_PREF = "ah_firebase";
    public static final int REQUEST_FOR_MOVIE_RESPONSE = 5001;
    public static final int REQUEST_FOR_AUOTOCOMPLETE_ADDRESS = 5002;
    public static final int REQUEST_SIGN_UP = 5003;
    public static final int REQUEST_OTP_SEND_PASSWORD = 5004;
    public static final int REQUEST_UPLOAD = 5005;
    public static final int REQUEST_CAR_CATEGORY = 5006;
    public static final int REQUEST_ONLINE_OFFLINE = 5007;
    public static final int REQUEST_PROFILE = 5008;
    public static final int REQUEST_STATE_LIST = 5007;
    public static final int REQUEST_STATE_CITY = 5008;

    public static void showSnakBar(Context context, ViewGroup viewGroup, String message) {
        Snackbar mSnackBar = Snackbar.make(viewGroup, message, Snackbar.LENGTH_LONG);
        View view = mSnackBar.getView();
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view.getLayoutParams();
        params.gravity = Gravity.TOP;
        view.setLayoutParams(params);
        view.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
        TextView mainTextView = (TextView) (view).findViewById(android.support.design.R.id.snackbar_text);
        mainTextView.setTextColor(Color.WHITE);
        mSnackBar.show();
    }

    public static boolean checkMailValidation(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return email.matches(emailPattern);
    }


    public static Uri getImageUriFromCameraBitmap(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 10, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }


    public static String getPath(Context context, Uri contentUri) {
        String[] proj = {MediaStore.Images.Media.DATA};
        CursorLoader loader = new CursorLoader(context, contentUri, proj, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(column_index);
        cursor.close();
        return result;
    }




    /*public GeoPoint getLocationFromAddress(Context context, String strAddress){

        Geocoder coder = new Geocoder(context);
        List<Address> address;
        GeoPoint p1 = null;

        try {
            address = coder.getFromLocationName(strAddress,5);
            if (address==null) {
                return null;
            }
            Address location=address.get(0);
            location.getLatitude();
            location.getLongitude();

            p1 = new GeoPoint((double) (location.getLatitude() * 1E6),
                    (double) (location.getLongitude() * 1E6));

            return p1;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/

}
