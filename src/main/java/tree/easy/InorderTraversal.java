package tree.easy;

import tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * 二叉树中序遍历
 *
 * @author 谢子轩
 * @date 2021/11/01 07/56
 */

public class InorderTraversal {

    private List<Integer> res = new ArrayList<>();


    /**
     * 遍历思想
     * @param root
     * @return
     */
    public List<Integer> resolve(TreeNode root) {
        step(root);
        return res;
    }

    public void step(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            step(node.left);
            res.add(node.left.val);
        }
        res.add(node.val);
        if (node.right != null) {
            step(node.right);
            res.add(node.right.val);
        }
    }

    /**
     * 堆栈思想
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }
}
