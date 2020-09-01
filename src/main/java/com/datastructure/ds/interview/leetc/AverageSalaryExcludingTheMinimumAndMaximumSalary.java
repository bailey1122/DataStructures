package com.datastructure.ds.interview.leetc;

public class AverageSalaryExcludingTheMinimumAndMaximumSalary {

    public double average(int[] salary) {
        double sum = 0d;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int s : salary) {
            max = Math.max(max, s);
            min = Math.min(min, s);
            sum += s;
        }

        return (sum - max - min) / (salary.length - 2);
    }
}
