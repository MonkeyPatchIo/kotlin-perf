package io.monkeypatch.talks.astronomy


fun getMoons(): String =
    SolarSystem.bodies
        .filterIsInstance<Planet>()
        .flatMap { planet -> planet.moons }
        .filterNot { it.name.startsWith("S/") }
        .sortedBy { it.name }
        .joinToString(",\n") { it.name }

fun getMoons2(): String =
    SolarSystem.bodies.asSequence()
        .filterIsInstance<Planet>()
        .flatMap { planet -> planet.moons.asSequence() }
        .filterNot { it.name.startsWith("S/") }
        .sortedBy { it.name }
        .joinToString(",\n") { it.name }

