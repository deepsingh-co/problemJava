public class treenode {
    
}
public class treenode {

    // Definition of TreeNode
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int result = 0;

    public static int averageOfSubtree(TreeNode root) {
        result = 0;
        dfs(root);
        return result;
    }

    // Returns [sum, count] for the subtree
    static int[] dfs(TreeNode node) {

        // Base case
        if (node == null) {
            return new int[]{0, 0};
        }

        // Get sum and count from left subtree
        int[] left = dfs(node.left);

        // Get sum and count from right subtree
        int[] right = dfs(node.right);

        // Calculate sum and count of current subtree
        int sum = node.val + left[0] + right[0];
        int count = 1 + left[1] + right[1];

        // Integer division automatically rounds down
        int average = sum / count;

        // Check if node value equals average
        if (node.val == average) {
            result++;
        }

        return new int[]{sum, count};
    }

    public static void main(String[] args) {

        /*
                 4
                / \
               8   5
              / \   \
             0   1   6
        */

        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(8);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);

        root.right.right = new TreeNode(6);

        int answer = averageOfSubtree(root);

        System.out.println("Number of nodes: " + answer);
    }
}
