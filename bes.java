import java.util.*;
import java.io.*;
public class bes {
  public static void main(String [] args) {
    Scanner scan = new Scanner(System.in);

    while(scan.hasNextLine()) {
      TreeMap<String,PriorityQueue<String>> map = new TreeMap<String,PriorityQueue<String>>();
      PriorityQueue<String> copy = new PriorityQueue<String>();
      String s = scan.nextLine();
      if(s.equals("0")) {
        break;
      }
      int numlines = Integer.parseInt(s);
      System.out.println();
      for(int i=0;i<numlines;i++) {
        s = scan.nextLine();
        String [] array = s.split(" ");
        String name = array[0];

        for(int j=1;j<array.length;j++) {
          String key = array[j];
          PriorityQueue<String> pq = new PriorityQueue<String>();
          if(map.containsKey(key) == false) {
            pq.add(name);
            map.put(key,pq);
          }
          else {
            pq = map.get(key);
            pq.add(name);
            map.put(key,pq);
          }
        }
      }
      String [] keys = new String[map.size()];
        String [] values = new String[map.size()];
      map.keySet().toArray(keys);

      for(int i=0;i<keys.length;i++) {

        System.out.print(keys[i]+" ");
        PriorityQueue<String> t= map.get(keys[i]);
        while(!t.isEmpty()){
          System.out.print(t.poll()+" ");
      }
      System.out.println();
      }
  }
}
}
