package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello! Let start!");

        try {
            Scanner in = new Scanner(System.in);
            System.out.println("1) Input k: (k < 0) ");
            int k = in.nextInt();
            double eps = Math.pow(10, k);
            if (k > 0) {
                throw new IllegalArgumentException("K should be in (∞, 0)");
            }

            System.out.println("2) Enter x: ");
            double x = in.nextDouble();
            double actualValue = calculateActualValue(x);
            double calculatedValue = calculateExp(eps, x);

            System.out.println("Result: ");
            System.out.println("Actual value : " + actualValue);
            System.out.println("Calculate value : " + calculatedValue);

            System.out.print("Test: ");

            if (myTest(calculateActualValue(x), calculateExp(eps, x), eps)) {
                System.out.println("Correct!");
            }
            else {
                System.out.println("Non correct");
            }
        }

        catch (Exception ex) {
            System.out.println("Error while reading value: " + ex.getMessage());
        }

    }

    static double calculateActualValue(double x) {
        double exp = 2.718;
        return Math.pow(exp, x);
    }

    static long factorial(int number) {
        long result = 1;
        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }
        return result;
    }

    static double calculateExp(double eps, double x) {
        double elem = 100;
        double calculatedValue = 1;
        int n = 1;
        while (Math.abs(elem) >= Math.abs(eps)) {
            elem = Math.pow(x,n) / factorial(n);
            calculatedValue += elem;
            n++;
        }
        return calculatedValue;
    }

    static boolean myTest(double first_value, double second_value, double eps) {
        if ((first_value - second_value) < eps) {
            return true;
        }
        else {
            return false;
        }
    }
}
