package com.company;

public abstract class MyListImpl<T extends String> implements MyList<T> {
    void addSome(T some) {
        System.out.println(some + " hello");
    }
}
