package com.dxesoft;

import java.util.Scanner;

public class Precio {

    public void calculaPrecio() {
        Scanner scan = new Scanner(System.in);
        double mealCost = scan.nextDouble(); // original meal price
        int tipPercent = scan.nextInt(); // tip percentage
        int taxPercent = scan.nextInt(); // tax percentage
        scan.close();

        // Write your calculation code here.

        double tip = mealCost * calculate(tipPercent);

        double tax = mealCost * calculate(taxPercent);

        double total = mealCost + tip + tax;

        // cast the result of the rounding operation to an int and save it as totalCost
        int totalCost = (int) Math.round(total);

        System.out.println("The total meal cost is " + totalCost + " dollars.");
    }

    private double calculate(double num) {
        return num/100;
    }
}
