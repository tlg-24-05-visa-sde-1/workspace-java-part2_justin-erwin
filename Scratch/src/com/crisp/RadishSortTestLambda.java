package com.crisp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class RadishSortTestLambda {
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

        System.out.println("Sort by color via lambda as the Comparator");
        radishes.sort((r1,r2) -> r1.getColor().compareTo( r2.getColor()));
        dump(radishes);

        System.out.println("Sort by guysOnTop via lambda as the Comparator");
        System.out.println("Sort by guysOnTop via Lambda");
        radishes.sort((r1,r2) -> Integer.compare(r1.getGuysOnTop(), r2.getGuysOnTop()));
        dump(radishes);

        System.out.println("Sort by tailLength via lambda as the Comparator");
        radishes.sort((r1,r2) -> Double.compare(r1.getTailLength(), r2.getTailLength()));
        dump(radishes);
    }

    private static void dump(List<Radish> radishes) {
        for (Radish radish : radishes) {
            System.out.println(radish);
        }
        System.out.println();
    }
}
