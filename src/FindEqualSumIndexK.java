import java.util.Arrays;

//Example 1:
//
//Input: A = [4, -1, 0, 3], B = [-2, 5, 0, 3]
//
//Output: 2
public class FindEqualSumIndexK {
    public int findIndex(int[] a, int[] b) {
        //find index fist half of two arrays equal
        int equalIndex = 0;
        int firstHalfSum1 = 0;
        int firstHalfSum2 = 0;
        int secondHalfSum1 = 0;
        int secondHalfSum2 = 0;

        for (int i = 0; i < a.length; i++) {
            firstHalfSum1 += a[i];
            firstHalfSum2 += b[i];
            if (firstHalfSum1 == firstHalfSum2) {
                equalIndex = i;
                for (int j = equalIndex + 1; j < a.length; j++) {
                    secondHalfSum1 += a[j];
                    secondHalfSum2 += b[j];
                }
                if (secondHalfSum1 == secondHalfSum2) {
                    break;
                }
            }
        }
        if (equalIndex == a.length - 1) {
            System.out.println("no result");
            return -1;
        } else {
            return equalIndex + 1;//+1 to represent normal counting number way
        }
    }

    public int update(int[] a, int[] b) {
        int equalIndex = 0;
        int firstHalfSum = 0;
        int secondHalfSum = 0;
        int sumOfFirstArr = Arrays.stream(a).sum();
        int sumOfSecondArr = Arrays.stream(b).sum();

        if (sumOfFirstArr != sumOfSecondArr) {
            return -1;
        }
        for (int i = 0; i < a.length; i++) {
            firstHalfSum += a[i];
            secondHalfSum += b[i];
            if (firstHalfSum == secondHalfSum) {
                equalIndex = i;
                break;
            }
        }
        if (equalIndex == a.length - 1) {
            return -1;
        }
        return equalIndex + 1;
    }

    public static void main(String[] args) {
        int[] a = {2, -2, -3, 3};
        int[] b = {0, 0, 4, -4};
        FindEqualSumIndexK ex = new FindEqualSumIndexK();
        System.out.println(ex.findIndex(a, b));
        System.out.println(ex.update(a, b));
    }
}
