package com.edureka.spring.obrs.error.exceptions;
//Kishlay Kishan

import com.edureka.spring.obrs.common.utils.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends DefaultRuntimeException{
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    private final String CLASS_NAME = this.getClass().getName();

    public NotFoundException() {
    }

    public NotFoundException(Map<String, String> parameters){
        super(parameters);
        LogUtil.logDebug(LOG,CLASS_NAME,"NotFoundException","parameters = " + parameters);
    }

    public NotFoundException(String errorMessages){
        super(errorMessages);
    }
}
