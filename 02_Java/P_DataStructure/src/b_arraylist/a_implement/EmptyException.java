package b_arraylist.a_implement;

public class EmptyException extends RuntimeException{
    public EmptyException() {
    }

    public EmptyException(String message) {
        super(message);
    }
}