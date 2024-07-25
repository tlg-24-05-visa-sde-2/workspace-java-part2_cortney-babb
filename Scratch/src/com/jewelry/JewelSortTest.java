package com.jewelry;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class JewelSortTest {
    public static void main(String[] args) {
        List<String> jewels = new ArrayList<>();
        jewels.add("Opal");
        jewels.add("Diamond");
        jewels.add("Malachite");
        jewels.add("Sapphire");
        jewels.add("Pearl");

        jewels.sort(null);
        dump(jewels);
        System.out.println();

        jewels.sort(new Comparator<String>() {
            @Override
            public int compare(String jewel1, String jewel2) {
                return Integer.compare(jewel1.length(), jewel2.length());
            }
        });
        dump(jewels);
    }

    private static void dump(List<String> jewelList) {
        for (String jewel : jewelList) {
            System.out.println(jewel);
        }
    }
}