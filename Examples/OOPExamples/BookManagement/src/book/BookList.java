package book;

public class BookList {

    private static final int DEFAULT_SIZE = 10;
    private Book[] books = new Book[DEFAULT_SIZE];
    private int usedSize; // 记录当前books数组里面有多少本树

    // 原生的set方法不满足我们的需求
    public void setBooks(int pos, Book book) {
        books[pos] = book;
    }

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }
}
