package operations;

import book.Book;
import book.BookList;

public class Display implements IOPeration{
    @Override
    public void work(BookList bookList) {
        System.out.println("打印所有图书");
        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            Book book = bookList.getBook(i);
            System.out.println(book);
        }
    }
}
