package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import list.Iterator;

public class CharrTreeMidIterator implements Iterator{

	private CharrTree tree;
	private CharrTree.CharrTreeNode root;
	private Queue<Charr> values;
	Stack<CharrTree.CharrTreeNode> stack;
	
	public CharrTreeMidIterator(CharrTree tree){
		this.tree = tree;
		root = tree.getRoot();
		values = new LinkedList<>();
		//mid_trace(current);
		//mid_trace_loop(current);
		stack = new Stack<>();
		if(root != null){
			if(root.right != null)	stack.push(root.right);	root.right = null;
			stack.push( root );
			if(root.left!=null) 	stack.push(root.left);	root.left = null;
		}
	}
	
	public boolean hasNext() {
		//return !values.isEmpty();
		return !stack.isEmpty();
	}

	public Object next() {
		//return values.poll();
		if(hasNext()){
			CharrTree.CharrTreeNode node = stack.pop();
			while(!(node.left == null && node.right == null)){
				if(node.right != null)	stack.push(node.right);	node.right = null;
				stack.push( node );
				if(node.left!=null) 	stack.push(node.left);	node.left = null;
				
				node = stack.pop();
			}
			return node.my;
		}
		return null;
	}
	
	@SuppressWarnings("unused")
	private void mid_trace_loop(CharrTree.CharrTreeNode root){
		Stack<CharrTree.CharrTreeNode> stack = new Stack<>();
		CharrTree.CharrTreeNode node = root;

		if(root.right != null)	stack.push(root.right);	root.right = null;
		stack.push( root );
		if(root.left!=null) 	stack.push(root.left);	root.left = null;
		
		while(!stack.isEmpty()){
			node = stack.pop();
			if(node.left == null && node.right == null){
				values.add( node.my );
			}
			else{
				if(node.right != null)	stack.push(node.right);	node.right = null;
				stack.push( node );
				if(node.left!=null) 	stack.push(node.left);	node.left = null;
			}
		}
		
	}
	
	@SuppressWarnings("unused")
	private void mid_trace(CharrTree.CharrTreeNode node){
		if(node.left != null) mid_trace(node.left);
		values.add(node.my);
		if(node.right != null) mid_trace(node.right);
	}
}
