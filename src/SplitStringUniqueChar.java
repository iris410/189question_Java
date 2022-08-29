import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

//Time complexity:O(N)
//Space complexity:O(1), We use the hashset to store unique chars, and the size of which can never be bigger than 26, so O(1)
public class SplitStringUniqueChar {
    public static int solution(String S) {
        // we don't need to check null for S since the question says S size [1, 1 million]
        // use HashSet to store current substring, which gives O(1) time complexity to decide if next character is seen.
       HashSet<Character> temp = new HashSet<Character>();
        // count total amount substrings, at least there will be one because S is at least 1 character.
        int count = 1;
        // loop to visit each char in S once, time complexity O(N)
        for (char i : S.toCharArray()) {
            if (temp.contains(i)) {
                // if duplicate is found, we need to create a new substring for i(by count++), and clear temp buffer
                // for the next substring
                temp.clear();
                count++;
            }
            temp.add(i);
        }
        return count;
    }

    public static void main(String[] args) {
        var world = "world";
        var dddd = "dddd";
        var cycle = "cycle";
        var abba = "abba";
        ArrayList<String> cases = new ArrayList<String>();
        cases.add(world);
        cases.add(dddd);
        cases.add(cycle);
        cases.add(abba);

        for (String i : cases) {
            System.out.println(i + " " + solution(i));
        }
    }
}

//greedy algorithm --- min split
//no repeat --- set
//Time complexity:O(N) scan the array anyway, set operations are all O(1).