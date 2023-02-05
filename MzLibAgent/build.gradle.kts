/*
 * This file was generated by the Gradle 'init' task.
 *
 * This project uses @Incubating APIs which are subject to change.
 */

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
plugins {
    id("mz.lib.java-conventions")
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

dependencies {
    implementation("io.github.karlatemp:unsafe-accessor:1.7.0")
}
tasks {
    named<ShadowJar>("shadowJar") {
        archiveBaseName.set("MzLibAgent")
        archiveName=archiveBaseName.get()+".jar";
        destinationDirectory.set(File(destinationDirectory.get().asFile.parentFile.parentFile.parentFile,"target"))
        mergeServiceFiles()
        manifest {
            attributes(mapOf("Premain-Class" to "mz.lib.InstrumentationGetterAgent"))
            attributes(mapOf("Can-Redefine-Classes" to "true"))
        }
    }
}
description = "MzLibAgent"
