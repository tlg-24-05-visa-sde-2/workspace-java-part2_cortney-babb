package com.javatunes.billing;

public class TaxCalculatorFactory {
    // no instantiation from outside, this is an all-static class
    private TaxCalculatorFactory() {
    }

    public static TaxCalculator createTaxCalculator(Location location) {
        return switch (location) {
            case ONLINE -> new OnlineTax();
            case USA -> new USATax();
            case EUROPE -> new EuropeTax();
        };

        // Classic switch statement
//        switch (location) {
//            case ONLINE:
//                calc = new OnlineTax();
//                break;
//            case USA:
//                calc = new USATax();
//                break;
//            case EUROPE:
//                calc = new EuropeTax();
//        }
//        return calc;
    }
}
