package bfs2;

import java.util.Comparator;

public class nodeComparator implements Comparator<Node>, java.io.Serializable {
	public int compare(Node n1, Node n2) {
	      int h1 = n1.evaluateH2();
		  int h2 = n2.evaluateH2();
		
	  if (h1 < h2)
		 return -1;
      else if (h1 == h2)
		 return 0;
	  else
		return 1;
	}
}
		