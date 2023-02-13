package com.xzx.listnode;

import com.xzx.structure.ListNode;

/**
 * @author 谢子轩
 * @date 2023/02/10 15/50
 */
public class ReveseBetween {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        a.printLn();
        reverseBetween(a, 2, 4).printLn();
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dmNode = new ListNode(-1);
        dmNode.next = head;
        ListNode pre = head;
        for (int i = 1; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode curNext;
        for (int i = 0; i < n - m; i++) {
            curNext = cur.next;
            cur.next = curNext.next;
            curNext.next = pre.next;
            pre.next = curNext;
        }

        return head;
    }
}
