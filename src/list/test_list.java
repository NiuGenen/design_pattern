package list;

import static org.junit.Assert.*;

import org.junit.*;

public class test_list {

	private BookShelfArray bookShelfArray = null;
	private BookShelfLinkedList bookShelfLinkedList = null;

	private String[] books = {
			"Around the World in 80 Days",
			"Bible",
			"Cinderella",
			"Daddy-Long-Legs"};

	@Before
	public void setup(){
		bookShelfArray = new BookShelfArray(4);
        bookShelfArray.appendBook(new Book( books[0] ));
        bookShelfArray.appendBook(new Book( books[1] ));
        bookShelfArray.appendBook(new Book( books[2] ));
        bookShelfArray.appendBook(new Book( books[3] ));
        
        bookShelfLinkedList = new BookShelfLinkedList();
        bookShelfLinkedList.appendBook(new Book( books[0] ));
        bookShelfLinkedList.appendBook(new Book( books[1] ));
        bookShelfLinkedList.appendBook(new Book( books[2] ));
        bookShelfLinkedList.appendBook(new Book( books[3] ));
	}
	
	@Test
	public void test_Array(){
		Iterator it = bookShelfArray.iterator();
		int i = 0;
        while (it.hasNext()) {
            Book book = (Book)it.next();
            System.out.println("[array]:" + book.getName());
            assertEquals(books[i++], book.getName());
        }
	}
	
	@Test
	public void test_linkedList(){
		Iterator it = bookShelfArray.iterator();
		int i = 0;
        while (it.hasNext()) {
            Book book = (Book)it.next();
            System.out.println("[linkedlist]" + book.getName());
            assertEquals(books[i++], book.getName());
        }
	}
}
