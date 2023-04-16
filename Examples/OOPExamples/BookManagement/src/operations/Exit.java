package operations;

import book.BookList;

public class Exit implements IOPeration {
    @Override
    public void work(BookList bookList) {
        System.out.println("退出系统！");
        System.exit(0);
    }
}
