
package com.example.demo.exception;

public class UserIdException extends RuntimeException {

    public UserIdException() {
        super();
    }

    public UserIdException(String message) {
        super(message);
    }
}
