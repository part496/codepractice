public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB){
            curA = curA == null ? headB : curA.next;//指针跳到另一链表和向后移动一步只能发生一个
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }
}
//题目链接 https://leetcode.cn/problems/intersection-of-two-linked-lists/
//这道题思路是双指针交换链表 这道题双指针同时移动的时候 容易错过真正地址相同的节点 因为地址相同的节点在对应链表的次序不同
//这道题的主要思路就是当a或者b指针走到原链表的最后时 然后交换到另外一个链表的首元节点 这样最后a指针和b指针走到相同节点所需要的次数是相同的
//即使没有相同的节点 所需次数也是一样的
//A独有长度设为a B独有长度设为b 公共长度设为c
//La = a + c  Lb = b + c;
//最后a，b指针走过的长度一定都为 a + b + c
//倘若没有公共交点 则两指针走过的长都为 a + b + 2c （c为0）
