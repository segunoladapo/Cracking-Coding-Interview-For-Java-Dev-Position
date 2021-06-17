package ds;

public class Stack<T> {
    private Node head;

    class Node {
        public T value;
        public Node next;
    }

    public void push(T value) {
        Node node = new Node();
        node.value = value;

        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public T pop() {
        Node temp = head;
        if (temp != null) {
            head = temp.next;
        }
        return temp != null ? temp.value : null;
    }

    public void removeNode(T value) {
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            if (prev == null && (temp.value == value)) {
                head = temp.next;
            }
            if (temp.value == value && prev != null) {
                prev.next = temp.next;
            }
            if (temp.value == value && temp.next == null) {
                prev.next = null;
            }
            prev = temp;
            temp = temp.next;

        }
    }

    public void printNodes() {
        Node temp = head;
        while (temp != null) {
            System.out.println("Node: " + temp.value);
            temp = temp.next;
        }
    }

    public static void main(String... args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.removeNode(2);
        stack.pop();
        stack.pop();

        stack.printNodes();
    }
}
