package com.crisp;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class RadishSortTest {
    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<>();
        radishes.add(new Radish("red", 1.5, 2.5, 5));
        radishes.add(new Radish("black", 1.0, 0.0, 0));
        radishes.add(new Radish("red", 2.7, 5.5, 0));
        radishes.add(new Radish("pink", 0.9, 0, 6));

        System.out.println("Original list");
        dump(radishes);

        System.out.println("Sort by natural order (size) as defined in the Radish class");
        radishes.sort(null); //this rearranges the same list, it is NOT a new list. passing null means natural order
        dump(radishes);

        System.out.println("Sort by color by way of external Comparator class - RadishColorComparator");
        radishes.sort(new RadishColorComparator());  //we pass sort an instance of the comparator to sort by color
        dump(radishes);

        System.out.println("Sort by guysOnTop by way of external Comparator class - RadishGuysOnTopComparator");
        radishes.sort(new RadishGuysOnTopComparator());
        dump(radishes);
    }

    private static void dump(List<Radish> radishes) {
        for (Radish radish : radishes) {
            System.out.println(radish);
        }
        System.out.println();
    }
}
