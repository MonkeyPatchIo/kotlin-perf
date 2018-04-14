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

fun getFirstMoonName(): String =
    SolarSystem.bodies
        .filterIsInstance<Planet>()
        .flatMap { planet -> planet.moons }
        .filterNot { it.name.startsWith("S/") }
//        .sortedBy { it.name }
        .map { it.name }
        .first()

fun getFirstMoonName2(): String =
    SolarSystem.bodies.asSequence()
        .filterIsInstance<Planet>()
        .flatMap { planet -> planet.moons.asSequence() }
        .filterNot { it.name.startsWith("S/") }
//        .sortedBy { it.name }
        .map { it.name }
        .first()


fun <T> timed(block: () -> T) {
    val startTime = System.currentTimeMillis()
    val result = block()
    val endTime = System.currentTimeMillis()
    val duration = endTime - startTime
    val readable = String.format("%d min %02d seconds", duration / 60000, (duration % 60000) / 1000)
    println("$result in $readable")
}


fun main(args: Array<String>) {
    timed {
        (0..1_000_000)
                .asSequence()
                .onEach {
                    if (it % 10_000 == 0) {
                        println("${(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576}MB / ${Runtime.getRuntime().totalMemory() / 1048576}MB")
                    }
                    println(it)
                }
                .map { Moon(it.toString()) }
                .first()
    }
}
