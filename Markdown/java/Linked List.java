## Java 链表节点的创建

ListNode head;
这仅仅只是声明了一个ListNode类型的引用变量 当前并没有实际指向的节点 因此不能访问 data next

需要先创建节点对象
ListNode head = new ListNode(0,null)//创建了一个头节点

头节点一半用来统一链表头部的处理 
如果不加头节点 若链表是空的（节点数量为0）
那么head = null 但是这时想加一个节点进来不能直接用head.next 因为空引用没有next
这个时候第一个节点就要特殊处理
if (head == null) {
    // 第一个节点：特殊处理
    //这个时候要加node这个节点 就必须先指向他
    head = node;//用来返回链表的
    tail = node;//用来遍历链表的
} else {
    // 后续节点：统一处理
    tail.next = node;
    tail = tail.next;
}
如果拥有头节点 那么就不需要特殊处理
