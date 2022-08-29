
public class SumOfSubarrayRanges {
    public static long findAllSubArr(int[] ex){
        int start = 0;
        int end = 0;
        int movingPointer = 0;
        long totalSum =0;
        int currentRange =0;
        int smallest = Integer.MAX_VALUE;
        int biggest = Integer.MIN_VALUE;

        for(start = 0;start < ex.length; start ++){
            for(end = start; end < ex.length; end++){
                for(movingPointer = start; movingPointer<= end;movingPointer++){
                    System.out.println(ex[movingPointer]);
                    smallest = Math.min(smallest,ex[movingPointer]);
                    biggest = Math.max(biggest,ex[movingPointer]);
                }
                currentRange = biggest -smallest;
                totalSum += currentRange;
                System.out.println(" ..."+currentRange);
                System.out.println(" ..."+totalSum);
                smallest = Integer.MAX_VALUE;
                biggest = Integer.MIN_VALUE;
                System.out.println("\n");
            }
        }
        return totalSum;
    }
     public long findAllSubArr1(int[] nums){

        return 1;
     }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(findAllSubArr(arr));
    }
}
