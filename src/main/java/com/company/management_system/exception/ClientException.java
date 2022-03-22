package com.company.management_system.exception;

import com.company.management_system.constants.ErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


public class ClientException extends ResponseStatusException {

    public ClientException(ErrorType errorType) {
        super(errorType.getStatus(), errorType.getMessage());
    }

    public ClientException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }

}
