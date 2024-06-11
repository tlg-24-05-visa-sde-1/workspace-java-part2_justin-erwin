package com.javatunes.billing;

import static com.javatunes.billing.Location.*;

public class TaxCalculatorFactory {

    //ctor to prevent direct instantiation
    private TaxCalculatorFactory() {
    }

    public static TaxCalculator createTaxCalculator(Location location) {
        TaxCalculator taxCalculator = null;

        switch (location) {
            case ONLINE:
                taxCalculator = new OnlineTax();
                break;
            case USA:
                taxCalculator = new USATax();
                break;
            case EUROPE:
                taxCalculator = new EuropeTax();
        }
        return taxCalculator;
    }
}


// we could also use if, if else, else instead of switch case:
 /* if (location.equals(Location.USA)) {
            taxCalculator = new USATax();
        } else if (location.equals(Location.EUROPE)) {
            taxCalculator = new EuropeTax();
        } else {
            taxCalculator = new OnlineTax();
        }*/