package com.example.spi.service;

import com.example.spi.domain.Quote;

import java.time.LocalDate;
import java.util.List;

/**
 * @author DechuYe
 * @date 7/2/20 1:36 AM
 */
public interface QuoteManager {

    List<Quote> getQuotes(String baseCurrency, LocalDate date);
}
