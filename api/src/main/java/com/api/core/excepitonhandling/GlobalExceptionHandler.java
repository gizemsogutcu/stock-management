package com.api.core.excepitonhandling;

import com.api.model.response.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<APIResponse> handleAllExceptions(Exception ex) {
        APIResponse apiResponse = setAPIResponse(ex);

        return new ResponseEntity(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ServiceBusinessException.class)
    public final ResponseEntity<APIResponse> handleServiceBusinessException(ServiceBusinessException ex) {
        APIResponse apiResponse = setAPIResponse(ex);

        return new ResponseEntity(apiResponse, HttpStatus.OK);
    }

    private <T> APIResponse setAPIResponse(T ex) {
        APIResponse apiResponse = new APIResponse();

        apiResponse.setSuccess(false);

        if(ex instanceof ServiceBusinessException)
            apiResponse.setErrorMessage(((ServiceBusinessException) ex).getErrorMessage());
        else if(ex instanceof MethodArgumentNotValidException)
            apiResponse.setErrorMessage(((MethodArgumentNotValidException) ex).getBindingResult().getFieldError().getDefaultMessage());
        else
            apiResponse.setErrorMessage(((Exception) ex).getMessage());

        return apiResponse;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<APIResponse> handleRequestValidationException(MethodArgumentNotValidException ex) {
        APIResponse apiResponse = setAPIResponse(ex);

        return new ResponseEntity(apiResponse, HttpStatus.BAD_REQUEST);
    }
}
