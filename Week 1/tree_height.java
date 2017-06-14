import java.util.*;
import java.io.*;

public class tree_height {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class TreeHeight {
		int n;
		int parent[];

		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
			}
		}

		int computeHeight() {

      LinkedList<Integer> [] nodes= new LinkedList[n];
      // nodes[0].add(1);
      for(int i=0;i<n;i++)
      nodes[i] = new LinkedList<Integer>();

      int root=0;

      // initialize the tree
      for(int i=0;i<n;i++){
        if( parent[i] == -1 )
        root = i;
        else
        nodes[ parent[i] ].add(i);
      }

      LinkedList queue = new LinkedList();
      queue.add(root);
      int height = 0;

      while(true){
        int count = queue.size();
        if(count == 0)
        return height;

        else
        height++;

        while(count > 0){
          int temp = (int) queue.poll();
          Iterator<Integer> i = nodes[temp].listIterator();
          //appending children of parent to the queue
          while(i.hasNext()){
            queue.add(i.next());
          }
          count--;
        }

      }

		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
