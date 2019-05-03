#!/usr/bin/env bash

# Build
mvn clean package

# run bench
java -jar target/benchmarks.jar -rf json

