package Sliding_Window;

import java.util.*;

public class longestSubstringWithoutRepeating {
    static int solve(String s) {
        HashMap<Character, Integer> mpp = new HashMap<Character, Integer>();

        int left = 0, right = 0;
        int n = s.length();
        int len = 0;


        // We take a map and start traversing the string with two pointers left and right pointing at 0
        // left being fixed and right traversing through the string 
        // and start putting the character as key in the map with its index as its value if it is not already present
        // if we find a character which is already present in the map then we will bring the left pointer ahead of that character
        // and update the index value for the character and in the mean time we are keeping the track of the length 
        // till where the character is not rerpeated and keep on updating the max length for every iteration 


        while (right < n) {
             // checking if already present or not
            if (mpp.containsKey(s.charAt(right))) {
                 // if already present then change the position of
                 // left pointer ahead of its last appearance
                left = Math.max(mpp.get(s.charAt(right)) + 1, left);
            }
           

            mpp.put(s.charAt(right), right); // if not present it will add new character with its index
            // if already present it will update the previous index of the character

            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }

    public static void main(String args[]) {
        String str = "";
        System.out.println("The length of the longest substring without repeating characters is " + solve(str));
    }
}