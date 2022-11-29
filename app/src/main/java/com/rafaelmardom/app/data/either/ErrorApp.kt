package com.rafaelmardom.app.data.either

sealed class ErrorApp {
    class DataError() : ErrorApp()
    class DomainError() : ErrorApp()
}