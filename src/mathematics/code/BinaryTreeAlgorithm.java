package mathematics.code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树算法
 *      - [?] 求二叉树的最大深度
 *      - [?] 求二叉树的最小深度
 *      - [?] 求二叉树中节点的个数
 *      - [?] 求二叉树中叶子节点的个数
 *      - [?] 求二叉树中第 k 层节点的个数
 *      - [?] 判断二叉树是否是平衡二叉树
 *      - [?] 判断二叉树是否是完全二叉树
 *      - [?] 判断两个二叉树是否完全相同
 *      - [?] 判断两个二叉树是否互为镜像
 *      - [?] 翻转二叉树
 *      - [?] 二叉树前序遍历
 *      - [?] 二叉树中序遍历
 *      - [?] 二叉树后序遍历
 *
 * 创建日期：2018.03.05
 * 最后更新：2018.03.06
 *
 * @author Suvan
 */
public class BinaryTreeAlgorithm {

    private class TreeNode {
        int val;

        TreeNode left;
        TreeNode right;

        TreeNode (int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 主函数
     */
    public static void main(String [] args) {
        int [] values = {1, 2, 3, 4, 5, 6, 7};
    }


    /*
     * ***********************************************
     * 二叉树相关题目
     * ***********************************************
     */

    /**
     * 求二叉树的最大深度
     *
     * @param node 根节点节点
     * @return int 二叉树的最大深度
     */
    private int getMaxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int maxLeft = this.getMaxDepth(node.left);
        int maxRight = this.getMaxDepth(node.right);
        return Math.max(maxLeft, maxRight) + 1;
    }

    /**
     * 求二叉树的最小深度
     *      - 可能出现斜树的情况，一边为空，只有一边有节点
     *
     * @param node 根节点
     * @return int 二叉树的最下深度
     */
    private int getMinDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int minLeft = this.getMinDepth(node.left);
        int minRight = this.getMinDepth(node.right);

        return minLeft == 0 || minRight == 0 ? minLeft + minRight + 1 : Math.min(minLeft , minRight) + 1;
    }

    /**
     * 求二叉树中节点的个数
     *
     * @param node 根节点
     * @return int 二叉树中节点的个数
     */
    private int countNode(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int numLeft = this.countNode(node.left);
        int numRight = this.countNode(node.right);
        return numLeft + numRight + 1;
    }

    /**
     * 求二叉树中叶子节点的个数
     *
     * @param node 根节点
     * @return int 二叉树中叶子节点的个数
     */
    private int countLeafNode(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return node.left == null && node.right == null
                ? 1 : this.countLeafNode(node.left) + this.countLeafNode(node.right);
    }

    /**
     * 求二叉树中第 k 层节点的个数
     *
     * @param node 根节点
     * @return int 二叉树中的 k 层的节点个数
     */
    private int countLayerNode(TreeNode node, int k) {
        if (node == null || k < 1) {
            return 0;
        }

        if (k == 1) {
            return 1;
        }

        int numLeft = this.countLayerNode(node.left, k - 1);
        int numRight = this.countLayerNode(node.right, k - 1);
        return numLeft + numRight;
    }

    /**
     * 判断二叉树是否是平衡二叉树
     *
     * @param node 根节点
     * @return boolean 判断结果
     */
    private boolean isBalanceTree(TreeNode node) {
        return this.getMaxDepthForIsBalanceTree(node) != -1;
    }

    /**
     * 获取最大深度，用于 isBalanceTree() 判断
     *      - 返回 -1 则表示不平衡
     *      - 每个节点的左右子数的高度相差不超过 1
     *
     * @param node 树的节点
     * @return int 返回节点长度 or -1
     */
    private int getMaxDepthForIsBalanceTree(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int maxLeft = this.getMaxDepthForIsBalanceTree(node.left);
        int maxRight = this.getMaxDepthForIsBalanceTree(node.right);
        return maxLeft == -1 || maxRight == -1 || Math.abs(maxLeft - maxRight) > -1
                ? -1 : Math.max(maxLeft, maxRight) + 1;
    }

