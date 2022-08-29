import java.util.Arrays;
/*
Are all characters ASCII or Unicode?
Time complexity is O(n). where n is the length of the string.( O(C) / O(min(c,n)), C is the set of characters)
The space complexity is O(1).
 */
public class UniqueCharacters {
    public static boolean isUniqueChar(String str) {
        //immediately return false if the string length exceeds the number of unique characters.
        if(str.length() > 128) return false;

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
    /*
    Time Complexity: O(n^2)(str.length() - 1 + str.length() - 2 + ...+ 1 )
    Space Complexity: O(1)
     */
    public static boolean isUniqueCharNoAdditionalSpace(String str){
        for(int i = 0; i < str.length() - 1; i++){
            for (int j= i+1; j < str.length(); j++){
                if(str.charAt(i) == str.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }

    public static  boolean isUniqueCharSortStr(String str){
        String temp = str;
        temp = sortArray(temp);
        for (int i = 0; i < temp.length()-1; i++){
            if(temp.charAt(i) == temp.charAt(i+1)){
                return false;
            }
        }
        return true;
    }

    public static String sortArray(String str){
        String temp = str;
        char[] tempCharArray = temp.toCharArray();//str.toCharArray() method will include space
        Arrays.sort(tempCharArray);//here java use quicksort which the time complexity is 0(n log n)
        temp = new String(tempCharArray);
        return temp;
    }


    public static void main(String[] args) {
        String ep = "happy day";
        String ep1 = "AbcdeA";
        String ep2 ="abc def np";
        System.out.println(isUniqueChar(ep2));
        System.out.println(isUniqueCharNoAdditionalSpace(ep2));
        System.out.println(isUniqueCharSortStr(ep));
        System.out.println(isUniqueCharSortStr(ep2));

    }

}