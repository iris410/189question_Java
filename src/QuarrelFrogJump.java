//Time complexity:O(n^2),for loop go through every element in the array, the while loop is nested in the for loop
//Space complexity:O(i), only 4 variables are created.
public class QuarrelFrogJump {

    public int solution(int[] blocks) {
        // how to know where is the optimal starting block?
        //from the lowest position to all
        //how to jump?
        //if from end or starting of the array,only one frog move
        //if from mid, two jump to two direction if possible,so check both side, and not out of bound
        int ansDistance = 0;
        for (int i = 0; i < blocks.length; i++) {
            int totalDistance = 0;
            int goLeftIndex = i;
            while (goLeftIndex > 0 && blocks[goLeftIndex - 1] >= blocks[goLeftIndex]) {
                goLeftIndex--;
            }
            int goRightIndex = i;
            while (goRightIndex + 1 < blocks.length && blocks[goRightIndex + 1] >= blocks[goRightIndex]) {
                goRightIndex++;
            }

            totalDistance = goRightIndex - goLeftIndex + 1;
            ansDistance = Math.max(ansDistance, totalDistance);
        }
        return ansDistance;
    }
    public int solution2(int[] blocks){
        int left=0;
        int right=0;
        int nextLeft=0;
        int ans=0;
        if(blocks.length == 1){
            return 1;
        }
        for(int i=1; i<blocks.length; i++){
            if(blocks[i-1] < blocks[i]){
                //array goes up, shrink nextLeft (used at next calc)
                nextLeft=i;
            }
            else if(blocks[i-1]==blocks[i]) {
                //array no change
                right=i-1;
            }
            else{
                //array goes down, cannot expand window any further
                right=i-1;

                //calc distance
                int dist = right-left+1;
                ans = Math.max(ans,dist);
                //update left to nextLeft, new left border of window
                left=nextLeft;
            }
        }
        //calc distance
        right=blocks.length-1;
        int dist = right-left+1;
        ans = Math.max(ans,dist);
        return ans;
    }

    public static void main(String[] args) {
        int[] ex1 = {2, 6, 8, 5}; //return 3;
        int[] ex2 = {1, 5, 5, 2, 6}; //return 4;
        QuarrelFrogJump temp = new QuarrelFrogJump();
        System.out.println(temp.solution(ex1));
        System.out.println(temp.solution(ex2));
        System.out.println(temp.solution2(ex1));
        System.out.println(temp.solution2(ex2));

    }
}
