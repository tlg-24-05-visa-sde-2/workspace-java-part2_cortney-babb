package com.crisp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class RadishSortTestLamda {
    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<>();

        radishes.add(new Radish("red", 2.75, 0.0, 7));
        radishes.add(new Radish("pink", 1.1, 2.1, 2));
        radishes.add(new Radish("red", 0.7, 3.3, 0));
        radishes.add(new Radish("black", 1.9, 0.0, 0));

        System.out.println("Original List:");
        dump(radishes);
        System.out.println();

        System.out.println("Sort by natural order (size)");
        radishes.sort(null); // null means natural order
        dump(radishes);
        System.out.println();

        System.out.println("Sort by guysOnTop by way of Lamda for the Comparator");
        //TODO radishes.sort(new RadishGuysOnTopComparator());
        radishes.sort( (r1, r2) -> Integer.compare(r1.getGuysOnTop(), r2.getGuysOnTop()) );
        dump(radishes);
        System.out.println();

        System.out.println("Sort by color by way of Lamda for the Comparator");
        //TODO radishes.sort(new RadishColorComparator());
        radishes.sort( (r1, r2) -> r1.getColor().compareTo(r2.getColor()) );
        dump(radishes);
        System.out.println();

        System.out.println("Sort by tailLength, via Lamda for the Comparator");
//TODO        radishes.sort(new Comparator<Radish>() {
//            @Override
//            public int compare(Radish tailLength1, Radish tailLength2) {
//                return Double.compare(tailLength1.getTailLength(), tailLength2.getTailLength());
//            }
//        });

        radishes.sort( (r1, r2) -> Double.compare(r1.getTailLength(), r2.getTailLength()) );
        dump(radishes);
        System.out.println();
    }

    private static void dump(List<Radish> radishList) {
        for (Radish r : radishList) {
            System.out.println(r);
        }
    }
}