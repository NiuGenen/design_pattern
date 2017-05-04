package list;

public class BookShelfLinkedListIterator  implements Iterator {
	private BookShelfLinkedList bookShelf;
	private BookShelfLinkedList.BookLinkedNode current;
    public BookShelfLinkedListIterator(BookShelfLinkedList bookShelf) {
        this.bookShelf = bookShelf;
        current = bookShelf.getHead();
    }
    public boolean hasNext() {
    	return current!=null;
    }
    public Object next() {
    	BookShelfLinkedList.BookLinkedNode ret = current;
    	if(current != null) current = current.next;
    	return ret;
    }
}
