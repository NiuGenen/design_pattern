package tree;

import java.util.LinkedList;
import java.util.Queue;

import list.Iterator;

public class CharrTreePreIterator implements Iterator{

	private CharrTree tree;
	private CharrTree.CharrTreeNode current;
	private Queue<CharrTree.CharrTreeNode> nodes;
	private Queue<CharrTree.CharrTreeNode> nodes_cur;
	public CharrTreePreIterator(CharrTree tree){
		this.tree = tree;
		current = tree.getRoot();
		nodes = new LinkedList<CharrTree.CharrTreeNode>();
		nodes_cur = new LinkedList<CharrTree.CharrTreeNode>();		
	}
	
	public boolean hasNext() {
		return current != null;
	}

	public Object next() {
		CharrTree.CharrTreeNode ret = current;
		while(!nodes_cur.isEmpty()){
			nodes.add( nodes_cur.poll() );
		}
		
		if(current.left != null){
			nodes_cur.add( current.left );
		}
		if(current.right != null){
			nodes_cur.add( current.right );
		}
		
		while(!nodes.isEmpty()){
			nodes_cur.add( nodes.poll() );
		}
		current = nodes_cur.poll();
		return ret.my;
	}

}
