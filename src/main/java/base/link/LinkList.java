package base.link;


public class LinkList {

    public static Node overturnLinklist(Node node) {
        Node currentNode = node;
        Node beforeNode = null;
        Node headNode = null;
        while (currentNode != null) {
            Node nextNode = currentNode.next;
            if (null == nextNode) {
                headNode = currentNode;
            }
            currentNode.next = beforeNode;
            beforeNode = currentNode;
            currentNode = nextNode;
        }
        return headNode;
    }

    public static Node deleteLastKth(Node list, int n) {
        Node fast = list;
        int i = 0;
        while (fast != null && i < n) {
            fast = fast.next;
            i++;
        }
        Node slow = list;
        Node prev = null;
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        assert prev != null;
        prev.next = slow.next;
        return prev;
    }

    static class Node {
        private int data;
        private Node next;

        public Node(int data, Node node) {
            this.data = data;
            this.next = node;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        LinkedListAlgo.Node node3 = null;
        LinkedListAlgo.Node node1 = null;
        LinkedListAlgo.Node node = new LinkedListAlgo.Node(1, new LinkedListAlgo.Node(2, new LinkedListAlgo.Node(3, new LinkedListAlgo.Node(4, node1))));
        node = new LinkedListAlgo.Node(33, new LinkedListAlgo.Node(44, node));

        System.out.println(node);
//        Node node1 = overturnLinklist(node);
//        System.out.println(node1);
        boolean b = LinkedListAlgo.checkCircle(node);
        System.out.println(b);
        LinkedListAlgo.Node node2 = LinkedListAlgo.deleteLastKth(node, 1);
        System.out.println(node2);
    }
}