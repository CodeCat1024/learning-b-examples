package f_tree;

import java.util.ArrayList;
import java.util.List;

public class A_BinaryTree {
    static class TreeNode {
        public char val;
        public TreeNode left; // 左孩子的引用
        public TreeNode right;// 右孩子的引用
        public TreeNode(char val) {
            this.val = val;
        }
    }
    public TreeNode createTree() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        return A;
    }

    // 前序遍历 根 左子树 右子树
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    // 前序遍历2（不太好，因为没有接收返回值）
    List<Character> ret = new ArrayList<>();
    public List<Character> preorderTraversal(TreeNode root) {
        if (root == null) {
            return ret;
        }
        ret.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return ret;
    }
    // 前序遍历3
    public List<Character> preorderTraversal2(TreeNode root) {
        List<Character> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        ret.add(root.val);
        List<Character> leftTree = preorderTraversal2(root.left);
        ret.addAll(leftTree);

        List<Character> rightTree = preorderTraversal2(root.right);
        ret.addAll(rightTree);

        return ret;
    }
    // 中序遍历 左子树 根 右子树
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    // 后序遍历 左子树 右子树 根
    void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
    // 获取树中节点的个数
    public int size(TreeNode root) {

    }

    public static void main(String[] args) {
        A_BinaryTree a_binaryTree = new A_BinaryTree();
        A_BinaryTree.TreeNode root = a_binaryTree.createTree();

        System.out.println("前序遍历的结果为：");
        a_binaryTree.preOrder(root);
        System.out.println();
        System.out.println("中序遍历的结果为：");
        a_binaryTree.inOrder(root);
        System.out.println();
        System.out.println("后序遍历的结果为：");
        a_binaryTree.postOrder(root);
        System.out.println();

        List<Character> ret = a_binaryTree.preorderTraversal2(root);
        System.out.println(ret);
    }
}
