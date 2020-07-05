package com.example.spi.impl;

import com.example.spi.ExchangeRateProvider;
import com.example.spi.service.QuoteManager;

/**
 * @author DechuYe
 * @date 7/2/20 1:42 AM
 */
public class YahooFinanceExchangeRateProvider implements ExchangeRateProvider {

    @Override
    public QuoteManager create() {
        return new YahooQuoteManagerImpl();
    }
}
