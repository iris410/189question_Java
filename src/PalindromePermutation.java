import java.util.HashMap;
import java.util.Locale;

public class PalindromePermutation {
    public static boolean isPalindromePermutation(String ex) {
        String example = ex.toLowerCase();
        char[] arr = example.toCharArray();
        HashMap<Character, Integer> dic = new HashMap<>();
        for (char element : arr) {
            if (Character.isLetter(element)) {
                if (dic.get(element) == null) {
                    dic.put(element, 1);
                } else {
                    dic.replace(element, dic.get(element) + 1);
                }
            }
        }
        System.out.println(dic);
        int numOfSingleChar = 0;
        for (Integer value : dic.values()) {
            if (value % 2 != 0) {
                numOfSingleChar++;
            }
        }
        return numOfSingleChar <= 1;
    }

    public static void main(String[] args) {
        //System.out.println(isPalindromePermutation("Tact Coa"));
        String s = "abc";
        System.out.println(s.substring(1));
    }
}

