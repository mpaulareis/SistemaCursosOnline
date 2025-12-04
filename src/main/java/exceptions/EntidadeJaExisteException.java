package exceptions;

public class EntidadeJaExisteException extends RuntimeException {
    public EntidadeJaExisteException(String msg) {
        super(msg);
    }
}
