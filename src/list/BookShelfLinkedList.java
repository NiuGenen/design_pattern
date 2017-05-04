package list;

public class BookShelfLinkedList  implements Aggregate {
	private BookLinkedNode books_head;
    private int length = 0;
    public BookShelfLinkedList() {
    	books_head = null;
    	length = 0;
    }
    public BookLinkedNode getHead(){
    	return books_head;
    }
    public void appendBook(Book book) {
    	if(books_head == null){
    		books_head = new BookLinkedNode();
    		books_head.book = book;
    		books_head.next = null;
    	}
    	else{
    		BookLinkedNode next = books_head;
    		books_head = new BookLinkedNode();
    		books_head.book = book;
    		books_head.next = next;
    	}
    	++length;
    }
    public int getLength() {
        return length;
    }
    public Iterator iterator() {
        return new BookShelfLinkedListIterator(this);
    }
    
    class BookLinkedNode{
    	public Book book;
    	public BookLinkedNode next;
    	public BookLinkedNode(){
    		book = null;
    		next = null;
    	}
    }
}
