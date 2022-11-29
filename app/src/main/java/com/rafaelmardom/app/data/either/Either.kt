package com.rafaelmardom.app.data.either

sealed class Either<out L, out R> {

    data class Left<out L>(val l: L) : Either<L, Nothing>()

    data class Right<out R>(val r: R) : Either<Nothing, R>()

}

fun <L, R> L.left(): Either<L, R> = Either.Left(this)
fun <L, R> R.right(): Either<L, R> = Either.Right(this)