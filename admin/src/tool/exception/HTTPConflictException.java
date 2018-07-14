package tool.exception;

public class HTTPConflictException extends HTTPException {
    public HTTPConflictException() {
        super("Conflict - Already Exist");
    }
}