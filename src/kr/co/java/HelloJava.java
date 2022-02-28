package kr.co.java;

import java.io.Serializable;

public class HelloJava implements Serializable {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        String msg = linkedList.printAll();
        System.out.println(msg);

        linkedList.add(2);
        linkedList.add(2);
        linkedList.add(2);
        linkedList.add(2);
        linkedList.add(2);

        msg = linkedList.printAll();
        System.out.println(msg);
    }
}
