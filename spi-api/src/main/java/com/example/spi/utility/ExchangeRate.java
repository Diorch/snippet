package com.example.spi.utility;

import com.example.spi.ExchangeRateProvider;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author DechuYe
 * @date 7/2/20 1:38 AM
 */
public class ExchangeRate {

    ServiceLoader<ExchangeRateProvider> loader = ServiceLoader.load(ExchangeRateProvider.class);

    public Iterator<ExchangeRateProvider> providers(boolean refresh) {
        if (refresh) {
            loader.reload();
        }
        return loader.iterator();
    }
}
