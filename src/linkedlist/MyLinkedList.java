package linkedlist;

public class MyLinkedList {
    public ListNode head;

    //插入节点
    public void insertNode(ListNode node) {
        if (node == null) return;
        else {
            ListNode temp = new ListNode();
            temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public MyLinkedList(ListNode node) {
        if (node == null) return;
        else head = node;
    }

    public ListNode deleteNode(ListNode head, int val) {
        //如果插入的首节点等于需要删除的节点
        if (head.val == val) {
            head = head.next;
            return head;
        } else {
            ListNode temp = new ListNode();
            temp = head;
            while (temp.next != null) {
                if (temp.next.val == val) {
                    //需要删除的节点为尾节点
                    if (temp.next.next == null) {
                        temp.next = null;
                        return head;
                    }
                    //需要删除的节点为非尾节点
                    else {
                        temp.next = temp.next.next;
                        return head;
                    }
                }
                temp = temp.next;
            }
        }
        return null;
    }

    public ListNode reverseList(ListNode head) {
        ListNode reverseNode = new ListNode();
        ListNode temp = head;
        while (temp != null) {
            ListNode newNode = new ListNode(temp.val);
            newNode.next = reverseNode.next;
            reverseNode.next = newNode;
            temp = temp.next;
        }
        return reverseNode.next;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList(new ListNode(-3));
        myLinkedList.insertNode(new ListNode(5));
        myLinkedList.insertNode(new ListNode(-99));
        myLinkedList.deleteNode(myLinkedList.head, -99);
        myLinkedList.reverseList(myLinkedList.head);
    }
}