import java.util.HashMap;

public class OneAway {
    public static boolean isOneAway(String a, String b) {

        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        HashMap<Character, Integer> dic = new HashMap();
        for (char element : arr1) {
            if (dic.get(element) == null) {
                dic.put(element, 1);
            } else {
                dic.replace(element, dic.get(element) + 1);
            }
        }
        System.out.println(dic);
        for (char e : arr2) {
            if (dic.get(e) == null) {
                dic.put(e, 1);
            } else {
                dic.replace(e, dic.get(e) - 1);
            }
            System.out.println(dic);
        }
        System.out.println(dic);
        int numOfZero = 0;
        int numOfOne = 0;
        int numOfNegOne = 0;
        int otherNum = 0;

        for (int value : dic.values()) {
            if (value == 0) {
                numOfZero++;
            } else if (value == 1) {
                numOfOne++;
            } else if (value == -1) {
                numOfNegOne++;
            } else otherNum++;
        }

        if(numOfZero == dic.size()){
            return true;
        }
        else if(numOfOne == 1 && numOfZero == dic.size()-1){
            return true;

        }
        else if(numOfNegOne == 1 && numOfZero == dic.size()-1){
            return true;
        }
        else if(numOfOne ==1 && numOfNegOne==1 &&numOfZero == dic.size()-2){
            return true;
        }
        else{
            return false;
        }
    }




    public static void main(String[] args) {
        String a = "pale";
        String b = "ple";
        System.out.println(isOneAway(a, b));
    }
}
