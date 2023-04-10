package com.rodrigoguerrero.domain.currency

import android.icu.text.NumberFormat
import android.icu.util.Currency
import java.math.BigDecimal

class Money(
    private val value: Long,
    private val currencyCode: String
) {

    override fun toString(): String {
        val amount = BigDecimal(value).divide(BigDecimal(100))
        val format = NumberFormat.getCurrencyInstance().apply {
            maximumFractionDigits = 2
            currency = Currency.getInstance(currencyCode)
        }

        return if (amount.scale() == 0) {
            format.format(amount).replace(".00", "")
        } else {
            format.format(amount)
        }
    }
}
