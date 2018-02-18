import java.util.*;
import java.io.*;
public class tower {
  public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String s = bf.readLine();
    String [] sar = s.split(" ");
    ArrayList<Integer> al = new ArrayList<Integer>();
    for(int i=0;i<sar.length;i++) {
      al.add(Integer.parseInt(sar[i]));
    }
    int tower1 = al.get(al.size()-1);
    al.remove(al.size()-1);
    int tower2 = al.get(al.size()-1);
    al.remove(al.size()-1);
    ArrayList<Integer> first = Do(al,tower1);
      Collections.sort(first,Collections.reverseOrder());
      ArrayList<Integer> second = Do(al,tower2);
      Collections.sort(second,Collections.reverseOrder());
    print(second);
      print(first);

  }
  public static void print(ArrayList<Integer> arr) {
    for(int i=0;i<arr.size();i++) {
      System.out.print(arr.get(i)+" ");
    }
  }
  public static ArrayList<Integer> Do(ArrayList<Integer> arr,int val) {
    ArrayList<Integer> a1 = new ArrayList<Integer>();
    for(int i=0;i<arr.size()-2;i++) {
        for(int j=i+1;j<arr.size()-1;j++) {
          for(int k=j+1;k<arr.size();k++) {
            if((arr.get(i)+arr.get(j)+arr.get(k)) == val) {
              a1.add(arr.get(i));
              a1.add(arr.get(j));
              a1.add(arr.get(k));
            }
          }
        }
    }
    return a1;
  }
}
