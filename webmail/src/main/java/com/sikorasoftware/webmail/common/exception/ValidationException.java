package com.sikorasoftware.webmail.common.exception;

/**
 * Created by robertsikora on 06.01.2016.
 */
public class ValidationException extends RuntimeException {

    public ValidationException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
