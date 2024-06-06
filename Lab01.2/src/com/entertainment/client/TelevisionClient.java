package com.entertainment.client;

import com.entertainment.Television;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

class TelevisionClient {
    public static void main(String[] args) {
        //examine == and the .equals() method
        //create two Televisions that are "the same"
        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("Sony", 50);  //we didn't write hashCode so,
/*        // the Set doesn't see them as duplicates and lets them both in. We have to write hashCode() if we write .equals().
        System.out.println(tvA.hashCode());
        System.out.println(tvB.hashCode());*/

        Television tvC = new Television("Sony", 52);
        Television tvD  = new Television("Sony", 12);

        //using == and .equals() to see if tvA and tvB are equal.
        System.out.println("tvA == tvB: " + (tvA == tvB));  //false of course b/c they point to 2 diff. objects
        System.out.println("tvA .equals() tvB: " + tvA.equals(tvB));  //false, why?  You have to WRITE the equals method
        // in Television or you inherit the default one from class Object.  The default inherited version executes inside
        // the tvA object and compares references.  Inside tvA, and checks if tvA is equal to tvB, the same thing as ==.
        // UPDATE: We wrote our own .equals() method and now it returns TRUE.
        System.out.println();

        Set<Television> tvs = new TreeSet<>();   //make a set with the tvs
        tvs.add(tvA);
        tvs.add(tvB);  //tvB won't go into set b/c it's equal to tvA
        tvs.add(tvC);
        tvs.add(tvD);
        System.out.println("The size of the Set is: " + tvs.size());
        for(Television tv : tvs){
            System.out.println(tv);
        }
        //System.out.println(tvs);
    }
}
