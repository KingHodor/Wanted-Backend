package com.iwant.api.controller;

import com.iwant.api.model.ApiResponse;
import com.iwant.api.model.SubmitRequest;
import com.iwant.api.model.UserRequest;
import com.iwant.api.model.WantersRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WantController {

    private static final String AUTH_HEADER_NAME = "X-AUTH-USERID";

    @Autowired
    WantService wantService;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse> register(HttpServletRequest request, @RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(wantService.register(userRequest), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/wanters", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse> getWanters(HttpServletRequest request, @RequestBody WantersRequest wantersRequest) {
        final String userId = request.getHeader(AUTH_HEADER_NAME);
        return new ResponseEntity<>(wantService.getWanters(userId, wantersRequest), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse> submit(HttpServletRequest request, @RequestBody SubmitRequest submitRequest) {
        final String userIp = request.getRemoteAddr();
        final String userAgent = request.getHeader("User-Agent");
        final String userId = request.getHeader(AUTH_HEADER_NAME);
        submitRequest.setUserId(userId);
        submitRequest.setUserIp(userIp);
        submitRequest.setUserAgent(userAgent);
        return new ResponseEntity<>(wantService.submit(submitRequest), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/deactive", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse> deactive(HttpServletRequest request, @RequestBody long id) {
        final String userId = request.getHeader(AUTH_HEADER_NAME);
        return new ResponseEntity<>(wantService.deactive(userId, id), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> ping(HttpServletRequest request) {
        return new ResponseEntity<>(new ApiResponse("success"), HttpStatus.OK);
    }
}
