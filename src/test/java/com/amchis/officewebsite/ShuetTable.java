package com.amchis.officewebsite;

import org.apache.commons.lang3.RandomUtils;

import java.util.Random;
import java.util.stream.IntStream;

public class ShuetTable {

    public static void main(String[] args) {
        Random random = new Random(1);
        IntStream ints = random.ints(1, 10);
        System.out.println(ints.count());
        int i1 = RandomUtils.nextInt();
        System.out.println(i1);
    }
}
