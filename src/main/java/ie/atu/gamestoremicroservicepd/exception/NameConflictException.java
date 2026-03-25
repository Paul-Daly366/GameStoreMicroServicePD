package ie.atu.gamestoremicroservicepd.exception;

public class NameConflictException extends RuntimeException {
    public NameConflictException(String message) {
        super(message);
    }
}
