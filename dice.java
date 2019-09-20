// Jaskaren Saini
// Uvic Id - V00877182
import java.util.*;
public class dice{
  static int n, s, k;
  static Double[][] array;
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    s = scan.nextInt();
    k = scan.nextInt();
    array = new Double[n+1][s+1];
    System.out.println(Prob(n, 0));

  }
  public static double Prob(int numthrows, int num) {

    if (num >= k) {
      return 1.0;
    }
    if (numthrows == 0) {
      return 0.0;
    }
    if (array[numthrows][num] != null) {
      return array[numthrows][num];
    }

    double probold = (double) num / (double) s;
    double probnew = 1.0 - probold;

    double probability = probnew * Prob(numthrows - 1, num + 1) + probold * Prob(numthrows - 1, num);

    array[numthrows][num] = probability;
    return array[numthrows][num];

  }
}
