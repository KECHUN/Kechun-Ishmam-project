package dfs;

public class Tree {
	
	private int root;
	private int[] parent;
	private int[] searchOrder;
	
	public Tree(int root,int[] parent, int[]searchOrder ) {
		this.root = root;
		this.parent = parent;
		this.searchOrder = searchOrder;
	}

	public int getRoot() {
		return root;
	}

	public void setRoot(int root) {
		this.root = root;
	}

	public int[] getParent() {
		return parent;
	}

	public void setParent(int[] parent) {
		this.parent = parent;
	}

	public int[] getSearchOrder() {
		return searchOrder;
	}

	public void setSearchOrder(int [] searchOrder) {
		this.searchOrder = searchOrder;
	}
	
  
}
