package everyday;

/**
 * @author jbzm
 * @date 8/7/20 4:36 PM
 **/
public class CompareTree {


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }


    public static void main(String[] args) {
//        TreeNode treeNode1 = new TreeNode(3, new TreeNode(4, new TreeNode(1, null, new TreeNode(4)), new TreeNode(6)), new TreeNode(2, new TreeNode(3), new TreeNode(5)));
//        TreeNode treeNode2 = new TreeNode(3, new TreeNode(4, new TreeNode(1, null, new TreeNode(4)), new TreeNode(6)), new TreeNode(2, new TreeNode(3), new TreeNode(5)));
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(1, null, new TreeNode(2));
        CompareTree compareTree = new CompareTree();
        boolean sameTree = compareTree.isSameTree(treeNode1, treeNode2);
        System.out.println(sameTree);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}