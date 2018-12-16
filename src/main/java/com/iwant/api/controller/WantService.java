package com.iwant.api.controller;

import com.iwant.api.component.LocaleMessageService;
import com.iwant.api.model.*;
import com.iwant.api.dao.WantUserDao;
import com.iwant.api.dao.WantActivityDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class WantService {

    private static final Log logger = LogFactory.getLog(WantService.class);

    @Autowired
    WantUserDao wantUserDao;
    @Autowired
    WantActivityDao wantActivityDao;
    @Autowired
    LocaleMessageService localeMessageService;
    @Autowired
    SpecificationService specificationService;

    @PostConstruct
    public void init() {
        logger.info("Want Service has been initialized. ");
    }

    public ApiResponse submit(SubmitRequest submitRequest) {
        String userId = submitRequest.getUserId();
        Integer category = submitRequest.getCategory();
        String phone = submitRequest.getPhone();
        String email = submitRequest.getEmail();
        BigDecimal price = submitRequest.getPrice();
        String description = submitRequest.getDescription();
        String latitude = submitRequest.getLatitude();
        String longitude = submitRequest.getLongitude();
        String city = submitRequest.getCity();
        String country = submitRequest.getCountry();
        if (userId == null) {
            return error(ApiResponseError.UNKNOWN_USER);
        }
        WantActivity wantActivity = new WantActivity();
        wantActivity.setUserIp(submitRequest.getUserIp());
        wantActivity.setUserAgent(submitRequest.getUserAgent());
        wantActivity.setAddTime(System.currentTimeMillis());
        wantActivity.setUserId(userId);
        wantActivity.setCategory(category);
        wantActivity.setPhone(phone);
        wantActivity.setEmail(email);
        wantActivity.setPrice(price);
        wantActivity.setDescription(description);
        wantActivity.setLatitude(latitude);
        wantActivity.setLongitude(longitude);
        wantActivity.setCity(city);
        wantActivity.setCountry(country);
        wantActivity.setActive(1);   // One means deactive want
        wantActivityDao.save(wantActivity);
        return new ApiResponse(Boolean.TRUE.toString());
    }

    public ApiResponse getWanters(String userId, WantersRequest wantersRequest) {
        List<WantActivity> wantList = new ArrayList();
        if (userId == null) {
            return error(ApiResponseError.UNKNOWN_USER);
        }
        int pageNum = wantersRequest.getPageNum();
        int pageCount = wantersRequest.getPerPageCount();
        Sort.Direction direction = Sort.Direction.DESC;
        String sort = "addTime";
        Pageable pageable = new PageRequest(pageNum, pageCount, direction, sort);
        String country = wantersRequest.getCountry();
        List<Integer> categoryList = wantersRequest.getCategories();
        Specifications spec = Specifications.where(specificationService.isEqual("country", country));
        return new ApiResponse(wantList);
    }

    public ApiResponse register(UserRequest userRequest) {
        String userId = userRequest.getUserId();
        String userName = userRequest.getName();
        String userEmail = userRequest.getEmail();
        if (userId == null) {
            return error(ApiResponseError.INVALID_USER_ID);
        }
        if (userEmail == null) {
            return error(ApiResponseError.INVALID_USER_EMAIL);
        }
        if (userName == null) {
            return error(ApiResponseError.INVALID_USER_NAME);
        }
        WantUser user = new WantUser();
        user.setUserId(userId);
        user.setEmail(userEmail);
        user.setName(userName);
        wantUserDao.save(user);
        return new ApiResponse(Boolean.TRUE.toString());
    }

    public ApiResponse deactive(String userId, long id) {
        if (userId == null) {
            return error(ApiResponseError.INVALID_USER_ID);
        }
        WantActivity wantActivity = wantActivityDao.findOne(id);
        if (wantActivity == null) {
            return error(ApiResponseError.INVALID_WANT_ID);
        }
        if (userId != wantActivity.getUserId()) {
            return error(ApiResponseError.INVALID_USER_ID);
        }
        wantActivity.setActive(0); // Zero means deactive want
        wantActivityDao.save(wantActivity);
        return new ApiResponse(Boolean.TRUE.toString());
    }

    public ApiResponse error(ApiResponseError error, String... args) {
        return ApiResponse.error(error.getCode(), localeMessageService.getMessage(error.getMessage(), args));
    }
}