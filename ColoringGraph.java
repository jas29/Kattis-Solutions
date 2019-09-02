import java.util.*;
import java.io.*;
public class ColoringGraph{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
            int numvertices=Integer.parseInt(scan.nextLine());
             int [][] graph=new int[numvertices][numvertices];
                 int [] color=new int[numvertices];
                 int total;
        for(int i=0;i<numvertices;i++){
            graph[i][i]=1;
            String s[]=scan.nextLine().split(" ");
            for(int j=0;j<s.length;j++){
                int a=Integer.parseInt(s[j]);
                graph[i][a]=1;
            }
        }
        for(total=2;total<=numvertices;total++){
            color[0]=1;
            if(graphColor(graph,color,total,numvertices,0)){
                System.out.println(total);
                break;
            }
        }
    }
    public static boolean graphColor(int graph[][],int color[],int m,int numvertices,int k){
        if(k==color.length){
            return true;
        }
        if(color[k]!=0){
            return graphColor(graph,color,m,numvertices,k+1);
        }
        for(int c=1;c<=m;c++){
            boolean check=true;
            for(int i=0;i<numvertices;i++){
                if(graph[k][i]!=1 && color[i]!=c){
                    check=false;
                }
            }
            if(is_safe(k,c,graph,color,numvertices)){
                color[k]=c;
                if(graphColor(graph,color,m,numvertices,k+1)) return true;
                color[k]=0;
            }
        }
        return false;
    }
    public static boolean is_safe(int k,int c,int graph[][],int color[],int numvertices){
        for(int i=0;i<numvertices;i++){
            if(graph[k][i]==1 && c==color[i]) return false;
        }
    return true;
    }
    public static void toString(int[][]array){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
    

    
}