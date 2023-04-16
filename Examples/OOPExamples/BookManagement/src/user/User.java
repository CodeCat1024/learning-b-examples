package user;

import book.BookList;
import operations.IOPeration;

abstract public class User {
    protected String name;
    protected IOPeration[] ioPerations;

    public User(String name) {
        this.name = name;
    }

    public abstract int menu();

    public void doWork(int choice, BookList bookList) {
        this.ioPerations[choice].work(bookList);
    }
}
