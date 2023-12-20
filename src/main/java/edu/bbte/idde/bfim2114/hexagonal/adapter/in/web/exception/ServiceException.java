package edu.bbte.idde.bfim2114.hexagonal.adapter.in.web.exception;

import lombok.experimental.StandardException;

import java.io.Serial;

@StandardException
public class ServiceException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
