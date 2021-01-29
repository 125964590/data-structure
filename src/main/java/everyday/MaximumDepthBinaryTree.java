package everyday;


import javax.swing.tree.TreeNode;

/**
 * @author jbzm
 * @date 7/28/20 9:48 AM
 **/
public class MaximumDepthBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return recursive(root) + 1;
        }
    }

    public int recursive(TreeNode root) {
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = recursive(root.left) + 1;
        }
        if (root.right != null) {
            right = recursive(root.right) + 1;
        }

        if (left > right) {
            return left;
        } else {
            return right;
        }

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        MaximumDepthBinaryTree maximumDepthBinaryTree = new MaximumDepthBinaryTree();
        TreeNode treeNode = new TreeNode(3);
        int[] a = new int[]{3, 9, 20, -1, -1, 15, 7};

        treeNode.left = new TreeNode(3);
        treeNode.right = null;
        treeNode.left.left = new TreeNode(29);
        treeNode.left.left = new TreeNode(42);
        treeNode.left.left.left = null;
        treeNode.left.left.right = new TreeNode(24);

        int i = maximumDepthBinaryTree.maxDepth(treeNode);
        System.out.println(i);
    }
}