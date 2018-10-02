package algorithmA1;

import java.util.Comparator;

public class nodeComparator implements Comparator<Node>, java.io.Serializable {
	public int compare(Node n1, Node n2) {
	      int h1 = n1.getF_n();
		  int h2 = n2.getF_n();
		
	  if (h1 < h2)
		 return -1;
      else if (h1 == h2)
		 return 0;
	  else
		return 1;
	}
}
		