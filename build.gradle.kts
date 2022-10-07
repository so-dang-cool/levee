plugins {
    `java-library`

    // Quality
    id("com.diffplug.spotless") version "6.11.0"
    `pmd`

    // Publishing
    `maven-publish`
    `signing`
    id("io.github.gradle-nexus.publish-plugin") version "1.1.0"
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

java {
    withSourcesJar()
    withJavadocJar()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            group = "so.dang.cool"
            version = "1.0.0"
            artifactId = "levee"

            from(components["java"])

            pom {
                name.set("levee")
                description.set("Stream control")
                url.set("https://github.com/hiljusti/levee")

                licenses {
                    license {
                        name.set("BSD 3-Clause License")
                        url.set("https://github.com/hiljusti/levee/blob/HEAD/LICENSE")
                    }
                }

                developers {
                    developer {
                        id.set("hiljusti")
                        name.set("J.R. Hill")
                        email.set("hiljusti@so.dang.cool")
                        url.set("https://so.dang.cool")
                    }
                }

                scm {
                    url.set("https://github.com/hiljusti/levee")
                    connection.set("scm:git:git://github.com/hiljusti/levee.git")
                    developerConnection.set("scm:git:git://github.com/hiljusti/levee.git")
                }
            }
        }
    }
}

signing {
    sign(publishing.publications["mavenJava"])
}

nexusPublishing {
    repositories {
        sonatype {
            nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
            snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
        }
    }
}

// Tasks

tasks.register("fmt").configure {
    dependsOn("spotlessApply")
}

// Publishing (https://github.com/gradle-nexus/publish-plugin)
//
// ./gradlew build publishToSonatype closeAndReleaseSonatypeStagingRepository
