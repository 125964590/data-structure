package search.tree;

/**
 * @author zhengyi
 * @date 2018-12-04 17:09
 **/
public class BinaryTree {

    /**
     * Time complexity: O(n)
     */
    static class TreeNode {
        String data;
        TreeNode leftNode;
        TreeNode rightNode;

        TreeNode(String data, TreeNode leftNode, TreeNode rightNode) {
            this.data = data;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }

    private static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrder(node.leftNode);
        preOrder(node.rightNode);
    }

    private static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.leftNode);
        System.out.println(node.data);
        inOrder(node.rightNode);
    }

    private static void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.leftNode);
        postOrder(node.rightNode);
        System.out.println(node.data);
    }

    public static void main(String[] args) {
        //create tree
        TreeNode treeNode1 = new TreeNode("1", null, null);
        TreeNode treeNode2 = new TreeNode("2", treeNode1, null);
        TreeNode treeNode3 = new TreeNode("3", treeNode2, null);
        TreeNode treeNode4 = new TreeNode("4", null, null);
        TreeNode treeNode5 = new TreeNode("5", null, null);
        TreeNode treeNode6 = new TreeNode("6", null, treeNode3);
        TreeNode treeNode7 = new TreeNode("7", treeNode4, null);
        TreeNode treeNode8 = new TreeNode("8", null, treeNode6);
        TreeNode treeNode9 = new TreeNode("9", treeNode7, treeNode5);
        TreeNode treeNode10 = new TreeNode("10", treeNode9, treeNode8);
        preOrder(treeNode10);
        inOrder(treeNode10);
        postOrder(treeNode10);
    }
}







