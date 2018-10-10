package base.stack;

/**
 * @author zhengyi
 * @date 2018/10/10 6:29 PM
 **/
public class LinkStack {
    private static Node top = null;

    public static void push(int data) {
        Node newNode = new Node(data, null);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public static int pop() {
        if (top == null) {
            return -1;
        }
        Node currentNode = top;
        top = top.next;
        return currentNode.data;
    }

    public static class Node {
        private int data;
        private Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
    }

}