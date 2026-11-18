package com.mattress;

import java.text.DecimalFormat;

/**
 * Holds the product names (single-dimensional array) and the monthly sales
 * (two-dimensional array: rows = products, columns = months).
 */
public class Product implements IProduct {

    private final String[] productNames;
    private final int[][] sales;

    public Product(String[] productNames, int[][] sales) {
        this.productNames = productNames;
        this.sales = sales;
    }

    /** Total number of products sold across all products and months. */
    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int p = 0; p < sales.length; p++) {
            for (int m = 0; m < sales[p].length; m++) {
                total += sales[p][m];
            }
        }
        return total;
    }

    /** Average number of products sold (total / number of sales entries). */
    @Override
    public double GetAverageProductSold() {
        int count = 0;
        for (int[] row : sales) {
            count += row.length;
        }
        if (count == 0) {
            return 0;
        }
        return (double) GetTotalProductsSold() / count;
    }

    /** Name of the product with the highest total sales, with its total in brackets. */
    @Override
    public String GetMostPopularProduct() {
        int bestIndex = 0;
        int bestTotal = -1;
        for (int p = 0; p < sales.length; p++) {
            int productTotal = 0;
            for (int m = 0; m < sales[p].length; m++) {
                productTotal += sales[p][m];
            }
            if (productTotal > bestTotal) {
                bestTotal = productTotal;
                bestIndex = p;
            }
        }
        return productNames[bestIndex] + " (" + bestTotal + ")";
    }

    /** Formats the average without needless decimals (17.0 -> 17, 17.33333 -> 17.33). */
    public static String formatAverage(double value) {
        return new DecimalFormat("0.##").format(value);
    }
}
