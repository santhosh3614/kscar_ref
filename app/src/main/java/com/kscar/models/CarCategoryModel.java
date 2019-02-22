package com.kscar.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CarCategoryModel {
    @SerializedName("responseCode")
    @Expose
    private Integer responseCode;
    @SerializedName("responseMessage")
    @Expose
    private String responseMessage;
    @SerializedName("responseData")
    @Expose
    private List<ResponseDatum> responseData = null;

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public List<ResponseDatum> getResponseData() {
        return responseData;
    }

    public void setResponseData(List<ResponseDatum> responseData) {
        this.responseData = responseData;
    }

    public static class ResponseDatum {

        @SerializedName("iCarCetegoryId")
        @Expose
        private Integer iCarCetegoryId;
        @SerializedName("vCar")
        @Expose
        private String vCar;
        @SerializedName("vCarImage")
        @Expose
        private String vCarImage;

        public Integer getICarCetegoryId() {
            return iCarCetegoryId;
        }

        public void setICarCetegoryId(Integer iCarCetegoryId) {
            this.iCarCetegoryId = iCarCetegoryId;
        }

        public String getVCar() {
            return vCar;
        }

        public void setVCar(String vCar) {
            this.vCar = vCar;
        }

        public String getVCarImage() {
            return vCarImage;
        }

        public void setVCarImage(String vCarImage) {
            this.vCarImage = vCarImage;
        }

    }

}
