package com.codegroup.desafio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class ExclusionNotAllowedException extends Exception{

    private static final long serialVersionUID = 1L;

    public ExclusionNotAllowedException(String message){
        super(message);
    }
}