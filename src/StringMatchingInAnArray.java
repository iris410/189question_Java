import java.util.*;

public class StringMatchingInAnArray {

    public static int isSubstring(String a, String b) {
        return a.indexOf(b);//O(m*n)
    }

    public static List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                //System.out.println(isSubstring(words[i], words[j]));
                if (isSubstring(words[i], words[j]) >= 0 && i != j && !ans.contains(words[j])) {
                    System.out.println(words[j]);
                    ans.add(words[j]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] ex1 = {"mass", "as", "hero", "superhero"};
        String[] ex2 = {"leetcode", "et", "code"};
        String[] ex3 = {"blue", "green", "bu"};
        String[] ex4 = {"leetcoder", "leetcode", "od", "hamlet", "am"};
        //System.out.println(stringMatching(ex1));
        // System.out.println(stringMatching(ex2));
        //System.out.println(stringMatching(ex3));
        System.out.println(stringMatching(ex4));

    }
}
