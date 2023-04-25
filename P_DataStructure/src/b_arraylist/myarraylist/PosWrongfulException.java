package b_arraylist.myarraylist;

public class PosWrongfulException extends RuntimeException{
    public PosWrongfulException() {

    }
    public PosWrongfulException(String message) {
        super(message);
    }
}