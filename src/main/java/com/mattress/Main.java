package com.mattress;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] productNames = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };
        int months = 3;
        int[][] sales = new int[productNames.length][months];

        Scanner input = new Scanner(System.in);

        for (int p = 0; p < productNames.length; p++) {
            for (int m = 0; m < months; m++) {
                sales[p][m] = readInt(input, "Enter number of sales for month "
                        + (m + 1) + " for " + productNames[p] + " mattress: ");
            }
            System.out.println();
        }

        Product product = new Product(productNames, sales);
        PrintProduct printer = new PrintProduct();

        printer.printHeader();
        printer.printTotalProductSales(product);
        printer.printAverageProductSales(product);
        printer.printMostPopularProduct(product);
    }

    /** Keeps asking until a valid non-negative whole number is entered. */
    private static int readInt(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine().trim();
            try {
                int value = Integer.parseInt(line);
                if (value >= 0) {
                    return value;
                }
            } catch (NumberFormatException ex) {
                // fall through to the error message
            }
            System.out.println("Invalid input. Please enter a whole number (0 or more).");
        }
    }
}
