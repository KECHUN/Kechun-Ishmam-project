package dfs;

public class Test {

	public static void main(String[] args) {
		int[] goal = {1,2,3,4,5,6,7,8,9,10,11,0};
		Node test = new Node(goal);
		Graph graph = new Graph(test);
		if(graph.contains(test)) {
			System.out.print( "yes");
		}
	}

}
