package tree;

import list.Iterator;

public class CharrTree implements TreeAggregate{
	private CharrTreeNode root;
	public CharrTreeNode getRoot(){
		return root;
	}
	
	class CharrTreeNode{
		public Charr my;
		public CharrTreeNode left;
		public CharrTreeNode right;
		public CharrTreeNode parent;
		public CharrTreeNode(){
			my = null;
			left = null;
			right = null;
			parent = null;
		}
	}
	
	public void build_as_exp_require(){
		Charr a = new Charr('a');
		Charr b = new Charr('b');
		Charr c = new Charr('c');
		Charr d = new Charr('d');
		Charr e = new Charr('e');
		Charr f = new Charr('f');
		Charr g = new Charr('g');

		CharrTreeNode node_a = new CharrTreeNode();
		CharrTreeNode node_b = new CharrTreeNode();
		CharrTreeNode node_c = new CharrTreeNode();
		CharrTreeNode node_d = new CharrTreeNode();
		CharrTreeNode node_e = new CharrTreeNode();
		CharrTreeNode node_f = new CharrTreeNode();
		CharrTreeNode node_g = new CharrTreeNode();

		node_a.my = a;
		node_b.my = b;
		node_c.my = c;
		node_d.my = d;
		node_e.my = e;
		node_f.my = f;
		node_g.my = g;
		
		node_a.left = node_b;	node_b.parent = node_a;
		node_a.right = node_c;	node_c.parent = node_a;
		node_b.left = node_d;	node_d.parent = node_b;
		node_b.right = node_f;	node_f.parent = node_b;
		node_d.right = node_e;	node_e.parent = node_d;
		node_f.left = node_g;	node_g.parent = node_f;
		
		root = node_a;
	}

	public void insert(Charr ch){}
	
	@Override
	public Iterator preIterator() {
		return new CharrTreePreIterator(this);
	}

	@Override
	public Iterator midIterator() {
		return new CharrTreeMidIterator(this);
	}

	@Override
	public Iterator postIterator() {
		return new CharrTreePostIterator(this);
	}
}