    /**
     * 判断二叉树是否为完全二叉树
     *
     * @param node 根节点
     */
    private boolean isCompleteTree(TreeNode node) {
        if (node == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        boolean result = true;
        boolean hasChildNode = false;
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.remove();
            if (hasChildNode) {
                if (currentNode.left != null && currentNode.right != null) {
                    result = false;
                    break;
                }
            } else {
                if (currentNode.left != null && currentNode.right != null) {
                    queue.add(currentNode.left);
                    queue.add(currentNode.right);
                } else if (currentNode.left != null && currentNode.right == null) {
                    //only have left node, pass， continue to find child node
                    queue.add(currentNode.left);
                    hasChildNode = true;
                } else if (currentNode == null && currentNode != null) {
                    //can not only have right node
                    result = false;
                    break;
                } else {
                    //left node == null & right node == null
                    hasChildNode = true;
                }
            }
        }

        return false;
    }

    /**
     * 判断两个二叉树是否完全相同
     *
     * @param t1 二叉树 1
     * @param t2 二叉树 2
     * @return boolean 判断结果
     */
    private boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        }

        if (t1.val != t2.val) {
            return false;
        }

        boolean isLeftNode = this.isSameTree(t1.left, t2.left);
        boolean isRightNode = this.isSameTree(t1.left, t2.right);
        return isLeftNode & isRightNode;
    }

    /**
     * 判断两个二叉树是否互为镜像
     *
     * @param t1 二叉树 1
     * @param t2 二叉树 2
     * @return boolean 判断结果
     */
    private boolean isMirrorTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        }

        if (t1.val != t2.val) {
            return false;
        }

        return this.isMirrorTree(t1.left, t2.right) && this.isMirrorTree(t1.right, t2.left);
    }

    /**
     * 翻转二叉树
     *      - 普通二叉树 or 镜像二叉树
     *
     * @param node 根节点
     * @return TreeNode 翻转后的树
     */
    private TreeNode turnTree(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode leftNode = this.turnTree(node.left);
        TreeNode rightNode = this.turnTree(node.right);
        node.left = rightNode;
        node.right = leftNode;

        return node;
    }

    /**
     * 二叉树的前序遍历
     *      - 迭代解法
     *      - 根 -> 左 -> 右
     *
     * @param node 根节点
     * @return ArrayList 二叉树前序遍历后结果集合
     */
    private ArrayList<Integer> preOrderTree(TreeNode node) {
        if (node == null) {
            return new ArrayList<>(0);
        }

        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            list.add(treeNode.val);

            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
        }

        return list;
    }

    /**
     * 二叉树的前序遍历
     *      - 递归解法
     *      - 根 -> 左 -> 右
     *
     * @param node 根节点
     * @return ArrayList 二叉树前序遍历结果集合
     */
    private ArrayList<Integer> preOrderTreeByRecurse(TreeNode node) {
        ArrayList<Integer> resultList = new ArrayList<>();
        this.preOrderTreeRecurse(node, resultList);
        return resultList;
    }

    /**
     * 前序遍历二叉树递归操作
     *
     * @param node 节点
     * @param resultList 结果集合
     */
    private void preOrderTreeRecurse(TreeNode node, ArrayList<Integer> resultList) {
        if (node == null) {
            return;
        }

        resultList.add(node.val);
        this.preOrderTreeRecurse(node.left, resultList);
        this.preOrderTreeRecurse(node.right, resultList);
    }

    /**
     * 二叉树中序遍历
     *
     * @param node 根节点
     * @return ArrayList 二叉树中序遍历结果集合
     */
    private ArrayList<Integer> inOrderTree(TreeNode node) {
        if (node == null) {
            return new ArrayList<>(0);
        }

        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        TreeNode currentNode = node;
        while (!stack.isEmpty()) {
            while (currentNode != null) {
                stack.add(currentNode);
                currentNode = currentNode.left;
            }

            //find, but no remove
            currentNode = stack.peek();

            stack.pop();
            list.add(currentNode.val);

            currentNode = currentNode.right;
        }

        return list;
    }

    /**
     * 二叉树后续遍历
     *
     * @param node 根节点
     * @return ArrayList 二叉树后序遍历集合
     */
    private ArrayList<Integer> postOrderTree(TreeNode node) {
        if (node == null) {
            return new ArrayList<>(0);
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(this.postOrderTree(node.left));
        list.addAll(this.postOrderTree(node.right));
        list.add(node.val);

        return list;
    }
}
