plugins {
    `java-library`
    id("com.diffplug.spotless") version "6.11.0"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.test {
    useJUnitPlatform()
}

spotless {
    java {
        removeUnusedImports()
        palantirJavaFormat()
    }
}

tasks.register("fmt").configure {
    dependsOn("spotlessApply")
}
