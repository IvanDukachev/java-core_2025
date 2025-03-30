package lr3;

public class Example11 {
    public static class Node1 {
        public int value;
        public Node1 next;
        Node1(int value, Node1 next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node1 head = null;
        for (int i = 9; i >= 0; i--) {
            head = new Node1(i, head);
        }

        Node1 ref1 = head;
        while (ref1 != null) {
            System.out.print(" " + ref1.value);
            ref1 = ref1.next;
        }

        System.out.println();

        Node1 head1 = new Node1(0, null);
        Node1 tail = head1;
        for (int i = 1; i <= 9; i++) {
            tail.next = new Node1(i, null);
            tail = tail.next;
        }

        Node1 ref2 = head1;
        while (ref2 != null) {
            System.out.print(" " + ref2.value);
            ref2 = ref2.next;
        }
    }
}