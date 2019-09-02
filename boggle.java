import java.util.*;
import java.io.*;
public class boggle {
	static char[][] board;
	static boolean [][] visited;
	public static void main(String[] args)throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int w = Integer.parseInt(bf.readLine());
		String [] dictionary = new String[w];
		for(int i=0;i<w;i++){
			dictionary[i] = bf.readLine();
		}
		bf.readLine();
		int numboards = Integer.parseInt(bf.readLine());
		for(int i=0;i<numboards;i++){
			 board = new char[4][4];
			for(int j=0;j<4;j++){
					board[j] = bf.readLine().toCharArray();
			}
			bf.readLine();
			visited = new boolean[4][4];
			ArrayList<String> fin = search(board,dictionary);
			int score = 0;
			int count = 0;
			for(int d=0;d<fin.size();d++){
			if(fin.get(d).length()<3){
				count++;
			}
			if(fin.get(d).length()==3||fin.get(d).length()==4){
				score = score+1;
				count++;
			}
			if(fin.get(d).length()==5){
				score = score+2;
				count++;
			}
			if(fin.get(d).length()==6){
				score = score+3;
				count++;
			}
			if(fin.get(d).length()==7){
				score = score+5;
				count++;
			}
			if(fin.get(d).length()==8){
				score = score+11;
				count++;
			}

		}
		String biggest = "";
		for(int m=0;m<fin.size();m++){
			if (fin.get(m).length() > biggest.length() || (fin.get(m).length() == biggest.length() && fin.get(m).compareTo(biggest) < 0)) {
                    biggest = fin.get(m);
                }
		}
		System.out.println(score+" "+biggest+" "+count);
		}
	}
	public static void toString(char[][]array){
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array.length;j++){
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static ArrayList<String> search(char[][]board,String[]dictionary){
		ArrayList<String> f = new ArrayList<String>();
		Set<String> foundWords = new HashSet<String>();
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				for(int k=0;k<dictionary.length;k++){
					if(board[i][j]==dictionary[k].charAt(0)){
					if(find(i,j,dictionary[k],1)==true){
						f.add(dictionary[k]);
					}
				}
				}
			}
		}
		Set<String> hs = new HashSet<>();
		hs.addAll(f);
		f.clear();
		f.addAll(hs);
		return f;
	}
	public static boolean find(int rows,int columns,String word,int position){
		int[] x = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] y = {-1, 0, 1, -1, 1, -1, 0, 1};
		if(position==word.length()){
			return true;
		}
		boolean res = false;
		visited[rows][columns] = true;
		for(int i=0;i<8;++i){
			int numx = rows+x[i];
			int numy = columns+y[i];
			 if (0 <= numx && numx < 4 && 0 <= numy && numy < 4 && !visited[numx][numy] && board[numx][numy] == word.charAt(position)) {
                res = res || find(numx, numy, word, position + 1);
            }
		}
		visited[rows][columns] = false;
		return res;
	}
}