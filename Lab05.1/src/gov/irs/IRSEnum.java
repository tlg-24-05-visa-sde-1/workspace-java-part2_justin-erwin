/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package gov.irs;

import java.util.ArrayList;
import java.util.Collection;

enum IRSEnum implements IRS {  //remove the word public so it's not visible outside of package
    INSTANCE;  //making this an enum fixes the number of instances to 1;

    // BUSINESS CODE
    private final Collection<TaxPayer> payers = new ArrayList<>();

    @Override
    public void collectTaxes() {
        for (TaxPayer payer : payers) {
            payer.payTaxes();
        }
    }
    @Override
    public void register(TaxPayer payer) {
        payers.add(payer);
    }
}