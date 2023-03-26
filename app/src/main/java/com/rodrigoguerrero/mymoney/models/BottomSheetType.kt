package com.rodrigoguerrero.mymoney.models

sealed class BottomSheetType {
    object Categories : BottomSheetType()
    object Intervals : BottomSheetType()
}
