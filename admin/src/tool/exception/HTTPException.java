package tool.exception;

public class HTTPException extends RuntimeException {
    public HTTPException(String message) {
        super(message);
    }
}