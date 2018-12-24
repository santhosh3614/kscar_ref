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
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

/**
 * Created by SONI on 9/29/2018.
 */

public interface ApiInterface {

   /* @GET("movie/top_rated")
    Call<MoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);

    @FormUrlEncoded
    @POST("user/edit")
    Call<User> updateUser(@Field("first_name") String first, @Field("last_name") String last);


    @FormUrlEncoded
    @POST("LoginNew.php/")
    Call<Login> Login(@FieldMap Map<String, String> fields);


    @Headers("Content-type: application/json")
    @POST("GetJSONResponse.php/")
    Call<JsonObject> postRawJSON(@Body JsonObject locationPost);

    @Multipart
    @POST("user/photo")
    Call<User> updateUser(@Part("photo") RequestBody photo, @Part("description") RequestBody description);

    @Multipart
    @POST("uploadNew.php")
    Call<UploadImage> postImage(@Part MultipartBody.Part image, @PartMap Map<String, RequestBody> map);

    @GET("ShowXml.php")
    Call<ROOT> getXmlData();*/

    //The
   /* @Multipart
    @POST("uploadNew.php")
    Call<ResponseBody> postImage(@Part MultipartBody.Part image, @PartMap Map<String, RequestBody> map);*/
    /*
     */

    //This is for definiation
    /*@Multipart
    @POST(WebServices.UPLOAD_SURVEY)
    Call<UploadSurveyResponseModel> uploadSurvey(@Part MultipartBody.Part[] surveyImage, @Part MultipartBody.Part propertyImage, @Part("DRA") RequestBody dra)
    */

    /*
private void requestUploadSurvey() {

   File propertyImageFile = new File(surveyModel.getPropertyImagePath());
    RequestBody propertyImage = RequestBody.create(MediaType.parse("image/*"), propertyImageFile);
    MultipartBody.Part propertyImagePart = MultipartBody.Part.createFormData("PropertyImage", propertyImageFile.getName(), propertyImage);

    MultipartBody.Part[] surveyImagesParts = new MultipartBody.Part[surveyModel.getPicturesList().size()];

    for (int index = 0; index < surveyModel.getPicturesList().size(); index++) {
        Log.d(TAG, "requestUploadSurvey: survey image " + index + "  " + surveyModel.getPicturesList().get(index).getImagePath());
        File file = new File(surveyModel.getPicturesList().get(index).getImagePath());
        RequestBody surveyBody = RequestBody.create(MediaType.parse("image/*"), file);
        surveyImagesParts[index] = MultipartBody.Part.createFormData("SurveyImage", file.getName(), surveyBody);
    }

    final WebServicesAPI webServicesAPI = RetrofitManager.getInstance().getRetrofit().create(WebServicesAPI.class);
    Call<UploadSurveyResponseModel> surveyResponse = null;
    if (surveyImagesParts != null) {
        surveyResponse = webServicesAPI.uploadSurvey(surveyImagesParts, propertyImagePart, draBody);
    }
    surveyResponse.enqueue(this);
 }
    */

    @Multipart
    @POST("oauth/driversignup")
    Call<SignUpModel> signUp(@Part MultipartBody.Part image, @PartMap Map<String, RequestBody> map);

    @Multipart
    @POST("oauth/driversignup")
    Call<SignUpModel> carSignUp(@Part MultipartBody.Part[] documentImage, @Part MultipartBody.Part image, @PartMap Map<String, RequestBody> map);

    @GET("site/getcarcategory")
    Call<CarCategoryModel> getCarCategory();

    @FormUrlEncoded
    @POST("oauth/driveronlineoffline")
    Call<OnlineOffline> onlineOffline(@FieldMap Map<String, String> fields);

    @FormUrlEncoded
    @POST("oauth/getdriverdetail")
    Call<SignUpModel> getProfile(@FieldMap Map<String, String> fields);

    @GET("oauth/getstatelist")
    Call<StateModel> stateList();

    @FormUrlEncoded
    @POST("oauth/getcitylist")
    Call<CityListModel> cityList(@FieldMap Map<String, String> fields);

}
