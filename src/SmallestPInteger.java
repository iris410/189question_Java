import java.util.Arrays;

public class SmallestPInteger{
    public static void printArray(int[] a){
        for(int i = 0; i< a.length; i++){
            System.out.println(a[i]);
        }
    }
    public static int FindMissingPos(int[] A){
        Arrays.sort(A);
        int min = 1;
        for(int element : A){
            if(element == min){
                min++;
            }
        }
        return min;
    }
    public static int FindSmallest(int[] A) {
        Arrays.sort(A);
        printArray(A);
        int indexTemp = 0;
        int result = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                indexTemp = i;
                break;
            }
        }
        if (indexTemp == A.length - 1 || A[indexTemp] != 1) {
            return 1;
        } else {
            for (int j = indexTemp + 1; j < A.length; j++) {
                if (A[j] - A[indexTemp] > 1) {
                    return A[indexTemp] + 1;
                }
                indexTemp++;
            }
            result = 1 + A[A.length - 1];
            return result;
        }
    }
    public static void main(String[] args) {
        int[] temp = new int[6];
        temp[0] = 1;
        temp[1] = 2;
        temp[2] = 3;
        temp[3] = 4;
        temp[4] = 5;
        temp[5] = 6;

        //System.out.println(FindSmallest(temp));
        System.out.println(FindMissingPos(temp));

    }
}
