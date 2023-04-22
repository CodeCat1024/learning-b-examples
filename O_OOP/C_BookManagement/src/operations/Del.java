package operations;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class Del implements IOPeration{
    @Override
    public void work(BookList bookList) {
        System.out.println("删除图书！");
        System.out.println("请输入您要删除的图书名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        int currentSize = bookList.getUsedSize();
        int index = -1;

        // 查看要删除的图书是否存在
        for (int i = 0; i < currentSize; i++) {
            Book tmp = bookList.getBook(i);
            if(tmp.getName().equals(name)) {
                index = i;
                break;
            }
        }

        // 挪动数据
        for (int j = index; j < currentSize - 1; j++) {
            Book book = bookList.getBook(j + 1);
            bookList.setBook(j, book);
        }
        bookList.setUsedSize(currentSize - 1);

        // 因为删除的是对象，所以需要把最后一个设置为null
        bookList.setBook(currentSize - 1, null);

        System.out.println("删除成功！");
    }
}
