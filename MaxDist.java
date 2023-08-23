import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Scanner;

 
public class MaxDist {
	
	public static void main(String[] args) {
        FastScanner in = new FastScanner();
            PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();

            int a[] = new int[n];
            for (int j = 0; j < n; j++) a[j] = in.nextInt();
            out.println(solve(a, k));
        }

        out.close();
    }

    public static int solve(int a[], int k) {
        int n = a.length;
        int left = 1, right = a[n-1] - a[0];
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (possible(a, k, mid)) left = mid;
            else right = mid - 1;
        }
        return left;
    }

    public static boolean possible(int a[], int k, int d) {
        int counter = k-1;
        int prev = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] - prev >= d) {
                prev = a[i];
                counter--;
                if (counter == 0) return true;
            }
        }
        return false;
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
