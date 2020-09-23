package by.sazanchuk.geometricConstructor.service.exception;

public class NotValidEntity extends Exception{
    public NotValidEntity(String message) {
        super(message);
    }

    public NotValidEntity(Throwable cause) {
        super(cause);
    }
}
