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
            sb.append(this.head.getValue().toString())
              .append(" / ");

            pointer = pointer.getNext();
        }

        sb.append(this.head.getValue().toString());

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
