//BOJ 1920
import java.util.Arrays;
import java.util.Scanner;

public class _1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int target = sc.nextInt();
            int start = 0;
            int end = arr.length - 1;
            int mid = 0;
            boolean find = false;
            while (start <= end) {
                mid = (start + end) / 2;
                if (arr[mid] == target) {
                    find = true;
                    System.out.println(1);
                    break;
                }
                else if (arr[mid] < target) start = mid + 1;
                else end = mid - 1;
            }
            if(!find){
                System.out.println(0);
            }
        }
    }
}
