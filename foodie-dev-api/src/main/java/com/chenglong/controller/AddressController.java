package com.chenglong.controller;


import com.chenglong.pojo.UserAddress;
import com.chenglong.pojo.bo.AddressBO;
import com.chenglong.service.AddressService;
import com.chenglong.util.CHENGLONGJSONResult;
import com.chenglong.util.MobileEmailUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: 程龙
 * @Date: 2020-10-25 10:56
 */

@Api(value = "地址相关", tags = {"地址相关的api接口"})
@RequestMapping("address")
@RestController
public class AddressController {
    /**
     * 用户在确认订单页面，可以针对的收获地址做如下操作：
     * 1，查询用户所有收获地址列表
     * 2，新增收获地址
     * 3，删除收获地址
     * 4，修改收获地址
     * 5，设置默认地址
     */

    @Autowired
    private AddressService addressService;

    @ApiOperation(value = "根据用户id查询收获地址列表", notes = "根据用户id查询收获地址列表", httpMethod = "POST")
    @PostMapping("/list")
    public CHENGLONGJSONResult list(@RequestParam String userId) {
        if (StringUtils.isBlank(userId)) {
            return CHENGLONGJSONResult.errorMsg("");
        }

        List<UserAddress> list = addressService.queryAll(userId);
        return CHENGLONGJSONResult.ok(list);
    }

    @ApiOperation(value = "用户新增收获地址", notes = "新增用户收获地址", httpMethod = "POST")
    @PostMapping("/add")
    public CHENGLONGJSONResult add(@RequestBody AddressBO addressBO) {
        CHENGLONGJSONResult checkRes = checkAddress(addressBO);
        if (checkRes.getStatus() != 200) {
            return checkRes;
        }
        addressService.addNewUserAddress(addressBO);
        return CHENGLONGJSONResult.ok();
    }

    @ApiOperation(value = "用户修改收获地址", notes = "用户修改收获地址", httpMethod = "POST")
    @PostMapping("/update")
    public CHENGLONGJSONResult update(@RequestBody AddressBO addressBO) {
        if (StringUtils.isBlank(addressBO.getAddressId())) {
            return CHENGLONGJSONResult.errorMsg("修改地址错误：addressId不能为空");
        }
        CHENGLONGJSONResult checkRes = checkAddress(addressBO);
        if (checkRes.getStatus() != 200) {
            return checkRes;
        }
        addressService.updateUserAddress(addressBO);
        return CHENGLONGJSONResult.ok();
    }

    @ApiOperation(value = "用户删除收获地址", notes = "用户删除收获地址", httpMethod = "POST")
    @PostMapping("/delete")
    public CHENGLONGJSONResult delete(@RequestParam String userId, @RequestParam String addressId) {
        if (StringUtils.isBlank(userId) || StringUtils.isBlank(addressId)) {
            return CHENGLONGJSONResult.errorMsg("");
        }

        addressService.deleteUserAddress(userId, addressId);
        return CHENGLONGJSONResult.ok();
    }


    @ApiOperation(value = "用户设置默认收获地址", notes = "用户设置默认收获地址", httpMethod = "POST")
    @PostMapping("/setDefalut")
    public CHENGLONGJSONResult setDefault(@RequestParam String userId, @RequestParam String addressId) {
        if (StringUtils.isBlank(userId) || StringUtils.isBlank(addressId)) {
            return CHENGLONGJSONResult.errorMsg("");
        }

        addressService.updateUserAddressToBeDefault(userId, addressId);
        return CHENGLONGJSONResult.ok();
    }

    private CHENGLONGJSONResult checkAddress(AddressBO addressBO) {
        String receiver = addressBO.getReceiver();
        if (StringUtils.isBlank(receiver)) {
            return CHENGLONGJSONResult.errorMsg("收货人不能为空");
        }

        if (receiver.length() > 12) {
            return CHENGLONGJSONResult.errorMsg("收货人姓名不能太长");
        }

        String mobile = addressBO.getMobile();
        if (StringUtils.isBlank(mobile)) {
            return CHENGLONGJSONResult.errorMsg("收货人手机号不能为空");
        }

        if (mobile.length() != 11) {
            return CHENGLONGJSONResult.errorMsg("收货人手机号长度不正确");
        }

        boolean isMobileOK = MobileEmailUtils.checkMobileIsOk(mobile);

        if (!isMobileOK) {
            return CHENGLONGJSONResult.errorMsg("收货人手机号格式不正确");

        }

        String province = addressBO.getProvince();
        String city = addressBO.getCity();
        String district = addressBO.getDistrict();
        String detail = addressBO.getDetail();

        if (StringUtils.isBlank(province) || StringUtils.isBlank(district) || StringUtils.isBlank(city) || StringUtils.isBlank(detail)) {
            return CHENGLONGJSONResult.errorMsg("收获地址信息不能为空");
        }
        return CHENGLONGJSONResult.ok();

    }
}
