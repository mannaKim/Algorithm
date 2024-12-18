import java.io.*;
import java.util.*;

public class Main {
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new Integer[n+1];
        dp[0] = dp[1] = 0;

        System.out.println(recur(n));
    }

    static int recur(int n) {
        if(dp[n] == null) {
            // 6으로 나눠지는 경우
            if(n % 6 == 0) {
                dp[n] = Math.min(recur(n-1), Math.min(recur(n/3), recur(n/2))) + 1;
            } 
            // 3으로 나눠지는 경우
            else if (n % 3 == 0) {
                dp[n] = Math.min(recur(n/3), recur(n-1)) + 1;
            } 
            // 2로 나눠지는 경우
            else if (n % 2 == 0) {
                dp[n] = Math.min(recur(n/2), recur(n-1)) + 1;
            } 
            // 그 외의 경우
            else {
                dp[n] = recur(n-1) + 1;
            }
        }
        return dp[n];
    }
}