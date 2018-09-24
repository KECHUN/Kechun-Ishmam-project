package dfs;


import java.util.ArrayList;
import java.util.List;

public class Graph {
	
	
	private List <Node> puzzles; 
	private List<List<Edge>> neighbors; 
	private Node goalNode;
	public Graph(Node initial) {
		int[] goal = {1,2,3,4,5,6,7,8,9,10,11,0};
		goalNode = new Node(goal);
		puzzles = new ArrayList<>(); 
		neighbors = new ArrayList<>();
		this.puzzles.add(initial);
		
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


	public List<List<Edge>> getNeighbors() {
		return neighbors;
	}


	public void setNeighbors(List<List<Edge>> neighbors) {
		this.neighbors = neighbors;
	}


	public Node getGoalNode() {
		return goalNode;
	}


	public void setGoalNode(Node goalNode) {
		this.goalNode = goalNode;
	}
	

}
