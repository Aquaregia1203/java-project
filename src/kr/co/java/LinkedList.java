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

    //TODO: 인덱스로 삭제
    public boolean delete(int index) {


        return false;
    }

    public boolean delete(T element) {
        Node pointer = this.head;

        if (pointer == null) {
            return false;
        } else if (pointer.getValue() == element) {
            this.head = pointer.getNext();

            return true;
        }

        Node beforePointer = null;
        while (pointer.getNext() != null){
            beforePointer = pointer;
            pointer = pointer.getNext();

            if (pointer.getValue() == element) {
                beforePointer.setNext(pointer.getNext());
                return true;
            }
        }

        if (pointer.getValue() == element) {
            beforePointer.setNext(null);
            return true;
        }

        return false;
    }

    public int size() {
        Node pointer = this.head;

        if (pointer == null) {
            return 0;
        }

        int size = 1;
        while (pointer.getNext() != null) {
            pointer = pointer.getNext();
            size++;
        }

        return size;
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
