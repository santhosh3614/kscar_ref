package com.kscar.prefrences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.kscar.KsCarApp;
import com.kscar.activities.CarSignUpActivity;
import java.util.HashMap;


public class SessionManager {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Context context;
    private int PRIVATE_MODE = 0;
    private static final String PREF_NAME = KsCarApp.class.getName();
    private static final String IS_LOGIN = "IsLoggedIn";
    private static final String KEY_TOKEN = "token";
    private static final String KEY_SEARCH = "search";
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";
    private static final String KEY_USER_ID = "userId";
    private static final String KEY_USER_ORDER_NAME = "order_name";
    private static final String KEY_ORDER_ADDRESS = "delevry_address";
    private static final String KEY_ORDER_CON_NO = "delevry_address";
    private static final String KEY_MODEL_ID = "model_id";
    private static final String KEY_IS_ADDRESS = "is_address";
    private static final String KEY_PROFILE = "profile";
    private static final String KEY_PRIVACY = "privacy";
    private static final String KEY_REWARD_POINT = "reward_point";
    private static final String KEY_REFRAL_CODE = "refral_code";
    private static final String KEY_HELP = "help";
    private static final String KEY_RETURN = "return";
    private static final String KEY_CONTACT_US = "contact";
    private static final String KEY_MOBILE_NO = "mobile";
    private static final String KEY_DELIVERY_POLICY = "delivey_policy";
    private static final String KEY_PAYMENT_POLICY = "payment_policy";
    private static final String KEY_CART_ITEM = "cartItem";
    private static final String KEY_ONLINE_OFFLINE = "online_offline";
    private static final String KYE_TOKEN = "token";


    // Constructor
    public SessionManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setIsAddress() {
        editor.putBoolean(KEY_IS_ADDRESS, true);
        editor.commit();
    }

    public boolean getIsAddress() {
        return pref.getBoolean(KEY_IS_ADDRESS, false);
    }

    public void setNotificationToken(String token) {
        editor.putString(KYE_TOKEN, token);
        editor.commit();
    }

    public String getNotificationToken() {
        return pref.getString(KYE_TOKEN, "");
    }

    public void setOnlineOfline(String onlineOfline) {
        editor.putString(KEY_ONLINE_OFFLINE, onlineOfline);
        editor.commit();
    }

    public String getOnlineOfline() {
        return pref.getString(KEY_ONLINE_OFFLINE, "");
    }


    public void setUserId(String userId) {
        editor.putString(KEY_USER_ID, userId);
        editor.commit();
    }

    public String getUserId() {
        return pref.getString(KEY_USER_ID, "-1");
    }


    public void setCartCount(String cartItem) {
        editor.putString(KEY_CART_ITEM, cartItem);
        editor.commit();
    }

    public String getCartCount() {
        return pref.getString(KEY_CART_ITEM, "-1");
    }


    public void setRewardPoint(String setPoint) {
        editor.putString(KEY_REWARD_POINT, setPoint);
        editor.commit();
    }

    public String getRewardPoint() {
        return pref.getString(KEY_REWARD_POINT, "");
    }


    public void setPrivacyPolicy(String userId) {
        editor.putString(KEY_PRIVACY, userId);
        editor.commit();
    }

    public String getPrivacyPolicy() {
        return pref.getString(KEY_PRIVACY, "");
    }

    public void setReturnPolicy(String help) {
        editor.putString(KEY_RETURN, help);
        editor.commit();
    }

    public String getReturnPolicy() {
        return pref.getString(KEY_RETURN, "");
    }

    public void setDeliveryPolicy(String help) {
        editor.putString(KEY_DELIVERY_POLICY, help);
        editor.commit();
    }

    public String getDeliveryPolicy() {
        return pref.getString(KEY_DELIVERY_POLICY, "");
    }


    public void setPaymentPolicy(String help) {
        editor.putString(KEY_PAYMENT_POLICY, help);
        editor.commit();
    }

    public String getPaymentPolicy() {
        return pref.getString(KEY_PAYMENT_POLICY, "");
    }

    public void setContactUs(String help) {
        editor.putString(KEY_CONTACT_US, help);
        editor.commit();
    }


    public String getContactUs() {
        return pref.getString(KEY_CONTACT_US, "");
    }


    public void setHelp(String help) {
        editor.putString(KEY_HELP, help);
        editor.commit();
    }

    public String getHelp() {
        return pref.getString(KEY_HELP, "");
    }


    public void setUserName(String cusName) {
        editor.putString(KEY_USER_ORDER_NAME, cusName);
        editor.commit();
    }

    public String getUserName() {
        return pref.getString(KEY_USER_ORDER_NAME, "");
    }

    public void setProfile(String cusName) {
        editor.putString(KEY_PROFILE, cusName);
        editor.commit();
    }

    public String getProfile() {
        return pref.getString(KEY_PROFILE, "");
    }


    public void setOrderAddress(String orderAddress) {
        editor.putString(KEY_ORDER_ADDRESS, orderAddress);
        editor.commit();
    }

    public String getOrderAddress() {
        return pref.getString(KEY_ORDER_ADDRESS, "");
    }

    public void setOrderNo(String orderAddress) {
        editor.putString(KEY_ORDER_CON_NO, orderAddress);
        editor.commit();
    }

    public String getOrderNo() {
        return pref.getString(KEY_ORDER_CON_NO, "");
    }


    public void setToken(String token) {
        editor.putString(KEY_TOKEN, token);
        editor.commit();
    }

    public String getToken() {
        return pref.getString(KEY_TOKEN, "");
    }

    public void checkLogin() {
        if (!this.isLoggedIn()) {
            Intent i = new Intent(context, CarSignUpActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }

    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(KEY_NAME, pref.getString(KEY_NAME, null));
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));
        return user;
    }

    /**
     * Clear session details
     */
    public void logoutUser() {
        editor.clear();
        editor.commit();
    }

    public boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }

    public void setSearchValue(String token) {
        editor.putString(KEY_SEARCH, token);
        editor.commit();
    }

    public String getSearchValue() {
        return pref.getString(KEY_SEARCH, "");
    }

    public void setModelId(String modelId) {
        editor.putString(KEY_MODEL_ID, modelId);
        editor.commit();
    }

    public String getModelId() {
        return pref.getString(KEY_MODEL_ID, "");
    }


    public void setReferalCode(String referalCode) {
        editor.putString(KEY_REFRAL_CODE, referalCode);
        editor.commit();
    }

    public String getReferalCode() {
        return pref.getString(KEY_REFRAL_CODE, "");
    }

    public void setMoileNo(String moileNo) {
        editor.putString(KEY_MOBILE_NO, moileNo);
        editor.commit();
    }


    public String getMobileNo() {
        return pref.getString(KEY_MOBILE_NO, "");
    }
}
