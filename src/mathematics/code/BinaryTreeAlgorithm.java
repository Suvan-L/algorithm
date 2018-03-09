package mathematics.code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * �������㷨
 *      - [?] ���������������
 *      - [?] �����������С���
 *      - [?] ��������нڵ�ĸ���
 *      - [?] ���������Ҷ�ӽڵ�ĸ���
 *      - [?] ��������е� k ��ڵ�ĸ���
 *      - [?] �ж϶������Ƿ���ƽ�������
 *      - [?] �ж϶������Ƿ�����ȫ������
 *      - [?] �ж������������Ƿ���ȫ��ͬ
 *      - [?] �ж������������Ƿ�Ϊ����
 *      - [?] ��ת������
 *      - [?] ������ǰ�����
 *      - [?] �������������
 *      - [?] �������������
 *
 * �������ڣ�2018.03.05
 * �����£�2018.03.06
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
     * ������
     */
    public static void main(String [] args) {
        int [] values = {1, 2, 3, 4, 5, 6, 7};
    }


    /*
     * ***********************************************
     * �����������Ŀ
     * ***********************************************
     */

    /**
     * ���������������
     *
     * @param node ���ڵ�ڵ�
     * @return int ��������������
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
     * �����������С���
     *      - ���ܳ���б���������һ��Ϊ�գ�ֻ��һ���нڵ�
     *
     * @param node ���ڵ�
     * @return int ���������������
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
     * ��������нڵ�ĸ���
     *
     * @param node ���ڵ�
     * @return int �������нڵ�ĸ���
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
     * ���������Ҷ�ӽڵ�ĸ���
     *
     * @param node ���ڵ�
     * @return int ��������Ҷ�ӽڵ�ĸ���
     */
    private int countLeafNode(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return node.left == null && node.right == null
                ? 1 : this.countLeafNode(node.left) + this.countLeafNode(node.right);
    }

    /**
     * ��������е� k ��ڵ�ĸ���
     *
     * @param node ���ڵ�
     * @return int �������е� k ��Ľڵ����
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
     * �ж϶������Ƿ���ƽ�������
     *
     * @param node ���ڵ�
     * @return boolean �жϽ��
     */
    private boolean isBalanceTree(TreeNode node) {
        return this.getMaxDepthForIsBalanceTree(node) != -1;
    }

    /**
     * ��ȡ�����ȣ����� isBalanceTree() �ж�
     *      - ���� -1 ���ʾ��ƽ��
     *      - ÿ���ڵ�����������ĸ߶������� 1
     *
     * @param node ���Ľڵ�
     * @return int ���ؽڵ㳤�� or -1
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
     * �ж϶������Ƿ�Ϊ��ȫ������
     *
     * @param node ���ڵ�
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
                    //only have left node, pass�� continue to find child node
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
     * �ж������������Ƿ���ȫ��ͬ
     *
     * @param t1 ������ 1
     * @param t2 ������ 2
     * @return boolean �жϽ��
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
     * �ж������������Ƿ�Ϊ����
     *
     * @param t1 ������ 1
     * @param t2 ������ 2
     * @return boolean �жϽ��
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
     * ��ת������
     *      - ��ͨ������ or ���������
     *
     * @param node ���ڵ�
     * @return TreeNode ��ת�����
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
     * ��������ǰ�����
     *      - �����ⷨ
     *      - �� -> �� -> ��
     *
     * @param node ���ڵ�
     * @return ArrayList ������ǰ�������������
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
     * ��������ǰ�����
     *      - �ݹ�ⷨ
     *      - �� -> �� -> ��
     *
     * @param node ���ڵ�
     * @return ArrayList ������ǰ������������
     */
    private ArrayList<Integer> preOrderTreeByRecurse(TreeNode node) {
        ArrayList<Integer> resultList = new ArrayList<>();
        this.preOrderTreeRecurse(node, resultList);
        return resultList;
    }

    /**
     * ǰ������������ݹ����
     *
     * @param node �ڵ�
     * @param resultList �������
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
     * �������������
     *
     * @param node ���ڵ�
     * @return ArrayList ��������������������
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
     * ��������������
     *
     * @param node ���ڵ�
     * @return ArrayList �����������������
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
