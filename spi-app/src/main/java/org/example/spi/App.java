package org.example.spi;

import com.example.spi.ExchangeRateProvider;
import com.example.spi.utility.ExchangeRate;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.concurrent.Exchanger;

/**
 * @author DechuYe
 * @date 7/5/20 1:59 PM
 */
public class App {

    public static void main(String[] args) {
        ExchangeRate rate = new ExchangeRate();
        Iterator<ExchangeRateProvider> providers = rate.providers(true);
        while (providers.hasNext()) {
            ExchangeRateProvider provider = providers.next();
            provider.create().getQuotes(null, LocalDate.now()).forEach(System.out::println);
        }

    }
}
