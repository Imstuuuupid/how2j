package com.xzx.listnode;

import com.xzx.structure.ListNode;

/**
 * @author 谢子轩
 * @date 2023/02/10 15/15
 */
public class ReverseListNode {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        a.printLn();
        ReverseList(a).printLn();

    }


    public static ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return pre;
    }

}
