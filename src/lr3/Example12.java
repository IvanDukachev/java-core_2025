package lr3;

public class Example12 {
    public static class Node2 {
        public int value;
        public Node2 next;

        Node2(int value, Node2 next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node2 head = createHead();

        System.out.println("Вывод списка, введенного с головы:");
        String nodes = nodesToString(head);
        System.out.println(nodes);

        head = createTail();
        System.out.println("Вывод списка, введенного с хвоста:");
        nodes = nodesToString(head);
        System.out.println(nodes);

        System.out.println("Вывод списка после добавления элемента в начало:");
        head = addFirst(5, head);
        nodes = nodesToString(head);
        System.out.println(nodes);

        System.out.println("Вывод списка после добавления элемента в конец:");
        addLast(15, head);
        nodes = nodesToString(head);
        System.out.println(nodes);

        System.out.println("Вывод списка после добавления элемента по индексу:");
        insert(23, 2, head);
        nodes = nodesToString(head);
        System.out.println(nodes);

        System.out.println("Вывод списка после удаления элемента по индексу:");
        remove(2, head);
        nodes = nodesToString(head);
        System.out.println(nodes);

        System.out.println("Вывод списка после удаления элемента с начала:");
        head = removeFirst(head);
        nodes = nodesToString(head);
        System.out.println(nodes);

        System.out.println("Вывод списка после удаления элемента с конца:");
        removeLast(head);
        nodes = nodesToString(head);
        System.out.println(nodes);

        StringBuilder nodesRec = new StringBuilder();

        System.out.println("Вывод списка, введенного с головы:");
        Node2 head1 = null;
        head1 = createHeadRec(10, head1);
        nodes = toStringRec(nodesRec, head1);
        System.out.println(nodes);
        nodesRec.setLength(0);

        System.out.println("Вывод списка, введенного с хвоста:");
        Node2 head2 = new Node2(0, null);
        Node2 tail2 = head2;
        tail2 = createTailRec(1, head2);
        nodes = toStringRec(nodesRec, head2);
        System.out.println(nodes);
    }

    public static Node2 createHead() {
        Node2 head = null;
        for (int i = 9; i >= 0; i--) {
            head = new Node2(i, head);
        }
        return head;
    }

    public static Node2 createTail() {
        Node2 head = new Node2(0, null);
        Node2 tail = head;
        for (int i = 1; i <= 9; i++) {
            tail.next = new Node2(i, null);
            tail = tail.next;
        }
        return head;
    }

    public static String nodesToString(Node2 head) {
        Node2 ref1 = head;
        StringBuilder nodes = new StringBuilder();
        while (ref1 != null) {
            nodes.append(ref1.value);
            if (ref1.next != null) {
                nodes.append(" ");
            }
            ref1 = ref1.next;
        }
        return nodes.toString();
    }

    public static Node2 addFirst(int n, Node2 head) {
        Node2 newhead = new Node2(n, head);
        return newhead;
    }

    public static void addLast(int n, Node2 head) {
        Node2 ref1 = head;
        while (ref1.next != null) {
            ref1 = ref1.next;
        }
        ref1.next = new Node2(n, null);
    }

    public static void insert(int n, int idx, Node2 head) {
        Node2 ref1 = head;
        Node2 left = null;

        while (idx != 0) {
            if (idx == 1) {
                left = ref1;
            }
            ref1 = ref1.next;
            idx--;
        }
        left.next = new Node2(n, ref1);
    }

    public static Node2 removeFirst(Node2 head) {
        head = head.next;
        return head;
    }

    public static void removeLast(Node2 head) {
        Node2 ref1 = head;
        Node2 ref = null;

        while (ref1.next != null) {
            if (ref1.next == null) {
                break;
            }
            ref = ref1;
            ref1 = ref1.next;
        }
        ref.next = null;
    }

    public static void remove(int idx, Node2 head) {
        Node2 ref1 = head;
        Node2 left = null;

        while (idx != 0) {
            if (idx == 1) {
                left = ref1;
            }
            ref1 = ref1.next;
            idx--;
        }
        left.next = ref1.next;
    }

    public static Node2 createHeadRec(int n, Node2 head) {
        if (n == 0) {
            return head;
        } else {
            head = createHeadRec(--n, new Node2(n, head));
            return head;
        }
    }

    public static Node2 createTailRec(int n, Node2 tail) {
        if (n == 10) {
            return tail;
        } else {
            tail.next = new Node2(n, null);
            tail = createTailRec(++n, tail.next);
            return tail;
        }
    }

    public static String toStringRec(StringBuilder nodesRec, Node2 head) {
        Node2 ref1 = head;
        nodesRec.append(head.value);
        if (ref1.next == null) {
            return nodesRec.toString();
        } else {
            nodesRec.append(" ");
            return toStringRec(nodesRec, head.next);
        }
    }
}
