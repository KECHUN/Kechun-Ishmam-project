package dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class depthFirstSearch {

	public static void main(String[] args) {

		int[] initial = new int[12];
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the board split by comma: ");
		String a = input.nextLine();
		String [] tokens = a.split("[,]");
		for (int i = 0; i < tokens.length; i++) {
			initial[i] = Integer.parseInt(tokens[i]);
		}
		Node initialNode = new Node(initial);
		Graph graph = new Graph(initialNode);
		expandGraph(graph);
		
		for(Node n: graph.getPuzzles()) {
			for(int i : n.getPuzzle()) {
				System.out.print( i + ",");
			}
			System.out.print( "\n");	
		}
		int NodeWithChildren = graph.getNeighbors().size();
		for(int i = 0; i < NodeWithChildren; i++) {
		int edgeNum = graph.getNeighbors().get(i).size();
		  for(int j = 0; j < edgeNum; j++) {
			  System.out.println(graph.getNeighbors().get(i).get(j).toString() +"\n");
		  }
		
	  }
		System.out.print( "size of nodes: " + graph.getPuzzles().size() +
				"\n");
		depthFirstSearch(graph);
	}	
	
	public static void expandGraph(Graph graph){
		
		int limit = 20000;

		for(int i = 0 ; i < graph.getPuzzles().size() & i <= limit; i++ ) {
		      
			 if(i == limit) {
				 
				 System.out.print( "The solution is too hard to find" +
							"\n");
			 }
			  Node child = graph.getPuzzles().get(i).moveUp();
			  if(child != null) {
				graph.getPuzzles().add(child);
				
				int s = i;
				int e = graph.getPuzzles().indexOf(child);
				Edge newOne = new Edge(s,e);
				if(graph.getNeighbors().size() == s) {
					graph.getNeighbors().add(new ArrayList<>());
					graph.getNeighbors().get(s).add(newOne);
				}
				else
					graph.getNeighbors().get(s).add(newOne);
				if(child.isGoal()) {
					break;
				}
		   }	
			  child = graph.getPuzzles().get(i).moveUpright();
			  if(child != null) {
				graph.getPuzzles().add(child);
				
				int s = i;
				int e = graph.getPuzzles().indexOf(child);
				Edge newOne = new Edge(s,e);
				if(graph.getNeighbors().size() == s) {
					graph.getNeighbors().add(new ArrayList<>());
					graph.getNeighbors().get(s).add(newOne);
				}
				else
					graph.getNeighbors().get(s).add(newOne);
				if(child.isGoal())
					break;
		   }
			  child = graph.getPuzzles().get(i).moveRight();
			  if(child != null) {
				graph.getPuzzles().add(child);
				
				int s = i;
				int e = graph.getPuzzles().indexOf(child);
				Edge newOne = new Edge(s,e);
				if(graph.getNeighbors().size() == s) {
					graph.getNeighbors().add(new ArrayList<>());
					graph.getNeighbors().get(s).add(newOne);
				}
				else
					graph.getNeighbors().get(s).add(newOne);
				if(child.isGoal())
					break;
		   }	
			  child = graph.getPuzzles().get(i).moveDownright();
			  if(child != null) {
				graph.getPuzzles().add(child);
				
				int s = i;
				int e = graph.getPuzzles().indexOf(child);
				Edge newOne = new Edge(s,e);
				if(graph.getNeighbors().size() == s) {
					graph.getNeighbors().add(new ArrayList<>());
					graph.getNeighbors().get(s).add(newOne);
				}
				else
					graph.getNeighbors().get(s).add(newOne);
				if(child.isGoal())
					break;
		   }	
			  child = graph.getPuzzles().get(i).moveDown();
			  if(child != null) {
				graph.getPuzzles().add(child);
				
				int s = i;
				int e = graph.getPuzzles().indexOf(child);
				Edge newOne = new Edge(s,e);
				if(graph.getNeighbors().size() == s) {
					graph.getNeighbors().add(new ArrayList<>());
					graph.getNeighbors().get(s).add(newOne);
				}
				else
					graph.getNeighbors().get(s).add(newOne);
				if(child.isGoal())
					break;
		   }	
			  child = graph.getPuzzles().get(i).moveDownleft();
			  if(child != null) {
				graph.getPuzzles().add(child);
				
				int s = i;
				int e = graph.getPuzzles().indexOf(child);
				Edge newOne = new Edge(s,e);
				if(graph.getNeighbors().size() == s) {
					graph.getNeighbors().add(new ArrayList<>());
					graph.getNeighbors().get(s).add(newOne);
				}
				else
					graph.getNeighbors().get(s).add(newOne);
				if(child.isGoal())
					break;
		   }	
			  child = graph.getPuzzles().get(i).moveLeft();
			  if(child != null) {
				graph.getPuzzles().add(child);
				
				int s = i;
				int e = graph.getPuzzles().indexOf(child);
				Edge newOne = new Edge(s,e);
				if(graph.getNeighbors().size() == s) {
					graph.getNeighbors().add(new ArrayList<>());
					graph.getNeighbors().get(s).add(newOne);
				}
				else
					graph.getNeighbors().get(s).add(newOne);
				if(child.isGoal())
					break;
		   }	
			  child = graph.getPuzzles().get(i).moveUpleft();
			  if(child != null) {
				graph.getPuzzles().add(child);
				
				int s = i;
				int e = graph.getPuzzles().indexOf(child);
				Edge newOne = new Edge(s,e);
				if(graph.getNeighbors().size() == s) {
					graph.getNeighbors().add(new ArrayList<>());
					graph.getNeighbors().get(s).add(newOne);
				}
				else
					graph.getNeighbors().get(s).add(newOne);
				if(child.isGoal())
					break;
		   }	
			  
		 
	   }
		
  }
	public static void depthFirstSearch(Graph graph) {
		//List<Integer> searchOrder = new ArrayList<>();
		int[] parent = new int[graph.getPuzzles().size()];
		for (int i = 0; i < parent.length; i++) {
		  parent[i] = -1; 
		}
		boolean[] isVisited = new boolean[graph.getPuzzles().size()];
		int start = 0;
		List <Integer> target = new ArrayList<>();;
		dfs(start, parent, isVisited,graph,target);
		if(target.isEmpty()) {
			System.out.print( "No solution is found " +
					"\n");
		}
		else {
		int index = target.get(0);
		ArrayList <Node> path = new ArrayList<>();
		do {
			path.add(graph.getPuzzles().get(index));
			index = parent[index];
			} while (index != -1);
		for(int i = path.size() -1; i >= 0; i--) {
			if(i == path.size() -1) {
				System.out.println("0");
			}
			else {
			System.out.println(path.get(i).getmovePosition());
			}
			for(int j : path.get(i).getPuzzle()) {
				System.out.print( j + ",");
			}
			System.out.print( "\n");	
			
		 }
		}	
	}

	

	public static void dfs(int s, int[] parent, boolean[] isVisited,Graph graph,List <Integer> target ) {
		
		
		int i = 0;
		isVisited[s] = true; 
	
		for (Edge e : graph.getNeighbors().get(s)) {
		   if (!isVisited[e.t]) {
			   parent[e.t] = s; 
			   if(graph.getPuzzles().get(e.t).isGoal()) {
				   i  = e.t;
				   target.add(i);
				   System.out.print("look " + i +"\n");
			   }		   
			  
		if(e.t < graph.getNeighbors().size())
		   dfs(e.t, parent, isVisited,graph, target);
		
	 }
   }
		
  }
}
