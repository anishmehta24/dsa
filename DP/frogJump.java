package DP;

public class frogJump {

    static int solve (int arr[]){

        int dp[] = new int[arr.length];
        dp[0] = 0;
        for(int i=1;i<arr.length;i++){
            int fs = dp[i-1] + Math.abs(arr[i]-arr[i-1]);
            int ss = Integer.MAX_VALUE;
            if(i>1) ss = dp[i-2] + Math.abs(arr[i]-arr[i-2]);

            dp[i] = Math.min(fs,ss);
        }
        return dp[arr.length-1];
    }
    public static void main(String[] args) {
        System.out.println();
    }
}
