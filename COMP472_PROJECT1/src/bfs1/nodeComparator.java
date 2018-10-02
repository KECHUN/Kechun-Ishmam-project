package bfs1;

import java.util.Comparator;

public class nodeComparator implements Comparator<Node>, java.io.Serializable {
	public int compare(Node n1, Node n2) {
	      int h1 = n1.evaluateH1();
		  int h2 = n2.evaluateH1();
		
	  if (h1 < h2)
		 return -1;
      else if (h1 == h2)
		 return 0;
	  else
		return 1;
	}
}
		