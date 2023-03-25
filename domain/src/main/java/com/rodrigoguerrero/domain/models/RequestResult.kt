package com.rodrigoguerrero.domain.models

sealed class RequestResult<out T: Any?> {
    object Loading : RequestResult<Nothing>()
    data class Success<out T: Any?>(val data: T): RequestResult<T>()
    data class Error(val throwable: Throwable?): RequestResult<Nothing>()
}
