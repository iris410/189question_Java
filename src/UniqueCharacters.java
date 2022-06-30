import java.util.Arrays;

public class UniqueCharacters {
    public static boolean isUniqueChar(String str) {
        boolean[] buffer = new boolean[128];
        Arrays.fill(buffer, false);

        for (int i = 0; i < str.length(); i++) {
            int var = str.charAt(i);
            if (buffer[var]) {
                return false;
            }
            buffer[var] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        String ep = "happy day";
        System.out.println(isUniqueChar(ep));

    }

}