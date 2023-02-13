package com.xzx.listnode;

import com.xzx.structure.ListNode;

/**
 * @author 谢子轩
 * @date 2023/02/11 16/01
 */
public class ReverseKGroup {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(7);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        a.printLn();
        reverseKGroup(a, 3).printLn();
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
//        找到下个翻转头
        ListNode nextHead = head;
        for (int i = 0; i < k; i++) {
            if (nextHead == null) {
//                不足k，直接返回头
                return head;
            }
            nextHead = nextHead.next;
        }
//        翻转当前k个节点
        ListNode pre = null;
        ListNode cur = head;
        while (cur != nextHead) {
            ListNode curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
//        翻转完毕后头尾互换，链接后续节点
        head.next = reverseKGroup(nextHead, k);
//        返回翻转头
        return pre;
    }
}
