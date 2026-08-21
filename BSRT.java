import java.util.*;

public class BSRT {

    // Definition of TreeNode
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {

        public List<Integer> rightSideView(TreeNode root) {

            List<Integer> result = new ArrayList<>();

            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {

                int levelSize = queue.size();

                for (int i = 0; i < levelSize; i++) {

                    TreeNode current = queue.poll();

                    // Last node at this level
                    if (i == levelSize - 1) {
                        result.add(current.val);
                    }

                    if (current.left != null) {
                        queue.offer(current.left);
                    }

                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {

        /*
                 1
                / \
               2   3
                \   \
                 5   4
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        Solution solution = new Solution();

        List<Integer> answer = solution.rightSideView(root);

        System.out.println("Right Side View: " + answer);
    }
}
