import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class _10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            boolean find = false;
            int start = 0;
            int end = n - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (arr[mid] == target) {
                    bw.write("1 ");
                    find = true;
                    break;
                }
                else if (arr[mid] > target) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            if (find == false) bw.write("0 ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
