package com.entertainment.client;

import com.entertainment.Television;

import java.util.*;

class TelevisionClient {
    public static void main(String[] args) {
        // Television objects
        Television tv = new Television();
        Television tv2 = new Television("RCA", 10);
        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("Sony", 50);
        Television tvC = new Television("Sony", 52);
        Television tvD = new Television("Sony", 12);

        // Output
        System.out.println(tv);
        System.out.println(tv2);

        tv2.changeChannel(9);
        System.out.println(tv2);
        System.out.println();

        System.out.println("tvA == tvB: " + (tvA == tvB)); // false
        System.out.println("tvA.equals(tvB): " + tvA.equals(tvB)); // true
        System.out.println();

        System.out.println(tvA.hashCode());
        System.out.println(tvB.hashCode());

        Set<Television> tvs = new TreeSet<>();
        tvs.add(tvA);
        tvs.add(tvB);
        tvs.add(tvC);
        tvs.add(tvD);
        System.out.println("Size of set:" + tvs.size());
        System.out.println();

        for (Television t : tvs) {
            System.out.println(t);
        }
    }
}