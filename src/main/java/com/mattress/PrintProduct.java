package com.mattress;

public class PrintProduct {

    public void printHeader() {
        System.out.println();
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println();
        System.out.println("*****************************************************");
    }

    public void printTotalProductSales(IProduct product) {
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
    }

    public void printAverageProductSales(IProduct product) {
        System.out.println("AVERAGE PRODUCT SALES: "
                + Product.formatAverage(product.GetAverageProductSold()));
    }

    public void printMostPopularProduct(IProduct product) {
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    }
}
