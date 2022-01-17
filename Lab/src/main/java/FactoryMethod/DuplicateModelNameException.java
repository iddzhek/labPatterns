package FactoryMethod;

public class DuplicateModelNameException  extends Exception{
    public DuplicateModelNameException() {
    }

    public DuplicateModelNameException(String message) {
        super(message);
    }

    public DuplicateModelNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateModelNameException(Throwable cause) {
        super(cause);
    }

    public DuplicateModelNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
