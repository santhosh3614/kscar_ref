package com.kscar.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by SONI on 12/6/2018.
 */

public class SignUpModel {

    @SerializedName("responseCode")
    @Expose
    private Integer responseCode;
    @SerializedName("responseMessage")
    @Expose
    private String responseMessage;
    @SerializedName("responseData")
    @Expose
    private ResponseData responseData;

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

    public ResponseData getResponseData() {
        return responseData;
    }

    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }

    public static class ResponseData {

        @SerializedName("vDriverName")
        @Expose
        private String vDriverName;
        @SerializedName("iCarCetegoryId")
        @Expose
        private String iCarCetegoryId;
        @SerializedName("vCarNumber")
        @Expose
        private String vCarNumber;
        @SerializedName("iCarModel")
        @Expose
        private String iCarModel;
        @SerializedName("vLicenceNumber")
        @Expose
        private String vLicenceNumber;
        @SerializedName("iDriverContactNo")
        @Expose
        private String iDriverContactNo;
        @SerializedName("iDriverAlterContactNo")
        @Expose
        private String iDriverAlterContactNo;
        @SerializedName("vDriverExp")
        @Expose
        private String vDriverExp;
        @SerializedName("vDriverEmail")
        @Expose
        private String vDriverEmail;
        @SerializedName("txDriverAddress")
        @Expose
        private String txDriverAddress;
        @SerializedName("vCity")
        @Expose
        private String vCity;
        @SerializedName("dtCreatedAt")
        @Expose
        private String dtCreatedAt;
        @SerializedName("tiStatus")
        @Expose
        private Integer tiStatus;
        @SerializedName("iDriverId")
        @Expose
        private Integer iDriverId;
        @SerializedName("vLicenceImage")
        @Expose
        private String vLicenceImage;
        @SerializedName("vDriverImage")
        @Expose
        private String vDriverImage;


        public String getvDriverImage() {
            return vDriverImage;
        }

        public void setvDriverImage(String vDriverImage) {
            this.vDriverImage = vDriverImage;
        }

        public String getVDriverName() {
            return vDriverName;
        }

        public void setVDriverName(String vDriverName) {
            this.vDriverName = vDriverName;
        }

        public String getICarCetegoryId() {
            return iCarCetegoryId;
        }

        public void setICarCetegoryId(String iCarCetegoryId) {
            this.iCarCetegoryId = iCarCetegoryId;
        }

        public String getVCarNumber() {
            return vCarNumber;
        }

        public void setVCarNumber(String vCarNumber) {
            this.vCarNumber = vCarNumber;
        }

        public String getICarModel() {
            return iCarModel;
        }

        public void setICarModel(String iCarModel) {
            this.iCarModel = iCarModel;
        }

        public String getVLicenceNumber() {
            return vLicenceNumber;
        }

        public void setVLicenceNumber(String vLicenceNumber) {
            this.vLicenceNumber = vLicenceNumber;
        }

        public String getIDriverContactNo() {
            return iDriverContactNo;
        }

        public void setIDriverContactNo(String iDriverContactNo) {
            this.iDriverContactNo = iDriverContactNo;
        }

        public String getIDriverAlterContactNo() {
            return iDriverAlterContactNo;
        }

        public void setIDriverAlterContactNo(String iDriverAlterContactNo) {
            this.iDriverAlterContactNo = iDriverAlterContactNo;
        }

        public String getVDriverExp() {
            return vDriverExp;
        }

        public void setVDriverExp(String vDriverExp) {
            this.vDriverExp = vDriverExp;
        }

        public String getVDriverEmail() {
            return vDriverEmail;
        }

        public void setVDriverEmail(String vDriverEmail) {
            this.vDriverEmail = vDriverEmail;
        }

        public String getTxDriverAddress() {
            return txDriverAddress;
        }

        public void setTxDriverAddress(String txDriverAddress) {
            this.txDriverAddress = txDriverAddress;
        }

        public String getVCity() {
            return vCity;
        }

        public void setVCity(String vCity) {
            this.vCity = vCity;
        }

        public String getDtCreatedAt() {
            return dtCreatedAt;
        }

        public void setDtCreatedAt(String dtCreatedAt) {
            this.dtCreatedAt = dtCreatedAt;
        }

        public Integer getTiStatus() {
            return tiStatus;
        }

        public void setTiStatus(Integer tiStatus) {
            this.tiStatus = tiStatus;
        }

        public Integer getIDriverId() {
            return iDriverId;
        }

        public void setIDriverId(Integer iDriverId) {
            this.iDriverId = iDriverId;
        }

        public String getVLicenceImage() {
            return vLicenceImage;
        }

        public void setVLicenceImage(String vLicenceImage) {
            this.vLicenceImage = vLicenceImage;
        }

    }


}
