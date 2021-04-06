package com.api.core.excepitonhandling;

import lombok.Data;

@Data
public class ServiceBusinessException extends RuntimeException {
    private String errorMessage;

    public ServiceBusinessException(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
