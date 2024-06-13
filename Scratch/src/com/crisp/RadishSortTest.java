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

        System.out.println("Sort by color via anonymous Comparator class");
        //radishes.sort(new RadishColorComparator());  //we pass sort an instance of the comparator to sort by color

        radishes.sort(new Comparator<Radish>() {
            @Override
            public int compare(Radish radish1, Radish radish2) {
                return radish1.getColor().compareTo(radish2.getColor()) ;
            }
        });
        dump(radishes);

        //System.out.println("sort with named top-level Comparator class");
        //radishes.sort(new RadishGuysOnTopComparator());

        //System.out.println("Sort by guysOnTop via anonymous Comparator class");
//        radishes.sort(new Comparator<Radish>() {
//            @Override
//            public int compare(Radish radish1, Radish radish2) {
//                return Integer.compare(radish1.getGuysOnTop(), radish2.getGuysOnTop());
//            }
//        });
        System.out.println("Sort by guysOnTop via Lambda");
        radishes.sort((r1,r2) -> Integer.compare(r1.getGuysOnTop(), r2.getGuysOnTop()));
        dump(radishes);

        System.out.println("Sort by tailLength via Anonymous Class");
        radishes.sort(new Comparator<Radish>(){
            public int compare(Radish radish1, Radish radish2){
                return Double.compare(radish1.getTailLength(), radish2.getTailLength());
            }
        });
        dump(radishes);
    }

    private static void dump(List<Radish> radishes) {
        for (Radish radish : radishes) {
            System.out.println(radish);
        }
        System.out.println();
    }
}
