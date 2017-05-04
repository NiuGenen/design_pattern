package tree;

import java.util.LinkedList;
import java.util.Queue;

import list.Iterator;

public class CharrTreePostIterator implements Iterator{

	private CharrTree tree;
	private CharrTree.CharrTreeNode current;
	private Queue<Charr> values;
	public CharrTreePostIterator(CharrTree tree){
		this.tree = tree;
		current = tree.getRoot();
		values = new LinkedList<>();
		post_trace(current);
	}
	
	private void post_trace(CharrTree.CharrTreeNode node){
		if(node.left != null) post_trace(node.left);
		if(node.right != null) post_trace(node.right);
		values.add(node.my);
	}
	
	public boolean hasNext() {
		return !values.isEmpty();
	}

	public Object next() {
		return values.poll();
	}
}
