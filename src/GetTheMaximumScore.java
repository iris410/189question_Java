import java.util.Arrays;

/*
Step1: While not reach end of any one of two arrays, compare each pairs two numbers pointed by two array pointers.
every time we move the pointer from smaller number, because two arrays are sorted.
sum the number in current index
compare two sum when two pointer pointing two number. add the bigger sum into the final answer.
update the current sum of each array to 0, and repeat the previous process.
Step2: Determine which condition break the loop.

return answer if reach both end of the arrays
return answer add rest of the unfinished array if only reached end of one array
 */
public class GetTheMaximumScore {
    public int maxSum(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        long sum1 = 0;//use long,the result may be very big mentioned by question
        long sum2 = 0;
        long ansSum = 0;
        int pointer1 = 0;
        int pointer2 = 0;

        while (pointer1 != len1 && pointer2 != len2) {
            if (nums1[pointer1] < nums2[pointer2]) {
                sum1 += nums1[pointer1];// sum1 += nums1[pointer1++];
                pointer1++;
            } else if (nums1[pointer1] > nums2[pointer2]) {
                sum2 += nums2[pointer2];// sum2 += nums2[pointer2++];
                pointer2++;
            } else {
                ansSum += Math.max(sum1, sum2) + nums1[pointer1];
                pointer1++;
                pointer2++;
                sum1 = 0;
                sum2 = 0;
            }
        }
        while (pointer1 != len1) {
            sum1 += nums1[pointer1++];
        }
        while (pointer2 != len2) {
            sum2 += nums2[pointer2++];
        }
         ansSum += Math.max(sum1,sum2);
        return (int)(ansSum % (Math.pow(10,9)+7));
    }

    public static void main(String[] args) {
        int[] num1 = {2,4,5,8,10};
        int[] num2 = {4,6,8,9};
        GetTheMaximumScore ex = new GetTheMaximumScore();
        System.out.println(ex.maxSum(num1,num2));
    }
}
