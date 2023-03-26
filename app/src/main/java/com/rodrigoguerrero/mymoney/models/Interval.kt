package com.rodrigoguerrero.mymoney.models

import androidx.annotation.StringRes
import com.rodrigoguerrero.mymoney.R

enum class Interval(@StringRes val nameResource: Int) {
    WEEK(R.string.week),
    BIWEEKLY(R.string.biweekly),
    FOUR_WEEKS(R.string.four_weeks),
    MONTHLY(R.string.month),
    BIMONTHLY(R.string.bimonthly),
    QUARTER(R.string.quarter),
    SEMI_ANNUALLY(R.string.semi_annually),
    YEAR(R.string.year),
    BI_ANNUALLY(R.string.biannually)
}
