import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MaxProductPalindromicSubsequences {
    public static boolean isPalindrome(String a) {
        StringBuilder strReverse = new StringBuilder();
        strReverse.append(a);
        return strReverse.reverse().toString().equals(a);
    }
    public static boolean isPalin(String a){
        int end = a.length() -1;
        int start = 0;
        while(start < end){
            if(a.charAt(start) != a.charAt(end)){
                return false;
            }
            start++;
            end --;
        }
        return true;
    }

    public static int maxProduct(String s) {
        HashMap<Integer, Integer> palindrome = new HashMap<>();
        int len = s.length();
        int ans = 0;
        for (int mask = 0; mask < (1 << len); mask++) {
            String temp = "";
            for (int i = 0; i < len; i++) {
                if ((mask & (1 << i)) != 0) {
                    temp += s.charAt(i);
                }
            }
            if (isPalindrome(temp)) {
                palindrome.put(mask, temp.length());
            }
        }

        for (int i : palindrome.keySet()) {
            for (int j : palindrome.keySet()) {
                if ((i & j) == 0) {
                    ans = Math.max(ans, palindrome.get(i) * palindrome.get((j)));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String ex = "accbcaxxcxx";
        System.out.println(maxProduct(ex));
    }
}
