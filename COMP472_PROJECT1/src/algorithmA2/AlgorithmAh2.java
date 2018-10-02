package algorithmA2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class AlgorithmAh2 {

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
		algorithmA_search(graph);
	}	
	
	public static void expandGraph(Graph graph){
		
		int limit = 20000;

		for(int i = 0 ; i < graph.getPuzzles().size() & i <= limit; i++ ) {
		      
			 if(i == limit) {
				 
				 System.out.print( "The solution is too hard to find" +
							"\n");
			 }
			 
			 Node child = graph.getPuzzles().get(i).moveDown();
			  if(child != null)  {
				if(graph.getPuzzles().get(i).getLastMove() + child.getLastMove() !=0) {
				child.setG_n(graph.getPuzzles().get(i).getG_n() +1);
			    	child.setF_n(child.getG_n() + child.getH2());
				graph.getPuzzles().add(child);
				graph.getPuzzles().get(i).setHasChild(true);
				int s = i;
				int e = graph.getPuzzles().indexOf(child);
				Edge1 newOne = new Edge1(s,e);
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
			  
			  child = graph.getPuzzles().get(i).moveDownleft();
			  if(child != null)  {
				if(graph.getPuzzles().get(i).getLastMove() + child.getLastMove() !=0) {
				child.setG_n(graph.getPuzzles().get(i).getG_n() +1);
			    	child.setF_n(child.getG_n() + child.getH2());
				graph.getPuzzles().add(child);
				graph.getPuzzles().get(i).setHasChild(true);
				int s = i;
				int e = graph.getPuzzles().indexOf(child);
				Edge1 newOne = new Edge1(s,e);
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
			  
			  child = graph.getPuzzles().get(i).moveLeft();
			  if(child != null)  {
				if(graph.getPuzzles().get(i).getLastMove() + child.getLastMove() !=0) {
				child.setG_n(graph.getPuzzles().get(i).getG_n() +1);
			    	child.setF_n(child.getG_n() + child.getH2());
			    	graph.getPuzzles().add(child);
				graph.getPuzzles().get(i).setHasChild(true);
				int s = i;
				int e = graph.getPuzzles().indexOf(child);
				Edge1 newOne = new Edge1(s,e);
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
			  child = graph.getPuzzles().get(i).moveUpleft();
			  if(child != null) {
				if(graph.getPuzzles().get(i).getLastMove() + child.getLastMove() !=0) {
				child.setG_n(graph.getPuzzles().get(i).getG_n() +1);
			    	child.setF_n(child.getG_n() + child.getH2());	
				graph.getPuzzles().add(child);
				graph.getPuzzles().get(i).setHasChild(true);
				int s = i;
				int e = graph.getPuzzles().indexOf(child);
				Edge1 newOne = new Edge1(s,e);
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
			    child = graph.getPuzzles().get(i).moveUp();
			  if(child != null) {
			     if(graph.getPuzzles().get(i).getLastMove() + child.getLastMove() !=0) {
			    	 child.setG_n(graph.getPuzzles().get(i).getG_n() +1);
			    	 child.setF_n(child.getG_n() + child.getH2());
				graph.getPuzzles().add(child);
				graph.getPuzzles().get(i).setHasChild(true);
				int s = i;
				int e = graph.getPuzzles().indexOf(child);
				Edge1 newOne = new Edge1(s,e);
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
		   }	
			  child = graph.getPuzzles().get(i).moveUpright();
			  if(child != null)  {
				if(graph.getPuzzles().get(i).getLastMove() + child.getLastMove() !=0) {
				child.setG_n(graph.getPuzzles().get(i).getG_n() +1);
			    	child.setF_n(child.getG_n() + child.getH2());
				graph.getPuzzles().add(child);
				graph.getPuzzles().get(i).setHasChild(true);
				int s = i;
				int e = graph.getPuzzles().indexOf(child);
				Edge1 newOne = new Edge1(s,e);
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
			  child = graph.getPuzzles().get(i).moveRight();
			  if(child != null)  {
				if(graph.getPuzzles().get(i).getLastMove() + child.getLastMove() !=0) {
				child.setG_n(graph.getPuzzles().get(i).getG_n() +1);
			    	child.setF_n(child.getG_n() + child.getH2());
				graph.getPuzzles().add(child);
				graph.getPuzzles().get(i).setHasChild(true);
				int s = i;
				int e = graph.getPuzzles().indexOf(child);
				Edge1 newOne = new Edge1(s,e);
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
			  child = graph.getPuzzles().get(i).moveDownright();
			  if(child != null)  {
				if(graph.getPuzzles().get(i).getLastMove() + child.getLastMove() !=0) {
				child.setG_n(graph.getPuzzles().get(i).getG_n() +1);
			    	child.setF_n(child.getG_n() + child.getH2());
				graph.getPuzzles().add(child);
				graph.getPuzzles().get(i).setHasChild(true);
				int s = i;
				int e = graph.getPuzzles().indexOf(child);
				Edge1 newOne = new Edge1(s,e);
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
		
  }
	public static void algorithmA_search(Graph graph) {
		
		
		boolean[] isVisited = new boolean[graph.getPuzzles().size()];
		int start = 0;
		List <Integer> target = new ArrayList<>();;
		Comparator<Node> comparator = new nodeComparator();
		PriorityQueue <Node> queueChildren = new PriorityQueue<Node>(1000,comparator);
		PriorityQueue <Node> queueTotal = new PriorityQueue<Node>(100000,comparator);
		queueTotal.offer(graph.getPuzzles().get(0));
		a_search(start, isVisited,graph,target,queueTotal,comparator,queueChildren);
		if(target.isEmpty()) {
			System.out.print( "No solution is found " +
					"\n");
		}
		else {
		int index = target.get(0);
		ArrayList <Node> path = new ArrayList<>();
		do {
			path.add(graph.getPuzzles().get(index));
			index = graph.getParent()[index];
			} while (index != -1);
		for(int i = path.size() -1; i >= 0; i--) {
			if(i == path.size() -1) {
				System.out.println("0");
			}
			else {
			System.out.println(path.get(i).getmovePosition() + " Node " + i + " h1 value " + path.get(i).getH2());
			}
			for(int j : path.get(i).getPuzzle()) {
				System.out.print( j + ",");
			}
			System.out.print( "\n");	
			
		 }
		}	
	}

	

	public static void a_search(int start,  boolean[] isVisited,Graph graph,List <Integer> target,PriorityQueue <Node> queueTotal, Comparator<Node> comparator,
    PriorityQueue <Node> queueChildren) {
		System.out.println("size of queueTotal " + queueTotal.size());
		
		if(!target.isEmpty() || queueTotal.size() >= 1000) {
			return;
		}
		else {
		
		int i = 0;
		isVisited[start] = true; 
		int theBest = 0;
		
		for (Edge1 e : graph.getNeighbors().get(start)) {
		   if (!isVisited[e.t]) {
			   queueChildren.offer(graph.getPuzzles().get(e.t));
			   if(!queueTotal.contains(graph.getPuzzles().get(e.t))) {
			   queueTotal.offer(graph.getPuzzles().get(e.t));
			   }
			   if(graph.getPuzzles().get(e.t).isGoal()) {
				   i  = e.t;
				   target.add(i);
				   System.out.print("look at" + i +"\n");
			   }		   
	    }
		  
   }    
		                              
		theBest = graph.getPuzzles().indexOf(queueChildren.remove());
		System.out.println("Node " + theBest + " h2= " + graph.getPuzzles().get(theBest).evaluateH2() + " queueTotal is empty " + queueTotal.isEmpty());
		if(graph.getPuzzles().get(theBest).isHasChild() & (graph.getPuzzles().get(theBest).getH2() < graph.getPuzzles().get(start).getH2())) { // if reach the leave of the tree
			   queueChildren.clear();
		       a_search(theBest, isVisited,graph, target,queueTotal, comparator,queueChildren);
		}
		
		else {
		
		if(!queueTotal.isEmpty()){
			   theBest = graph.getPuzzles().indexOf(queueTotal.remove());
		
		while(!graph.getPuzzles().get(theBest).isHasChild() || isVisited[theBest]) {
			if(!queueTotal.isEmpty())
			   theBest = graph.getPuzzles().indexOf(queueTotal.remove());
			else 
				return;
			
		}
		System.out.println("The second index is " + theBest);
		       queueChildren.clear();
		       a_search(theBest, isVisited,graph, target,queueTotal, comparator,queueChildren);//1,0,3,7,5,2,6,4,9,10,11,8 //0,2,3,4,5,1,7,8,9,6,10,11//1,5,3,7,0,2,6,4,9,10,11,8
		}
		else
			return;
			
	}
  }
 }
}
