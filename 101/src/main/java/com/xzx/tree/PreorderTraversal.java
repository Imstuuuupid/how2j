package com.xzx.tree;

import com.xzx.structure.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 前序遍历
 *
 * @author 谢子轩
 * @date 2023/02/13 15/38
 */
public class PreorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        int[] ints = preorderTraversal(root);
        List<Integer> sout = Arrays.stream(ints).boxed().collect(Collectors.toList());
        System.out.println(sout);
        ints = stackMethod(root);
        System.out.println(Arrays.stream(ints).boxed().collect(Collectors.toList()));
    }

    public static int[] preorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        return recursion(root, res);
    }

    public static int[] recursion(TreeNode root, LinkedList<Integer> res) {
        if (root != null) {
            res.add(root.val);
        }
        if (root.left != null) {
            recursion(root.left, res);
        }
        if (root.right != null) {
            recursion(root.right, res);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    public static int[] stackMethod(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            list.add(temp.val);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        return list.stream().mapToInt(a -> a).toArray();
    }
}
