package com.kscar.retrofit;

import com.kscar.models.CarCategoryModel;
import com.kscar.models.CityListModel;
import com.kscar.models.OnlineOffline;
import com.kscar.models.SignUpModel;
import com.kscar.models.StateModel;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;

/**
 * Created by SONI on 9/30/2018.
 */

public class WsFactory {

   /* public static Call loginWsCall(Map<String, String> map) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Login> loginCall = apiService.Login(map);
        return loginCall;
    }

    public static Call uplaodImage(MultipartBody.Part image, Map<String, RequestBody> map) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<UploadImage> loginCall = apiService.postImage(image, map);
        return loginCall;
    }


    public static Call rawJSONRequest(JsonObject jsonObject) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<JsonObject> loginCall = apiService.postRawJSON(jsonObject);
        return loginCall;
    }

    public static Call getXmlData() {
        ApiInterface apiService = ApiClient.getXmlRetrofit().create(ApiInterface.class);
        Call<ROOT> loginCall = apiService.getXmlData();
        return loginCall;

    }
*/

    public static Call signUp(MultipartBody.Part image, Map<String, RequestBody> map) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<SignUpModel> loginCall = apiService.signUp(image, map);
        return loginCall;
    }

    public static Call signUp(MultipartBody.Part[] images, MultipartBody.Part image, Map<String, RequestBody> map) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<SignUpModel> loginCall = apiService.carSignUp(images, image, map);
        return loginCall;
    }

    public static Call getCarCategory() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<CarCategoryModel> category = apiService.getCarCategory();
        return category;
    }

    public static Call onlineOffline(Map<String, String> map) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<OnlineOffline> onlineOfflineCall = apiService.onlineOffline(map);
        return onlineOfflineCall;
    }

    public static Call profile(Map<String, String> map) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<SignUpModel> onlineOfflineCall = apiService.getProfile(map);
        return onlineOfflineCall;
    }


    public static Call getSatate() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<StateModel> onlineOfflineCall = apiService.stateList();
        return onlineOfflineCall;
    }

    public static Call getCityState(Map<String, String> map) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<CityListModel> onlineOfflineCall = apiService.cityList(map);
        return onlineOfflineCall;
    }


}
