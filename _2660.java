import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.lang.Math;
public class _2660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][n+1];
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < n + 1; j++) {
                arr[i][j] = 987654321;
            }
        }
        for(int i = 1 ; i < n+1; i++) {
            arr[i][i] = 0;
        }
        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1) break;
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        for(int k = 1; k < n + 1; k++) {
            for (int a = 1; a < n + 1; a++) {
                for (int b = 1; b < n + 1; b++) {
                    if (arr[a][b] > arr[a][k] + arr[k][b]) {
                        arr[a][b] = arr[a][k] + arr[k][b];
                    }
                }
            }
        }

        int min_val = 987654321;
        for(int i = 1; i < n+1; i++) {
            int max_val = 0;
            for (int j = 1; j < n + 1; j++) {
                max_val = Math.max(max_val, arr[i][j]);
            }
            min_val = Math.min(min_val, max_val);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i < n+1; i++) {
            int max_val = 0;
            for (int j = 1; j < n + 1; j++) {
                max_val = Math.max(max_val, arr[i][j]);
            }
            if(max_val == min_val) {
                list.add(i);
            }
        }

        System.out.println(min_val + " " + list.size());
        for(int val : list) {
            bw.write(String.valueOf(val) + " ");
        }
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
