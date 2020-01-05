package com.zipcodewilmington.singlylinkedlist;

import java.util.Comparator;

public class GenericComparator<T extends Comparable<T>>implements Comparator<T> {


    public int compare(final T o1, final T o2) {

        return o1.compareTo(o2);
    }
}
