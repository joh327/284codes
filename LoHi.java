import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Scanner;

 
public class LowHi {
	
	public static void main(String[] args) {
    FastScanner in = new FastScanner();
 		PrintWriter out = new PrintWriter(System.out);

		int n = in.nextInt();
    int a[] = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int m = in.nextInt();
    for (int i = 0; i < m; i++) {
      int low = in.nextInt();
      int hi = in.nextInt();

      int first = find_below(a, low);
      int last = find_above(a, hi);
      if (first == -1) out.println(0);
      else if (last == -1) out.println(0);
      else out.println(last - first + 1);
    }
    out.close();
	}

  public static int find_above(int a[], int hi) {
    int left = 0, right = a.length-1;
    while (left < right) {
      int k = (int) Math.ceil((left + right)/2.0);
      if (a[k] > hi) right = k-1;
      else left = k;
    }
    if (a[left] <= hi) return left;
    else return -1; 
  }

  public static int find_below(int a[], int low) {
    int left = 0, right = a.length-1;
    while (left < right) {
      int k = (left + right)/2;
      if (a[k] < low) left = k+1;
      else right = k;
    }
    if (a[left] >= low) return left;
    else return -1; 
  }

  static class FastScanner {
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st=new StringTokenizer("");

      String next() {
        while (!st.hasMoreTokens())
          try { 
            st=new StringTokenizer(br.readLine());				              
          } catch (IOException e) {}
        return st.nextToken();
      }
      
      int nextInt() {
        return Integer.parseInt(next());
      }
  }
}

