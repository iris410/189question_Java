public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    public static int minDeletions(String s) {
        int[] frequency = new int[26];
        char[] chars = s.toCharArray();
        for (char ele : chars) {
            frequency[ele - 'a']++;
        }
        for(int e:frequency){
            System.out.println(e);
        }
        int ans = 0;
        int i = 0;
        int j = 0;
        while (i < 26) {
            for (j = 0; j < 26; j++) {
                if (i != j && frequency[i] != 0 && frequency[i]==frequency[j]) {
                    frequency[i]--;
                    ans++;
                    break;
                }
            }
            if (j == 26) {
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String ex1 = "aab";
        String ex2 = "aaabbbcc";
        String ex3 = "ceabaacb";
        //System.out.println(minDeletions(ex1));
       // System.out.println(minDeletions(ex2));
        System.out.println(minDeletions(ex3));

    }
}
