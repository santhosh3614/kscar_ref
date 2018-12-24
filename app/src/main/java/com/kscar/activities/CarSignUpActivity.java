package com.kscar.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.kscar.R;
import com.kscar.models.CarCategoryModel;
import com.kscar.models.CityListModel;
import com.kscar.models.SignUpModel;
import com.kscar.models.StateModel;
import com.kscar.prefrences.SessionManager;
import com.kscar.retrofit.WsFactory;
import com.kscar.retrofit.WsResponse;
import com.kscar.retrofit.WsUtils;
import com.kscar.utils.PermisionUtils;
import com.kscar.utils.PoupUtils;
import com.kscar.utils.StaticUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import dmax.dialog.SpotsDialog;
import retrofit2.Call;

/**
 * Created by SONI on 11/29/2018.
 */

public class CarSignUpActivity extends BaseActivity implements WsResponse {

    private static final int REQUEST_CAMERA = 1001;
    private static final int SELECT_FILE = 1002;
    private ImageView imgProfile;
    private TextView txtSubmit;
    private String selectedValue;
    private String filePath = "";
    private AlertDialog progressDialog;
    private SessionManager sessionManager;
    private TextView txtSelectCarId, txtUpload;
    private EditText edtCarNo, edtCarModel, edtMobile, edtCity, edtAddress, edtLicenceNo;
    private String carId = "1";
    private ArrayList<String> docImages = new ArrayList<>();
    private ImageView img1, img2, img3;
    private int id;
    private TextView txtFileName;
    private TextView txtState, txtCity;
    private String stateId = "0";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_car);
        try {
            initComponents();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getCarCategory() {
        progressDialog.show();
        Call sateList = WsFactory.getCarCategory();
        WsUtils.getReponse(sateList, StaticUtils.REQUEST_CAR_CATEGORY, this);
    }

    private void getStateList() {
        progressDialog.show();
        Map<String, String> map = new HashMap<>();
        map.put("iStatesId", stateId);
        Call cityListModel = WsFactory.getCityState(map);
        WsUtils.getReponse(cityListModel, StaticUtils.REQUEST_STATE_LIST, this);
    }

    private void getCityList() {
        progressDialog.show();
        Call loginWsCall = WsFactory.getCarCategory();
        WsUtils.getReponse(loginWsCall, StaticUtils.REQUEST_STATE_CITY, this);
    }


    @Override
    public void initComponents() {
        txtSubmit = findViewById(R.id.txtSubmit);
        imgProfile = findViewById(R.id.imgProfile);
        progressDialog = new SpotsDialog(this, R.style.Custom);
        sessionManager = new SessionManager(this);
        edtCarNo = findViewById(R.id.edtCarNo);
        edtCarModel = findViewById(R.id.edtCarModel);
        edtMobile = findViewById(R.id.edtMobile);
        edtAddress = findViewById(R.id.edtAddress);
        txtSelectCarId = findViewById(R.id.txtSelectCarId);
        edtLicenceNo = findViewById(R.id.edtLicenceNo);
        txtUpload = findViewById(R.id.txtUpload);
        txtFileName = findViewById(R.id.txtFileName);
        txtState = findViewById(R.id.txtState);
        txtCity = findViewById(R.id.txtCity);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);

        txtState.setOnClickListener(v -> {
            getStateList();
        });
        txtCity.setOnClickListener(v -> {
            getCityList();
        });

        img1.setOnClickListener(v -> {
            id = img1.getId();
            PoupUtils.showCameraAndGallery(this, "Choose option",
                    camera -> {
                        selectedValue = camera.getTag().toString();
                        boolean result = PermisionUtils.checkPermission(this);
                        if (result)
                            cameraIntent();
                    },
                    gallary -> {
                        selectedValue = gallary.getTag().toString();
                        boolean result = PermisionUtils.checkPermission(this);
                        if (result)
                            galleryIntent();
                    });
        });

        img2.setOnClickListener(v -> {
            id = img2.getId();
            PoupUtils.showCameraAndGallery(this, "Choose option",
                    camera -> {
                        selectedValue = camera.getTag().toString();
                        boolean result = PermisionUtils.checkPermission(this);
                        if (result)
                            cameraIntent();
                    },
                    gallary -> {
                        selectedValue = gallary.getTag().toString();
                        boolean result = PermisionUtils.checkPermission(this);
                        if (result)
                            galleryIntent();
                    });
        });

        img3.setOnClickListener(v -> {
            id = img3.getId();
            PoupUtils.showCameraAndGallery(this, "Choose option",
                    camera -> {
                        selectedValue = camera.getTag().toString();
                        boolean result = PermisionUtils.checkPermission(this);
                        if (result)
                            cameraIntent();
                    },
                    gallary -> {
                        selectedValue = gallary.getTag().toString();
                        boolean result = PermisionUtils.checkPermission(this);
                        if (result)
                            galleryIntent();
                    });

        });

        txtUpload.setOnClickListener(v -> {
            id = txtUpload.getId();
            PoupUtils.showCameraAndGallery(this, "Choose option",
                    camera -> {
                        selectedValue = camera.getTag().toString();
                        boolean result = PermisionUtils.checkPermission(this);
                        if (result)
                            cameraIntent();
                    },
                    gallary -> {
                        selectedValue = gallary.getTag().toString();
                        boolean result = PermisionUtils.checkPermission(this);
                        if (result)
                            galleryIntent();
                    });
        });

        imgProfile.setOnClickListener(v -> {
            PoupUtils.showCameraAndGallery(this, "Choose option",
                    camera -> {
                        selectedValue = camera.getTag().toString();
                        boolean result = PermisionUtils.checkPermission(this);
                        if (result)
                            cameraIntent();
                    },
                    gallary -> {
                        selectedValue = gallary.getTag().toString();
                        galleryIntent();
                    });
        });

        txtSelectCarId.setOnClickListener(v -> {
            getCarCategory();
        });

        txtSubmit.setOnClickListener(v -> {
            String carNo = edtCarNo.getText().toString().trim();
            String mobile = edtMobile.getText().toString().trim();
            String city = "sd";
            String carModel = edtCarModel.getText().toString().trim();
            String address = edtAddress.getText().toString().trim();
            String licenceNo = edtLicenceNo.getText().toString().trim();

       /*     if (TextUtils.isEmpty(carId)) {
                PoupUtils.showAlertDailog(this, "Select Car Type");
            } else if (TextUtils.isEmpty(carNo)) {
                PoupUtils.showAlertDailog(this, "Enter car no");
            } else if (TextUtils.isEmpty(mobile)) {
                PoupUtils.showAlertDailog(this, "Enter mobile no");
            } else if (TextUtils.isEmpty(city)) {
                PoupUtils.showAlertDailog(this, "Enter city");
            } else if (TextUtils.isEmpty(carModel)) {
                PoupUtils.showAlertDailog(this, "Enter car model");
            } else if (TextUtils.isEmpty(address)) {
                PoupUtils.showAlertDailog(this, "Enter Address");
            } else if (TextUtils.isEmpty(licenceNo)) {
                PoupUtils.showAlertDailog(this, "Enter Licence no");
            } else if (docImages.size() < 1) {
                PoupUtils.showAlertDailog(this, "Selcect One Image");
            } else {
                progressDialog.show();
                File file = new File(filePath);
                RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), file);
                MultipartBody.Part body = MultipartBody.Part.createFormData("vLicenceImage", file.getName(), reqFile);
                RequestBody iCarCetegoryId = RequestBody.create(MediaType.parse("text/plain"), carId);
                RequestBody vCarNumber = RequestBody.create(MediaType.parse("text/plain"), carNo);
                RequestBody iCarModel = RequestBody.create(MediaType.parse("text/plain"), carModel);
                RequestBody vLicenceNumber = RequestBody.create(MediaType.parse("text/plain"), licenceNo);
                RequestBody iDriverContactNo = RequestBody.create(MediaType.parse("text/plain"), mobile);
                RequestBody txDriverAddress = RequestBody.create(MediaType.parse("text/plain"), address);
                RequestBody vCity = RequestBody.create(MediaType.parse("text/plain"), city);
                //Uplaod multiple image here:---
                MultipartBody.Part[] surveyImagesParts = new MultipartBody.Part[docImages.size()];
                for (int index = 0; index < docImages.size(); index++) {
                    File fileArray = new File(docImages.get(index));
                    RequestBody docBody = RequestBody.create(MediaType.parse("image/*"), file);
                    surveyImagesParts[index] = MultipartBody.Part.createFormData("vDocumentImage", fileArray.getName(), docBody);
                }
                Map<String, RequestBody> map = new HashMap<>();
                map.put("iCarCetegoryId", iCarCetegoryId);
                map.put("vCarNumber", vCarNumber);
                map.put("iCarModel", iCarModel);
                map.put("vLicenceNumber", vLicenceNumber);
                map.put("iDriverContactNo", iDriverContactNo);
                map.put("txDriverAddress", txDriverAddress);
                map.put("vCity", vCity);
                Call loginWsCall = WsFactory.signUp(surveyImagesParts, body, map);
                WsUtils.getReponse(loginWsCall, StaticUtils.REQUEST_SIGN_UP, this);
            }*/
            Intent intent = new Intent(CarSignUpActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });
    }


    private void cameraIntent() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    private void galleryIntent() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"), SELECT_FILE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case PermisionUtils.MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (selectedValue.equals("Take Photo"))
                        cameraIntent();
                    else if (selectedValue.equals("Choose from Library"))
                        galleryIntent();
                } else {
                    //code for deny
                }
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE)
                onSelectFromGalleryResult(data);
            else if (requestCode == REQUEST_CAMERA)
                onCaptureImageResult(data);
        }
    }

    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {
        Uri picUri = data.getData();
        filePath = StaticUtils.getPath(getApplicationContext(), picUri);
        if (id == R.id.img1) {
            img1.setImageURI(picUri);
            docImages.add(filePath);
        } else if (id == R.id.img2) {
            img2.setImageURI(picUri);
            docImages.add(filePath);
        } else if (id == R.id.img3) {
            img3.setImageURI(picUri);
            docImages.add(filePath);
        } else if (id == R.id.txtUpload) {
            String filename = filePath.substring(filePath.lastIndexOf("/") + 1);
            txtFileName.setText(filename);
        }
    }

    private void onCaptureImageResult(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        Uri tempUri = StaticUtils.getImageUriFromCameraBitmap(getApplicationContext(), thumbnail);
        filePath = StaticUtils.getPath(getApplicationContext(), tempUri);
        Log.e("Camera image", "" + filePath);
        if (id == R.id.img1) {
            img1.setImageBitmap(thumbnail);
            docImages.add(filePath);
        } else if (id == R.id.img2) {
            img2.setImageBitmap(thumbnail);
            docImages.add(filePath);
        } else if (id == R.id.img3) {
            img2.setImageBitmap(thumbnail);
            docImages.add(filePath);
        } else if (id == R.id.txtUpload) {
            String filename = filePath.substring(filePath.lastIndexOf("/") + 1);
            txtFileName.setText(filename);
        }
    }

    @Override
    public void successResponse(Object response, int code) {
        progressDialog.cancel();
        switch (code) {
            case StaticUtils.REQUEST_SIGN_UP:
                SignUpModel signUpModel = (SignUpModel) response;
                sessionManager.setUserId(signUpModel.getResponseData().getIDriverId() + "");
                PoupUtils.showAlertDailog(this, signUpModel.getResponseMessage());
                break;
            case StaticUtils.REQUEST_CAR_CATEGORY:
                CarCategoryModel categoryModel = (CarCategoryModel) response;
                PoupUtils.showCarCategory(this, "Select your car category", categoryModel.getResponseData(), (v, pos) -> {
                    CarCategoryModel.ResponseDatum responseDatum = categoryModel.getResponseData().get(pos);
                    txtSelectCarId.setText(responseDatum.getVCar());
                    carId = responseDatum.getICarCetegoryId() + "";
                });
                break;
            case StaticUtils.REQUEST_STATE_LIST:
                StateModel stateModel = (StateModel) response;
                if (stateModel != null) {
                    PoupUtils.showState(CarSignUpActivity.this, "Select State", stateModel.getResponseData(), (view, pos) -> {
                        StateModel.ResponseDatum responseDatum = stateModel.getResponseData().get(pos);
                        stateId = responseDatum.getIStatesId();
                        txtState.setText(responseDatum.getVStateName());
                    });
                }
                break;
            case StaticUtils.REQUEST_STATE_CITY:
                CityListModel cityListModel = (CityListModel) response;
                if (cityListModel != null) {
                    PoupUtils.showCity(CarSignUpActivity.this, "Select City", cityListModel.getResponseData(), (view, pos) -> {
                        CityListModel.ResponseDatum responseDatum = cityListModel.getResponseData().get(pos);
                        txtCity.setText(responseDatum.getVCityName());
                    });
                }
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



