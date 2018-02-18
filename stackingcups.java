import java.util.*;
import java.io.*;
public class stackingcups{
  public static void main(String[] args) throws Exception{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(bf.readLine());
    String s = "";
    TreeMap<Integer,String> tm = new TreeMap<Integer,String>();
    while((s = bf.readLine()) != null) {
      String [] sar = s.split(" ");
      int radius = 0;
      int diameter = 0;
      if(IsNumber(sar[1]) == true) {
        radius = Integer.parseInt(sar[1]);
        tm.put(radius,sar[0]);
      }
      else {
        diameter = Integer.parseInt(sar[0]);
        radius = diameter/2;
        tm.put(radius,sar[1]);
      }
    }
  for(Map.Entry m:tm.entrySet()) {
    System.out.println(m.getValue());
  }


  }
  public static boolean IsNumber(String s) {
    try  {
      int i = Integer.parseInt(s);
      return true;
    }
    catch (NumberFormatException er){
      return false;
    }

  }
}
