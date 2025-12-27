package com.java8.stream;

import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> salaryList = Arrays.asList(1223,4455,300,6788,99);

       //without stream
      /*  int count = 0;
        for(Integer sal : salaryList){
            if(sal >300){
                count++;
            }
        }*/

        long output = salaryList.stream().filter((Integer sal)->sal>300).count();
        System.out.println(output);

    }
}
