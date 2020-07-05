package com.example.spi.impl;

import com.example.spi.domain.Quote;
import com.example.spi.service.QuoteManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DechuYe
 * @date 7/2/20 1:44 AM
 */
public class YahooQuoteManagerImpl implements QuoteManager {
    @Override
    public List<Quote> getQuotes(String baseCurrency, LocalDate date) {
        ArrayList<Quote> quotes = new ArrayList<>();
        Quote e = new Quote();
        e.setCurrency("USD");
        e.setDate(LocalDate.now());
        quotes.add(e);
        return quotes;
    }
}
