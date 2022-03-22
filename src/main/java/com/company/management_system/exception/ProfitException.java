package com.company.management_system.exception;

import com.company.management_system.config.StringResources;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ProfitException extends ResponseStatusException {

    public ProfitException(String message) {
        super(HttpStatus.BAD_REQUEST, getMessage(message));
    }

    public static String getMessage(String message) {
        return String.format(StringResources.getString("EXCEPTION.REASON"), message);
    }

}
