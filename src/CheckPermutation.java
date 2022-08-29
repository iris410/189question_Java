import java.util.Arrays;

public class CheckPermutation {
    public static boolean isPermutation(String a, String b) {
        //sort two string, java use quick sort which complexity is O(n logn)
        char[] temp1 = a.toCharArray();
        char[] temp2 = b.toCharArray();
        Arrays.sort(temp1);
        Arrays.sort(temp2);
        // compare
        return new String(temp1).equals(new String(temp2));
    }

    public static boolean isPermutationOne(String a, String b) {
        char[] stringOne = a.toCharArray();
        char[] stringTwo = b.toCharArray();
        int[] count = new int[128];
        Arrays.fill(count, 0);

        if (a.length() != b.length()) {
            return false;
        }

        for (int i = 0; i < a.length(); i++) {
            count[stringOne[i]]++;
            count[stringTwo[i]]--;
        }

        for (int j = 0; j < 128; j++) {
            if (count[j] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "dog";
        String b = "God";
        String c = "d o g";
        String d = "god";
        System.out.println(isPermutation(a, c));
        System.out.println(isPermutation(a, b));
        System.out.println(isPermutation(a, d));

        System.out.println(isPermutationOne(a, c));
        System.out.println(isPermutationOne(a, b));
        System.out.println(isPermutationOne(a, d));
    }
}
