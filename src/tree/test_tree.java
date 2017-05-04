package tree;

import static org.junit.Assert.*;

import org.junit.*;

import list.Iterator;

public class test_tree {
	
	CharrTree tree;

	@Before
	public void setup(){
		tree = new CharrTree();
		tree.build_as_exp_require();
	}

	@Test
	public void test_pre(){
		char[] pre_result = {'a','b','d','e','f','g','c'};
		
		Iterator it = tree.preIterator();
		int i = 0;
        while (it.hasNext()) {
        	Charr ch = (Charr)it.next();
            System.out.println("[pre]:" + ch.getChar() );
            assertEquals(pre_result[i++], ch.getChar());
        }
	}
	
	@Test
	public void test_mid(){
		char[] mid_result = {'d','e','b','g','f','a','c'};
		
		Iterator it = tree.midIterator();
		int i = 0;
        while (it.hasNext()) {
        	Charr ch = (Charr)it.next();
            System.out.println("[mid]:" + ch.getChar() );
            assertEquals(mid_result[i++], ch.getChar());
        }
	}
	
	@Test
	public void test_post(){
		char[] post_result = {'e','d','g','f','b','c','a'};
		
		Iterator it = tree.postIterator();
		int i = 0;
        while (it.hasNext()) {
        	Charr ch = (Charr)it.next();
            System.out.println("[post]:" + ch.getChar() );
            assertEquals(post_result[i++], ch.getChar());
        }
	}
}
