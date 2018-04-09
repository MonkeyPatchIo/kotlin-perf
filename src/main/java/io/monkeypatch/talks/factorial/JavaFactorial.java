package io.monkeypatch.talks.factorial;

public class JavaFactorial {

    public static int javaFactorial(int n) {
        int acc = 1;
        for (int i = 1; i < n; i++) {
            acc *= i;
        }
        return acc;
    }
}
