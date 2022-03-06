package kr.co.java;

import java.io.Serializable;

public class LinkedList<T> implements Serializable {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public LinkedList(T element) {
        this.head = new Node(element, null);
    }

    public String printAll() {
        if (this.head == null) {
            return "";
        }

        Node pointer = this.head;

        StringBuffer sb = new StringBuffer();
        while (pointer.getNext() != null) {
            sb.append(pointer.getValue().toString())
                    .append(" / ");

            pointer = pointer.getNext();
        }

        sb.append(pointer.getValue().toString());

        return sb.toString();
    }

    public void add(T element) {
        if (head == null) {
            head = new Node(element, null);
        } else {
            Node pointer = head;

            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }

            pointer.setNext(new Node(element, null));
        }
    }

    public void add(int index, T element) {
        Node pointer = head;

        if (index == 0) {
            head = new Node(element, pointer);
        } else {
            for (int i = 0; i < index - 1; i++) {
                if (pointer == null) {
                    throw new IndexOutOfBoundsException();
                }

                pointer = pointer.getNext();
            }

            if (pointer == null) {
                throw new IndexOutOfBoundsException();
            }

            Node nextPointer = pointer.getNext();
            pointer.setNext(new Node(element, nextPointer));
        }
    }

    public T get(int index) {
        Node pointer = head;

        for (int i = 0; i < index; i++) {
            pointer = pointer.getNext();

            if (pointer == null) {
                throw new IndexOutOfBoundsException();
            }
        }

        T value = (T) pointer.getValue();

        return value;
    }

    //TODO: 삭제
    public void delete(T element) {
        Node pointer = head;

        if (head == null) {
            return;
        } else if (head.getValue() == element) {
            Node newNode = new Node(element, head.getNext());

            head = newNode;
        }

        Node beforePointer = null;
        while (pointer.getNext() != null){
            Node temp = pointer.getNext();
            beforePointer = pointer;

            if (pointer.getValue() == element) {
                pointer.setNext(temp.getNext());
            }

            pointer = pointer.getNext();
        }

        if (pointer.getValue() == element) {
            beforePointer.setNext(null);
        }
    }

    //TODO: 길이 측정


    class Node<T> {
        private T value;
        private Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return this.value;
        }

        public Node getNext() {
            return this.next;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
