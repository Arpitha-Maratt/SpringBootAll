package com.java8;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LamdaExpression {
    public static void main(String[] args) {
            List<Integer> nums = new ArrayList<>();
            nums.add(3);
            nums.add(5);
            nums.add(9);
            nums.add(23);
            nums.add(5);

//            Consumer<Integer> consumer = number-> System.out.println(number);
//            nums.forEach(consumer);

//
//      nums.forEach(n-> System.out.println(nums));

        nums.forEach(System.out::println);
        }
    }

