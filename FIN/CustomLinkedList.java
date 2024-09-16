package interfaces;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CustomLinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private int size;

    public CustomLinkedList() {
        head = null;
        size = 0;
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(T value) {
        if (head == null) {
            head = new Node<>(value);
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(value);
        }
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    public boolean contains(T value) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void addAll(List<T> values) {
        for (T value : values) {
            add(value);
        }
    }

    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();

        list.add(1);
        System.out.println("Element at index 0: " + list.get(0));
        list.add(2);
        list.add(3);
        list.add(4);
        list.printList();

        list.remove(1);
        list.printList();

        System.out.println("List contains 2: " + list.contains(2));
        System.out.println("List contains 3: " + list.contains(3));

        list.addAll(List.of(5, 6, 7));
        list.printList();
    }
}
