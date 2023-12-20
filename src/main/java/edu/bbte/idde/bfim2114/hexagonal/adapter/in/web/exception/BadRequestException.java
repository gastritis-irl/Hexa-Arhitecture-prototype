package edu.bbte.idde.bfim2114.hexagonal.adapter.in.web.exception;

import lombok.experimental.StandardException;

@StandardException
public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
