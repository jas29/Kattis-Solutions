import java.util.Scanner;
import java.util.LinkedList;
import java.util.Stack;
@SuppressWarnings("unchecked")
public class pick {
  // Digraph class taken from the textbook
  static class Digraph
{
  private final int V;
  private int E;
  private LinkedList<Integer>[] adj;
  private static final String NEWLINE = System.getProperty("line.separator");

  public  Digraph(int V)
  {
    this.V = V;
    this.E = 0;
    adj = (LinkedList<Integer>[]) new LinkedList[V];
    for (int v = 0; v < V; v++)
    adj[v] = new LinkedList<Integer>();
  }
  public int V() { return V; }
  public int E() { return E; }
  public void addEdge(int v, int w)
  {
    adj[v].add(w);
    E++;
  }
  public Iterable<Integer> adj(int v)
  { return adj[v];
  }
  public Digraph reverse()
  {
    Digraph R = new Digraph(V);
    for (int v = 0; v < V; v++)
    for (int w : adj(v))
    R.addEdge(w, v);
    return R;
  }
  public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(String.format("%d: ", v));
            for (int w : adj[v]) {
                s.append(String.format("%d ", w));
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}
// DirectedCycle class taken from the textbook
static class DirectedCycle
{
  private boolean[] marked;
  private int[] edgeTo;
  private Stack<Integer> cycle;
  private boolean[] onStack;
  public DirectedCycle(Digraph G)
  {
    onStack = new boolean[G.V()];
    edgeTo = new int[G.V()];
    marked = new boolean[G.V()];
    for (int v = 1; v < G.V(); v++)
    if (!marked[v]) dfs(G, v);
  }
  private void dfs(Digraph G, int v)
  {
    onStack[v] = true;
    marked[v] = true;
    for (int w : G.adj(v))
    if (this.hasCycle()){
      return;
    }
    else if (!marked[w])
    { edgeTo[w] = v; dfs(G, w); }
    else if (onStack[w])
    {
    cycle = new Stack<Integer>();
    for (int x = v; x != w; x = edgeTo[x])
    cycle.push(x);
    cycle.push(w);
    cycle.push(v);
    }
    onStack[v] = false;
  }
  public boolean hasCycle()
  { return cycle != null; }
  public Iterable<Integer> cycle()
  { return cycle; }
}
// DFS class taken from the textbook
static class DepthFirstOrder
{
  private boolean[] marked;
  private Stack<Integer> reversePost;
  public DepthFirstOrder(Digraph G)
  {
    reversePost = new Stack<Integer>();
    marked = new boolean[G.V()];
    for (int v = 1; v < G.V(); v++)
    if (!marked[v]) dfs(G, v);
  }
  private void dfs(Digraph G, int v)
  {
    marked[v] = true;
    for (int w : G.adj(v))
    if (!marked[w])
    dfs(G, w);
    reversePost.push(v);
  }
  public Iterable<Integer> reversePost()
  { return reversePost; }
}
// Topological class taken from the textbook
static class Topological
{
  private Iterable<Integer> order;
  public Topological(Digraph G)
  {
    DepthFirstOrder dfs = new DepthFirstOrder(G);
    order = dfs.reversePost();

  }
  public Iterable<Integer> order()
  { return order; }
  public boolean isDAG()
  { return order == null; }
}
// This is the beginning of the code writen by me.
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String s1 = scan.nextLine();
    String [] array = s1.split(" ");
    int numsticks = Integer.parseInt(array[0]);
    int numlines = Integer.parseInt(array[1]);
    Digraph d = new Digraph(numsticks+1);
    while(scan.hasNextLine()) {
        String s = scan.nextLine();
        String [] arr = s.split(" ");
        d.addEdge(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]));

  }
  DirectedCycle dc = new DirectedCycle(d);
    if(dc.hasCycle() == true) {
      System.out.println("IMPOSSIBLE");
    }
    else {
      Topological t = new Topological(d.reverse());
      StringBuilder sb = new StringBuilder();
      for(int w:t.order()) {
        sb.append(w);
        sb.append("\n");
      }
      System.out.print(sb);
    }
}

}
