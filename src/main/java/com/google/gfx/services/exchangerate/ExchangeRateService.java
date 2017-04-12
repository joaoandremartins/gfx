package com.google.gfx.services.exchangerate;

import java.util.Currency;

/**
 * Polls external sources that contain exchange rates between different currencies.
 */
public interface ExchangeRateService {

  /**
   * Gets the current exchange rate between two currencies, for a single unit of
   * {@code fromCurrency}.
   *
   * <p>For example, at the time of writing,
   * {@code getExchangeRate(Currency.getInstance("USD"), Currency.getInstance("EUR")} should return
   * 0.94.
   *
   * @param fromCurrency offered currency
   * @param toCurrency gotten currency
   * @return the exchange rate value, such that 'itself * fromCurrency = toCurrency'
   */
  float getExchangeRate(Currency fromCurrency, Currency toCurrency);
}
