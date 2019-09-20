// JASKAREN SAINI
// UVIC ID - V00877182
import java.util.*;
import java.math.*;
public class treeinsertion
{
	static class Node {
		int value = 0;
		int subnodes = 0;
		Node[] children = new Node[2];
    BigInteger permutationation;
		Node() {
      this.value = 0;
      children[0] = null;
      children[1] = null;
    }
    Node(int num) {
      this.value = num;
    }
	}

	Node root;
  StringTokenizer st = new StringTokenizer("");
  Scanner scan = new Scanner(System.in);
	public static void main(String[] args) throws Exception{
		new treeinsertion().run();
	}
	String nextToken() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(scan.nextLine());
		return st.nextToken();
	}
	public int isInteger() throws Exception {
		return Integer.parseInt(nextToken());
	}

	public void addNumber(int num, Node parent, int child) {
		while (parent.children[child] != null) {
			parent = parent.children[child];
			if((num < parent.value)) {
        child = 0;
      }
      else {
        child = 1;
      }
		}
		parent.children[child] = new Node(num);
	}

	public void calculate(Node n) {
		BigInteger[] perms = new BigInteger[2];
		int[] cnts = new int[2];
		for (int i = 0; i < 2; ++i) {
			Node chld = n.children[i];
			if (chld == null) {
				perms[i] = BigInteger.ONE;
				cnts[i] = 0;
			} else {
				calculate(chld);
				perms[i] = chld.permutationation;
				cnts[i] = chld.subnodes;
			}
		}
		n.subnodes = cnts[0] + cnts[1] + 1;
		n.permutationation = perms[0].multiply(perms[1]).multiply(
				combine(cnts[0]+cnts[1], cnts[0]));
	}

	public static BigInteger combine(int n, int k) {
		if (k > n/2) k = n-k;
		return multiply(n-k, n).divide(multiply(0, k));
	}

	public static BigInteger multiply(int min, int max) {
		BigInteger b = BigInteger.ONE;
		for (int i = min; ++i <= max; ) {
			b = b.multiply(BigInteger.valueOf(i));
		}
		return b;
	}
	public void run() throws Exception {
		while(scan.hasNextLine()) {
			int num = isInteger();
			if (num == 0) break;
			root = new Node(0);
			while (num > 0) {
        num--;
				addNumber(isInteger(), root, 0);
			}
			calculate(root);
			System.out.println(root.permutationation);
		}
	}

}
