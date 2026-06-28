package com.shahd.immigration_system.Exception;
import org.springframework.http.HttpStatus;

public class ImmigrationException extends RuntimeException {

    private final HttpStatus status;

    public ImmigrationException(String message) {
        super(message);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public ImmigrationException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public static ImmigrationException notFound(String message) {
        return new ImmigrationException(HttpStatus.NOT_FOUND, message);
    }

    public static ImmigrationException badRequest(String message) {
        return new ImmigrationException(HttpStatus.BAD_REQUEST, message);
    }

    public HttpStatus getStatus() {
        return status;
    }
}
