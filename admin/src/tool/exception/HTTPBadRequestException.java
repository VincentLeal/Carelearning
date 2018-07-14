package tool.exception;

public class HTTPBadRequestException extends HTTPException {
    public HTTPBadRequestException() {
        super("Erreur cote client");
    }
}