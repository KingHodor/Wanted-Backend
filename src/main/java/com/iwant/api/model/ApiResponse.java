package com.iwant.api.model;

public class ApiResponse<T> {
    final ApiResponseError error;
    final T result;
    final String status;
    final static String OK_STATUS = "OK";
    final static String ERROR_STATUS = "ERROR";

    public ApiResponse(T result) {
        this(null, result, OK_STATUS);
    }

    public ApiResponse(ApiResponseError error, T result, String status) {
        this.error = error;
        this.result = result;
        this.status = status;
    }

    public static ApiResponse error(int errorCode, String errorMessage) {
        return new ApiResponse<>(new ApiResponseError(errorCode, errorMessage), null, ERROR_STATUS);
    }

    public ApiResponseError getError() {
        return error;
    }

    public T getResult() {
        return result;
    }
    
}
