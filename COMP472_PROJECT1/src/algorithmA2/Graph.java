package algorithmA2;


import java.util.ArrayList;
import java.util.List;

import dfs.Edge;

public class Graph {
	
	
	private List <Node> puzzles; 
	private List<List<Edge1>> neighbors; 
	private Node goalNode;
	private int[] parent;
	public Graph(Node initial) {
		int[] goal = {1,2,3,4,5,6,7,8,9,10,11,0};
		goalNode = new Node(goal);
		puzzles = new ArrayList<>(); 
		neighbors = new ArrayList<>();
		this.puzzles.add(initial);
		parent = this.getParent();
		
	}
    
	
	public boolean contains(Node target) {
		for(Node n : this.puzzles ) {
			if(n.isGoal()) {
				return true;
			}
		}
		return false;
	}


	public List<Node> getPuzzles() {
		return puzzles;
	}


	public void setPuzzles(List<Node> puzzles) {
		this.puzzles = puzzles;
	}


	public List<List<Edge1>> getNeighbors() {
		return neighbors;
	}


	public void setNeighbors(List<List<Edge1>> neighbors) {
		this.neighbors = neighbors;
	}


	public Node getGoalNode() {
		return goalNode;
	}


	public void setGoalNode(Node goalNode) {
		this.goalNode = goalNode;
	}


	public int[] getParent() {
		parent = new int[this.getPuzzles().size()];
		for (int i = 0; i < parent.length; i++) {
			  parent[i] = -1; 
			}
		boolean[] isVisited = new boolean[this.getPuzzles().size()];
		for(int i = 0; i < this.getPuzzles().size(); i++) {
		if(this.getPuzzles().get(i).isHasChild()) {	 
			for (Edge1 e : this.getNeighbors().get(i)) {
				   if (!isVisited[e.t]) {
					   parent[e.t] = i; 
		 }
		
	 }

 }
}       
		return parent;

 }
}
