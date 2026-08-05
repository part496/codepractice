class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode first = head;//一组中的第一个节点
        ListNode secend = first.next;//一组中的第二个节点
        head = secend;
        ListNode nextPair;//下一组的第一个节点
        ListNode PreviousTail = first;//首轮循环用不上 用来存上一组的第一个节点(交换后的第二个节点)
        while (first != null && first.next != null){//存在一组有两个节点
            secend = first.next;
            PreviousTail.next = secend;
            nextPair = secend.next;//储存下一组的第一个节点
            secend.next = first;
            first.next = nextPair;
            PreviousTail = first;
            first = nextPair;//first移动到下一组的第一个节点上(有可能是null)
        }
        return head;
    }
}
//题目链接：https://leetcode.cn/problems/swap-nodes-in-pairs/
//这个题我依旧是自己写出来的 但是我还是记了 因为我觉得这个题还是有点难度 这一份代码的变量我修改了一下 当初自己写的那个变量导致我编到后面都看不懂最初什么意思了
//while 前面大概意思就是链表最少有两个节点 并且我把head节点移动到第二个节点处了
//将链表两个为一组分开算

//secend = first.next;
//secend.next = first;
//first.next = nextPair;
//一组进行交换 同时交换后的第二个节点指向下一组的第一个节点

//当交换结束 PreviousTail = first; 储存上一组的第二个节点
//进入下一次循环后 PreviousTail.next = secend; 上一组的第二个节点 接上这一组的第二个节点
//因为已经进入下一组 所以必然存在第二个节点
