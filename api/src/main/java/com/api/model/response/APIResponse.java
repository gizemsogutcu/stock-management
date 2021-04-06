package com.api.model.response;

import lombok.Data;

@Data
public class APIResponse<T> {
    private boolean success = true;
    private String errorMessage;
    private T body;

    public APIResponse() {}

    public APIResponse(T body) {
        this.body = body;
    }
}
