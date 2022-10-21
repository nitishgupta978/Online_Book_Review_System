package com.edureka.spring.obrs.error.exceptions;
//Kishlay Kishan

import com.edureka.spring.obrs.common.utils.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class AlreadyExistsException extends RuntimeException{
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    private final String CLASS_NAME = this.getClass().getName();

    private String errorMessage;

    public AlreadyExistsException() {
    }

    public AlreadyExistsException(String errorMessage) {
        LogUtil.logError(LOG,CLASS_NAME,"AlreadyExistsException","errorMessage = " + errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
