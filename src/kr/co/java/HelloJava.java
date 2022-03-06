package kr.co.java;

import java.io.Serializable;
import java.util.ArrayList;

public class HelloJava implements Serializable {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        //linkedList.delete(1);
        linkedList.add(1, 6);

        String msg = linkedList.printAll();

        System.out.println(msg);
    }
}
