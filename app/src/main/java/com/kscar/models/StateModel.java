package com.kscar.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by SONI on 12/23/2018.
 */

public class StateModel {
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
        @SerializedName("iStatesId")
        @Expose
        private String iStatesId;
        @SerializedName("vStateName")
        @Expose
        private String vStateName;

        public String getIStatesId() {
            return iStatesId;
        }

        public void setIStatesId(String iStatesId) {
            this.iStatesId = iStatesId;
        }

        public String getVStateName() {
            return vStateName;
        }

        public void setVStateName(String vStateName) {
            this.vStateName = vStateName;
        }

    }
}
