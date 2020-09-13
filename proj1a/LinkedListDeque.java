public class LinkedListDeque<T> {

    private final Node<T> sentinal;
    private int size;

    public LinkedListDeque() {
        sentinal = new Node<>(null, null, null);
        sentinal.prev = sentinal.next = sentinal;
        size = 0;
    }

    public void addFirst(T item) {
        Node<T> addNode = new Node<>(item, sentinal.next, sentinal);
        sentinal.next.prev = addNode;
        sentinal.next = addNode;

        size++;
    }

    public void addLast(T item) {
        Node<T> addNode = new Node<>(item, sentinal, sentinal.prev);
        sentinal.prev.next = addNode;
        sentinal.prev = addNode;

        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node<T> p = sentinal.next;
        while (p != sentinal) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    public T removeLast() {
        Node<T> deletedNode = sentinal.prev;
        deletedNode.prev.next = sentinal;
        sentinal.prev = deletedNode.prev;

        if (deletedNode != sentinal) {
            size--;
        }
        return deletedNode.item;
    }

    public T removeFirst() {
        Node<T> deletedNode = sentinal.next;
        deletedNode.next.prev = sentinal;
        sentinal.next = deletedNode.next;

        if (deletedNode != sentinal) {
            size--;
        }
        return deletedNode.item;
    }

    public T get(int index) {
        Node<T> p = sentinal.next;
        int i = 0;
        while (p != sentinal) {
            if (i == index) {
                return p.item;
            }
            p = p.next;
            i++;
        }
        return null;
    }

    public T getRecursive(int index) {
        return (T) getRecursiveHelpMethod(sentinal.next, index);
    }

    private T getRecursiveHelpMethod(Node<T> p, int index) {
        if (index == 0) {
            if (p != sentinal) {
                return p.item;
            } else {
                return null;
            }
        } else {
            if (p == sentinal) {
                return null;
            } else {
                return (T) getRecursiveHelpMethod(p.next, index - 1);
            }
        }
    }

    private static class Node<Item> {
        private final Item item;
        private Node next;
        private Node prev;

        public Node(Item t, Node next, Node prev) {
            item = t;
            this.next = next;
            this.prev = prev;
        }
    }
}
