package com.iwant.api.model;

import com.iwant.api.component.LocaleMessageService;

public class ApiResponseError {
    public static ApiResponseError INTERNAL_ERROR = new ApiResponseError(101, LocaleMessageService.INTERNAL_ERROR);
    public static ApiResponseError INVALID_WANT_ID = new ApiResponseError(102, LocaleMessageService.INVALID_WANT_ID);
    public static ApiResponseError UNKNOWN_USER = new ApiResponseError(103, LocaleMessageService.UNKNOWN_USER);
    public static ApiResponseError INVALID_USER_ID = new ApiResponseError(104, LocaleMessageService.INVALID_USER_ID);
    public static ApiResponseError INVALID_USER_NAME = new ApiResponseError(105, LocaleMessageService.INVALID_USER_NAME);
    public static ApiResponseError INVALID_USER_EMAIL = new ApiResponseError(106, LocaleMessageService.INVALID_USER_EMAIL);
    private int code;
    private String message;

    public ApiResponseError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}