/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/7.1/userguide/building_java_projects.html
 */

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
    id("org.sonarqube") version "3.3"

}
sonarqube {
    properties {
        property ("sonar.projectKey", "BackslashWelsh_Cinema-Room-Manager")
        property ("sonar.organization", "backslash-welsh")
        property ("sonar.host.url", "https://sonarcloud.io")
    }
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.1")

    // This dependency is used by the application.
    implementation("com.google.guava:guava:30.1-jre")
}

application {
    // Define the main class for the application.
    mainClass.set("cinema.manager.Cinema")
}

tasks.test {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
//tasks.run {
//    doFirst{
//        Cinem
//    }
//}
