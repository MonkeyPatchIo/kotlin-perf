package io.monkeypatch.talks.factorial

fun reduceFactorial(n: Int): Int =
    (1..n).reduce { acc, i -> acc * i }


