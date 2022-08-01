import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = matrix[0].length;
        int[][] left = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }

            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }


        int res = 0;
        Deque<Integer> queue = new ArrayDeque<Integer>();

        for (int j = 0; j < col; j++) {
            int[] low = new int[row];
            int[] up = new int[row];
            for (int i = 0; i < row; i++) {
                while (!queue.isEmpty() && left[queue.peek()][j] >= left[i][j]) {
                    queue.pop();
                }
                low[i] = queue.isEmpty() ? -1 : queue.peek();
                queue.push(i);
            }
            queue.clear();
            for (int i = row - 1; i >= 0; i--) {
                while (!queue.isEmpty() && left[queue.peek()][j] >= left[i][j]) {
                    queue.pop();
                }
                up[i] = queue.isEmpty() ? row : queue.peek();
                queue.push(i);
            }
            queue.clear();
            for (int i = 0; i < row; i++) {
                res = Math.max(res, left[i][j] * (up[i] - low[i] - 1));
            }
        }
        return res;

    }

    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        stack = new ArrayDeque<>();
        stack.offer(1);
        stack.offer(2);
        stack.offer(3);
        System.out.println(stack.poll());
        System.out.println(stack.poll());
        System.out.println(stack.poll());


    }
}
