package operations;

import book.BookList;

/**
 * 因为所有的操作都是操作图书的，所以可以直接
 */

public interface IOPeration {
    void work(BookList bookList);
}
