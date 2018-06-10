package io.monkeypatch.talks.factorial;

import java.util.stream.IntStream;

public class JavaFactorial {

    public static int javaFactorial(int n) {
        int acc = 1;
        for (int i = 1; i < n; i++) {
            acc *= i;
        }
        return acc;
    }

    public static int javaRecursionFactorial(int n) {
        return (n < 1 ? 1 : n * javaRecursionFactorial(n - 1));
    }

    public static int javaTailRecursionFactorial(int n) {
        return javaTailRecursionFactorialAux(n, 1);
    }

    private static int javaTailRecursionFactorialAux(int n, int acc) {
        return (n < 1 ? acc : javaTailRecursionFactorialAux(n - 1, acc * n));
    }

    public static int javaReduceFactorial(int n) {
        return IntStream.rangeClosed(1, n)
                .reduce((left, right) -> left * right)
                .orElseGet(() -> 1);
    }

}
