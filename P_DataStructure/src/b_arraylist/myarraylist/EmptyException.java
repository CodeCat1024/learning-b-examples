package b_arraylist.myarraylist;

public class EmptyException extends RuntimeException{
    public EmptyException() {
    }

    public EmptyException(String message) {
        super(message);
    }
}