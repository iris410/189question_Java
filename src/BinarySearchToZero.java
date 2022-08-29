import java.util.Arrays;
import java.util.PriorityQueue;

public class BinarySearchToZero {

    public static Boolean searchToZero(int[] input, int startIndex) {
        if (input == null) {
            return false;
        }
        if (input.length <= startIndex || startIndex < 0) {
            return false;
        }
        int[] visited = new int[input.length];
        Arrays.fill(visited, 0);

        return bfs(input, startIndex, visited);
    }
    // bfs

    public static boolean bfs(int[] input, int startIndex, int[] visited) {
        int stepFromStartIndex = input[startIndex];
        int leftIndex = startIndex - stepFromStartIndex;
        int rightIndex = startIndex + stepFromStartIndex;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        if (input[startIndex] == 0)
            return true;

        while (true) {
            // if left child exists and is not visited, add it to queue
            if (0 <= leftIndex &&
                    leftIndex < input.length &&
                    visited[leftIndex] == 0) {
                queue.add(leftIndex);
            }
            // if right child exists and is not visited, add it to queue
            if (0 <= rightIndex &&
                    rightIndex < input.length &&
                    visited[rightIndex] == 0) {
                queue.add(rightIndex);
            }

            Integer pollResult = queue.poll();

            if (pollResult == null) {
                return false;
            } else if (input[pollResult] == 0) {
                return true;
            } else {
                startIndex = pollResult;
                visited[startIndex] = 1;
                leftIndex = startIndex - input[startIndex];
                rightIndex = startIndex + input[startIndex];
            }
        }
    }

    public static boolean bfs1(int[] input, int startIndex, int[] visited) {
        //add startIndex into the queue
        //if not pop out, then check if startIndex is goal, yes return true
        // no, and add its left child and right child
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        queue.add(startIndex);
        visited[startIndex] = 1;
        while (queue.size() != 0) {
            if (input[queue.poll()] == 0) {
                return true;
            } else {
                int leftChild = startIndex - input[startIndex];
                int rightChild = startIndex + input[startIndex];
                if (leftChild >= 0 && leftChild < input.length && visited[leftChild] == 0) {
                    queue.add(leftChild);
                }
                if (rightChild >= 0 && rightChild < input.length && visited[rightChild] == 0) {
                    queue.add(rightChild);
                }
            }
        }
        return false;
    }

    //dfs
    public static boolean dfs(int[] input, int startIndex, int[] visited) {
        if (startIndex < 0 || startIndex >= input.length) return false;
        int stepFromStartIndex = input[startIndex];

        // base case 1
        if (input[startIndex] == 0) {
            return true;
        }
        // base case 2
        else if (visited[startIndex] > 0) {
            return false;
        } else {
            visited[startIndex] = 1;
            return dfs(input, startIndex - stepFromStartIndex, visited) ||
                    dfs(input, startIndex + stepFromStartIndex, visited);
        }
    }

    public static void main(String[] args) {
        int[] input1 = {3, 4, 2, 3, 0, 3, 1, 2, 1};
        int startIndex1 = 7;
        boolean expectedResult1 = true;

        int[] input2 = {3, 2, 1, 3, 0, 3, 1, 2, 1};
        int startIndex2 = 2;
        boolean expectedResult2 = false;

        System.out.println("test1: expected: " + expectedResult1 + " actual: " + searchToZero(input1, startIndex1) + "\n");
        System.out.println("test2: expected: " + expectedResult2 + " actual: " + searchToZero(input2, startIndex2) + "\n");
    }
}
