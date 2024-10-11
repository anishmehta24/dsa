import java.util.HashMap;

public class anagram {
    public static void main(String[] args) {
        String s ="silent";
        String t = "listen";
        System.out.println(isAnagram(s,t));

    }

    static HashMap<Character,Integer> makeFreqMap(String str)
    {
        HashMap<Character,Integer> mp = new HashMap<>();
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            if(!mp.containsKey(ch))
            {
                mp.put(ch,1);
            }
            else
            {
                mp.put(ch, mp.get(ch)+1);
            }
        }
        return mp;
    }

    public static boolean isAnagram(String s,String t)
    {
        if(s.length()!=t.length())
        return false;
        HashMap <Character,Integer> mp1 = makeFreqMap(s);
        HashMap <Character,Integer> mp2 = makeFreqMap(t);
        return mp1.equals(mp2);
    }
}
