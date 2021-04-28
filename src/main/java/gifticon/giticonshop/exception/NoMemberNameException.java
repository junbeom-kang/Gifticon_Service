package gifticon.giticonshop.exception;

public class NoMemberNameException extends RuntimeException {
    public NoMemberNameException() {
        super();
    }

    public NoMemberNameException(String message) {
        super(message);
    }

    public NoMemberNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoMemberNameException(Throwable cause) {
        super(cause);
    }

    protected NoMemberNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
