package com.adapter;

import org.springframework.security.core.parameters.P;

public class School {
    public static void main(String[] args) {
        Pen pen = new PenAdapter();
        Assignment assignment = new Assignment();

        assignment.setPen(pen);
        assignment.writeAssignment("I am tiered to write assigment");

    }
}
