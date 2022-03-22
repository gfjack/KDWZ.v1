package com.company.management_system.exception;

import com.company.management_system.config.StringResources;
import com.company.management_system.constants.ErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class SupplierException extends ResponseStatusException {

    public SupplierException(ErrorType errorType) {
        super(errorType.getStatus(), errorType.getMessage());
    }

    public SupplierException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }

    
}
