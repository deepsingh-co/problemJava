import java.util.Stack;

public class Kth{

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {

            // Move to the leftmost node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Visit node
            current = stack.pop();
            k--;

            if (k == 0) {
                return current.val;
            }

            // Move to right subtree
            current = current.right;
        }

        return -1;
    }

    public static void main(String[] args) {

        // Create BST
        //
        //       5
        //      / \
        //     3   7
        //    / \
        //   2   4

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        int k = 3;

        int result = kthSmallest(root, k);

        System.out.println("Kth smallest value: " + result);
    }
}