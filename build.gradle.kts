plugins {
    java
    `maven-publish`
    id("com.gradleup.shadow") version "9.2.2"
}

group = "io.github.ftincdev.ftincdev.mttransformer"

val majorVersion = "0"
val minorVersion = "1"
val patchVersion = "0"

version = if (project.hasProperty("release")) {
    "${majorVersion}.${minorVersion}.${patchVersion}"
} else {
    "${majorVersion}.${minorVersion}-SNAPSHOT"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.0")
    implementation("org.slf4j:slf4j-api:2.0.12")
    implementation("ch.qos.logback:logback-classic:1.5.3")

    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
}

application {
    mainClass.set("io.github.ftincdev.mttransformer.Main")
}

tasks.test {
    useJUnitPlatform()
}

tasks.shadowJar {
    archiveBaseName.set("MT-Transformer-1.7.10")
    archiveClassifier.set("")
    archiveVersion.set("")
    mergeServiceFiles()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifact(tasks.shadowJar)
        }
    }
}
