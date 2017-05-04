package list;

public class BookShelfArrayIterator implements Iterator {
    private BookShelfArray bookShelf;
    private int index;
    public BookShelfArrayIterator(BookShelfArray bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }
    public boolean hasNext() {
        if (index < bookShelf.getLength()) {
            return true;
        } else {
            return false;
        }
    }
    public Object next() {
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}
