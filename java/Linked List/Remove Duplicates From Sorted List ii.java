class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode fast = head.next;//遍历重复的一组数据
        ListNode slow = head;//那组数据的第一个节点
        ListNode pre = head;//已经确定需要的部分的最右边的节点
        boolean flag = true;//拿来判断这一组是否是重复的数
        while (fast != null){
            if(fast.val != slow.val){
                if(flag == true) {//这一组不是重复的数
                    pre = slow;//pre前移
                }else if(slow == head) {//首元节点是重复节点
                    pre = fast;//规范来写不能这么写因为没有确定fast那一个节点是否需要保留 规范来写要加头节点
                    head = fast;
                }else pre.next = fast;//如果这一组是重复数组 那就截掉
                flag = true;//重置flag
                slow = fast;//最上面的if表示的是这一组已经结束fast现在处于下一组的第一个节点 那这一组已经结束 slow就得前移至下一组的第一个节点
            }else flag = false;//fast.val == slow.val说明这一组是重复的数
            fast = fast.next;
        }
        if(flag == false) {//最后这一组是重复数组
            if(slow.next != fast) pre.next = null;
            if(slow == head) return null;//整个链表都是同一个重复数组
        }
        return head;
    }
}
//题目链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/description/
//当时基本上算是没想出来 虽然有有点累的原因在吧
