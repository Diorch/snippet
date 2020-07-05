package com.example.spi;

import com.example.spi.service.QuoteManager;

/**
 * @author DechuYe
 * @date 7/2/20 1:37 AM
 */
public interface ExchangeRateProvider {

    /**
     *
     * @return QuoteManager
     */
    QuoteManager create();
}
