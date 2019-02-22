package com.kscar.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by SONI on 12/23/2018.
 */

public class CityListModel {

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

        @SerializedName("iStateId")
        @Expose
        private String iStateId;
        @SerializedName("iCityId")
        @Expose
        private String iCityId;
        @SerializedName("vCityName")
        @Expose
        private String vCityName;

        public String getIStateId() {
            return iStateId;
        }

        public void setIStateId(String iStateId) {
            this.iStateId = iStateId;
        }

        public String getICityId() {
            return iCityId;
        }

        public void setICityId(String iCityId) {
            this.iCityId = iCityId;
        }

        public String getVCityName() {
            return vCityName;
        }

        public void setVCityName(String vCityName) {
            this.vCityName = vCityName;
        }

    }


}
