package operations;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class Borrow implements IOPeration{
    @Override
    public void work(BookList bookList) {
        System.out.println("借阅图书！");
        System.out.println("输入你要借阅的图书");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
             Book book = bookList.getBook(i);
             if (book.getName().equals(name) &&
                 !book.isBorrowed()) {
                 book.setBorrowed(true);
                 System.out.println("借阅成功！");
                 return;
             }
        }
    }
}
