/*Input: [1, 3, 5, 7, 9]
values	   location(from, to)	Velocity
[1, 3, 5]	    (0,2)	            2
[3, 5, 7]	    (1,3)	            2
[5, 7, 9]	    (2,4)	            2
[1, 3, 5, 7, 9]	(0,4)	            2
[1, 3, 5, 7]	(0,3)	            2
[3, 5, 7, 9]	(1,4)	            2
Output: 6 */

/*Input: [7, 7, 7, 7]
values	    location(from, to)	   Velocity
[7, 7, 7, 7]	(0,3)	              0
[7, 7, 7]	    (1,3)	              0
[7, 7, 7]	    (0,2)	              0
Output: 3 */


public class FindEqualPeriods {
    public static int particleVelocity(int[] particles) {
        int firstDiff = 0;
        int tempCount = 0;
        int ans = 0;
        for (int i = 0; i < particles.length - 2; i++) {
            firstDiff = particles[i + 1] - particles[i];
            if (firstDiff == particles[i + 2] - particles[i + 1]) {
                tempCount += 1;
                for (int j = i + 2; j < particles.length - 1; j++) {
                    if (particles[j + 1] - particles[j] == firstDiff) {
                        tempCount += 1;
                    } else {
                        break;
                    }
                }
                ans += tempCount;
                tempCount = 0;
            }
        }
        if (ans == 0) {
            return -1;
        } else {
            return ans;
        }
    }


    public static void main(String[] args) {
        int[] ex = {1, 3, 5, 7, 9};
        int[] ex1 = {-1, 1, 3, 3, 3, 2, 3, 2, 1, 0};
        int[] ex3 = {-1, 1, 4, 8, 16};

        System.out.println(particleVelocity(ex));
        System.out.println(particleVelocity(ex1));
        System.out.println(particleVelocity(ex3));
    }
}
