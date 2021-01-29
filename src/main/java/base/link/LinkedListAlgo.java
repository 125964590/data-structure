package base.link;

/**
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 *
 * @author zhengyi
 * @date 2018/10/9 2:11 PM
 **/
public class LinkedListAlgo {

    // 单链表反转
    public static Node reverse(Node list) {
        Node headNode = null;

        Node previousNode = null;
        Node currentNode = list;
        while (currentNode != null) {
            Node nextNode = currentNode.next;
            if (nextNode == null) {
                headNode = currentNode;
            }
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        return headNode;
    }

    public static Node linkCycle(Node node) {
        Node next = null;
        Node currentNode = node;
        Node previousNode = node.next;
        currentNode.next = next;
        while (previousNode != null) {
            next = currentNode;
            currentNode = previousNode;
            previousNode = currentNode.next;
            currentNode.next = next;
        }
        return currentNode;
    }

    // 检测环
    public static boolean checkCircle(Node list) {
        if (list == null) return false;

        Node fast = list.next;
        Node slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) return true;
        }

        return false;
    }

    public ListNode detectCycle(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode quickNode = head;
        ListNode slowNode = head;

        while (quickNode != null && quickNode.next != null) {
            quickNode = quickNode.next.next;
            slowNode = slowNode.next;

            if (quickNode == slowNode) {
                quickNode = head;
                while (quickNode != slowNode) {
                    quickNode = quickNode.next;
                    slowNode = slowNode.next;
                }
                return slowNode;
            }
        }

        return null;
    }

    // 有序链表合并
    public static Node mergeSortedLists(Node la, Node lb) {
        if (la == null) return lb;
        if (lb == null) return la;

        Node p = la;
        Node q = lb;
        Node head;
        if (p.data < q.data) {
            head = p;
            p = p.next;
        } else {
            head = q;
            q = q.next;
        }
        Node r = head;

        while (p != null && q != null) {
            if (p.data < q.data) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }

        if (p != null) {
            r.next = p;
        } else {
            r.next = q;
        }

        return head;
    }

    public static Node mergeOrderLink(Node a, Node b) {
        Node result = null;
        if (a.data > b.data) {
            result = b;
            b = b.next;
        } else {
            result = a;
            a = a.next;
        }
        Node head = result;
        while (a.next != null && b.next != null) {
            if (a.data > b.data) {
                result.next = b;
                result = result.next;
                b = b.next;
            } else {
                result.next = a;
                result = result.next;
                a = a.next;
            }
        }
        return head;
    }

    // 删除倒数第K个结点
    public static Node deleteLastKth(Node list, int k) {
        Node fast = list;
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.next;
            ++i;
        }

        if (fast == null) return list;

        Node slow = list;
        Node prev = null;
        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        if (prev == null) {
            list = list.next;
        } else {
            prev.next = prev.next.next;
        }
        return list;
    }

    // 求中间结点
    public static Node findMiddleNode(Node list) {
        if (list == null) return null;

        Node fast = list;
        Node slow = list;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void printAll(Node list) {
        Node p = list;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }

        public int getData() {
            return data;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
//        Node node1 = new Node(3, new Node(6, new Node(8, new Node(12, null))));
//        Node node2 = new Node(1, new Node(2, new Node(7, new Node(14, new Node(25, null)))));
//        Node node = mergeOrderLink(node1, node2);
//        System.out.println();

        LinkedListAlgo linkedListAlgo = new LinkedListAlgo();

        ListNode listNode = new ListNode(1);

        ListNode listNode1 = linkedListAlgo.detectCycle(listNode);
        System.out.println(listNode1);
    }

}
