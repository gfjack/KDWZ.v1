package com.company.management_system.exception;

import com.company.management_system.config.StringResources;
import com.company.management_system.constants.ErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class OrderException extends ResponseStatusException {

    public OrderException(ErrorType errorType) {
        super(errorType.getStatus(), errorType.getMessage());
    }

    public OrderException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }

}
