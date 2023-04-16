package book;

public class BookList {

    private static final int DEFAULT_SIZE = 10;
    private Book[] books = new Book[DEFAULT_SIZE];
    private int usedSize; // 记录当前books数组里面有多少本树

    public BookList() {
        books[0] = new Book("三国演义", "罗贯中", 89, "小说");
        books[1] = new Book("三国演义", "罗贯中", 89, "小说");
        this.usedSize = 2;
    }

    public Book getBook(int pos) {
        return this.books[pos];
    }

    public void setBook(Book book) {
        this.books[usedSize] = book;

    }

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
