class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode next;
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null){
            next = cur.next; //预先保存当前地址的地址成员变量 就是cur下一个节点的地址
            cur.next = pre; //使cur的后继节点的地址变成 前驱节点的地址
            pre = cur;//pre向前一个节点
            cur = next;//cur向前一个节点
        }
        return pre;
    }
}
//题目链接 https://leetcode.cn/problems/reverse-linked-list/
//这个题目的主要思路是 用pre表示已经反转的好的链表节点 cur表示正在处理的节点 next表示cur的后继节点
