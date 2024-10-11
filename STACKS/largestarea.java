import java.util.*;
public class largestarea {

    
    public int maximalRectangle(char[][] matrix) {
        // int n = matrix.length;
        // int m = matrix[0].length;
        int arr[]= new int[m];
            for(int k=0;k<n;k++)
            {
                // arr[k]=(int)matrix[0][k];
                if(matrix[0][k]=='1')
                arr[k]=1;
                else
                arr[k]=0;
            }

            int max = largestRectangleArea(arr);
            for(int i =1;i<n;i++)
            {
                 for(int j=0;j<matrix[i].length;j++)
                 {
                    if(matrix[i][j]=='1')
                    {
                        arr[j]++;
                    }
                    else
                    arr[j]=0;
                 }
                 for(int j=0;j<matrix[i].length;j++)
                 {
                    System.out.print(arr[j]+" ");
                 }
                 System.out.println();

                 int curVal=largestRectangleArea(arr);
                 System.out.println(curVal);
                 max = Math.max(max,curVal);
             }
             return max;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack <Integer> st = new Stack<>();
        int[] nse = new int[n];
        int[] pse = new int[n];
        //calculate nse
        st.push(n-1);
        nse[n-1]=n;
        for(int i=n-2;i>=0;i--)
        {
            while(st.size()>0 && heights[st.peek()]>=heights[i])
            {
                st.pop();
            }
            if(st.size()==0) nse[i] = n;
            else nse[i] = st.peek();
            st.push(i);
 
        }

        while(st.size()>0) st.pop();
        //calculate previous smaller element
        st.push(0);
        pse[0]=-1;
        for(int i =1;i<=n-1;i++)
        {
            while(st.size()>0 && heights[st.peek()]>=heights[i])
            {
                st.pop();
            }
            if(st.size()==0) pse[i] = -1;
            else pse[i] = st.peek();
            st.push(i);
        }
        //maximum area of rectangle
        int max = -1;
        for(int i=0;i<n;i++)
        {
            int area = heights[i]*(nse[i]-pse[i]-1);
            max = Math.max(max,area);
        }
        return max;
    }


}