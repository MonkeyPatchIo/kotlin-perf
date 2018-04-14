/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package io.monkeypatch.talks;

import io.monkeypatch.talks.factorial.JavaFactorial;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import static io.monkeypatch.talks.astronomy.OperationKt.*;
import static io.monkeypatch.talks.factorial.For_factorialKt.forFactorial;
import static io.monkeypatch.talks.factorial.Rec_factorialKt.recFactorial;
import static io.monkeypatch.talks.factorial.Tailrec_factorialKt.tailRecFactorial;

public class MyBenchmark {

    private static final String[] ARGS = new String[0];

    private static final int FACTORIAL = 10;

    // Hello World
    @Benchmark
    public void helloJava() {
        HelloWorld.main(ARGS);
    }

    @Benchmark
    public void helloKotlin() {
        HelloWorldKt.main(ARGS);
    }

    // Factorial
    @Benchmark
    public void factorialJava(Blackhole blackHole) {
        blackHole.consume(JavaFactorial.javaFactorial(FACTORIAL));
    }

    @Benchmark
    public void factorialKotlinFor(Blackhole blackHole) {
        blackHole.consume(forFactorial(FACTORIAL));
    }

    @Benchmark
    public void factorialKotlinRec(Blackhole blackHole) {
        blackHole.consume(recFactorial(FACTORIAL));
    }

    @Benchmark
    public void factorialKotlinTailRec(Blackhole blackHole) {
        blackHole.consume(tailRecFactorial(FACTORIAL));
    }

    // Sequence
    @Benchmark
    public void collectionApiClassic(Blackhole blackHole) {
        blackHole.consume(getMoons());
    }

    @Benchmark
    public void collectionApiSequence(Blackhole blackHole) {
        blackHole.consume(getMoons2());
    }

    // Sequence 2
    @Benchmark
    public void collectionApiClassicFirst(Blackhole blackHole) {
        blackHole.consume(getFirstMoonName());
    }

    @Benchmark
    public void collectionApiSequenceFirst(Blackhole blackHole) {
        blackHole.consume(getFirstMoonName2());
    }
}
