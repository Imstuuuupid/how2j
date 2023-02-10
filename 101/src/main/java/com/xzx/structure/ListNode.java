package com.xzx.structure;

/**
 * @author 谢子轩
 * @date 2023/02/10 15/14
 */
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public void printLn(){
        StringBuilder sb = new StringBuilder();
        sb.append(val).append(",");
        ListNode nex = next;
        while (nex != null){
            sb.append(nex.val).append(",");
            nex = nex.next;
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}
