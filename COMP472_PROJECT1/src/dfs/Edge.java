package dfs;

public class Edge {
   public int s;
   public int t;
   
   public Edge(int s, int t) {
	   this.s = s;
	   this.t = t;
   }
   public String toString() {
	   return "Node " + s + " to node " + t ;
	   }
}
