import java.util.*;
import java.io.*;
public class kitten {
    public static void main(String[] args)
    throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        int [] arr = new int [101];
        int kitten = scan.nextInt();
        while(scan.hasNextLine()) {
            String s = scan.nextLine();
            if(s.equals(-1)) {
             break;
         }
            String [] array = s.split(" ");
             for(int i=1;i<array.length;i++) {
                arr[Integer.parseInt(array[i])] = Integer.parseInt(array[0]);
            }
        }
        ArrayList<Integer> array2 =  new ArrayList<Integer>(101);
        BringDown(arr,kitten,array2);
        for(int j=0;j<array2.size();j++) {
            System.out.println(array2.get(j));
        }
    }
    public static ArrayList<Integer> BringDown(int [] arrays, int kit,ArrayList<Integer> arrays1) {
            arrays1.add(kit);

            if(arrays[kit] == 0 ) {
                return arrays1;
            }
            int kit2 = arrays[kit];
            BringDown(arrays,kit2,arrays1);
            return arrays1;

    }
}
