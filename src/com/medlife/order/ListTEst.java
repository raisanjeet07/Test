package com.medlife.order;

import java.util.ArrayList;
import java.util.List;

public class ListTEst {
public static void main(String[] args) {
    List<A> list1 = new ArrayList<>();
    List<A> list2 = new ArrayList<>();
    A a = new A();
    a.name = "sanjeet";
    list1.add(a);
    list2.add(list1.get(0));
    System.out.println(list1);
    System.out.println(list2);
    a.name = "Gopal";
    System.out.println(list1);
    System.out.println(list2);
    
}
}


class A {
    String name;
    @Override
    public String toString() {
        return name;
    }
}