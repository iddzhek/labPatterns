package FactoryMethod;

import java.util.NoSuchElementException;

public class NoSuchModelNameException extends Exception {
    public NoSuchModelNameException() {
    }

    public NoSuchModelNameException(String message) {
        super(message);
    }

    public NoSuchModelNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchModelNameException(Throwable cause) {
        super(cause);
    }

    public NoSuchModelNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
