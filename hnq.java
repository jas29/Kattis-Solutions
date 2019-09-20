import java.util.*;
public class hnq {
  static int n;
  static int []x = new int[256];
  static int count;
  static boolean []a = new boolean[256];
  static boolean []b = new boolean[256];
  static boolean []c = new boolean[256];
  static boolean[][] chessboard;
  static int row;
  static int col;

  static void printsol(){
    count++;
  }

  static void gen (int col){
    for (int row=0;row<n;++row){
      if(chessboard[row][col]) continue;
      if(a[row] && b[row+col] && c[row-col+n]){
        a[row] = b[row+col] = c[row-col+n] = false;

        x[col]=row;
        if(col==n-1){printsol();}else gen (col+1);

        a[row] = b[row+col] = c[row-col+n] = true;
      }
    }
  }
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    String[] input=scan.nextLine().split(" ");
    for (int i=0;i<256;i++){
      a[i]=true;
      b[i]=true;
      c[i]=true;
    }
    while((n=Integer.parseInt(input[0]))!=0){
      chessboard = new boolean[256][256];
      int M=Integer.parseInt(input[1]);
      for (int i=0;i<M;i++){
        input=scan.nextLine().split(" ");
        row=Integer.parseInt(input[0]);
        col=Integer.parseInt(input[1]);
        chessboard[row][col]=true;
      }
      gen(0);
      System.out.println(count);
      input=scan.nextLine().split(" ");
      count=0;
    }
  }
}