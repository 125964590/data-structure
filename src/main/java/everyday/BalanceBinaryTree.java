package everyday;

/**
 * @author jbzm
 * @date 8/18/20 12:01 AM
 **/
public class BalanceBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalance(root, 1) != -1;
    }

    public int isBalance(TreeNode root, int high) {
        int left = high;
        int right = high;
        if (root.left != null) {
            left = isBalance(root.left, high + 1);
            if (left == -1) {
                return -1;
            }
        }

        if (root.right != null) {
            right = isBalance(root.right, high + 1);
            if (right == -1) {
                return -1;
            }
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
        BalanceBinaryTree balanceBinaryTree = new BalanceBinaryTree();
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(4);
        boolean balanced = balanceBinaryTree.isBalanced(treeNode);
        System.out.println(balanced);
    }
}