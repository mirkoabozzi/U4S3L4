package mirkoabozzi.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String id) {
        super("Id " + id + " non trovato");
    }
}
