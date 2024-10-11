package DP;

public class climbStair {
    public static void main(String[] args) {
        System.out.println(solve(5));
    }

    static int solve (int index){
        if(index == 0) return 0;
        if(index == 1) return 1;

        return (solve(index-1) + solve(index-2) );
    }
  
}
