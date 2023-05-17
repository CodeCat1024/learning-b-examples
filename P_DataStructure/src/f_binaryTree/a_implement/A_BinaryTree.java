package f_binaryTree.a_implement;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的实现
 */
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

    // 前序遍历（递归）
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
    // 前序遍历（非递归）
    public void preOrder2(TreeNode root) {

    }


    // 中序遍历（递归）
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    // 中序遍历（非递归）
    public void inOrder2(TreeNode root) {

    }
    // 后序遍历 左子树 右子树 根
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
    // 后序遍历（非递归）
    public void postOrder2(TreeNode root) {

    }

    // 获取树中节点的个数（时间复杂度O(N)，空间复杂度O(logN)（以2为底））
    public int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSize = size(root.left);
        int rightSize = size(root.right);
        return leftSize + rightSize + 1;
    }
    // 获取树中节点的个数2（成员变量，但多次遍历的话次数就会叠加）
    public int nodeSize;
    public void size2(TreeNode root) {
        if (root == null){
            return;
        }
        nodeSize++;
        size2(root.left);
        size2(root.right);
    }
    // 获取叶子节点的个数
    public int getLeafNodeCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        int leftSize = getLeafNodeCount(root.left);
        int rightSize = getLeafNodeCount(root.right);

        return leftSize + rightSize;
    }
    // 获取叶子节点的个数（成员变量，但多次遍历的话次数就会叠加）
    public int leafSize;
    public void getLeafNodeCount2(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafSize++;
        }
        getLeafNodeCount2(root.left);
        getLeafNodeCount2(root.right);
    }
    // 获取第 k 层节点的个数
    public int getKLevelNodeCount(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        int leftSize = getKLevelNodeCount(root.left, k - 1);
        int rightSize = getKLevelNodeCount(root.right, k - 1);
        return leftSize + rightSize;
    }
    // 获取二叉树的高度 / 深度（左树的高度 + 右树的高度 + 1（根节点））
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return (getHeight(root.left) > getHeight(root.right)) ? (getHeight(root.left) + 1) : (getHeight(root.right) + 1);
    }
    // 获取二叉树的高度 / 深度2（时间复杂度O(N)，空间复杂度(输的高度)）
    public int getHeight2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return (leftHeight > rightHeight) ? (leftHeight + 1) : (rightHeight + 1);
    }
    // 检测值为 value 的元素是否存在
    public TreeNode find(TreeNode root, char val) {
        if (root == null) {
            return null;
        }
        if (root.val == val ) {
            return root;
        }
        TreeNode leftTree = find(root.left, val);
        if (leftTree != null) {
            return leftTree;
        }
        TreeNode rightTree = find(root.right, val);
        if (rightTree != null) {
            return rightTree;
        }
        return null; // 没有找到
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

        System.out.println(a_binaryTree.size(root));
        a_binaryTree.size2(root);
        System.out.println(a_binaryTree.nodeSize);
        a_binaryTree.size2(root);
        System.out.println(a_binaryTree.nodeSize);

        System.out.println("叶子节点个数为：");
        System.out.println(a_binaryTree.getLeafNodeCount(root));

        a_binaryTree.getLeafNodeCount2(root);
        System.out.println(a_binaryTree.leafSize);
        a_binaryTree.getLeafNodeCount2(root);
        System.out.println(a_binaryTree.leafSize);

        System.out.println("第k层的节点个数为：" + a_binaryTree.getKLevelNodeCount(root, 3));
        System.out.println("树的高度为：" + a_binaryTree.getHeight(root));

        System.out.println("查找A节点：" + a_binaryTree.find(root, 'A').val);

    }
}
