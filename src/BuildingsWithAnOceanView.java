import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BuildingsWithAnOceanView {
    public static List<Integer> findBuildingIndex(int[] arr) {
        //from right to left to count
        int highest = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > highest) {
                ans.add(0, i);
                highest = arr[i];
            }
        }
        return ans;
    }

    public static Stack<Integer> findBuildingIndex1(int[] arr) {
        //from left to right
        Stack<Integer> ansStack = new Stack<>();
        ansStack.add(0);
        for (int i = 0; i < arr.length; i++) {
            while (!ansStack.empty() && arr[i] >= arr[ansStack.peek()]) {
                ansStack.pop();
            }
            ansStack.push(i);
        }
        return ansStack;
    }

    public static void main(String[] args) {
        int[] ex1 = {4, 2, 3, 1};
        int[] ex2 = {4, 3, 2, 1};
        int[] ex3 = {1, 3, 2, 4};
        int[] ex4 = {2, 2, 2, 2};
        // System.out.println(findBuildingIndex(ex1));
        //System.out.println(findBuildingIndex(ex2));
        //System.out.println(findBuildingIndex(ex3));
        //System.out.println(findBuildingIndex(ex4));

        System.out.println(findBuildingIndex1(ex1));
        System.out.println(findBuildingIndex1(ex2));
        System.out.println(findBuildingIndex1(ex3));
        System.out.println(findBuildingIndex1(ex4));

    }

}
