package com.chenglong.pojo.bo;

/**
 * @Author: 程龙
 * @Date: 2020-10-25 11:21
 * <p>
 * 用于新增或者修改地址的BO
 */


public class AddressBO {

    private String addressId;
    private String userId;
    private String receiver;
    private String mobile;
    private String province;
    private String city;
    private String district;
    private String detail;

    public String getAddressId() {
        return addressId;
    }

    public String getUserId() {
        return userId;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getMobile() {
        return mobile;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getDetail() {
        return detail;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
