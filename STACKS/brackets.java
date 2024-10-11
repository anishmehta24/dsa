import java.util.Scanner;
import java.util.Stack;

public class brackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
       System.out.println(isValid(s));
    }

    public static boolean isValid(String s)
    {
        Stack<Character> st = new Stack<>();
        for(int i =0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch=='('||ch=='{'||ch=='[')
            st.push(ch);
            else{
                if(st.size()==0)
                return false;
                else
                {
                    if(ch==')'&&st.peek()=='('||ch=='}'&&st.peek()=='{'||ch==']'&&st.peek()=='[')
                    st.pop();
                }       
            }
        }
        if(st.isEmpty())
        return true;
        else
        return false;
    }
}
