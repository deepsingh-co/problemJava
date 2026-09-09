public class Flatten {

    // TreeNode class
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Flatten binary tree
    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode current = root;

        while (current != null) {

            if (current.left != null) {

                // Find the rightmost node in left subtree
                TreeNode predecessor = current.left;

                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }

                // Connect original right subtree
                predecessor.right = current.right;

                // Move left subtree to right
                current.right = current.left;
                current.left = null;
            }

            current = current.right;
        }
    }

    // Print flattened tree
    public static void printTree(TreeNode root) {
        TreeNode current = root;

        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.right;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   5
             / \   \
            3   4   6
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(6);

        // Flatten the tree
        flatten(root);

        // Print result
        printTree(root);
    }
}
