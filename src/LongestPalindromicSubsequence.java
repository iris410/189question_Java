public class LongestPalindromicSubsequence {
   // static String[][] dp;

    public static String helper(String s, int i, int j) {
        String[][] dp = new String[s.length()][s.length()];
        if (s.equals("")) return "";
        if (i > j) {
            return "";
        }
        if (i == j) {
            return s.charAt(i) + "";
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (s.charAt(i) == s.charAt(j)) {
            return s.charAt(i) + helper(s, i + 1, j - 1) + s.charAt(j);
        }
        String left = helper(s, i, j - 1);
        String right = helper(s, i + 1, j);

        if (left.length() > right.length()) {
            dp[i][j] = left;
        } else {
            dp[i][j] = right;
        }
        return dp[i][j];
    }

    public static int longestPaSubsequence(String a) {
        //dp = new String[a.length()][a.length()];
        int i, j;
        String ans = "";
        for (i = 0; i < a.length(); i++) {
            for (j = i; j < a.length(); j++) {
                if (j - i + 1 < ans.length()) {
                    continue;
                }
                if (helper(a, i, j).length() > ans.length()) {
                    ans = helper(a, i, j);
                }
            }
        }
        return ans.length();
    }
//    public static String longestPaSubsequence(String a) {
//        dp = new String[a.length()][a.length()];
//        int i, j;
//        String ans = "";
//        for (i = 0; i < a.length(); i++) {
//            for (j = i; j < a.length(); j++) {
//                if(j-i+1 < ans.length()){
//                    continue;
//                }
//                if(helper(a, i, j).length()>ans.length()){
//                    ans = helper(a, i, j);
//                }
//            }
//        }
//        return ans;
//    }

    public static void main(String[] args) {
        String s = "cbbd";
        //System.out.println(longestPaSubsequence(s));
        System.out.println(helper(s,0,s.length()-1));
    }
}
