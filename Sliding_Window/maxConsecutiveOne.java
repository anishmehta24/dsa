package Sliding_Window;

//Longest Subarray with at most k zeros
public class maxConsecutiveOne {

    static int solve(int arr[], int k){
        int left =0, right =0;
       int zero =0;
       int maxLength = 0;
       while (right<arr.length){
        if(arr[right]==0) {
            zero++;
        }
       
        if(zero > k){
          if(arr[left] == 0) zero--; // Whenever the zero count  get increased by k we shift the left pointer forward
            left++;
        }

        if(zero <= k){
            maxLength = Math.max(maxLength, right-left+1);
        }
        right++;
       }
        return maxLength;
    }
    public static void main(String[] args) {
        int arr[] = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(solve(arr, k));
    }
}
